package cms.spring.mvc.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = UserNameValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface UserName {
	String message() default "{UserName}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
