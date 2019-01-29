package com.consulting.controllers;

import javax.servlet.http.*;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import com.consulting.validator.*;
import com.consulting.helpers.LoginHelper;
import com.consulting.models.*;
import com.consulting.service.*;

@Controller
public class LoginController {

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private LoginHelper loginHelper;

	@InitBinder("user")
	protected void initBinderForLogin(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		binder.addValidators(userValidator);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet(Model model) {

		User user = new User();
		loginHelper.setLogindata(model, user);
		return "website/index";

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {

		userValidator.validate(user, result);
		if (result.hasErrors()) {
			loginHelper.setLogindata(model, user);
			return "website/index";
		}
		securityService.autologin(user.getUsername(), user.getPassword());
		return "redirect:/admin";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession(false);
		if (request.isRequestedSessionIdValid() && session != null) {
			session.invalidate();
		}
		handleLogOutResponse(response, request);
		return "redirect:/login";
	}

	private void handleLogOutResponse(HttpServletResponse response, HttpServletRequest request) {

		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			cookie.setMaxAge(0);
			cookie.setValue(null);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
	}
}
