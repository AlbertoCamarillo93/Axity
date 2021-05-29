package mx.com.axity.userservice.services;

import java.util.List;

import mx.com.axity.userservice.commons.to.ResponseTO;
import mx.com.axity.userservice.commons.to.UserTO;

public interface IUserService {
	
	UserTO getUserById(int userId);
	List<UserTO> getAllUsers();
	ResponseTO createUser(UserTO user);
	ResponseTO updateUser(int usrId, UserTO user);
	ResponseTO deleteUser(int usrId, UserTO user);

}
