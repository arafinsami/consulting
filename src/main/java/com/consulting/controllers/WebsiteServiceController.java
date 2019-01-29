package com.consulting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.consulting.helpers.WebServiceHelper;

@Controller
public class WebsiteServiceController {

	@Autowired
	private WebServiceHelper webServiceHelper;
	
	@RequestMapping("/services")
	public String services(Model model) {

		webServiceHelper.setData(model);
		return "website/index";
	}
}


