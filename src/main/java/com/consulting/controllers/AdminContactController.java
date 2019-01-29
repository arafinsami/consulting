package com.consulting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.consulting.helpers.AdminContactHelper;
import com.consulting.models.Contact;
import com.consulting.repositories.ContactRepository;

@Controller
public class AdminContactController {

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private AdminContactHelper adminContactHelper;

	Integer size = new Integer(5);
	Integer page = new Integer(0);

	@RequestMapping("/admin/contact/index")
	public String index(Model model, @RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {

		if (page == null) {
			page = 0;
		}
		if (size == null) {
			size = this.size;
		}
		Pageable pageable = new PageRequest(page, size);
		Page<Contact> contacts = contactRepository.findAllByOrderByContactIdDesc(pageable);
		adminContactHelper.setData(model, contacts, page, size);
		return "admin/index";
	}

	@RequestMapping(value = { "/admin/contact/delete/{contactId}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("contactId") Integer contactId, Model model) {
		contactRepository.delete(contactId);
		return "redirect:/admin/contact/index";
	}

}
