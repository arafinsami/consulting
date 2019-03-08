package com.consulting.controllers;

import java.io.File;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.consulting.models.ChooseUs;
import com.consulting.models.ChooseUsList;
import com.consulting.repositories.ChooseUsListRepository;
import com.consulting.repositories.ChooseUsRepository;

@Controller
public class AdminChooseUsController extends BaseController {

	@Value("${whyChooseUsUploadPath}")
	String whyChooseUsUploadPath;

	@Value("${whyChooseUsDeletionPath}")
	String whyChooseUsDeletionPath;

	@Autowired
	private ChooseUsRepository chooseUsRepository;

	@Autowired
	private ChooseUsListRepository chooseUsListRepository;

	@Autowired
	public DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	@RequestMapping("/admin/why-choose-us/index")
	public String index(Model model) {

		model.addAttribute("pages", "why-choose-us/index");
		model.addAttribute("chooses", chooseUsRepository.findAll());
		model.addAttribute("title", "why choose us");
		return "admin/index";
	}

	@RequestMapping("/admin/why-choose-us/create")
	public String create(Model model) {

		ChooseUs chooseUs = new ChooseUs();
		model.addAttribute("chooseUs", chooseUs);
		model.addAttribute("title", "why choose us");
		model.addAttribute("pages", "why-choose-us/create");
		model.addAttribute("action", "/admin/why-choose-us/create");
		return "admin/index";
	}

	@RequestMapping(value = { "/admin/why-choose-us/create" }, method = RequestMethod.POST)
	public String save(Model model, @ModelAttribute("chooseUs") ChooseUs chooseUs,
			@RequestParam("chooseUsUpload") MultipartFile file) {

		String attachment = chooseUsUploadFile(file);
		if (attachment == null) {
			chooseUs.setAttachment(null);
		} else {
			chooseUs.setAttachment(attachment);
		}
		chooseUsRepository.save(chooseUs);
		return "redirect:/admin/why-choose-us/index";
	}

	@RequestMapping("/admin/why-choose-us/delete/{id}")
	public String deleteContent(Model model, @PathVariable("id") Integer id) {

		ChooseUs chooseUsOld = chooseUsRepository.findOne(id);
		try {
			File fileOld = new File(whyChooseUsDeletionPath + chooseUsOld.getAttachment());
			if (fileOld.delete()) {
				System.out.println(fileOld.getName() + " FILE Is Deleted!");
			} else {
				System.out.println("Delete operation Is Failed.");
			}
		} catch (Exception e) {
			System.out.println("Failed to Delete File !!");
		}
		chooseUsRepository.delete(id);
		return "redirect:/admin/why-choose-us/index";
	}

	@RequestMapping("/admin/why-choose-us-list/index")
	public String indexList(Model model) {

		model.addAttribute("pages", "why-choose-us-list/index");
		model.addAttribute("chooses", chooseUsListRepository.findAll());
		model.addAttribute("title", "why choose us List");

		return "admin/index";
	}

	@RequestMapping("/admin/why-choose-us-list/create")
	public String createList(Model model) {

		ChooseUsList chooseUsList = new ChooseUsList();
		model.addAttribute("chooseUsList", chooseUsList);
		model.addAttribute("title", "why choose us List");
		model.addAttribute("pages", "why-choose-us-list/create");
		model.addAttribute("chooses", chooseUsRepository.findAll());
		model.addAttribute("action", "/admin/why-choose-us-list/create");
		return "admin/index";
	}

	@RequestMapping(value = { "/admin/why-choose-us-list/create" }, method = RequestMethod.POST)
	public String saveList(Model model, @ModelAttribute("chooseUsList") ChooseUsList chooseUsList) {

		chooseUsListRepository.save(chooseUsList);
		return "redirect:/admin/why-choose-us-list/index";
	}

	@RequestMapping("/admin/why-choose-us-list/delete/{id}")
	public String deleteContentList(Model model, @PathVariable("id") Integer id) {

		jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		String deleteQuery = "DELETE FROM choose_us_list WHERE id = ?";
		jdbcTemplate.update(deleteQuery, id);
		return "redirect:/admin/why-choose-us-list/index";
	}

}
