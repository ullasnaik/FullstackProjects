package app.players.userservice.controller;

import app.players.userservice.model.User;
import app.players.userservice.service.UserAuthService;
import app.players.userservice.util.exception.UserAlreadyExistsException;
import app.players.userservice.util.exception.UserIdAndPasswordMismatchException;
import app.players.userservice.util.exception.UserNotFoundException;
import app.players.userservice.util.exception.UserNullException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")

public class UserController {
	
	private UserAuthService userAuthService;
	private static final String USER_REGISTERED_SUCCESSFULLY = "User registered successfully";
	private static final String USER_ALREADY_PRESENT = "User already present";
	private static final String USER_NOT_EXIST = "User does not exists";
	private static final String USER_DELETED_SUCCESSFULLY = "User deleted successfully";
	private static final String USER_UPDATED_SUCCESSFULLY = "User updated successfully";
    private static final String USER_REGISTRATION_ERROR = "Error occurred during registration";
    private static final String USERID_PASSWORD_NULL = "UserId and Password cannot be null or empty";
    private static final String USER_SUCCESSFUL_LOGIN = "User has successfully logged in";
    private static final String USER_UNSUCCESSFUL_LOGIN = "User login has failed";


    @Autowired
	public UserController(UserAuthService userAuthService) {
		this.userAuthService = userAuthService;
	}

    
	@PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {

        ResponseEntity<?> responseEntity = null;

        try {
        	userAuthService.saveUser(user);
            responseEntity = new ResponseEntity<>(USER_REGISTERED_SUCCESSFULLY, HttpStatus.CREATED);
        } catch (UserAlreadyExistsException upae) {
            responseEntity = new ResponseEntity<>(USER_ALREADY_PRESENT, HttpStatus.CONFLICT);
        } 
        
        return responseEntity;
    }
   

	@PutMapping("/user/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable() String userId, @RequestBody User user) {

        ResponseEntity<?> responseEntity = null;

        try {
            userAuthService.updateUser(userId, user);
            responseEntity = new ResponseEntity<>(USER_UPDATED_SUCCESSFULLY, HttpStatus.OK);
        } catch (UserNotFoundException upnfe) {
            responseEntity = new ResponseEntity<>(USER_NOT_EXIST, HttpStatus.NOT_FOUND);
        }

        return responseEntity;
    }


	@DeleteMapping("/user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable() String userId) {
        ResponseEntity<?> responseEntity = null;

        try {
        	userAuthService.deleteUser(userId);
            responseEntity = new ResponseEntity<>(USER_DELETED_SUCCESSFULLY, HttpStatus.OK);

        } catch (UserNotFoundException exception) {
            responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);

        }
        return responseEntity;
    }


	 @GetMapping(value="/user/{userId}")
	 public ResponseEntity<?> getUserById(@PathVariable() String userId) {

	        ResponseEntity<?> responseEntity = null;
	        try {
	            User fetchedUser = userAuthService.getUserById(userId);
	            responseEntity = new ResponseEntity<>(fetchedUser, HttpStatus.OK);

	        } catch (UserNotFoundException e) {
	            responseEntity = new ResponseEntity<>(USER_NOT_EXIST, HttpStatus.NOT_FOUND);
	        }
	        return responseEntity;
	    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> loginUser(@RequestBody User loginDetails) {
        try {
            String userId = loginDetails.getUserId();
            String password = loginDetails.getPassword();
            System.out.println("userId:"+userId+"password:"+password);
            if (userId == null || userId.isEmpty() || password == null || password.isEmpty()) {
                throw new UserNullException(USERID_PASSWORD_NULL);
            }

            User user = userAuthService.findByUserIdAndPassword(userId, password);
            if (user == null) {
                throw new UserNotFoundException(USER_NOT_EXIST);
            }
            String userPassword = user.getPassword();
            if (password == null || password.isEmpty() || !password.equals(userPassword)) {
                throw new UserIdAndPasswordMismatchException("Invalid login credential, Please check username and password ");
            }

            Map<String, String> userLoginMap = new HashMap<>();

            String jwtToken = Jwts.builder().setSubject(user.getUserId())
                    .setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, "mysecret").compact();

            userLoginMap.put("token", jwtToken);
            userLoginMap.put("message", USER_SUCCESSFUL_LOGIN);
            return new ResponseEntity<>(userLoginMap, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(USER_UNSUCCESSFUL_LOGIN, HttpStatus.UNAUTHORIZED);
        }
    }
}
