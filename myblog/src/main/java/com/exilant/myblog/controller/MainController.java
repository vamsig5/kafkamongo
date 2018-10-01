package com.exilant.myblog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.exilant.myblog.dao.CountryDao;
import com.exilant.myblog.form.LoginForm;
import com.exilant.myblog.form.RegisterForm;
import com.exilant.myblog.model.Country;
import com.exilant.myblog.model.User;
import com.exilant.myblog.services.LoginService;
import com.exilant.myblog.services.UserService;
import com.exilant.myblog.services.UserValidation;

@Controller
public class MainController {

	@Autowired
	private UserService usService; 
	
	@Autowired
	private LoginService login;
	
	@Autowired
	private CountryDao country;
	
	@Autowired
	private UserValidation usvalid;
	
	
	@RequestMapping("/")
	public String Home(Model  model) {
		return "home";	
		}
	
	
	
	 @InitBinder
	   protected void initBinder(WebDataBinder dataBinder) {
	   
	      Object target = dataBinder.getTarget();
	      if (target == null) {
	         return;
	      }
	      System.out.println("Target=" + target);
	 
	      if (target.getClass() == RegisterForm.class) {
	         dataBinder.setValidator(usvalid);
	      }
	 
	   }
	 
	 @RequestMapping(value = "/register", method = RequestMethod.GET)
	   public String viewRegister(Model model) {
	 
	      RegisterForm form = new RegisterForm();
	      List<Country> countries = country.allCountries();
	 
	      model.addAttribute("form", form);
	      model.addAttribute("countries", countries);
	 
	      return "register";
	   }
	
	
	 @RequestMapping(value = "/register", method = RequestMethod.POST)
	   public String saveRegister(Model model, 
	         @ModelAttribute("form") @Validated RegisterForm form, 
	         BindingResult result, 
	         final RedirectAttributes redirectAttributes) {
	 User user=new User();
	  model.addAttribute(form);
	      if (result.hasErrors()) {
	         List<Country> countries = country.allCountries();
	         model.addAttribute("countries", countries);
	         return "register";
	      }
	      
	      try {
	         user = usService.saveUser(form);
	         
	      }
	     
	      catch (Exception e) {
	         List<Country> countries = country.allCountries();
	         model.addAttribute("countries", countries);
	         model.addAttribute("errorMessage", "Error: " + e.getMessage());
	         return "register";
	      }
	     
	      redirectAttributes.addFlashAttribute("flashUser", user);
	       
	      return "redirect:/";
	   }
	 
//	 @RequestMapping(value = "/login")
//	    public String loginPage(@Valid LoginForm loginForm, BindingResult bindingResult) {
//	        if (bindingResult.hasErrors()) {
//	         
//	             return "login1";
//	        }
//	       // String username=loginForm.getUsername();
//
//	        if (!login.authenticate(
//	             loginForm.getUsername(), loginForm.getPassword())) {
//	            
//	             return "login1";
//	        }
//
//	        
//	        return "loginSuccess";
//	    }
	 
}
