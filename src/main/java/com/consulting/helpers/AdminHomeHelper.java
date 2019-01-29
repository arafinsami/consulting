package com.consulting.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.consulting.repositories.ContactRepository;

@Component
public class AdminHomeHelper {

	@Autowired
	private ContactRepository contactRepository;

	public void setData(Model model) {
		model.addAttribute("title", "Admin Home");
		model.addAttribute("pages", "home");
		model.addAttribute("counts", contactRepository.count());
	}

}
