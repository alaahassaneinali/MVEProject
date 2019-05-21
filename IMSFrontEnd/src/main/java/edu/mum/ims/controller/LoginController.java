package edu.mum.ims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import edu.mum.ims.domain.User;
import edu.mum.ims.domain.UserCredentials;
import edu.mum.ims.service.UserService;
import edu.mum.ims.service.UserCredentialsService;
import edu.mum.ims.service.impl.UserCredentialsServiceImpl;

@Controller
@SessionAttributes("user")
public class LoginController {

	@Autowired
	UserCredentialsService credentialsService;

	@Autowired
	UserService userService;

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
 		return "login";
	}
 
	
	@RequestMapping(value="/postLogin", method = RequestMethod.POST)
	public String PostLogin(UserCredentials credentials, Model model) {

		// KLUDGE to set Credentials...for REST Security Needed to do Login
		UserCredentials userCredentials = 
				((UserCredentialsServiceImpl)
				credentialsService).getUserCredentials();
		if (userCredentials == null) userCredentials = new UserCredentials();
		
		userCredentials.setPassword("admin");
		userCredentials.setUsername("admin");
		((UserCredentialsServiceImpl)
				credentialsService).setUserCredentials(userCredentials);
		
		UserCredentials validCredentials = credentialsService.findOne(credentials.getUsername());
 
		if (validCredentials == null)
			return  "login";
 
		///DEMO JSON bidirectional issue solution
		User user = validCredentials.getUser();
 		user = userService.findOne(user.getId());
 		
		model.addAttribute("user", validCredentials.getUser());
 		return "redirect:/welcome";
	}
 
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
 
		model.addAttribute("error", "true");
		return "login";
 
	}
 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model, SessionStatus status) {
		status.setComplete();
 		return "redirect:/welcome";
 	}
}
