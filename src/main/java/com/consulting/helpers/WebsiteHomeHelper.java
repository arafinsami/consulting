package com.consulting.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.consulting.repositories.ChooseUsRepository;
import com.consulting.repositories.OurBusinessRepository;
import com.consulting.repositories.OurProcessRepository;
import com.consulting.repositories.OurServiceRepository;
import com.consulting.repositories.SliderRepository;

@Component
public class WebsiteHomeHelper {

	@Autowired
	private OurServiceRepository ourServiceRepository;

	@Autowired
	private ChooseUsRepository chooseUsRepository;

	@Autowired
	private OurBusinessRepository ourBusinessRepository;

	@Autowired
	private OurProcessRepository ourProcessRepository;

	@Autowired
	private SliderRepository sliderRepository;

	public void setData(Model model) {
		
		model.addAttribute("title", "Home");
		model.addAttribute("pages", "home");
		model.addAttribute("businessLists", ourBusinessRepository.getFirstOne());
		model.addAttribute("services", ourServiceRepository.findAll());
		model.addAttribute("processLists", ourProcessRepository.findAll());
		model.addAttribute("sliders", sliderRepository.findAll());
		model.addAttribute("chooses", chooseUsRepository.findAll());
	}

}
