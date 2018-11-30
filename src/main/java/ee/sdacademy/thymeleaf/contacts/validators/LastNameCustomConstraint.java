package ee.sdacademy.thymeleaf.contacts.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Ryan Alexander on 30/11/2018.
 */

@Documented
// what is specifically implemented is featured in LastNameCustomValidator.class
@Constraint(validatedBy = LastNameCustomValidator.class)

// for getters,setters and fields
@Target( { ElementType.METHOD, ElementType.FIELD })

// our default message
@Retention(RetentionPolicy.RUNTIME)
public @interface LastNameCustomConstraint {

    String message() default "Surname must end with 'ova' [Russian women only]";

    // mandatory, copied from '@interface Min' library
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    // explicitly defining
    String expectedCustomConstraint();
}
