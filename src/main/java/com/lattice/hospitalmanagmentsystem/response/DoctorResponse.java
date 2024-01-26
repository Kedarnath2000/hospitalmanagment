package com.lattice.hospitalmanagmentsystem.response;

import java.util.List;

import com.lattice.hospitalmanagmentsystem.pojo.Doctor;

import lombok.Data;

@Data
public class DoctorResponse {

	private String message;
	private Doctor doctor;
	private List<Doctor> doctors;
	private int status;

}
