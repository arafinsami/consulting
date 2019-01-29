package com.consulting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.consulting.repositories.*;

@ControllerAdvice
public class GlobalMenuController {
	
	/*@Autowired
	private AreasOfExpertiseMenuRepository areasOfExpertiseMenuRepository;*/
	
	@Autowired
	private MenuRepository menuRepository;
	
	/*@ModelAttribute("areasOfExpertiseMenus")
	public void menu(Model model) {
		model.addAttribute("areasOfExpertiseMenus",areasOfExpertiseMenuRepository.findAll());
	}*/
	
	@ModelAttribute("menus")
	public void menus(Model model) {
		model.addAttribute("menus",menuRepository.findAll());
	}
}
