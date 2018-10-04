package com.exilant.myblog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.exilant.myblog.dao.UserRepository;
import com.exilant.myblog.form.RegisterForm;
import com.exilant.myblog.model.User;
@Component
public class UserValidation implements Validator {

	 //common-validator library.
	    //private EmailValidator emailValidator = EmailValidator.getInstance();
	 
	    @Autowired
	    private UserRepository userrepo;
	 
	    
	    @Override
	    public boolean supports(Class<?> clazz) {
	        return clazz == RegisterForm.class;
	    }
	 
	    @Override
	    public void validate(Object target, Errors errors) {
	    	RegisterForm registerForm = (RegisterForm) target;
	 
	        // Check the fields of AppUserForm.
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty.registerForm.userName");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.registerForm.firstName");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.registerForm.email");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.registerForm.password");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty.registerForm.confirmPassword");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "NotEmpty.registerForm.gender");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "countryCode", "NotEmpty.registerForm.countryCode");
	 
//	        if (!this.emailValidator.isValid(appUserForm.getEmail())) {
//	            // Invalid email.
//	            errors.rejectValue("email", "Pattern.appUserForm.email");
//	        } else if (appUserForm.getUserId() == null) {
//	            User dbUser = appUserDAO.findAppUserByEmail(appUserForm.getEmail());
//	            if (dbUser != null) {
//	                // Email has been used by another account.
//	                errors.rejectValue("email", "Duplicate.appUserForm.email");
//	            }
//	        }
	 
	        if (!errors.hasFieldErrors("userName")) {
	            User dbUser = userrepo.UserByName(registerForm.getUserName());
	            if (dbUser != null) {
	                
	                errors.rejectValue("userName", "Duplicate.Form.userName");
	            }
	        }
//	 
//	        if (!errors.hasErrors()) {
//	            if (!Form.getConfirmPassword().equals(Form.getPassword())) {
//	                errors.rejectValue("confirmPassword", "Match.RegisterForm.confirmPassword");
//	            }
//	        }
	    }

}
