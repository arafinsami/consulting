package com.consulting.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.consulting.models.Gallery;
import com.consulting.models.GalleryContent;
import com.consulting.repositories.GalleryRepository;

@Component
public class AdminGalleryHelper {

	@Autowired
	private GalleryRepository galleryRepository;

	public void setGalleryData(Model model, Page<Gallery> galleries, Integer page, Integer size) {
		model.addAttribute("title", "Admin Gallery");
		model.addAttribute("pages", "gallery/index");
		model.addAttribute("page", page);
		model.addAttribute("size", size);
		model.addAttribute("galleries", galleries);
	}

	public void setGalleryData(Model model, Gallery gallery) {
		model.addAttribute("title", "Admin Gallery");
		model.addAttribute("pages", "gallery/create");
		model.addAttribute("gallery", gallery);
		model.addAttribute("action", "/admin/gallery/create");
	}

	public void setGalleryData(Model model, Gallery gallery, Integer galleryId) {
		model.addAttribute("title", "Admin Gallery");
		model.addAttribute("pages", "gallery/create");
		model.addAttribute("gallery", gallery);
		model.addAttribute("action", "/admin/gallery/create/" + galleryId);
	}

	public void setGalleryContentData(Model model, Page<GalleryContent> galleryContents, Integer page, Integer size) {
		model.addAttribute("title", "Gallery Content");
		model.addAttribute("pages", "gallery-content/index");
		model.addAttribute("galleryContents", galleryContents);
		model.addAttribute("page", page);
		model.addAttribute("size", size);
	}

	public void setGalleryContentData(Model model, GalleryContent galleryContent) {
		model.addAttribute("title", "Gallery Content");
		model.addAttribute("pages", "gallery-content/create");
		model.addAttribute("galleryContent", galleryContent);
		model.addAttribute("galleries", galleryRepository.findAll());
		model.addAttribute("action", "/admin/gallery-content/create");
	}
	
	public void setGalleryContentData(Model model, GalleryContent galleryContent,Integer galleryContentId) {
		model.addAttribute("title", "Gallery Content");
		model.addAttribute("pages", "gallery-content/create");
		model.addAttribute("galleryContent", galleryContent);
		model.addAttribute("galleries", galleryRepository.findAll());
		model.addAttribute("action", "/admin/gallery-content/create/" +galleryContentId);
	}
}
