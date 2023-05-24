package com.tigist.dojosandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tigist.dojosandninjas.models.Ninja;
import com.tigist.dojosandninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
	
	@Autowired
	private NinjaService ninjaService;
	
	//===========================CREATE and SAVE TO DB=================
	
	@PostMapping("/ninjas")
	public String makeNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "newNinja.jsp"; //return "newDojo.jsp"; ???????check if its ninja or dojo
		}
		ninjaService.createNinja(ninja);
		return String.format("redirect:dojos/%s", ninja.getDojo().getId());
	}
	
	}