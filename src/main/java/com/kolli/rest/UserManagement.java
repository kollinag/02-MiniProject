package com.kolli.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kolli.entity.User;
import com.kolli.service.IUserManagementService;

@RestController
public class UserManagement {
	
	@Autowired
	private IUserManagementService iUserManagementService;
	
	
	@GetMapping(value="/countries",
			produces= {"application/json"})
   public ResponseEntity<Map<Integer,String>> getCountries(){
		Map<Integer, String> findCountries = iUserManagementService.findCountries();
		return new ResponseEntity<Map<Integer,String>>(findCountries,HttpStatus.OK);
	   
   }
	
	@GetMapping(value="/states/{countryId}",
			produces= {"application/json"})
   public ResponseEntity<Map<Integer,String>> getStates(@PathVariable("countryId") Integer countryId){
		Map<Integer, String> findStates = iUserManagementService.findStates(countryId);
		return new ResponseEntity<Map<Integer,String>>(findStates,HttpStatus.OK);
	   
   }
	
	@GetMapping(value="/cities/{stateId}",
			produces= {"application/json"})
   public ResponseEntity<Map<Integer,String>> getCities(@PathVariable("stateId") Integer stateId){
		Map<Integer, String> findCities = iUserManagementService.findStates(stateId);
		return new ResponseEntity<Map<Integer,String>>(findCities,HttpStatus.OK);
	   
   }
	
 @PostMapping(value="/signUp",
		 consumes= {"application/json"})
  public ResponseEntity<String>  registration(@RequestBody User user){
	  //TODO
	 boolean saveUserDetails = iUserManagementService.saveUserDetails(user);
	
	 return new ResponseEntity<String>("Please check your email to unlock account",HttpStatus.CREATED);
	 
	 
  }
 
 @PutMapping(value="/forgetPassword/{emailId}",
		       produces={"application/json"})
 public ResponseEntity<String> forgetPassword(@PathVariable("emailId") String emailId){
	 String forgetPassword = iUserManagementService.forgetPassword(emailId);
	 return new ResponseEntity<String>(forgetPassword,HttpStatus.OK);
 }
 
 
 
 @PostMapping(value="/signIn/{emailId}/{pass}",
		       produces= {"application/json"})
 public ResponseEntity<String> signIn(@PathVariable("emialId") String emailId,@PathVariable("pass") String pass){
	 String loginCheck = iUserManagementService.loginCheck(emailId, pass);
	 return new ResponseEntity<String>(loginCheck,HttpStatus.OK);
 }
	
 
 

 @PutMapping(value="/unlock/{emailid}/temppass/{newpass}")
 public ResponseEntity<String> unlockAccount(@PathVariable("emailId") String emailId,@PathVariable("temppass") String temppass,@PathVariable("newpass") String newpass){
	 boolean unlockAccount = iUserManagementService.unlockAccount(emailId, temppass, newpass);
	 return new ResponseEntity<String>("Account unlocked, please proceed with login",HttpStatus.OK);
  }
	
	
}
	
	
	