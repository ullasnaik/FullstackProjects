package app.players.userservice.repository;

import app.players.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


/*
* This class is implementing the JpaRepository interface for Note.
* Annotate this class with @Repository annotation
*/


public interface UserAuthRepository extends JpaRepository<User,String>{

	public User findByUserIdAndPassword(String userId, String password);

}
