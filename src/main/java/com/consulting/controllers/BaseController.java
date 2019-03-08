package com.consulting.controllers;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.multipart.MultipartFile;

public class BaseController {

	@Autowired
	HttpServletRequest httpServletRequest;

	@Value("${galleryUploadPath}")
	String galleryUploadPath;

	@Value("${ourBusinessUploadPath}")
	String ourBusinessUploadPath;

	@Value("${ourProcessUploadPath}")
	String ourProcessUploadPath;

	@Value("${ourServicesUploadPath}")
	String ourServicesUploadPath;
	
	@Value("${teamUploadPath}")
	String teamUploadPath;
	
	@Value("${sliderUploadPath}")
	String sliderUploadPath;
	
	@Value("${attachmentUploadPath}")
	String attachmentUploadPath;
	
	@Value("${galleryContentUploadPath}")
	String galleryContentUploadPath;
	
	@Value("${whyChooseUsUploadPath}")
	String whyChooseUsUploadPath;
	
	protected String getUsername() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

	protected String galleryThemeUploadFile(MultipartFile file) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-");
		String date = dateFormat.format(new Date());
		String name = date + file.getOriginalFilename().replace(' ', '-');
		String userNameDirectory = SecurityContextHolder.getContext().getAuthentication().getName();
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				File dir = new File(galleryUploadPath + "/" + userNameDirectory);
				if (!dir.exists())
					dir.mkdirs();
				File serverFile = new File(dir + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				return userNameDirectory + "/" + name;
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}
	
	protected String galleryContentUploadFile(MultipartFile file) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-");
		String date = dateFormat.format(new Date());
		String name = date + file.getOriginalFilename().replace(' ', '-');
		String userNameDirectory = SecurityContextHolder.getContext().getAuthentication().getName();
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				File dir = new File(galleryContentUploadPath + "/" + userNameDirectory);
				if (!dir.exists())
					dir.mkdirs();
				File serverFile = new File(dir + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				return userNameDirectory + "/" + name;
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}

	protected String ourBusinessUploadFile(MultipartFile file) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-");
		String date = dateFormat.format(new Date());
		String name = date + file.getOriginalFilename().replace(' ', '-');
		String userNameDirectory = SecurityContextHolder.getContext().getAuthentication().getName();
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				File dir = new File(ourBusinessUploadPath + "/" + userNameDirectory);
				if (!dir.exists())
					dir.mkdirs();
				File serverFile = new File(dir + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				return userNameDirectory + "/" + name;
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}

	protected String ourProcessUploadFile(MultipartFile file) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-");
		String date = dateFormat.format(new Date());
		String name = date + file.getOriginalFilename().replace(' ', '-');
		String userNameDirectory = SecurityContextHolder.getContext().getAuthentication().getName();
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				File dir = new File(ourProcessUploadPath + "/" + userNameDirectory);
				if (!dir.exists())
					dir.mkdirs();
				File serverFile = new File(dir + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				return userNameDirectory + "/" + name;
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}

	protected String ourServicesUploadFile(MultipartFile file) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-");
		String date = dateFormat.format(new Date());
		String name = date + file.getOriginalFilename().replace(' ', '-');
		String userNameDirectory = SecurityContextHolder.getContext().getAuthentication().getName();
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				File dir = new File(ourServicesUploadPath + "/" + userNameDirectory);
				if (!dir.exists())
					dir.mkdirs();
				File serverFile = new File(dir + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				return userNameDirectory + "/" + name;
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}
	
	
	protected String teamUploadFile(MultipartFile file) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-");
		String date = dateFormat.format(new Date());
		String name = date + file.getOriginalFilename().replace(' ', '-');
		String userNameDirectory = SecurityContextHolder.getContext().getAuthentication().getName();
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				File dir = new File(teamUploadPath + "/" + userNameDirectory);
				if (!dir.exists())
					dir.mkdirs();
				File serverFile = new File(dir + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				return userNameDirectory + "/" + name;
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}

	
	protected String sliderUploadFile(MultipartFile file) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-");
		String date = dateFormat.format(new Date());
		String name = date + file.getOriginalFilename().replace(' ', '-');
		String userNameDirectory = SecurityContextHolder.getContext().getAuthentication().getName();
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				File dir = new File(sliderUploadPath + "/");
				if (!dir.exists())
					dir.mkdirs();
				File serverFile = new File(dir + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				return  "/" + name;
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}
	
	protected String menuContentUploadFile(MultipartFile file) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-");
		String date = dateFormat.format(new Date());
		String name = date + file.getOriginalFilename().replace(' ', '-');
		String userNameDirectory = SecurityContextHolder.getContext().getAuthentication().getName();
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				File dir = new File(attachmentUploadPath + "/" + userNameDirectory);
				if (!dir.exists())
					dir.mkdirs();
				File serverFile = new File(dir + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				return userNameDirectory + "/" + name;
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}
	
	
	protected String chooseUsUploadFile(MultipartFile file) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-");
		String date = dateFormat.format(new Date());
		String name = date + file.getOriginalFilename().replace(' ', '-');
		String userNameDirectory = SecurityContextHolder.getContext().getAuthentication().getName();
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				File dir = new File(whyChooseUsUploadPath + "/" + userNameDirectory);
				if (!dir.exists())
					dir.mkdirs();
				File serverFile = new File(dir + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				return userNameDirectory + "/" + name;
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}
}
