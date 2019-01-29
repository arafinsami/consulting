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

import com.consulting.helpers.AdminSliderHelper;
import com.consulting.models.Slider;
import com.consulting.repositories.SliderRepository;

@Controller
public class AdminSliderController extends BaseController {

	@Value("${sliderDeletionPath}")
	String sliderDeletionPath;

	Integer size = new Integer(5);
	Integer page = new Integer(0);

	@Autowired
	private SliderRepository sliderRepository;

	@Autowired
	private AdminSliderHelper adminSliderHelper;

	@RequestMapping("/admin/slider/index")
	public String index(Model model, @RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {

		if (page == null) {
			page = 0;
		}
		if (size == null) {
			size = this.size;
		}
		Pageable pageable = new PageRequest(page, size);
		Page<Slider> sliders = sliderRepository.findAllByOrderBySliderIdDesc(pageable);
		adminSliderHelper.setData(model, sliders, page, size);
		return "admin/index";
	}

	@RequestMapping("/admin/slider/create")
	public String create(Model model) {
		Slider slider = new Slider();
		adminSliderHelper.setData(model, slider);
		return "admin/index";
	}

	@RequestMapping("/admin/slider/create/{sliderId}")
	public String edit(Model model, @PathVariable("sliderId") Integer sliderId) {
		Slider slider = sliderRepository.findOne(sliderId);
		adminSliderHelper.setData(model, slider, sliderId);
		return "admin/index";
	}

	@RequestMapping(value = { "/admin/slider/create" }, method = RequestMethod.POST)
	public String save(Model model, @ModelAttribute("slider") Slider slider,
			@RequestParam("sliderUpload") MultipartFile file) {

		String attachment = sliderUploadFile(file);

		if (attachment == null) {
			slider.setAttachment(null);
		} else {
			slider.setAttachment(attachment);
		}
		sliderRepository.save(slider);
		return "redirect:/admin/slider/index";
	}

	@RequestMapping(value = { "/admin/slider/create/{sliderId}" }, method = RequestMethod.POST)
	public String update(Model model, @ModelAttribute("slider") Slider slider,
			@RequestParam("sliderUpload") MultipartFile file, @PathVariable("sliderId") Integer sliderId) {

		Slider sliderOld = sliderRepository.findOne(sliderId);
		try {
			File fileOld = new File(sliderDeletionPath + sliderOld.getAttachment());
			if (fileOld.delete()) {
				System.out.println(fileOld.getName() + " FILE From Slider Controller File Is Deleted!");
			} else {
				System.out.println("Delete operation Is Failed.");
			}
		} catch (Exception e) {
			System.out.println("Failed to Delete File !!");
		}

		String attachment = sliderUploadFile(file);

		if (attachment == null) {
			slider.setAttachment(null);
		} else {
			slider.setAttachment(attachment);
		}
		sliderRepository.save(slider);
		return "redirect:/admin/slider/index";
	}
	
	
	
	@RequestMapping(value = { "/admin/slider/delete/{sliderId}" }, method = RequestMethod.GET)
	public String delete(Model model,@PathVariable("sliderId") Integer sliderId) {
		
		Slider sliderOld = sliderRepository.findOne(sliderId);
		try {
			File fileOld = new File(sliderDeletionPath + sliderOld.getAttachment());
			if (fileOld.delete()) {
				System.out.println(fileOld.getName() + " FILE From Slider Controller File Is Deleted!");
			} else {
				System.out.println("Delete operation Is Failed.");
			}
		} catch (Exception e) {
			System.out.println("Failed to Delete File !!");
		}
		
		sliderRepository.delete(sliderId);
		return "redirect:/admin/slider/index";
	}
}








