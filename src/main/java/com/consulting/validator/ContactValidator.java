package com.consulting.validator;

import org.springframework.stereotype.*;
import org.springframework.validation.*;

import com.consulting.models.Contact;
import static com.consulting.utils.HtmlValidation.isHtml;

@Component
public class ContactValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Contact.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Contact contact = (Contact) target;

		boolean name = isHtml(contact.getName());
		boolean email = isHtml(contact.getEmail());
		boolean message = isHtml(contact.getMessage());

		if (name || contact.getName() == null) {
			errors.rejectValue("name", "contact.name");
		}

		if (email || contact.getEmail() == null) {
			errors.rejectValue("email", "contact.email");
		}
		
		if (message || contact.getMessage() == null) {
			errors.rejectValue("message", "contact.message");
		}
	}

}





