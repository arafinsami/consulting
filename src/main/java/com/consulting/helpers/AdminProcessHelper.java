package com.consulting.helpers;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.consulting.models.OurProcess;

@Component
public class AdminProcessHelper {

	public void setData(Model model, Page<OurProcess> ourProcesses, Integer page, Integer size) {
		model.addAttribute("title", "Our Process");
		model.addAttribute("pages", "process/index");
		model.addAttribute("page", page);
		model.addAttribute("size", size);
		model.addAttribute("ourProcesses", ourProcesses);
	}

	public void setData(Model model, OurProcess ourProcess) {
		model.addAttribute("title", "Our Process Create");
		model.addAttribute("pages", "process/create");
		model.addAttribute("ourProcess", ourProcess);
		model.addAttribute("action", "/admin/process/create");
	}

	public void setData(Model model, OurProcess ourProcess, Integer ourProcessId) {
		model.addAttribute("title", "Our Process Create");
		model.addAttribute("pages", "process/create");
		model.addAttribute("ourProcess", ourProcess);
		model.addAttribute("action", "/admin/process/create/" + ourProcessId);
	}

}
