package br.com.itau.backendchallenge.validator;

import br.com.itau.backendchallenge.util.ValidPasswordUtil;
import br.com.itau.backendchallenge.validator.constraint.PasswordConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String> {
    @Override
    public boolean isValid(String pass, ConstraintValidatorContext constraintValidatorContext) {
        return ValidPasswordUtil.isValid(pass);
    }
}
