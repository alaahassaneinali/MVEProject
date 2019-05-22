package edu.mum.ims.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.ims.domain.User;
import edu.mum.ims.service.UserService;

@RestController
@RequestMapping({"/users"})
public class UserController {
	
	@Autowired
	private UserService  userService;

	@RequestMapping
	public List<User>  findAll( ) {
		List<User> memberList = userService.findAll();
		return  memberList;
 
	}
	
  	@RequestMapping("/{id}")
	public User getMemberById(@PathVariable("id") Long id) {
		return   userService.findOne(id);
 
	}
	   
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void processAddNewMemberForm(@RequestBody User user, HttpServletRequest request) {
				userService.save(user);
 
	}
	
 
}
