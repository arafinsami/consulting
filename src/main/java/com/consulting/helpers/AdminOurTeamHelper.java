package com.consulting.helpers;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.consulting.models.OurTeam;


@Component
public class AdminOurTeamHelper {

	
	public void setData(Model model,Page<OurTeam> ourTeams, Integer page, Integer size) {
		model.addAttribute("title", "Admin Our Team");
		model.addAttribute("pages", "team/index");
		model.addAttribute("page", page);
		model.addAttribute("size", size);
		model.addAttribute("ourTeams", ourTeams);
	}
	
	public void setData(Model model,OurTeam ourTeam) {
		model.addAttribute("title", "Admin Our Team");
		model.addAttribute("pages", "team/create");
		model.addAttribute("ourTeam", ourTeam);
		model.addAttribute("action", "/admin/team/create");
	}
	
	public void setData(Model model,OurTeam ourTeam,Integer teamId) {
		model.addAttribute("title", "Admin Team Create");
		model.addAttribute("pages", "team/create");
		model.addAttribute("ourTeam", ourTeam);
		model.addAttribute("action", "/admin/team/create/" +teamId);
	}
}
