package com.howtodoinjava.demo.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import net.squadleader.people.Person;

@Component
public class EmployeeValidator implements Validator {

	public boolean supports(Class clazz) {
		return Person.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		// Validation for first name. Cannot be blank. Cannot have over 30 chars
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "FIRST_NAME", "error.firstName", "First name is required.");
		Person p = (Person) target;
		while (p.getFIRST_NAME().length() > 30) {
			errors.rejectValue("firstName", "error.FIRST_NAME.tooManyChars");
		}

		// Validation for last name. Cannot be blank. Cannot have over 30 chars
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "LAST_NAME", "error.lastName", "Last name is required.");
		if (p.getFIRST_NAME().length() > 30) {
			errors.rejectValue("lastName", "error.LAST_NAME.tooManyChars");
		}

		// Validation for email address. Cannot be blank. Must match with regex.
		final Pattern emailRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailRegex.matcher(p.getEMAIL());

		if (!matcher.find()) {
			errors.rejectValue("EMAIL", "error.email.invalid");
		}

		final Pattern authRegex = Pattern.compile("\\*69\\*69", Pattern.CASE_INSENSITIVE);
		Matcher AuthMatcher = authRegex.matcher(p.getAUTHORIZATION());

		if (!AuthMatcher.find()) {
			errors.rejectValue("AUTHORIZATION", "error.AUTHORIZATION");
		}

	}

}
