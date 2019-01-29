package com.consulting.helpers;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.consulting.models.OurService;


@Component
public class AdminOurServiceHelper {

	
	public void setData(Model model,Page<OurService> ourServices, Integer page, Integer size) {
		model.addAttribute("title", "Admin Service");
		model.addAttribute("pages", "service/index");
		model.addAttribute("page", page);
		model.addAttribute("size", size);
		model.addAttribute("ourServices", ourServices);
	}
	
	public void setData(Model model,OurService ourService) {
		model.addAttribute("title", "Admin Create");
		model.addAttribute("pages", "service/create");
		model.addAttribute("ourService", ourService);
		model.addAttribute("action", "/admin/service/create");
	}
	
	public void setData(Model model,OurService ourService,Integer ourServiceId) {
		model.addAttribute("title", "Admin Create");
		model.addAttribute("pages", "service/create");
		model.addAttribute("ourService", ourService);
		model.addAttribute("action", "/admin/service/create/" +ourServiceId);
	}
}
