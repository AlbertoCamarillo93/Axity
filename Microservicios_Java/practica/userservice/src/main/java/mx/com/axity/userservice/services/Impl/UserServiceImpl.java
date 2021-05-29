package mx.com.axity.userservice.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.axity.userservice.commons.to.ResponseTO;
import mx.com.axity.userservice.commons.to.UserTO;
import mx.com.axity.userservice.model.UserDO;
import mx.com.axity.userservice.persistence.UserRepository;
import mx.com.axity.userservice.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	static final Logger LOG = LogManager.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserTO getUserById(int userId) {
		
		LOG.info("Obteniendo valor para el parámetro " + userId);
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserDO userDo = userRepository.findByUserId(userId);
		UserTO returnValue = modelMapper.map(userDo, UserTO.class);
		
		return returnValue;
	}

	@Override
	public List<UserTO> getAllUsers() {
		
		LOG.info("Obteniendo todos los usuarios ");
		
		List<UserDO> usersDo =  (List<UserDO>) userRepository.findAll();
		
		return usersDo.stream()
					  .map(this::convertToTO)
					  .collect(Collectors.toList());
		
	}
	
	private UserTO convertToTO(UserDO user) {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserTO userTo = modelMapper.map(user, UserTO.class);
		
		return userTo;
	}
	
	

	@Override
	public ResponseTO createUser(UserTO user) {

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserDO userDo = modelMapper.map(user, UserDO.class);
		
		userRepository.save(userDo);
		
		ResponseTO responseValue = new ResponseTO();
		
		responseValue.setCode(201);
		responseValue.setMesage("Se ha creado el usuario con identificador --> " + userDo.getUserId());
		
		return responseValue;
	}

	@Override
	public ResponseTO updateUser(int userId, UserTO user) {
		
		UserDO userDo = userRepository.findByUserId(userId);
		
		userDo.setDsEmail(user.getDsEmail());
		userDo.setDsPassword(user.getDsPassword());
		userDo.setUserInformationId(user.getUserInformationId());
		
		userRepository.save(userDo);
		
		ResponseTO responseValue = new ResponseTO();
		responseValue.setCode(200);
		responseValue.setMesage("Se ha actualizado el usuario con identificador --> " + userId);
		
		return responseValue;
	}

	@Override
	public ResponseTO deleteUser(int userId, UserTO user) {
		// TODO Auto-generated method stub
		return null;
	}

}
