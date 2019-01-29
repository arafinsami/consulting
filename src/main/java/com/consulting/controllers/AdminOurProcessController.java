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

import com.consulting.helpers.AdminProcessHelper;
import com.consulting.models.*;
import com.consulting.repositories.*;

@Controller
public class AdminOurProcessController extends BaseController {

	@Value("${ourProcessDeletionPath}")
	String ourProcessDeletionPath;
	
	@Autowired
	private AdminProcessHelper adminProcessHelper;

	@Autowired
	OurProcessRepository ourProcessRepository;

	Integer size = new Integer(5);
	Integer page = new Integer(0);

	@RequestMapping("/admin/process/index")
	public String index(Model model, @RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {

		if (page == null) {
			page = 0;
		}
		if (size == null) {
			size = this.size;
		}
		Pageable pageable = new PageRequest(page, size);
		Page<OurProcess> ourProcesses = ourProcessRepository.findAllByOrderByOurProcessIdDesc(pageable);
		adminProcessHelper.setData(model, ourProcesses, page, size);
		return "admin/index";
	}

	@RequestMapping("/admin/process/create")
	public String create(Model model) {
		OurProcess ourProcess = new OurProcess();
		adminProcessHelper.setData(model, ourProcess);
		return "admin/index";
	}
	
	@RequestMapping("/admin/process/create/{ourProcessId}")
	public String edit(Model model,@PathVariable("ourProcessId") Integer ourProcessId) {
		OurProcess ourProcess = ourProcessRepository.findOne(ourProcessId);
		adminProcessHelper.setData(model, ourProcess,ourProcessId);
		return "admin/index";
	}

	@RequestMapping(value = { "/admin/process/create" }, method = RequestMethod.POST)
	public String save(Model model, @ModelAttribute("ourProcess") OurProcess ourProcess,
			@RequestParam("processUpload") MultipartFile file) {

		String attachment = ourProcessUploadFile(file);
		if (attachment == null) {
			ourProcess.setAttachment(null);
		} else {
			ourProcess.setAttachment(attachment);
		}
		ourProcessRepository.save(ourProcess);
		return "redirect:/admin/process/index";
	}
	
	@RequestMapping(value = { "/admin/process/create/{ourProcessId}" }, method = RequestMethod.POST)
	public String update(Model model, @ModelAttribute("ourProcess") OurProcess ourProcess,
			@RequestParam("processUpload") MultipartFile file , @PathVariable("ourProcessId") Integer ourProcessId) {

		OurProcess ourProcessOld = ourProcessRepository.findOne(ourProcessId);
		try {
			File fileOld = new File(ourProcessDeletionPath + ourProcessOld.getAttachment());
			if (fileOld.delete()) {
				System.out.println(fileOld.getName() + " FILE From Our Process Controller File Is Deleted!");
			} else {
				System.out.println("Delete operation Is Failed.");
			}
		} catch (Exception e) {
			System.out.println("Failed to Delete File !!");
		}
		
		String attachment = ourProcessUploadFile(file);
		if (attachment == null) {
			ourProcess.setAttachment(null);
		} else {
			ourProcess.setAttachment(attachment);
		}
		ourProcessRepository.save(ourProcess);
		return "redirect:/admin/process/index";
	}
	
	@RequestMapping(value = { "/admin/process/delete/{ourProcessId}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("ourProcessId") Integer ourProcessId, Model model) {
		
		OurProcess ourProcessOld = ourProcessRepository.findOne(ourProcessId);
		try {
			File fileOld = new File(ourProcessDeletionPath + ourProcessOld.getAttachment());
			if (fileOld.delete()) {
				System.out.println(fileOld.getName() + " FILE From Our Process Controller File Is Deleted!");
			} else {
				System.out.println("Delete operation Is Failed.");
			}
		} catch (Exception e) {
			System.out.println("Failed to Delete File !!");
		}
		ourProcessRepository.delete(ourProcessId);
		return "redirect:/admin/process/index";
	}
}




