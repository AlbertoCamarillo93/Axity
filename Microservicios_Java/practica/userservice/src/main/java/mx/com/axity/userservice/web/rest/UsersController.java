package mx.com.axity.userservice.web.rest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import mx.com.axity.userservice.commons.constants.Constants;
import mx.com.axity.userservice.commons.to.ResponseTO;
import mx.com.axity.userservice.commons.to.ResponseTestTO;
import mx.com.axity.userservice.commons.to.UserTO;
import mx.com.axity.userservice.services.IUserService;


@RestController
@RequestMapping("users/v1")
@Api(value = "serviceusers")
public class UsersController {
	
	static final Logger LOG = LogManager.getLogger(UsersController.class);
	
	@Autowired
	IUserService userService;
	
	@GetMapping(value="/users", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<UserTO>> getUsers () {
		LOG.info("Se invoca GET /users");
		List<UserTO> returnResponse = userService.getAllUsers();
		return new ResponseEntity<List<UserTO>>(returnResponse, HttpStatus.OK);
	}
	
	@GetMapping(value="/user/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserTO> getUser (@PathVariable("id") int id ) {
		LOG.info("Se invoca GET /user/" + id);
		UserTO responseValue = new UserTO();
		responseValue = userService.getUserById(id);
		return new ResponseEntity<UserTO>(responseValue, HttpStatus.OK);
	}
	
	@PostMapping(value="/user", produces = { MediaType.APPLICATION_JSON_VALUE }
						       , consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseTO> createUser (@RequestBody UserTO request) {
		LOG.info("Se invoca POST /user");
		ResponseTO responseValue = userService.createUser(request);
		return new ResponseEntity<ResponseTO>(responseValue, HttpStatus.CREATED);
	}
	
	@PutMapping(value="/user/{id}", produces = { MediaType.APPLICATION_JSON_VALUE }
							  , consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseTO> updateUser (@PathVariable("id") int id, @RequestBody UserTO request) {
		LOG.info("Se invoca PUT /user/" + id );
		
		ResponseTO responseValue = userService.updateUser(id, request);
		
		return new ResponseEntity<ResponseTO>(responseValue , HttpStatus.OK);
	}
	
	@DeleteMapping(value="/user/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> deleteUser () {
		return new ResponseEntity<String>(Constants.RESPONSE_TEST_MESSAGE, HttpStatus.OK);
	}
	
	@GetMapping(value = "/test", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseTestTO> test() {
		LOG.info("Se invoca /test");
		ResponseTestTO returnResponse = new ResponseTestTO();
		returnResponse.setCode(200);
		returnResponse.setMesage("Servicio OK ..");
		return new ResponseEntity<ResponseTestTO>(returnResponse, HttpStatus.OK);
	}

}
