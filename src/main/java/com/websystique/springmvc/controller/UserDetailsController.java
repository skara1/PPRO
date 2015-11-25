package com.websystique.springmvc.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websystique.springmvc.model.Employee;
import com.websystique.springmvc.model.UserDetails;
import com.websystique.springmvc.service.EmployeeService;
import com.websystique.springmvc.service.UserDetailsService;

@Controller
@RequestMapping("/users/")
public class UserDetailsController {
	
	@Autowired
	UserDetailsService service;
	
	@Autowired
	MessageSource messageSource;
	
	
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {

		List<UserDetails> users = service.findAllUserDetails();
		model.addAttribute("users", users);
		return "allusers";
	}
	

	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		UserDetails user = new UserDetails();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		return "adduser";
	}
	

	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveUser(@Valid UserDetails user, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "adduser";
		}
	
		service.saveUserDetails(user);

		model.addAttribute("success", "uzivatel " + user.getFirstName()+ " uspesne pridan");
		return "useradded";
	}
	
	@RequestMapping(value = { "/edit-{id}-user" }, method = RequestMethod.GET)
	public String editUser(@PathVariable int id, ModelMap model) {
		UserDetails user = service.findById(id);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		return "adduser";
	}
	

	@RequestMapping(value = { "/edit-{id}-user" }, method = RequestMethod.POST)
	public String updateUser(@Valid UserDetails user, BindingResult result, ModelMap model, @PathVariable int id) {

		if (result.hasErrors()) {
			return "adduser";
		}

		service.updateUserDetails(user);

		model.addAttribute("success", "Uzivatel " + user.getFirstName() + " " + user.getLastName() + " upraven");
		return "useradded";
	}
	
	
	@RequestMapping(value = { "/delete-{id}-user" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable int id) {
		UserDetails user = service.findById(id);
		service.deleteUserDetails(user);
		return "redirect:list";
	}
	
	
	
	
}
