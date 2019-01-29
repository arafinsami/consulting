package com.consulting.helpers;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.consulting.models.Slider;


@Component
public class AdminSliderHelper {

	
	public void setData(Model model,Page<Slider> sliders, Integer page, Integer size) {
		model.addAttribute("title", "Admin Slider");
		model.addAttribute("pages", "slider/index");
		model.addAttribute("page", page);
		model.addAttribute("size", size);
		model.addAttribute("sliders", sliders);
	}
	
	public void setData(Model model,Slider slider) {
		model.addAttribute("title", "Admin Slider");
		model.addAttribute("pages", "slider/create");
		model.addAttribute("slider", slider);
		model.addAttribute("action", "/admin/slider/create");
	}
	
	public void setData(Model model,Slider slider,Integer sliderId) {
		model.addAttribute("title", "Admin Slider");
		model.addAttribute("pages", "slider/create");
		model.addAttribute("slider", slider);
		model.addAttribute("action", "/admin/slider/create/" +sliderId);
	}
}
