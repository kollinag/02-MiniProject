package com.kolli.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kolli.entity.State;

public interface StateRepo extends JpaRepository<State, Serializable> {
	
	public List<State> findByCountryId(Integer countryId);

}
