package edu.mum.ims.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

 
@Controller
public class HomeController {
 
	@RequestMapping({"/","/welcome"})
	public String welcome(Model model) {
		
		model.addAttribute("greeting", "Welcome to Inventory Management Service!");
		model.addAttribute("tagline", "The one and only place access your inventory services!");
		
		return "index";
	}
 
}
