package com.example.aop.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aop.entity.User;
import com.example.aop.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200")
public class UserController {
	@Autowired
	private UserService userService;

Logger log=LoggerFactory.getLogger(UserController.class);

	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody User user)
	{
		User saveUsers=userService.saveUser(user);
		log.debug("save method executed {}",user);
		return new ResponseEntity<String>("Registration successfuly done ...!",HttpStatus.ACCEPTED);
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getUsers()
	{
		List<User> getUsers=userService.getUsers();
		return new ResponseEntity<>(getUsers,HttpStatus.OK);
	}
	@GetMapping("/email/{email}")
	public ResponseEntity<?> getByEmail(@PathVariable("email") String email)
	{
		List<User> getEmail=userService.getByEmail(email);
		log.debug("email get by email {}" ,email);
		log.info("email method excuted");
		return new ResponseEntity<>(getEmail,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<?> deleteBy(@PathVariable("id") int id)
	{
	List<User>users=userService.deleteById(id);
		 
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getByIds(@PathVariable("id") int id)
	{
	List<User> user=	userService.getByIds(id);
	log.info("getbYIdmethod inovoked");
		 
		return new ResponseEntity<>( user,HttpStatus.OK);
	}
	@PutMapping("update/{id}")
public ResponseEntity<?> updateUsers(@PathVariable("id") int id,@RequestBody User user)
{
	User update=userService.updateUsers(id,user);
	return  new ResponseEntity<>(update,HttpStatus.OK);
}
	@GetMapping("/getAllList")
public ResponseEntity<?> getAllList()
{
	List<User> getAllList=userService.getAllList();
	return new ResponseEntity<>(getAllList,HttpStatus.OK);
}
}
