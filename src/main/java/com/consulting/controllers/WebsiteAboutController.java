package com.consulting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.consulting.helpers.WebsiteAboutHelper;

@Controller
public class WebsiteAboutController {

	@Autowired
	private WebsiteAboutHelper websiteAboutHelper;

	@RequestMapping("/about")
	public String about(Model model) {

		websiteAboutHelper.setData(model);
		return "website/index";
	}

}
