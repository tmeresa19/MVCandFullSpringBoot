package com.tigist.bookclub.controllers;

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

import com.tigist.bookclub.models.Donation;
import com.tigist.bookclub.services.DonationService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class DonationController {

	@Autowired
	private DonationService donationService;
	
	
    //===================================RENDER CREATE FORM============================================//

	@GetMapping("/donations/new")
	public String renderCreateDonationForm(@ModelAttribute("newDonation") Donation newDonation) {
		//if I want to select a donor from a list of users in a drop down field, I need to use the following line of code:
		//model.addAttribute("newDonation", new Donation());//this will grab all users from Service, and put it in Model model for jsp page
		return "createDonation.jsp";
	}
	
	//================================PROCESS CREATE=================================================//
	
	@PostMapping("/donations/new")
	public String processCreateDonation(@Valid @ModelAttribute("newDonation") Donation newDonation, BindingResult result) {
		
		if(result.hasErrors()) {
			return "createDonation.jsp";
		}else {
			donationService.createDonation(newDonation);
			return "redirect:/donations";
		}
	}
	
	//=================================DISPLAY DASHBOARD FOR DONATIONS=================================//
	
	@GetMapping("/donations")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("userId") == null){ //helps to check after logging out, if the user's session is indeed cleared or can access the dashboard.
			return "redirect:/";
		}
		model.addAttribute("donationList", donationService.allDonations());
		return "dashboard.jsp"; //if the user's id is found in the session(for the purpose of route protection), then display the dashboard/give access to resources
	}
	
	//==================================DETAILS --DISPLAY BY ID=========================================//
	
	@GetMapping("/donations/{id}")
	public String donationDetails(@PathVariable("id")Long id, Model model) {
		model.addAttribute("oneDonation", donationService.findOne(id));
		return "donationDetails.jsp";
	}
	
	//===================================RENDER EDIT FORM================================================//
	
	@GetMapping("/donations/edit/{id}")
	public String renderEditDonationForm(@PathVariable("id")Long id, Model model) {
		model.addAttribute("oneDonation", donationService.findOne(id));
		return "updateDonation.jsp";	
	}
	
	
	//==================================PROCESS EDIT AND SAVE TO DB=======================================//	
	
	@PutMapping("/donations/edit/{id}")
	public String processEditDonation(
			@Valid @ModelAttribute("oneDonation")Donation oneDonation, 
			BindingResult result, Model model) {
	
		if(result.hasErrors()) {
			return "updateDonation.jsp"; //go back to the same edit page
		}else {
			donationService.updateDonation(oneDonation);
			return "redirect:/donations";
	
		}
   }
	
	//===========================DELETE===============================================================//
	
	@DeleteMapping("/donations/{id}")
	public String deleteDonation(@PathVariable("id")Long id) {
		donationService.removeDonation(id);
		return "redirect:/donations";
	}
	
}
//	@GetMapping("/donations/edit/{id}")
//	public String renderEditDonationForm(@PathVariable("id")Long id, Model model, HttpSession session) {
//		Donation oneDonation = donationService.findOne(id);
//		if(!oneDonation.getDonor().getId().equals(session.getAttribute("userId")) ) {
//			return "redirect:/donations";
//		}
//		model.addAttribute("oneDonation", donationService.findOne(id));
//		return "updateDonation.jsp";	
//	}
	
//	//==================================PROCESS EDIT AND SAVE TO DB=======================================//	
//		
//		@PutMapping("/donations/edit/{id}")
//		public String processEditDonationForm(
//				@Valid @ModelAttribute("oneDonation")Donation oneDonation, 
//				BindingResult result, Model model) {
//		
//			if(result.hasErrors()) {
//				return "updateDonation.jsp"; //go back to the same edit page
//			}else {
//				donationService.updateDonation(oneDonation);
//				return "redirect:/donations";
//			
//			}
//		}


						//Spring MVC thru DataBinding makes it easy to collect all the form inputs and automatically bundle it into an object 
						//since behind the scene the expense is bound to the jsp thru the view model(by view model, we don't have to manually create the expense like: 
						//Expense newExpense = new Expense(id, expenseName, donor, ....) THe below line is enough to create it
						
						//After editing, if I want to go to the details page of whatever I updated/edited instead of redirecting to the /donations page, 
						//then, I need to use the id during the redirect like below line of code since I already used the @PathVariable("id"):

	// return "redirect:/donations/{id}";




