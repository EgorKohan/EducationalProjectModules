package dev.struchkov.services;

import javax.validation.*;
import java.util.Set;

public class ProgrammaticallyValidatingService {

    public void validateInput(Object obj) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(obj);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

}
