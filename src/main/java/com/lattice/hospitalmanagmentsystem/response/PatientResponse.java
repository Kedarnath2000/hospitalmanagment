package com.lattice.hospitalmanagmentsystem.response;

import java.util.List;

import com.lattice.hospitalmanagmentsystem.pojo.Patient;

import lombok.Data;


@Data
public class PatientResponse {
	
	private String message;
	private Patient patient;
	private List<Patient> patients;
	private int status;
	

}
