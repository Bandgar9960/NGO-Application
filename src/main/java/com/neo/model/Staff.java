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
@Table(name = "STAFF_DETAILS")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long staffId;

	@Column(name = "staff_name")
	private String staffName;

	@Column(name = "staff_contact")
	private String staffContact;

	@Column(name = "staff_aadhar")
	private String staffAadhar;

	@Column(name = "staff_designation")
	private String staffDesignation;

	@Column(name = "staff_department")
	private String staffDepartment;

	@Column(name = "staff_gender")
	private String staffGender;

	@Column(name = "staff_dob")
	private String staffDOB;

}
