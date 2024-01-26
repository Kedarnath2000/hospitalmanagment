package com.lattice.hospitalmanagmentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lattice.hospitalmanagmentsystem.pojo.Doctor;
import com.lattice.hospitalmanagmentsystem.pojo.Patient;
import com.lattice.hospitalmanagmentsystem.pojo.Specialities;
import com.lattice.hospitalmanagmentsystem.response.SuggestionResponse;
import com.lattice.hospitalmanagmentsystem.service.SuggestionService;

@RestController
public class SuggestionController {

	@Autowired
	private SuggestionService suggestionService;

	@GetMapping(path = "/get_doctors")
	public ResponseEntity<SuggestionResponse> getDoctors(@RequestParam long id) {
		System.out.println(id);
		Patient patient = suggestionService.findPatientById(id);
		if (patient != null) {
			Specialities specialities = suggestionService.findDoctor(patient);
			List<Doctor> doctorsSepcilist = suggestionService.findAllDoctorBySpeciality(specialities.getSpeciality());
			if (doctorsSepcilist != null && doctorsSepcilist.size() > 0) {
				List<Doctor> doctors = suggestionService.findDoctorByCityAndSpecility(patient.getCity(),
						specialities.getSpeciality());
				if (doctors != null && doctors.size() > 0) {
					SuggestionResponse suggestionResponse = new SuggestionResponse();
					suggestionResponse.setMessage("Doctors founds");
					suggestionResponse.setDoctors(doctors);
					suggestionResponse.setStatus(HttpStatus.FOUND.value());
					return new ResponseEntity<SuggestionResponse>(suggestionResponse, HttpStatus.FOUND);
				} else {
					SuggestionResponse suggestionResponse = new SuggestionResponse();
					suggestionResponse.setMessage("We are still waiting to expand to your location");
					suggestionResponse.setDoctors(null);
					suggestionResponse.setStatus(HttpStatus.NOT_FOUND.value());
					return new ResponseEntity<SuggestionResponse>(suggestionResponse, HttpStatus.NOT_FOUND);
				}
			} else {
				SuggestionResponse suggestionResponse = new SuggestionResponse();
				suggestionResponse.setMessage("There isn’t any doctor present at your location for your symptom");
				suggestionResponse.setDoctors(null);
				suggestionResponse.setStatus(HttpStatus.NOT_FOUND.value());
				return new ResponseEntity<SuggestionResponse>(suggestionResponse, HttpStatus.NOT_FOUND);
			}
		} else {
			SuggestionResponse suggestionResponse = new SuggestionResponse();
			suggestionResponse.setMessage("Patient not found");
			suggestionResponse.setDoctors(null);
			suggestionResponse.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<SuggestionResponse>(suggestionResponse, HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping(path = "/add")
	public Specialities addSuggestion(@RequestBody Specialities specialities) {
		Specialities s = suggestionService.add(specialities);
		return s;

	}

}
