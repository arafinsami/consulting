package com.consulting.controllers;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.consulting.helpers.AdminOurBusinessHelper;
import com.consulting.models.*;
import com.consulting.repositories.*;

@Controller
public class AdminOurBusinessController extends BaseController {
	
	@Value("${ourBusinessDeletionPath}")
	String ourBusinessDeletionPath;
	
	@Autowired
	private OurBusinessRepository ourBusinessRepository;
	
	@Autowired
	private AdminOurBusinessHelper adminOurBusinessHelper;
	
	Integer size = new Integer(5);
	Integer page = new Integer(0);
	

	@RequestMapping("/admin/business/index")
	public String index(Model model,@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {
		
		if (page == null) {
			page = 0;
		}
		if (size == null) {
			size = this.size;
		}
		Pageable pageable = new PageRequest(page, size);
		
		Page<OurBusiness> ourBusiness = ourBusinessRepository.findAllByOrderByOurBusinessIdDesc(pageable);
		adminOurBusinessHelper.setData(model, ourBusiness, page, size);
		return "admin/index";
	}
	
	@RequestMapping("/admin/business/create")
	public String create(Model model) {
		OurBusiness ourBusiness = new OurBusiness();
		adminOurBusinessHelper.setData(model, ourBusiness);
		return "admin/index";
	}
	
	@RequestMapping("/admin/business/create/{ourBusinessId}")
	public String edit(Model model,@PathVariable("ourBusinessId") Integer ourBusinessId) {
		OurBusiness ourBusiness = ourBusinessRepository.findOne(ourBusinessId);
		adminOurBusinessHelper.setData(model, ourBusiness, ourBusinessId);
		return "admin/index";
	}

	@RequestMapping(value = { "/admin/business/create" }, method = RequestMethod.POST)
	public String save(Model model, @ModelAttribute("ourBusiness") OurBusiness ourBusiness,
			@RequestParam("businessUpload") MultipartFile file) {
		
		String attachment = ourBusinessUploadFile(file);
		if (attachment == null) {
			ourBusiness.setAttachment(null);
		} else {
			ourBusiness.setAttachment(attachment);
		}
		ourBusinessRepository.save(ourBusiness);
		return "redirect:/admin/business/index";
	}
	
	@RequestMapping(value = { "/admin/business/create/{ourBusinessId}" }, method = RequestMethod.POST)
	public String update(Model model, @ModelAttribute("ourBusiness") OurBusiness ourBusiness,
			@RequestParam("businessUpload") MultipartFile file,@PathVariable("ourBusinessId") Integer ourBusinessId) {
		
		OurBusiness ourBusinessOld = ourBusinessRepository.findOne(ourBusinessId);
		try {
			File fileOld = new File(ourBusinessDeletionPath + ourBusinessOld.getAttachment());
			if (fileOld.delete()) {
				System.out.println(fileOld.getName() + " FILE From Gallery Controller File Is Deleted!");
			} else {
				System.out.println("Delete operation Is Failed.");
			}
		} catch (Exception e) {
			System.out.println("Failed to Delete File !!");
		}
		
		String attachment = ourBusinessUploadFile(file);
		if (attachment == null) {
			ourBusiness.setAttachment(null);
		} else {
			ourBusiness.setAttachment(attachment);
		}
		ourBusinessRepository.save(ourBusiness);
		return "redirect:/admin/business/index";
	}
	
	@RequestMapping(value = { "/admin/business/delete/{ourBusinessId}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("ourBusinessId") Integer ourBusinessId, Model model) {
		
		OurBusiness ourBusinessOld = ourBusinessRepository.findOne(ourBusinessId);
		try {
			File fileOld = new File(ourBusinessDeletionPath + ourBusinessOld.getAttachment());
			if (fileOld.delete()) {
				System.out.println(fileOld.getName() + " FILE From Gallery Controller File Is Deleted!");
			} else {
				System.out.println("Delete operation Is Failed.");
			}
		} catch (Exception e) {
			System.out.println("Failed to Delete File !!");
		}
		ourBusinessRepository.delete(ourBusinessId);
		return "redirect:/admin/business/index";
	}
}








