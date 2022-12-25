package com.neo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DonorDto {

	private Long donorId;

	@NotEmpty
	@Size(min = 3, max = 20, message = "Name must be Atleast 3 character!! ")
	private String donorName;


	@NotEmpty
	@Size(min = 10, max = 10, message = "Not Valid ADMIN_CONTACT !!!")
	private String donorContact;


	@NotEmpty
	@Size(min = 10, max = 10, message = "PAN-Card must be 10 digit....!!!")
	@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}")
	private String donorPAN;  //ABEDF4578L

	@NotEmpty
	private String donorGender;

	@NotEmpty
	private String donorDOB;

	private Long donorAmount;

}
