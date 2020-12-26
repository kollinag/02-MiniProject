package com.kolli.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kolli.entity.Country;

public interface CountryRepo extends JpaRepository<Country, Serializable> {

}
