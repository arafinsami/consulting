package com.consulting.helpers;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.consulting.models.User;

@Component
public class LoginHelper {

	
	public void setLogindata(Model model,User user) {
		model.addAttribute("title", "Login");
		model.addAttribute("pages", "login");
		model.addAttribute("user", user);
	}

}
