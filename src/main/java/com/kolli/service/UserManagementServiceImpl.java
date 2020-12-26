package com.kolli.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.kolli.entity.City;
import com.kolli.entity.Country;
import com.kolli.entity.State;
import com.kolli.entity.User;
import com.kolli.repository.CityRepo;
import com.kolli.repository.CountryRepo;
import com.kolli.repository.StateRepo;
import com.kolli.repository.UserManagementRepo;

public class UserManagementServiceImpl implements IUserManagementService {
	
	@Autowired
	private UserManagementRepo userManagementRepo;
	
	@Autowired
	private StateRepo stateRepo;
	
	@Autowired
	private CountryRepo countryRepo;
	
	@Autowired
	private CityRepo cityRepo;

	@Override
	public Map<Integer, String> findCountries() {
		
		Map<Integer,String> countryData=new HashMap<>();
		List<Country> countries = countryRepo.findAll();
		countries.forEach(cntData->{
			countryData.put(cntData.getCountryId(),cntData.getCountryName());
		 });
		return countryData;
	}

	@Override
	public Map<Integer, String> findStates(Integer countryId) {
		
		Map<Integer,String> stateData=new HashMap<>();
		List<State> states = stateRepo.findByCountryId(countryId);
		states.forEach(stateDetails->{
			stateData.put(stateDetails.getStateId(), stateDetails.getStateName());
		});
		return stateData;
	}

	@Override
	public Map<Integer, String> findCities(Integer stateId) {
		Map<Integer,String> citiesData=new HashMap<Integer,String>();
		List<City> cities = cityRepo.findByCityId(stateId);
		cities.forEach(cityDetails->{
			citiesData.put(cityDetails.getCityId(), cityDetails.getCityName());
		});
		return citiesData;
	}

	@Override
	public boolean isEmilunique(String emailId) {
		User userData = userManagementRepo.findByEmail(emailId);
		
		if(userData!=null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public boolean saveUserDetails(User user) {
		user.setAccountStatus("LOCKED");
		user.setPassword(generatePasword());
		User userData = userManagementRepo.save(user);
	
		return userData.getUserId()!=null;
	}

	@Override
	public String loginCheck(String email, String password) {
		User userData = userManagementRepo.findByEmailAndPassword(email, password);
		String msgTxt="";
		
		if(userData!=null) {
			if(userData.getAccountStatus().equalsIgnoreCase("LOCKED")) {
				msgTxt="Your account is Locked, Please unlock the Account";
			}else {
				msgTxt="Login Success";
			}
			
		}
		else{
			msgTxt="Invalid Credentials";
		}
		return msgTxt;
	}

	@Override
	public boolean isTempPassValid(String email, String pwd) {
		User userDetails = userManagementRepo.findByEmailAndPassword(email, pwd);
		if(userDetails!=null) {
			return true;
		}else {
			return false;
		}
		
}

	@Override
	public boolean unlockAccount(String email,String tempPass, String password) {
		boolean isTempPassValid = isTempPassValid(email,tempPass);
		if(isTempPassValid) {
			User userDetails = userManagementRepo.findByEmail(email);
			userDetails.setPassword(password);
			userDetails.setAccountStatus("UNLOCKED");
			User save = userManagementRepo.save(userDetails);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String forgetPassword(String email) {
		User userDetails = userManagementRepo.findByEmail(email);
		String msgTxt="";
		if(userDetails!=null) {
			msgTxt="You have provided invalid Email Please check Email";
		}
		else {
			String password=userDetails.getPassword();
	    		boolean sendEmail = sendEmail(password);
	    		if(sendEmail) {
	    			msgTxt="Password sent to Your registered Email id Please check ";
	    		}
	    		else {
	    			System.out.println("got errorwhile sending password through email");
	    			//TODO 
	    			msgTxt="Password sent to Your registered Email id Please check ";
	    		}
		    	
		}
		return msgTxt;
	}

	private boolean sendEmail(String password) {
		//TODO  mail sending logic
		return true;
		
	}

	@Override
	public String generatePasword() {
	    String password="";
	    String passWords="ABCDEFGHabcdefgh123@#$";
	    
	    Random r=new Random();
	    
	    for(int i=0;i<=8;i++) {
	    	password=password+passWords.charAt(r.nextInt(passWords.length()));
	    }
		return password;
	}

}
