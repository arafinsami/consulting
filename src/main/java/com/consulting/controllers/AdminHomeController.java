package com.consulting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.consulting.helpers.AdminHomeHelper;

@Controller
public class AdminHomeController {

	@Autowired
	private AdminHomeHelper adminHomeHelper;

	@RequestMapping("/admin")
	public String index(Model model) {
		adminHomeHelper.setData(model);	
		return "admin/index";
	}
}
