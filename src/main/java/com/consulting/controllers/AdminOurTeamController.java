package com.consulting.controllers;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.consulting.helpers.AdminOurTeamHelper;
import com.consulting.models.OurTeam;
import com.consulting.repositories.OurTeamRepository;

@Controller
public class AdminOurTeamController extends BaseController {
	
	@Value("${teamDeletionPath}")
	String teamDeletionPath;
	
	@Autowired
	private AdminOurTeamHelper adminOurTeamHelper;

	@Autowired
	private OurTeamRepository ourTeamRepository;
	
	Integer size = new Integer(5);
	Integer page = new Integer(0);

	@RequestMapping("/admin/team/index")
	public String index(Model model,@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {
		
		if (page == null) {
			page = 0;
		}
		if (size == null) {
			size = this.size;
		}
		Pageable pageable = new PageRequest(page, size);
		Page<OurTeam> ourTeams = ourTeamRepository.findAllByOrderByTeamIdDesc(pageable);
		adminOurTeamHelper.setData(model, ourTeams, page, size);
		return "admin/index";
	}
	
	@RequestMapping("/admin/team/create")
	public String create(Model model) {
		OurTeam ourTeam = new OurTeam();
		adminOurTeamHelper.setData(model, ourTeam);
		return "admin/index";
	}
	
	@RequestMapping("/admin/team/create/{teamId}")
	public String edit(Model model, @PathVariable("teamId") Integer teamId) {
		OurTeam ourTeam = ourTeamRepository.findOne(teamId);
		adminOurTeamHelper.setData(model, ourTeam , teamId);
		return "admin/index";
	}

	@RequestMapping(value = { "/admin/team/create" }, method = RequestMethod.POST)
	public String save(Model model, @ModelAttribute("ourTeam") OurTeam ourTeam,
			@RequestParam("teamUpload") MultipartFile file) {
		
		String attachment = teamUploadFile(file);
		if (attachment == null) {
			ourTeam.setAttachment(null);
		} else {
			ourTeam.setAttachment(attachment);
		}
		ourTeamRepository.save(ourTeam);
		return "redirect:/admin/team/index";
	}
	
	@RequestMapping(value = { "/admin/team/create/{teamId}" }, method = RequestMethod.POST)
	public String update(Model model, @ModelAttribute("ourTeam") OurTeam ourTeam,
			@RequestParam("teamUpload") MultipartFile file,@PathVariable("teamId") Integer teamId) {
		
		OurTeam ourTeamOld = ourTeamRepository.findOne(teamId);
		try {
			File fileOld = new File(teamDeletionPath + ourTeamOld.getAttachment());
			if (fileOld.delete()) {
				System.out.println(fileOld.getName() + " FILE From Team Controller File Is Deleted!");
			} else {
				System.out.println("Delete operation Is Failed.");
			}
		} catch (Exception e) {
			System.out.println("Failed to Delete File !!");
		}
		
		String attachment = teamUploadFile(file);
		if (attachment == null) {
			ourTeam.setAttachment(null);
		} else {
			ourTeam.setAttachment(attachment);
		}
		ourTeamRepository.save(ourTeam);
		return "redirect:/admin/team/index";
	}
	
	@RequestMapping(value = { "/admin/team/delete/{teamId}" }, method = RequestMethod.GET)
	public String delete(Model model,@PathVariable("teamId") Integer teamId) {
		
		OurTeam ourTeamOld = ourTeamRepository.findOne(teamId);
		try {
			File fileOld = new File(teamDeletionPath + ourTeamOld.getAttachment());
			if (fileOld.delete()) {
				System.out.println(fileOld.getName() + " FILE From Team Controller File Is Deleted!");
			} else {
				System.out.println("Delete operation Is Failed.");
			}
		} catch (Exception e) {
			System.out.println("Failed to Delete File !!");
		}
		
		ourTeamRepository.delete(teamId);
		return "redirect:/admin/team/index";
	}
}






