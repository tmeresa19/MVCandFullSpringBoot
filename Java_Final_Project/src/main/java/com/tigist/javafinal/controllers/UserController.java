package com.tigist.javafinal.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tigist.javafinal.models.LoginUser;
import com.tigist.javafinal.models.User;
import com.tigist.javafinal.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	
	//==========================RENDER LOGIN AND REGISTRATION FORM======================================//
	
	@GetMapping("/")
	public String renderLoginRegForm(Model model) {
		model.addAttribute("newUser", new User());//instantiate a new User obj (display blank/empty form:form with out any errors)
		model.addAttribute("newLogin", new LoginUser()); //display a new loginUser obj (blank form)(but no more instantiating a user since no need of those other fields of the user object.
		return "loginreg.jsp";
	}
	
	//==============================REGISTER============================================================//
	
	@PostMapping("/register")
	public String processRegister(@Valid @ModelAttribute("newUser")User newUser, BindingResult result, Model model, HttpSession session) {
		User registeredUser = userService.register(newUser,  result);		
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());//since loginreg.jsp is the main page and requires both newUser and loginUser forms to be rendered
			return "loginreg.jsp"; //loginreg.jsp renders the register form with all the errors that captured.
		}else {
			session.setAttribute("userId", registeredUser.getId());
			session.setAttribute("userName", registeredUser.getName());
			return "redirect:/claasses";
		}	
	}
	
	//==================================LOGIN=============================================================//
	
	@PostMapping("/login")
	public String processLogin(@Valid @ModelAttribute("newLogin")LoginUser newLogin, BindingResult result, Model model, HttpSession session){
		User loginUser = userService.login(newLogin,  result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());//since loginreg.jsp requires both newUser and loginUser forms to be rendered
			return "loginreg.jsp";
		}else {
			session.setAttribute("userId", loginUser.getId());//unlike for register, for login, we don't save anything except saving the using info in session and redirect to pages with resources. However, before displaying the resource to the logged in user, first need to check the user's id in session in the @GetMapping("/donations") route for route protection)
			return "redirect:/claasses";
		}
				
	}
	
	//===============================LOGOUT===========================================================//
	
	@GetMapping("/logout")
	public String processLogout(HttpSession session) {
		session.invalidate();	
		return "redirect:/";
	}
	
}
