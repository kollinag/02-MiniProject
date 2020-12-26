package com.kolli.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kolli.entity.City;

public interface CityRepo extends JpaRepository<City,Serializable> {
	
	public List<City> findByCityId(Integer stateId);
	

}
