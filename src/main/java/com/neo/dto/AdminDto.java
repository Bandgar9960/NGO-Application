package com.neo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {

	private Long adminId;
    
	@NotEmpty
	@Size(min = 3,max = 20, message ="Name must be Atleast 3 character!! ")
	private String adminName;


	@NotEmpty
 	@Size(min=10,max = 10 ,message = "Not Valid ADMIN_CONTACT !!!")
	private String adminContact;

	@NotEmpty
	@Size(min=12,max = 12 ,message = "Aadhar-Card must be 12 digit....!!!")
	private String adminAadhar;
    
	@NotEmpty
	private String adminGender;

}
