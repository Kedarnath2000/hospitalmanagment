package com.lattice.hospitalmanagmentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lattice.hospitalmanagmentsystem.pojo.Doctor;
import com.lattice.hospitalmanagmentsystem.response.DoctorResponse;
import com.lattice.hospitalmanagmentsystem.service.DoctorService;

@RestController
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@PostMapping(path = "/add_doctor")
	public ResponseEntity<DoctorResponse> addDoctor(@RequestBody Doctor doctor) {
		try {
			if (doctorService.isValidSpeciality(doctor.getSpeciality())) {
				System.out.println(doctorService.isValidSpeciality(doctor.getSpeciality()));
				Doctor doctorToBeAdded = doctorService.addDoctor(doctor);
				DoctorResponse doctorResponse = new DoctorResponse();
				doctorResponse.setMessage("Doctor added");
				doctorResponse.setDoctor(doctorToBeAdded);
				doctorResponse.setDoctors(null);
				doctorResponse.setStatus(HttpStatus.CREATED.value());
				return new ResponseEntity<DoctorResponse>(doctorResponse, HttpStatus.CREATED);
			} else {
				DoctorResponse doctorResponse = new DoctorResponse();
				doctorResponse.setMessage("Doctor not added");
				doctorResponse.setDoctor(null);
				doctorResponse.setDoctors(null);
				doctorResponse.setStatus(HttpStatus.NOT_FOUND.value());
				return new ResponseEntity<DoctorResponse>(doctorResponse, HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			DoctorResponse doctorResponse = new DoctorResponse();
			doctorResponse.setMessage("Doctor not added");
			doctorResponse.setDoctor(null);
			doctorResponse.setDoctors(null);
			doctorResponse.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<DoctorResponse>(doctorResponse, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "/delete_doctor")
	public ResponseEntity<DoctorResponse> removeDoctor(@RequestParam long id) {
		Doctor doctor = doctorService.removeDoctor(id);
		if (doctor != null) {
			DoctorResponse doctorResponse = new DoctorResponse();
			doctorResponse.setMessage("Doctor deleted");
			doctorResponse.setDoctor(doctor);
			doctorResponse.setDoctors(null);
			doctorResponse.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<DoctorResponse>(doctorResponse, HttpStatus.OK);
		} else {
			DoctorResponse doctorResponse = new DoctorResponse();
			doctorResponse.setMessage("Doctor not found");
			doctorResponse.setDoctor(null);
			doctorResponse.setDoctors(null);
			doctorResponse.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<DoctorResponse>(doctorResponse, HttpStatus.NOT_FOUND);
		}

	}

}
