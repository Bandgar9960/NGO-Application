package com.neo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "admin_details")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Admin  {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private Long adminId;
	
	@Column(name = "admin_name")
	private String adminName;
	
	@Column(name = "admin_contact")
	private String adminContact;
	
	@Column(name = "admin_aadhar")
	private String adminAadhar;
	
	@Column(name = "admin_gender")
	private String adminGender;
	
	
   
}
