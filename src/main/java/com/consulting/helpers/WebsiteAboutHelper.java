package com.consulting.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.consulting.repositories.OurTeamRepository;

@Component
public class WebsiteAboutHelper {

	@Autowired
	private OurTeamRepository ourTeamRepository;

	public void setData(Model model) {
		model.addAttribute("title", "About");
		model.addAttribute("pages", "about");
		model.addAttribute("ourTeams", ourTeamRepository.findAll());
	}

}
