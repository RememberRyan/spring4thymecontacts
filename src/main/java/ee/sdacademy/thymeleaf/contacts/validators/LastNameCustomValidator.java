package ee.sdacademy.thymeleaf.contacts.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Ryan Alexander on 30/11/2018.
 */

// Step 5. on this url https://www.baeldung.com/spring-mvc-custom-validator
public class LastNameCustomValidator implements ConstraintValidator<LastNameCustomConstraint, String> {

    private LastNameCustomConstraint lastNameCustomConstraint;

    @Override
    public void initialize (final LastNameCustomConstraint lastNameCustomConstraint) {
        this.lastNameCustomConstraint = lastNameCustomConstraint;
    }

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext ctx) {
        return value !=null && value.endsWith(lastNameCustomConstraint.expectedCustomConstraint());
    }
}
