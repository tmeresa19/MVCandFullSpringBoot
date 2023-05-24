package com.tigist.mvcsavetravel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tigist.mvcsavetravel.models.Donation;
import com.tigist.mvcsavetravel.repositories.DonationRepository;



@Service
public class DonationService {
	
//	//import repository
//	private final DonationRepository donationRepo;
//	
//	//constructor
//	public DonationService( DonationRepository donationRepo) {
//		this.donationRepo = donationRepo;
//	}
	
	@Autowired
	private DonationRepository donationRepo;
	
	//==================Find All==================
	
	public List<Donation> allDonations(){
		return donationRepo.findAll();
	}
	
	//==================Create=====================
	
		public Donation createDonation(Donation newDonation) {
		// meaning, go to the donationRepo and save the newDonation. 
		//Even if we didn't include the save method inside the Repository,we can still use the save method. 
		//That's why, we were able to get all the donations and save the create or post donations in the controller 
			return donationRepo.save(newDonation);
	}
	
		//=================Find/Get one donation by id===================
		
		//The return type of find by id is an Interface/class called Optional. So, it retrieves an entity by it's id
		//it's called Optional data type because it gives us whether something is present or not. If not present, no error will be displayed.
		public Donation findDonation(Long id) {
		//return donationRepo.findById(id); since it's optional, we can't return like this but like below:
			Optional<Donation> optionalDonation = donationRepo.findById(id);
			//created optionalDonation object or variable with the datatype of Optional Donation
			if(optionalDonation.isPresent())//one of the method of Optional type is isPresent().
				return optionalDonation.get();//get() allows us to get the data type inside the <> which is of type Donation
			else {
				return null; //because Donation could be null. And null is accepted for Donation datatype
			}
			
		}
			//====================EDIT==========================
			
			//edit implementation is combination of create and find by id methods
			
		public Donation updateDonation(Donation oneDonation) {
				return donationRepo.save(oneDonation);		 
			}
		//create and update implementation in the service side is the same as long as we provided the id
		
		//====================DELETE==========================
		
		public void removeDonation(Long id) {
			donationRepo.deleteById(id);
		}
}
