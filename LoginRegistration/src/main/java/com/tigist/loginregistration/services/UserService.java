package com.tigist.loginregistration.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.tigist.loginregistration.models.LoginUser;
import com.tigist.loginregistration.models.User;
import com.tigist.loginregistration.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public User register(User newUser, BindingResult result) {//by making use of the form info we get (i.e. newUser) and the result, we can customize the errors even more
		//find user in the db(userRepo) by email
		Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
		if(optionalUser.isPresent()) {
			result.rejectValue("email", "unique", "Email already exist");//then, in the controller, result gets updated with this new custom error message (refer to: User registeredUser = userService.register(newUser, result) line
		}
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "matches", "Password and Confirm Password doesn't match");//then, in the controller, result gets updated with this new custom error message (refer to: User registeredUser = userService.register(newUser, result) line
		}
		if(result.hasErrors()) { 
			return null; //if there are errors here in the Service as well as in the form, then returns null and leaves this function and goes to the controller specifically to the processRegister POST routing method and display ALL the errors on the form
		}
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());//if pw has no errors, then hash first before saving it by adding salt to the pw for extra security then 
		newUser.setPassword(hashed); //update the hashed pw to the newUser. Then, 
		return userRepo.save(newUser);//save the hashed pw to the db	
	}
	
	public User login(LoginUser newLogin, BindingResult result) {
		Optional<User> optionalUser = userRepo.findByEmail(newLogin.getEmail());
		if(!optionalUser.isPresent()) {
			result.rejectValue("email", "unique", "Email is not registered");
			return null;
		}
		User user = optionalUser.get();
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {//these two arguments' order matters. the first one(newLogin.getPassword() shd be from the form to be checked. and the second one(user.getPassword()) shd be from the db(the hashed one) to be checked
			result.rejectValue("password", "matches", "Wrong credential");
		}
		if(result.hasErrors()) { 
			return null; 
			}
		return user;//otherwise, give them the whole user object from the db that contains the un, email,...
		}

}
