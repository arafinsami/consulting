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

import com.consulting.helpers.AdminOurServiceHelper;
import com.consulting.models.OurService;
import com.consulting.repositories.OurServiceRepository;

@Controller
public class AdminServiceController extends BaseController {

	@Value("${ourServicesDeletionPath}")
	String ourServicesDeletionPath;

	@Autowired
	private OurServiceRepository ourServiceRepository;

	@Autowired
	private AdminOurServiceHelper adminOurServiceHelper;

	Integer size = new Integer(5);
	Integer page = new Integer(0);

	@RequestMapping("/admin/service/index")
	public String index(Model model, @RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {

		if (page == null) {
			page = 0;
		}
		if (size == null) {
			size = this.size;
		}
		Pageable pageable = new PageRequest(page, size);
		Page<OurService> ourServices = ourServiceRepository.findAllByOrderByOurServiceIdDesc(pageable);
		adminOurServiceHelper.setData(model, ourServices, page, size);
		return "admin/index";
	}

	@RequestMapping("/admin/service/create")
	public String create(Model model) {
		OurService ourService = new OurService();
		adminOurServiceHelper.setData(model, ourService);
		return "admin/index";
	}

	@RequestMapping("/admin/service/create/{ourServiceId}")
	public String edit(Model model, @PathVariable("ourServiceId") Integer ourServiceId) {
		OurService ourService = ourServiceRepository.findOne(ourServiceId);
		adminOurServiceHelper.setData(model, ourService, ourServiceId);
		return "admin/index";
	}

	@RequestMapping(value = { "/admin/service/create" }, method = RequestMethod.POST)
	public String save(Model model, @ModelAttribute("ourService") OurService ourService,
			@RequestParam("serviceUpload") MultipartFile file) {

		String attachment = ourServicesUploadFile(file);
		if (attachment == null) {
			ourService.setAttachment(null);
		} else {
			ourService.setAttachment(attachment);
		}
		ourServiceRepository.save(ourService);
		return "redirect:/admin/service/index";
	}

	@RequestMapping(value = { "/admin/service/create/{ourServiceId}" }, method = RequestMethod.POST)
	public String update(Model model, @ModelAttribute("ourService") OurService ourService,
			@RequestParam("serviceUpload") MultipartFile file, @PathVariable("ourServiceId") Integer ourServiceId) {

		OurService ourServiceOld = ourServiceRepository.findOne(ourServiceId);
		try {
			File fileOld = new File(ourServicesDeletionPath + ourServiceOld.getAttachment());
			if (fileOld.delete()) {
				System.out.println(fileOld.getName() + " FILE From Service Controller File Is Deleted!");
			} else {
				System.out.println("Delete operation Is Failed.");
			}
		} catch (Exception e) {
			System.out.println("Failed to Delete File !!");
		}

		String attachment = ourServicesUploadFile(file);
		if (attachment == null) {
			ourService.setAttachment(null);
		} else {
			ourService.setAttachment(attachment);
		}
		ourServiceRepository.save(ourService);
		return "redirect:/admin/service/index";
	}

	@RequestMapping(value = { "/admin/service/delete/{ourServiceId}" }, method = RequestMethod.GET)
	public String delete(Model model,@PathVariable("ourServiceId") Integer ourServiceId) {

		OurService ourServiceOld = ourServiceRepository.findOne(ourServiceId);
		try {
			File fileOld = new File(ourServicesDeletionPath + ourServiceOld.getAttachment());
			if (fileOld.delete()) {
				System.out.println(fileOld.getName() + " FILE From Service Controller File Is Deleted!");
			} else {
				System.out.println("Delete operation Is Failed.");
			}
		} catch (Exception e) {
			System.out.println("Failed to Delete File !!");
		}

		ourServiceRepository.delete(ourServiceId);
		return "redirect:/admin/service/index";
	}
}
