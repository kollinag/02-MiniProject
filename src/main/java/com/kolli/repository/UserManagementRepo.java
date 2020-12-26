package com.kolli.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kolli.entity.User;

public interface UserManagementRepo extends JpaRepository<User, Serializable> {
	
	public User findByEmail(String email);
	
	public User findByEmailAndPassword(String email,String password);
	
	

}
