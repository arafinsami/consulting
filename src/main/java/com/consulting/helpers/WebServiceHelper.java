package com.consulting.helpers;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class WebServiceHelper {

	public void setData(Model model) {
		model.addAttribute("title", "Services");
		model.addAttribute("pages", "services");
	}

}
