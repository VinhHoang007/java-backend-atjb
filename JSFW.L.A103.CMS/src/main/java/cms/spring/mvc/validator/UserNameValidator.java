package cms.spring.mvc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cms.spring.mvc.services.MemberServices;

public class UserNameValidator implements ConstraintValidator<UserName, String> {
	@Autowired MemberServices memberServices;
	public void initialize(UserName paramA) {
	}

	public boolean isValid(String userName, ConstraintValidatorContext ctx) {
		if (userName == null) {
			return false;
		}else {
			if(memberServices.checkUserNameInDB(userName)) {
				return true;
			}
		}
		return false;
	}

}
