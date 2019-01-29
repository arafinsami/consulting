package com.consulting.helpers;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.consulting.models.Contact;

@Component
public class AdminContactHelper {

	
	public void setData(Model model, Page<Contact> contacts, Integer page, Integer size) {
		model.addAttribute("title", "Admin Contact");
		model.addAttribute("pages", "contact/index");
		model.addAttribute("page", page);
		model.addAttribute("size", size);
		model.addAttribute("contacts", contacts);
	}

}
