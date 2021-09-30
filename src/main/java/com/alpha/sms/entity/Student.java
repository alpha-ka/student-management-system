package com.alpha.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="first_name",nullable = false )
	private String firstName;
	@Column(name="last_name", nullable = false)
	private String lastName;
	@Column(name="email")
	private String email;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Student(String firstName, String lastName, String email) {
		super();
		if(firstName.isEmpty())
			firstName=null;
		this.firstName = firstName;
		if(lastName.isEmpty())
			lastName=null;
		this.lastName = lastName;
	
		if(email.isEmpty())
			{email=null;}
		else 
			{email=email.toLowerCase();}
		this.email = email;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		if(firstName.isEmpty())
			firstName=null;
		
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		if(lastName.isEmpty())
			lastName=null;
		
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
	 
			if(email.isEmpty())
			{email=null;}
		else 
			{email=email.toLowerCase();}
		
		
		this.email = email;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
	

}
