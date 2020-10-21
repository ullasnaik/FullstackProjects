package com.stackroute.userapp.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.stackroute.userapp.entity.User;

@Component
public class UserDAOImpl implements UserDAO {
	
	private List<User> users;
	
	

	public UserDAOImpl() {
		this.users = new ArrayList<User>();
	}

	@Override
	public boolean addUser(User user) {
			
		return users.add(user);
	}

	@Override
	public boolean updateUser(User user) {
		
		User existingUser = getUserByEmail(user.getEmail());
		
		if(existingUser!=null) {
			existingUser.setCity(user.getCity());
			existingUser.setName(user.getName());
			
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteUser(String email) {
		User existingUser = getUserByEmail(email);
		
		if(existingUser!=null) {
			users.remove(existingUser);
			
			return true;
		}
		return false;
	}

	@Override
	public List<User> listAllUsers() {
		
		return users;
	}

	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByEmail(String email) {
		
		Iterator<User> itr = users.iterator();
		
		User user = null;
		
		while(itr.hasNext()) {
			user = itr.next();
			if(email.equals(user.getEmail())) {
				return user;
			}
		}
		
		return null;
		
	}

}
