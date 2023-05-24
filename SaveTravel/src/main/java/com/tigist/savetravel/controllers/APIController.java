package com.tigist.savetravel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tigist.savetravel.models.Donation;
import com.tigist.savetravel.services.DonationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class APIController {
	//Service depends on Repository
	//Controller depends on Service
	//in the Service class(area), we do all the queries. Whereas, in the Controller class(area), we just call the service
	//for the service and the controller, we are doing same thing except
	
	@Autowired
	private DonationService donationService;
	
	//==============Get All donations
	
	@GetMapping("/donations")
	public List<Donation> findAllDonations(){
		return donationService.allDonations();
	}
	
	//===============Create================
	
	@PostMapping("/donations")
	public Donation addDonation(
			@RequestParam("donationName") String donationName,
			@RequestParam("donor") String donor,
			@RequestParam("quantity") Integer quantity,
			@RequestParam("description") String description
			) {
		
		//Then, create a new donation using the above values. The order for the above fields doesn't matter
		//The order of the fields should match what's inside the constructor
		Donation newDonation = new Donation(donationName, donor, description, quantity);	
		return donationService.createDonation(newDonation);
		
	}
	
     //==============Get one by ID===============
	
	//if used @RequestParam for the id, then search?name=something //if used @PathParam, then /donations/2
	@GetMapping("/donations/{id}")
//	public String oneDonation(@PathVariable("id") Long id) {
	public Donation oneDonation(@PathVariable("id") Long id) { //oneDonation is of type Donation not String
		return donationService.findDonation(id);//findDonation method of Service class used findById method of the Repository
	}
	
	//=============Edit/update================
	@PutMapping("/donations/{id}")
	public Donation editDonation(
		//when we try to update/edit something, we need to read the id first:
			@PathVariable("id") Long id,
			//I also want to read all the request params. So, copy from the above addDonation method and paste it here:
			@RequestParam("donationName") String donationName,
			@RequestParam("donor") String donor,
			@RequestParam("quantity") Integer quantity,
			@RequestParam("description") String description
			) {
		Donation oneDonation = donationService.findDonation(id);
		
		oneDonation.setDescription(description);
		oneDonation.setDonationName(donationName);
		oneDonation.setDonor(donor);
		oneDonation.setQuantity(quantity);
		
		return donationService.updateDonation(oneDonation);
	}	
		
		//=============Delete======================
		
		//if I need to delete a donation, I need first to have a delete method inside Service
		@DeleteMapping("/donations/{id}")
		public void deleteDonation(@PathVariable("id") Long id) {
			donationService.removeDonation(id);
		}
		
		
		
		//================seeing  how DataBinding makes create and update tasks easy:=========================
		
		@PostMapping("/donations2")
		public Donation addDonation2(
				@Valid @ModelAttribute("newDonation") Donation newDonation, BindingResult result
				) {
			return donationService.createDonation(newDonation);
			
		}		
		//when doing create and update, we are doing lots of work(using @RequestParam and the like) similar to Python stack. 
		//However, Spring has great integrations with the database and using DataBinding, create and update becomes seamless 
		//So, by using DataBinding, spring makes use of all the constructors and getters and setters and then 
		//creates all the getters and setters for us very easily/quickly
		
		//Now, compare donations2 and donations methods above and see the big difference. Both of them works tho
		
		//Behind the scene, @Valid goes to our Donation model and checks whether everything is valid (specially the fields). 
		//Then Spring uses the setters to set every single fields.
		//So, when we say @Valid @ModelAttribute, behind the scene, Spring is going to do the following:
		//            Donation newDonation = new Donation(); this is the empty constructor
		//then, they are going to read all the parameters that we got:
		//			  newDonation.setDonationName(donationName)...
		

		//=================update/edit using DataBinding:=============
		
		
		@PutMapping("/donations2/{id}")
		public Donation editDonation2(
			//even if we removed those @RequestParam, from both the create and edit methods, for the edit method, we still need the @PathVariable to get the id:
				@PathVariable("id") Long id,
				@Valid @ModelAttribute("oneDonation") Donation oneDonation, BindingResult result
				) {
			return donationService.updateDonation(oneDonation);
		}		
}









