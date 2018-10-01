package com.exilant.myblog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.exilant.myblog.dao.UserRepository;
import com.exilant.myblog.form.RegisterForm;
import com.exilant.myblog.model.User;
@Service
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
	    	RegisterForm Form = (RegisterForm) target;
	 
	        // Check the fields of AppUserForm.
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty.RegisterForm.userName");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.RegisterForm.firstName");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.RegisterForm.email");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.RegisterForm.password");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty.RegisterForm.confirmPassword");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "NotEmpty.RegisterForm.gender");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "countryCode", "NotEmpty.RegisterForm.countryCode");
	 
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
	            User dbUser = userrepo.UserByName(Form.getUserName());
	            if (dbUser != null) {
	                
	                errors.rejectValue("userName", "Duplicate.RegisterForm.userName");
	            }
	        }
	 
	        if (!errors.hasErrors()) {
	            if (!Form.getConfirmPassword().equals(Form.getPassword())) {
	                errors.rejectValue("confirmPassword", "Match.RegisterForm.confirmPassword");
	            }
	        }
	    }

}
