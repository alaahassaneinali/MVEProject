package edu.mum.ims.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.ims.domain.User;
import edu.mum.ims.service.UserService;

@Controller
@RequestMapping({"/users"})
public class MemberController {
	
	@Autowired
	private UserService  userService;

	@RequestMapping("")
	public String listMembers(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "users";
	}
	
  	@RequestMapping("/{id}")
	public String getMemberById(@PathVariable("id") Long id,Model model) {
		User user = userService.findOne(id);
		model.addAttribute("user", user);

 		return "user";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewMemberForm(@ModelAttribute("newUser") User newUser) {
	   return "addUser";
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewMemberForm(@ModelAttribute("newUser") @Valid User userToBeAdded, BindingResult result) {
 
		if(result.hasErrors()) {
			return "addUser";
		}

			 //  Error caught by ControllerAdvice IF no authorization...
		userService.save(userToBeAdded);

	   	return "redirect:/users";
 
	}
	
 
}
