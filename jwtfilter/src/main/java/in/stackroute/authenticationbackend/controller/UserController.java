package in.stackroute.authenticationbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.stackroute.authenticationbackend.model.User;
import in.stackroute.authenticationbackend.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> listAllUsers() {
		return new ResponseEntity<List<User>>(userService.list(), HttpStatus.OK);
	}

	  
	@GetMapping(value = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser(@PathVariable("username") String username) {
		
		User user = userService.get(username);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	 
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User u = userService.get(user.getUsername());
		if (u != null) {
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		}
		userService.save(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	 
	@PutMapping(value = "/{username}")
	public ResponseEntity<User> updateUser(@PathVariable("username") String username, @RequestBody User user) {
		
		User currentUser = userService.get(username);

		if (currentUser == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		currentUser.setName(user.getName());
		currentUser.setPassword(user.getPassword());

		userService.update(currentUser);
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}

}
