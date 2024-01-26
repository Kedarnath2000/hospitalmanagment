package com.lattice.hospitalmanagmentsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lattice.hospitalmanagmentsystem.enums.Speciality;
import com.lattice.hospitalmanagmentsystem.pojo.Doctor;
import com.lattice.hospitalmanagmentsystem.pojo.Patient;
import com.lattice.hospitalmanagmentsystem.pojo.Specialities;
import com.lattice.hospitalmanagmentsystem.repository.DoctorRepository;
import com.lattice.hospitalmanagmentsystem.repository.SuggestionRepository;

@Service
public class SuggestionService {

	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private PatientService patientService;

	@Autowired
	private SuggestionRepository suggestionRepository;

	public Patient findPatientById(long id) {
		Patient patient = patientService.findPatientById(id);
		return patient;
	}

	public List<Doctor> findDoctorByCityAndSpecility(String city, Speciality speciality) {
		return doctorRepository.findByCityAndSpeciality(city, speciality);
	}

	public Specialities add(Specialities specialities) {
		Specialities specialities2 = suggestionRepository.save(specialities);
		return specialities2;

	}

	public Specialities findDoctor(Patient patient) {
		return suggestionRepository.findBySymptom(patient.getSymptom());

	}

	public List<Doctor> findAllDoctorBySpeciality(Speciality speciality) {
		return doctorRepository.findBySpeciality(speciality);

	}

}
