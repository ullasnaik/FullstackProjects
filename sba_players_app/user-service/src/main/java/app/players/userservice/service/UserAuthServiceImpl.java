package app.players.userservice.service;

import app.players.userservice.model.User;
import app.players.userservice.util.exception.UserAlreadyExistsException;
import app.players.userservice.util.exception.UserNotFoundException;
import app.players.userservice.repository.UserAuthRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserAuthServiceImpl implements UserAuthService {


    private UserAuthRepository userAuthRepository;

    private static final String USER_NOT_EXISTS = "User does not exists";
    private static final String USER_ALREADY_EXISTS = "User already exists";

    private static final String USERID_PASSWORD_MISMATCH = "UserId and Password are not matching";
    private static final String USER_ALREADY_PRESENT = "User is already present";

    @Autowired
    public UserAuthServiceImpl(UserAuthRepository userAuthRepository) {
        this.userAuthRepository = userAuthRepository;
    }

    @Override
    public User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException {

        User user = userAuthRepository.findByUserIdAndPassword(userId, password);

        if (user == null) {
            throw new UserNotFoundException(USERID_PASSWORD_MISMATCH);
        }
        return user;
    }

    @Override
    public boolean saveUser(User user) throws UserAlreadyExistsException {

        Optional<User> newUser = userAuthRepository.findById(user.getUserId());

        if (newUser.isPresent()) {
            throw new UserAlreadyExistsException(USER_ALREADY_PRESENT);
        }

        userAuthRepository.save(user);
        return true;
    }

    @Override
    public User updateUser(String userId, User user) throws UserNotFoundException {

        try {
            User user1 = null;
            Optional<User> fetchedUser = userAuthRepository.findById(userId);

            if (fetchedUser.isPresent()) {
                user1 = fetchedUser.get();
                user1.setFirstName(user.getFirstName());
                user1.setLastName(user.getLastName());
                user1.setEmail(user.getEmail());
                user1.setContact(user.getContact());
                userAuthRepository.save(user1);
            }
            return user;
        } catch (Exception e) {
            throw new UserNotFoundException(USER_NOT_EXISTS);
        }
    }


    @Override
    public boolean deleteUser(String userId) throws UserNotFoundException {

        boolean deleteStatus = false;
        try {
            User user = null;
            Optional<User> fetchedUser = userAuthRepository.findById(userId);

            if (fetchedUser.isPresent()) {
                user = fetchedUser.get();
                if (user != null) {
                    userAuthRepository.delete(user);
                    deleteStatus = true;
                }
            }
        } catch (Exception e) {
            throw new UserNotFoundException(USER_NOT_EXISTS);
        }
        return deleteStatus;
    }


    @Override
    public User getUserById(String userId) throws UserNotFoundException {

        User user = null;
        Optional<User> fetchedUser = userAuthRepository.findById(userId);

        if (fetchedUser.isPresent()) {
            user = fetchedUser.get();

            if (user == null) {
                throw new UserNotFoundException(USER_NOT_EXISTS);
            }
        }
        return user;
    }
}
