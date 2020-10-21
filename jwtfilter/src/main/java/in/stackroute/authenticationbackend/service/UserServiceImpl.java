package in.stackroute.authenticationbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.stackroute.authenticationbackend.model.User;
import in.stackroute.authenticationbackend.repository.UserRepository;

@Service("UserService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	public boolean save(User user) {
		return (userRepository.save(user) != null);
	}

	public boolean update(User user) {
		return (userRepository.save(user) != null);
	}

	public boolean delete(User user) {

		userRepository.delete(user);
		if (userRepository.findOne(user.getUsername()) != null) {
			return false;
		} else
			return true;
	}

	public List<User> list() {
		return (List<User>) userRepository.findAll();
	}

	public boolean validate(String username, String password) {

		//userRepository.validate(username, password);

		if (userRepository.validate(username, password) != null) {
			return true;
		} else {
			return false;
		}
	}

	public User get(String username) {
		return userRepository.findOne(username);

	}

	public boolean exists(String username) {

		return userRepository.exists(username);

	}
}
