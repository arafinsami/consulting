package com.consulting.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.consulting.models.Gallery;
import com.consulting.models.GalleryContent;
import com.consulting.repositories.GalleryRepository;

@Component
public class WebGalleryHelper {

	@Autowired
	private GalleryRepository galleryRepository;

	public void setData(Model model) {
		model.addAttribute("title", "Gallery");
		model.addAttribute("pages", "gallery");
		model.addAttribute("galleryLists", galleryRepository.findAll());
	}

	public void setData(Model model, GalleryContent galleryContent) {
		model.addAttribute("pages", "gallery-content-details");
		model.addAttribute("galleryContent", galleryContent);
	}

	public void setData(Model model, Gallery gallery) {
		model.addAttribute("pages", "gallery-content");
		model.addAttribute("gallery", gallery);
	}
}
