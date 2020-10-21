package app.players.userservice.service;

import app.players.userservice.model.User;
import app.players.userservice.util.exception.UserAlreadyExistsException;
import app.players.userservice.util.exception.UserNotFoundException;

public interface UserAuthService {

    public User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException;
    boolean saveUser(User user) throws UserAlreadyExistsException;

    User updateUser(String userId,User user) throws UserNotFoundException;

    boolean deleteUser(String userId) throws UserNotFoundException;

    User getUserById(String userId) throws UserNotFoundException;
}
