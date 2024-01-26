package com.lattice.hospitalmanagmentsystem.response;

import java.util.List;

import com.lattice.hospitalmanagmentsystem.pojo.Doctor;

import lombok.Data;

@Data
public class SuggestionResponse {
	
	private String message;
	private List<Doctor> doctors;
	private int status;
	

}
