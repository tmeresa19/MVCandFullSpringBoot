package com.tigist.dojosandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tigist.dojosandninjas.models.Dojo;
import com.tigist.dojosandninjas.services.DojoService;

import jakarta.validation.Valid;

@Controller
public class DojoController {
	
	@Autowired
	private DojoService dojoService;
	
	//===========================CREATE and SAVE TO DB=================

	@PostMapping("/dojos")
	public String makeDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result ) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		}
		dojoService.createDojo(dojo);
		return "redirect:/dojos";
		}
	
	
}
