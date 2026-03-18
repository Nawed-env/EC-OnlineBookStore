package com.nareshit.controller;

import java.net.HttpURLConnection;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nareshit.entity.UserRegister;
import com.nareshit.model.ResponseMessage;
import com.nareshit.model.requestDto;
import com.nareshit.model.userRequestDto;
import com.nareshit.service.UserRegisterService;
import com.nareshit.utility.Constants;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "UserRegister-"+ "Controller ",description = "UserRegister Regsiter & Login ")
@RestController
@RequestMapping("/api")
public class UserRegisterController {


	@Autowired
	private UserRegisterService userRegisterService;
	private static final Logger logger=org.slf4j.LoggerFactory.getLogger(UserRegisterController.class);

	@Operation(summary = "Create User Register",description = "e commerece online books store  register the users")
    @ApiResponses({
     @ApiResponse(responseCode = "201",description = "User register successfully"),
     @ApiResponse(responseCode = "400",description = "User register failure"),       ///////see this ..how controller come here
     @ApiResponse(responseCode = "500",description = "Internal server error")
     })

	@PostMapping("/userregisters")
	public ResponseEntity<ResponseMessage> createUserRegister(@RequestBody userRequestDto userRequestDTO) {
		logger.info("Registration controller layer calling or started");
		try {
			if(userRequestDTO.getEmail()==null || userRequestDTO.getEmail().isEmpty() || userRequestDTO.getPassword()==null ||  userRequestDTO.getPassword().isEmpty())  {
				logger.debug("Recived userRegData: {} ",userRequestDTO);
				logger.warn("missing email and password registration request");
				logger.error("User Registration email or password missing : Bad reg. data");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constants.FAILED, "Email and passowrd cannot be empty"));
			}

			UserRegister userRegister =	userRegisterService.insertUserRegister(userRequestDTO);
			if(userRegister!=null) {
				 logger.info("Message return eco-system = \"BOOKSTORE_ONLINE_REGISTRATION_CREATION_SUCCESS\" .");
				return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constants.SUCCESS, "online bookstore save successfully",userRegister));
			}else {
				 logger.info("Message return eco-system = \"BOOKSTORE_ONLINE_REGISTRATION_CREATION_FAILED\" .");
	             logger.info("Registration controller layer calling completed");
	             logger.warn("User Registration service return null : registration failed");

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constants.FAILED, "User Register Failed" ,userRegister));
			}
		}catch (Exception e) {
            logger.error("New user creation process failed in Bookstore-DB . Exception:" +e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseMessage(HttpURLConnection.HTTP_INTERNAL_ERROR, Constants.FAILED, "Internal server error"));
		}


	}


	@PostMapping("/LoginData")
	public ResponseEntity<ResponseMessage> retrieveUserData(@RequestBody userRequestDto userRequestDTO) {

		try {
			if(userRequestDTO.getEmail()==null || userRequestDTO.getEmail().isEmpty() || userRequestDTO.getPassword()==null ||  userRequestDTO.getPassword().isEmpty())  {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constants.FAILED, "Email and passowrd cannot be empty"));
			}

			UserRegister userRegister =	userRegisterService.loginUserRegister(userRequestDTO);
			if(userRegister!=null) {
				return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_OK,Constants.SUCCESS,"Login Successfully",userRegister));
			}else {
				return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constants.FAILURE, "Invalid Credential...!"));
			}
		}catch (Exception e) {
			return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_INTERNAL_ERROR, Constants.FAILURE, "Internal server error...!! "));

		}

	}
//
//	@GetMapping()
//	public ResponseEntity<ResponseMessage> fetchData(@PathVariable Long id){
//		userRegisterService.retrieveDataById(id);
//		return null;
//	}

	 @Operation(summary = "Fetch User Register",description = "e-commerece online books store fatch the users")
	    @ApiResponses({
	     @ApiResponse(responseCode = "200",description = "User Login successfully!"),
	     @ApiResponse(responseCode = "400",description = "User Login failure!"),
	     @ApiResponse(responseCode = "500",description = "Internal server error!")
	     })
	@GetMapping("/userDetails/{id}")
	public requestDto fetchData(@PathVariable Long id){
		return userRegisterService.retrieveDataById(id);



	}

	@GetMapping("/fetchDetails")
	public List<UserRegister> getAllRecords() {

	 List<UserRegister> data=userRegisterService.fetchAllDetails();
		return data;
	}



}

