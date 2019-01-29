package com.consulting.helpers;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.consulting.models.Contact;

@Component
public class WebContactUsHelper {

	public void setData(Model model,Contact contact) {
		model.addAttribute("title", "Contact Us");
		model.addAttribute("pages", "contact");
		model.addAttribute("contact",contact);
		model.addAttribute("action","/contact");
	}
}
