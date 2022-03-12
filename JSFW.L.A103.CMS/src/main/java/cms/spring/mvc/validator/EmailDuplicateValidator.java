package cms.spring.mvc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cms.spring.mvc.services.MemberServices;

public class EmailDuplicateValidator implements ConstraintValidator<EmailDuplicate, String> {
	@Autowired 
	MemberServices memberServices;
	public void initialize(EmailDuplicate paramA) {
	}

	public boolean isValid(String EmailDuplicate, ConstraintValidatorContext ctx) {
		if (EmailDuplicate == null) {
			return false;
		} else {
			if(memberServices.checkEmailInDB(EmailDuplicate)) {
				return true;
			}
		}		
		return false;
	}

}
