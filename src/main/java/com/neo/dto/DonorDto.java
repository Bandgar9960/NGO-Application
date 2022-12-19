package com.neo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DonorDto {

	private Long donorId;

	private String donorName;

	private String donorContact;

	private String donorPAN;

	private String donorGender;

	private String donorDOB;

	private Long donorAmount;

}
