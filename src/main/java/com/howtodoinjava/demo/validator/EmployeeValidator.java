package com.howtodoinjava.demo.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import java.util.regex.*;
import com.howtodoinjava.demo.model.EmployeeVO;

@Component
public class EmployeeValidator implements Validator {

	public boolean supports(Class clazz) {
		return EmployeeVO.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		// Validation for first name. Cannot be blank. Cannot have over 30 chars
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.firstName", "First name is required.");
		EmployeeVO p = (EmployeeVO) target;
		if (p.getFirstName().length() > 30) {
			errors.rejectValue("firstName", "error.firstName.tooManyChars");
		}

		// Validation for last name. Cannot be blank. Cannot have over 30 chars
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.lastName", "Last name is required.");
		if (p.getFirstName().length() > 30) {
			errors.rejectValue("lastName", "error.lastName.tooManyChars");
		}

		// Validation for email address. Cannot be blank. Must match with regex.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.email", "Email is required.");
		final Pattern emailRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailRegex.matcher(p.getEmail());

		if (!matcher.find()) {
			errors.rejectValue("email", "error.email.invalid");
		}

		// NEEDS TO VALIDATE ADDRESS DYNAMICALLY THROUGH API
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "streetAddress", "error.streetAddress",
				"Street Address Required.");

		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "error.city", "City Required.");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "error.state", "State Required.");

	}

}
