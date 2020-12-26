package com.kolli.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="USER_MASTER")
public class User {
	
	@Id
	@Column(name="USER_ID")
	private Integer userId;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="EMAIL")
    private String email;
	@Column(name="PHONE_NUMBER")
    private String phno;
	@Column(name="DOB")
    private  Date dob;
	@Column(name="COUNTRY")
    private Integer country;
	@Column(name="STATE")
    private Integer  state;
	@Column(name="CITY")
    private Integer  city;
	  @Column(name="PASSWORD")
    private String password;
    @Column(name="ACCOUNT_STATUS")
    private String accountStatus;


}
