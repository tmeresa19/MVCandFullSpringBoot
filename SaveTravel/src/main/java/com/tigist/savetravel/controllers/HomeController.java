package com.tigist.savetravel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.tigist.savetravel.models.Donation;
import com.tigist.savetravel.services.DonationService;

import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	@Autowired
	private DonationService donationService;
	
	//=========================DISPLAY ALL DONATIONS=======================
	
	@GetMapping("/donations")
	public String donationBoard(Model model) { //since this is for the jsp page, the return type should be String. Otherwise, it should be type of Donation
		List<Donation> donationList = donationService.allDonations();
		model.addAttribute("donationList", donationList);
		return "dashboard.jsp";
	}
	
	//======================GET A DONATION'S DETAILS BY ID====================
	
	@GetMapping("/donations/{id}")
	public String donationDetails(@PathVariable("id")Long id, Model model) {
		Donation oneDonation = donationService.findDonation(id);
		model.addAttribute("oneDonation", oneDonation);
		return "details.jsp";
	}
	
	//==========================RENDER A CREATE PAGE============================
	
	@GetMapping("/donations/new")
	public String renderCreateForm(Model model) {
		//alternative way is to use: @ModelAttribute("newDonation")Donation newDonation to create an empty donation. NB: for this alternative way to work, we must have zero argument constructor
		Donation newDonation = new Donation();
		model.addAttribute("newDonation", newDonation);
		return "createPage.jsp";
	}
	
	//===========================CREATE and SAVE A DONATION TO DB=================
	
	@PostMapping("/donations/new")
	public String processCreateForm(
			@Valid @ModelAttribute("newDonation")Donation newDonation, //NB:"newDonation" is same as what's in z form. But, newDonation without the quotation is the new donation that we created
			BindingResult result
			) {
		if(result.hasErrors()) { //if any of the fields are invalid
			return "createPage.jsp"; //return the same create page WITH ALL the ERRORS(need to render the page not redirect NB)
		}else {
		
		//Spring MVC thru DataBinding makes it easy to collect all the form inputs and automatically bundle it into an object 
		//since behind the scene the donation is bound to the jsp thru the view model(by view model, we don't have to manually create the donation like: 
		//Donation newDonation = new Donation(id, donationName, donor, ....) THe below line is enough to create it
		
		donationService.createDonation(newDonation);
		return "redirect:/donations";
		
		//(by view model, we mean Model model or dependency injection)

		}
	}
	
	//==========================RENDER EDIT PAGE==================================
	
	@GetMapping("/donations/edit/{id}")
	public String renderEditForm(
			@PathVariable("id")Long id,
			Model model) {
		Donation oneDonation = donationService.findDonation(id);
		model.addAttribute("oneDonation", oneDonation); //note that this oneDonation should be the same as what's in the edit page
		return "editPage.jsp";
	}
	
	
	//========================EDIT AND SAVE TO DB=================================
	
	@PutMapping("/donations/edit/{id}")
	public String processEditForm(
			@Valid @ModelAttribute("oneDonation")Donation oneDonation, 
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "editPage.jsp"; //go back to the same edit page
		}else {
		
		//Spring MVC thru DataBinding makes it easy to collect all the form inputs and automatically bundle it into an object 
		//since behind the scene the donation is bound to the jsp thru the view model(by view model, we don't have to manually create the donation like: 
		//Donation newDonation = new Donation(id, donationName, donor, ....) THe below line is enough to create it
		
		donationService.updateDonation(oneDonation);
		return "redirect:/donations";
		//After editing, if I want to go to the details page of whatever I updated/edited instead of redirecting to the /donations page, 
		//then, I need to use the id during the redirect like below line of code since I already used the @PathVariable("id"):
		
		// return "redirect:/donations/{id}";
		
		
		//(by view model, we mean Model model or dependency injection)

		}
	}
	
	@DeleteMapping("/donations/{id}")
	public String deleteDonation(@PathVariable("id")Long id) {
		donationService.removeDonation(id);
//		System.out.println("Delete working");
		return "redirect:/donations";
	}
	
	//==================ROUTES FOR MAIN PAGE================
	
	@GetMapping("/")
	public String mainPage(Model model) {
		//1. to display a dashboard
		model.addAttribute("donationList", donationService.allDonations());
		
		//2. to render a create form
		model.addAttribute("newDonation", new Donation());//to create empty object
		
		return "main.jsp";
	}
	
	@PostMapping("/process")
	public String processMainCreate(
			@Valid @ModelAttribute("newDonation") Donation newDonation, BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			model.addAttribute("donationList", donationService.allDonations());
			return "main.jsp";
		}else
			donationService.createDonation(newDonation);
			return "redirect:/";
		
	}
}

//=============COMMON ERRORS TO RENDER A FORM:=================
//1. modelAttribute should match (form:form & GetMapping model)
//2. path must match the attribute with getters
//3. constructor with zero argument is required to use @ModelAttribute("newDonation")Donation newDonation 

//NB application.properties is like .env file in MERN. We can save api keys in application.properties file since we are saving db pw too










