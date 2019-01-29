package com.consulting.helpers;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.consulting.models.OurBusiness;


@Component
public class AdminOurBusinessHelper {

	
	public void setData(Model model,Page<OurBusiness> ourBusiness, Integer page, Integer size) {
		model.addAttribute("title", "Our Business");
		model.addAttribute("pages", "business/index");
		model.addAttribute("page", page);
		model.addAttribute("size", size);
		model.addAttribute("ourBusiness", ourBusiness);
	}
	
	public void setData(Model model,OurBusiness ourBusiness) {
		model.addAttribute("title", "Our Business Create");
		model.addAttribute("pages", "business/create");
		model.addAttribute("ourBusiness", ourBusiness);
		model.addAttribute("action", "/admin/business/create");
	}
	
	public void setData(Model model,OurBusiness ourBusiness,Integer ourBusinessId) {
		model.addAttribute("title", "Our Business Create");
		model.addAttribute("pages", "business/create");
		model.addAttribute("ourBusiness", ourBusiness);
		model.addAttribute("action", "/admin/business/create/" +ourBusinessId);
	}
}
