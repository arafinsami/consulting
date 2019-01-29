package com.consulting.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;

import com.consulting.models.ChildMenuContent;
import com.consulting.models.Menu;
import com.consulting.repositories.MenuRepository;

@Component
public class AdminMenuHelpers {

	@Autowired
	private MenuRepository menuRepository;

	public void setMenuHelper(Model model,Page<Menu> menus,Integer page,Integer size) {
		
		model.addAttribute("title", "Admin Sub-Menu");
		model.addAttribute("menus", menus);
		model.addAttribute("page", page);
		model.addAttribute("size", size);
		model.addAttribute("pages", "menu/index");
		
	}

	
	public void setMenuHelper(Model model, Menu menu) {
		model.addAttribute("title", "Admin Menu");
		model.addAttribute("pages", "menu/create");
		model.addAttribute("menu", menu);
		model.addAttribute("action", "/admin/menu/create");
	}

	public void setMenuHelper(Model model, Menu menu, Integer menuId) {
		model.addAttribute("title", "Admin Menu");
		model.addAttribute("pages", "menu/create");
		model.addAttribute("menu", menu);
		model.addAttribute("action", "/admin/menu/create/" + menuId);
	}
	
	
	public void setSubMenuContentHelper(Model model,Page<ChildMenuContent> ChildMenuContents,Integer page,Integer size) {
		model.addAttribute("title", "Admin Sub-Menu");
		model.addAttribute("pages", "sub-menu-content/index");
		model.addAttribute("ChildMenuContents", ChildMenuContents);
		model.addAttribute("page", page);
		model.addAttribute("size", size);
	}
	
	public void setSubMenuContentHelper(Model model, ChildMenuContent childMenuContent) {
		model.addAttribute("title", "Admin Sub-Menu Content");
		model.addAttribute("pages", "sub-menu-content/create");
		model.addAttribute("childMenuContent", childMenuContent);
		model.addAttribute("menus", menuRepository.findAll());
		model.addAttribute("action", "/admin/sub-menu-content/create");
	}
	
}








