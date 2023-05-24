package com.tigist.javafinal.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tigist.javafinal.models.Claass;
import com.tigist.javafinal.repositories.ClaassRepository;



@Service
public class ClaassService {
	
		//	//import repository
		//	private final ClaassRepository claassRepo;
		//	
		//	//constructor
		//	public ClaassService( ClaassRepository claassRepo) {
		//		this.claassRepo = claassRepo;
		//	}
	
	        //Alternative way to import repository than using the above 3 lines of code
	@Autowired
	private ClaassRepository claassRepo;
	
	
	//====================BUILDING ALL BACKEND LOGIC WITH CRUD===================================//
	
	
	  //==================FIND ALL=======================================================//
	
	public List<Claass> allClaasss(){
		return claassRepo.findAll();
	}
	
	  //==================CREATE===========================================================//
	
		public Claass createClaass(Claass newClaass) {
				// meaning, go to the claassRepo and save the newClaass. 
				//Even if we didn't include the save method inside the Repository,we can still use it. 
				//That's why, we were able to get all the claasss and save the create or post claasss in the controller 
			return claassRepo.save(newClaass);
	}
	
		//=================FIND ONE BY ID===================================================//
		
				//The return type of find by id is an Interface/class called Optional. So, it retrieves an entity by it's id
				//it's called Optional data type because it gives us whether something is present or not. If not present, no error will be displayed.
		public Claass findOne(Long id) {
				//return claassRepo.findById(id); since it's optional, we can't return like this but like below:
			Optional<Claass> optionalClaass = claassRepo.findById(id);
				//created optionalClaass object or variable with the datatype of Optional Claass
			if(optionalClaass.isPresent())//one of the method of Optional type is isPresent().
				return optionalClaass.get();//get() allows us to get the data type inside the <> which is of type Claass
			else {
				return null; //because Claass could be null. And null is accepted for Claass datatype
			}
		}
		
		//====================EDIT OR UPDATE============================================//
		
		public Claass updateClaass(Claass oneClaass) { //create and update implementations in the service side is the same as long as we provided the id
				return claassRepo.save(oneClaass);		//edit or update implementation is a combination of create and find by id methods 
			}
		
		//====================DELETE======================================================//
		
		public void removeClaass(Long id) {
			claassRepo.deleteById(id);
		}
	
}
