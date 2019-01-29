/*package com.consulting.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.consulting.models.AreasOfExpertiseMenu;
import com.consulting.repositories.AreasOfExpertiseMenuRepository;

@Component
public class AreasOfExpertiesHelper {

	@Autowired
	private AreasOfExpertiseMenuRepository areasOfExpertiseMenuRepository;
	
	public void setData(Model model,String areasOfExpertiesUrl) {
		AreasOfExpertiseMenu areasOfExpertiseMenu = areasOfExpertiseMenuRepository.findByUrl(areasOfExpertiesUrl);
		model.addAttribute("title", areasOfExpertiseMenu.getName());
		model.addAttribute("pages", "advertisement_dynamic_page");
	}
}
*/