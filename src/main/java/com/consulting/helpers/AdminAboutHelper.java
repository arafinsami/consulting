package com.consulting.helpers;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class AdminAboutHelper {

	
	public void setData(Model model	) {
		model.addAttribute("title","Admin About");
		model.addAttribute("pages", "about");
	}

}
