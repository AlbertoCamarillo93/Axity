package mx.com.axity.userservice.persistence;

import org.springframework.data.repository.CrudRepository;

import mx.com.axity.userservice.model.UserDO;

public interface UserRepository extends CrudRepository<UserDO, Long>{
	
	UserDO findByUserId(int userId);

}
