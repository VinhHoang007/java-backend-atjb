package cms.spring.mvc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, String> {

	public void initialize(Email paramA) {
	}

	public boolean isValid(String email, ConstraintValidatorContext ctx) {
		if (email == null) {
			return false;
		}
		return email.matches("[A-Za-z][A-Za-z0-9]+[@](gmail.com)");
	}

}
