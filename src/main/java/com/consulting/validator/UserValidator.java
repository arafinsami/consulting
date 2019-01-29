package com.consulting.validator;

import org.springframework.stereotype.*;
import org.springframework.validation.*;

import com.consulting.models.User;
import static com.consulting.utils.HtmlValidation.isHtml;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		User user = (User) target;

		boolean username = isHtml(user.getUsername());
		boolean password = isHtml(user.getPassword());
		
		if (username || user.getUsername() == null) {
			errors.rejectValue("username", "user.username");
		}

		if (password || user.getPassword() == null) {
			errors.rejectValue("password", "user.password");
		}
	}

}





