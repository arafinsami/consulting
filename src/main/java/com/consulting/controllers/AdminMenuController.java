package com.consulting.controllers;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.consulting.helpers.AdminMenuHelpers;
import com.consulting.models.ChildMenuContent;
import com.consulting.models.Menu;
import com.consulting.repositories.ChildMenuContentRepository;
import com.consulting.repositories.MenuRepository;

@Controller
public class AdminMenuController extends BaseController {

	@Value("${attachmentDeletionPath}")
	String attachmentDeletionPath;

	@Autowired
	private ChildMenuContentRepository childMenuContentRepository;

	@Autowired
	private MenuRepository menuRepository;

	@Autowired
	AdminMenuHelpers adminMenuHelpers;

	Integer size = new Integer(5);
	Integer page = new Integer(0);

	@RequestMapping("/admin/menu/index")
	public String index(Model model, @RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {

		if (page == null) {
			page = 0;
		}
		if (size == null) {
			size = this.size;
		}

		Pageable pageable = new PageRequest(page, size);
		Page<Menu> menus = menuRepository.findAllByOrderByMenuIdDesc(pageable);
		adminMenuHelpers.setMenuHelper(model, menus, page, size);
		return "admin/index";
	}

	@RequestMapping("/admin/menu/create")
	public String create(Model model) {
		Menu menu = new Menu();
		adminMenuHelpers.setMenuHelper(model, menu);
		return "admin/index";
	}

	@RequestMapping(value = { "/admin/menu/create/{menuId}" }, method = RequestMethod.GET)
	public String edit(@PathVariable("menuId") Integer menuId, Model model) {
		Menu menu = menuRepository.findOne(menuId);
		adminMenuHelpers.setMenuHelper(model, menu, menuId);
		return "admin/index";
	}

	@RequestMapping(value = { "/admin/menu/create" }, method = RequestMethod.POST)
	public String save(Model model, @ModelAttribute("menu") Menu menu) {
		menuRepository.save(menu);
		return "redirect:/admin/menu/index";
	}

	@RequestMapping(value = { "/admin/menu/create/{menuId}" }, method = RequestMethod.POST)
	public String update(Model model, @ModelAttribute("menu") Menu menu, @PathVariable("menuId") Integer menuId) {
		menuRepository.save(menu);
		return "redirect:/admin/menu/index";
	}

	@RequestMapping(value = { "/admin/menu/delete/{menuId}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("menuId") Integer menuId, Model model) {
		menuRepository.delete(menuId);
		return "redirect:/admin/menu/index";
	}

	@Transactional
	public void deleteSchedule() {
		List<ChildMenuContent> childMenuContents = childMenuContentRepository.getFirstOneRows();

		for (ChildMenuContent childMenuContent : childMenuContents) {

			//ChildMenu childMenu = childMenuRepository.findOne(childMenuContent.getChildMenu().getChildMenuId());
			Menu menu = menuRepository.findOne(childMenuContent.getMenu().getMenuId());

			try {
				File fileOld = new File(attachmentDeletionPath + childMenuContent.getAttachment());
				if (fileOld.delete()) {
					System.out.println(fileOld.getName() + " PDS FILE From PDS Controller File Is Deleted!");
				} else {
					System.out.println("Delete operation Is Failed.");
				}
			} catch (Exception e) {
				System.out.println("Failed to Delete File !!");
			}

			childMenuContentRepository.delete(childMenuContent);
			//childMenuRepository.delete(childMenu.getChildMenuId());
			menuRepository.delete(menu.getMenuId());
		}

	}
}
