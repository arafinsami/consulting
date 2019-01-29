package com.consulting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.consulting.helpers.AdminAboutHelper;

@Controller
public class AdminAboutController {

	@Autowired
	private AdminAboutHelper AdminAboutHelper;

	@RequestMapping("/admin/about")
	public String index(Model model) {
		AdminAboutHelper.setData(model);
		return "admin/index";
	}
}
