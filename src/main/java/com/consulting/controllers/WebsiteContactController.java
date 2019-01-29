package com.consulting.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.consulting.helpers.WebContactUsHelper;
import com.consulting.models.Contact;
import com.consulting.repositories.ContactRepository;
import com.consulting.validator.ContactValidator;

@Controller
public class WebsiteContactController {

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private ContactValidator contactValidator;

	@Autowired
	private WebContactUsHelper webContactUsHelper;

	@InitBinder("contact")
	protected void initBinderForContact(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		binder.addValidators(contactValidator);
	}

	@RequestMapping("/contact")
	public String webContactGet(Model model) {
		
		Contact contact = new Contact();
		webContactUsHelper.setData(model, contact);
		return "website/index";
	}

	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public String webContactPost(Model model, @Valid @ModelAttribute("contact") Contact contact, BindingResult result,
			RedirectAttributes redirectAttributes) {

		contactValidator.validate(contact, result);
		if (result.hasErrors()) {
			webContactUsHelper.setData(model, contact);
			return "website/index";
		}
		contactRepository.save(contact);
		redirectAttributes.addFlashAttribute("You have Successfully sent message");
		return "redirect:/contact";
	}
}
