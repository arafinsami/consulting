package com.consulting.controllers;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.consulting.helpers.*;
import com.consulting.models.*;
import com.consulting.repositories.*;

@Controller
public class AdminSubMenuContentController extends BaseController {
	
	@Value("${attachmentUploadPath}")
	String attachmentUploadPath;
	
	@Value("${attachmentDeletionPath}")
	String attachmentDeletionPath;

	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private ChildMenuContentRepository childMenuContentRepository;

	@Autowired
	AdminMenuHelpers adminMenuHelpers;
	
	Integer size = new Integer(5);
	Integer page = new Integer(0);

	@RequestMapping("/admin/sub-menu-content/index")
	public String index(Model model,@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {
		
		if (page == null) {
			page = 0;
		}
		if (size == null) {
			size = this.size;
		}
		Pageable pageable = new PageRequest(page, size);
		Page<ChildMenuContent> ChildMenuContents = childMenuContentRepository.findAllByOrderByChildMenuContentIdDesc(pageable);
		adminMenuHelpers.setSubMenuContentHelper(model,ChildMenuContents,page,size);
		return "admin/index";
	}

	@RequestMapping("/admin/sub-menu-content/create")
	public String create(Model model) {
		ChildMenuContent childMenuContent = new ChildMenuContent();
		adminMenuHelpers.setSubMenuContentHelper(model, childMenuContent);
		return "admin/index";
	}
	
	@RequestMapping(value = { "/admin/sub-menu-content/create/{childMenuContentId}" }, method = RequestMethod.GET)
	public String edit(@PathVariable("childMenuContentId") Integer childMenuContentId, Model model) {
		ChildMenuContent childMenuContent = childMenuContentRepository.findOne(childMenuContentId);
		model.addAttribute("childMenuContent",childMenuContent);
		model.addAttribute("title", "Admin Sub-Menu Content");
		model.addAttribute("pages", "sub-menu-content/create");
		model.addAttribute("childMenuContent", childMenuContent);
		model.addAttribute("menus", menuRepository.findAll());
		model.addAttribute("action", "/admin/sub-menu-content/create/" +childMenuContentId);
		return "admin/index";
	}

	@RequestMapping(value = { "/admin/sub-menu-content/create"}, method = RequestMethod.POST)
	public String save(Model model, @ModelAttribute("childMenuContent") ChildMenuContent childMenuContent,
			@RequestParam("attachmentUpload") MultipartFile file) {

		String attachment = menuContentUploadFile(file);
		if (attachment == null) {
			childMenuContent.setAttachment(null);
		} else {
			childMenuContent.setAttachment(attachment);
		}
		childMenuContentRepository.save(childMenuContent);
		return "redirect:/admin/sub-menu-content/index";
	}
	
	
	@RequestMapping(value = { "/admin/sub-menu-content/create/{childMenuContentId}" }, method = RequestMethod.POST)
	public String update(Model model, @ModelAttribute("childMenu") ChildMenuContent childMenuContent,
			@RequestParam("attachmentUpload") MultipartFile file,@PathVariable("childMenuContentId") Integer childMenuContentId) {

		ChildMenuContent childMenuContentOld = childMenuContentRepository.findOne(childMenuContentId);
		try {
			File fileOld = new File(attachmentDeletionPath + childMenuContentOld.getAttachment());
			if (fileOld.delete()) {
				System.out.println(fileOld.getName() + " PDS FILE From PDS Controller File Is Deleted!");
			} else {
				System.out.println("Delete operation Is Failed.");
			}
		} catch (Exception e) {
			System.out.println("Failed to Delete File !!");
		}
		
		
		String attachment = menuContentUploadFile(file);
		if (attachment == null) {
			childMenuContent.setAttachment(null);
		} else {
			childMenuContent.setAttachment(attachment);
		}
		childMenuContentRepository.save(childMenuContent);
		return "redirect:/admin/sub-menu-content/index";
	}
	
	@RequestMapping(value = { "/admin/sub-menu-content/delete/{childMenuContentId}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("childMenuContentId") Integer childMenuContentId, Model model) {
		
		ChildMenuContent childMenuContent = childMenuContentRepository.findOne(childMenuContentId);
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
		childMenuContentRepository.delete(childMenuContentId);
		return "redirect:/admin/sub-menu-content/index";
	}
}



