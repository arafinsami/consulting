package com.consulting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.consulting.helpers.WebsiteHomeHelper;

@Controller
public class WebsiteHomeController {

	@Autowired
	private WebsiteHomeHelper websiteHomeHelper;

	@RequestMapping("/")
	public String index(Model model) {
		
		websiteHomeHelper.setData(model);
		return "website/index";
	}
}
