package com.kolli.service;

import java.util.Map;

import com.kolli.entity.User;

public interface IUserManagementService {
	
	//Registration Page 

	public Map<Integer, String> findCountries();

	public Map<Integer, String> findStates(Integer countryId);

	public Map<Integer, String> findCities(Integer stateId);

	public boolean isEmilunique(String emailId);

	public boolean saveUserDetails(User user);
	
	
	//LoginCheck
	public String loginCheck(String email,String password);
	
	//Unlock Account
	
	public boolean isTempPassValid(String email,String pwd);
	
	public boolean unlockAccount(String email,String tempPass,String password);
	
	
	//forget Password
	
	public String forgetPassword(String email);
	
	//Password generation
	
	public String generatePasword();
	
	

}
