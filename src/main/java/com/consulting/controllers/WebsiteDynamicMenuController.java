package com.consulting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.consulting.models.*;
import com.consulting.repositories.*;

@Controller
public class WebsiteDynamicMenuController {

	/*@Autowired
	private AreasOfExpertiesHelper areasOfExpertiesHelper;*/

	
	@Autowired
	private ChildMenuContentRepository childMenuContentRepository;

	/*@RequestMapping(value = "/areas-of-experties/{areasOfExpertiesUrl}")
	public String about(Model model, @PathVariable("areasOfExpertiesUrl") String areasOfExpertiesUrl) {
		areasOfExpertiesHelper.setData(model, areasOfExpertiesUrl);
		return "website/index";
	}*/
	
	/*@RequestMapping(value = "/{id}")
	public String about(Model model, @PathVariable("id") Integer id) {
		ChildMenu childMenu = childMenuRepository.findOne(id);
		model.addAttribute("pages","advertisement_dynamic_page");
		model.addAttribute("childMenu",childMenu);
		return "website/index";
	}*/
	
	@RequestMapping(value = "/details/{id}")
	public String details(Model model, @PathVariable("id") Integer id) {
		ChildMenuContent childMenuContent = childMenuContentRepository.findOne(id);
		model.addAttribute("pages","details");
		model.addAttribute("childMenuContent",childMenuContent);
		return "website/index";
	}

}
