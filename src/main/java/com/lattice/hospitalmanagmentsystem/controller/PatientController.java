package com.lattice.hospitalmanagmentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lattice.hospitalmanagmentsystem.pojo.Patient;
import com.lattice.hospitalmanagmentsystem.response.PatientResponse;
import com.lattice.hospitalmanagmentsystem.service.PatientService;

@RestController
public class PatientController {

	@Autowired
	private PatientService patientService;

	@PostMapping(path = "/add_patient")
	public ResponseEntity<PatientResponse> addPatient(@RequestBody Patient patient) {
		try {
			Patient patirntToBeAdded = patientService.addPatient(patient);
			PatientResponse patientResponse = new PatientResponse();
			patientResponse.setMessage("Patient added");
			patientResponse.setPatient(patirntToBeAdded);
			patientResponse.setPatients(null);
			patientResponse.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<PatientResponse>(patientResponse, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			PatientResponse patientResponse = new PatientResponse();
			patientResponse.setMessage("Patient not added");
			patientResponse.setPatient(null);
			patientResponse.setPatients(null);
			patientResponse.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<PatientResponse>(patientResponse, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "/delete_patient")
	public ResponseEntity<PatientResponse> removePatient(@RequestParam long id) {
		Patient patient = patientService.removePatient(id);
		if (patient != null) {
			PatientResponse patientResponse = new PatientResponse();
			patientResponse.setMessage("Patient deleted");
			patientResponse.setPatient(patient);
			patientResponse.setPatients(null);
			patientResponse.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<PatientResponse>(patientResponse, HttpStatus.OK);
		} else {
			PatientResponse patientResponse = new PatientResponse();
			patientResponse.setMessage("Patient not deleted");
			patientResponse.setPatient(patient);
			patientResponse.setPatients(null);
			patientResponse.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<PatientResponse>(patientResponse, HttpStatus.NOT_FOUND);
		}

	}

}
