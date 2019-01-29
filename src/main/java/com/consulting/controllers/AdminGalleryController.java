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

import com.consulting.helpers.AdminGalleryHelper;
import com.consulting.models.Gallery;
import com.consulting.models.GalleryContent;
import com.consulting.repositories.GalleryContentRepository;
import com.consulting.repositories.GalleryRepository;

@Controller
public class AdminGalleryController extends BaseController {

	@Value("${galleryDeletionPath}")
	String galleryDeletionPath;

	@Value("${galleryContentDeletionPath}")
	String galleryContentDeletionPath;

	@Autowired
	private GalleryRepository galleryRepository;

	@Autowired
	private GalleryContentRepository galleryContentRepository;

	@Autowired
	private AdminGalleryHelper adminGalleryHelper;

	Integer size = new Integer(5);
	Integer page = new Integer(0);

	@RequestMapping("/admin/gallery/index")
	public String index(Model model, @RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {

		if (page == null) {
			page = 0;
		}
		if (size == null) {
			size = this.size;
		}
		Pageable pageable = new PageRequest(page, size);
		Page<Gallery> galleries = galleryRepository.findAllByOrderByGalleryIdDesc(pageable);
		adminGalleryHelper.setGalleryData(model, galleries, page, size);
		return "admin/index";
	}

	@RequestMapping("/admin/gallery/create")
	public String create(Model model) {
		Gallery gallery = new Gallery();
		adminGalleryHelper.setGalleryData(model, gallery);
		return "admin/index";
	}

	@RequestMapping("/admin/gallery/create/{galleryId}")
	public String edit(Model model, @PathVariable("galleryId") Integer galleryId) {
		Gallery gallery = galleryRepository.findOne(galleryId);
		adminGalleryHelper.setGalleryData(model, gallery, galleryId);
		return "admin/index";
	}

	@RequestMapping(value = { "/admin/gallery/create" }, method = RequestMethod.POST)
	public String save(Model model, @ModelAttribute("gallery") Gallery gallery,
			@RequestParam("galleryUpload") MultipartFile file) {

		String attachment = galleryThemeUploadFile(file);
		if (attachment == null) {
			gallery.setAttachment(null);
		} else {
			gallery.setAttachment(attachment);
		}
		galleryRepository.save(gallery);
		return "redirect:/admin/gallery/index";
	}

	@RequestMapping(value = { "/admin/gallery/create/{galleryId}" }, method = RequestMethod.POST)
	public String update(Model model, @ModelAttribute("gallery") Gallery gallery,
			@RequestParam("galleryUpload") MultipartFile file, @PathVariable("galleryId") Integer galleryId) {

		Gallery galleryOld = galleryRepository.findOne(galleryId);
		try {
			File fileOld = new File(galleryDeletionPath + galleryOld.getAttachment());
			if (fileOld.delete()) {
				System.out.println(fileOld.getName() + " FILE From Gallery Controller File Is Deleted!");
			} else {
				System.out.println("Delete operation Is Failed.");
			}
		} catch (Exception e) {
			System.out.println("Failed to Delete File !!");
		}

		String attachment = galleryThemeUploadFile(file);
		if (attachment == null) {
			gallery.setAttachment(null);
		} else {
			gallery.setAttachment(attachment);
		}
		galleryRepository.save(gallery);
		return "redirect:/admin/gallery/index";
	}

	@RequestMapping("/admin/gallery/delete/{galleryId}")
	public String delete(Model model, @PathVariable("galleryId") Integer galleryId) {

		Gallery galleryOld = galleryRepository.findOne(galleryId);
		try {
			File fileOld = new File(galleryDeletionPath + galleryOld.getAttachment());
			if (fileOld.delete()) {
				System.out.println(fileOld.getName() + " FILE From Gallery Controller File Is Deleted!");
			} else {
				System.out.println("Delete operation Is Failed.");
			}
		} catch (Exception e) {
			System.out.println("Failed to Delete File !!");
		}

		galleryRepository.delete(galleryId);
		return "redirect:/admin/gallery/index";
	}

	@RequestMapping("/admin/gallery-content/index")
	public String indexGalleryContent(Model model, @RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {

		if (page == null) {
			page = 0;
		}
		if (size == null) {
			size = this.size;
		}
		Pageable pageable = new PageRequest(page, size);
		Page<GalleryContent> galleryContents = galleryContentRepository.findAllByOrderByGalleryContentIdDesc(pageable);
		adminGalleryHelper.setGalleryContentData(model, galleryContents, page, size);
		return "admin/index";
	}

	@RequestMapping("/admin/gallery-content/create")
	public String createGalleryContentcreate(Model model) {
		GalleryContent galleryContent = new GalleryContent();
		adminGalleryHelper.setGalleryContentData(model, galleryContent);
		return "admin/index";
	}

	@RequestMapping("/admin/gallery-content/create/{galleryContentId}")
	public String editGalleryContent(Model model, @PathVariable("galleryContentId") Integer galleryContentId) {
		GalleryContent galleryContent = galleryContentRepository.findOne(galleryContentId);
		adminGalleryHelper.setGalleryContentData(model, galleryContent, galleryContentId);
		return "admin/index";
	}

	@RequestMapping(value = { "/admin/gallery-content/create" }, method = RequestMethod.POST)
	public String saveGalleryContent(Model model, @ModelAttribute("galleryContent") GalleryContent galleryContent,
			@RequestParam("galleryContent") MultipartFile file) {

		String attachment = galleryContentUploadFile(file);
		if (attachment == null) {
			galleryContent.setAttachment(null);
		} else {
			galleryContent.setAttachment(attachment);
		}
		galleryContentRepository.save(galleryContent);
		return "redirect:/admin/gallery-content/index";
	}

	@RequestMapping(value = { "/admin/gallery-content/create/{galleryContentId}" }, method = RequestMethod.POST)
	public String updateGalleryContent(Model model, @ModelAttribute("galleryContent") GalleryContent galleryContent,
			@RequestParam("galleryContent") MultipartFile file,
			@PathVariable("galleryContentId") Integer galleryContentId) {

		GalleryContent galleryContentOld = galleryContentRepository.findOne(galleryContentId);
		try {
			File fileOld = new File(galleryContentDeletionPath + galleryContentOld.getAttachment());
			if (fileOld.delete()) {
				System.out.println(fileOld.getName() + " FILE From Gallery Controller File Is Deleted!");
			} else {
				System.out.println("Delete operation Is Failed.");
			}
		} catch (Exception e) {
			System.out.println("Failed to Delete File !!");
		}

		String attachment = galleryContentUploadFile(file);
		if (attachment == null) {
			galleryContent.setAttachment(null);
		} else {
			galleryContent.setAttachment(attachment);
		}
		galleryContentRepository.save(galleryContent);
		return "redirect:/admin/gallery-content/index";
	}

	@RequestMapping("/admin/gallery-content/delete/{galleryContentId}")
	public String deleteContent(Model model, @PathVariable("galleryContentId") Integer galleryContentId) {

		GalleryContent galleryContentOld = galleryContentRepository.findOne(galleryContentId);
		try {
			File fileOld = new File(galleryContentDeletionPath + galleryContentOld.getAttachment());
			if (fileOld.delete()) {
				System.out.println(fileOld.getName() + " FILE From Gallery Controller File Is Deleted!");
			} else {
				System.out.println("Delete operation Is Failed.");
			}
		} catch (Exception e) {
			System.out.println("Failed to Delete File !!");
		}
		galleryContentRepository.delete(galleryContentId);
		return "redirect:/admin/gallery-content/index";
	}

}
