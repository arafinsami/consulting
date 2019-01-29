package com.consulting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.consulting.helpers.WebGalleryHelper;
import com.consulting.models.Gallery;
import com.consulting.models.GalleryContent;
import com.consulting.repositories.GalleryContentRepository;
import com.consulting.repositories.GalleryRepository;

@Controller
public class WebsiteGalleryController {

	@Autowired
	private GalleryRepository galleryRepository;

	@Autowired
	private GalleryContentRepository galleryContentRepository;

	@Autowired
	private WebGalleryHelper webGalleryHelper;

	@RequestMapping("/gallery")
	public String gallery(Model model) {

		webGalleryHelper.setData(model);
		return "website/index";
	}

	@RequestMapping(value = "/gallery/{id}")
	public String gallery(Model model, @PathVariable("id") Integer id) {

		Gallery gallery = galleryRepository.findOne(id);
		webGalleryHelper.setData(model, gallery);	
		return "website/index";
	}

	@RequestMapping(value = "/gallery/details/{id}")
	public String galleryContentDetails(Model model, @PathVariable("id") Integer id) {

		GalleryContent galleryContent = galleryContentRepository.findOne(id);
		webGalleryHelper.setData(model, galleryContent);
		return "website/index";
	}

}
