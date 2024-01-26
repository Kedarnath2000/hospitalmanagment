package com.lattice.hospitalmanagmentsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lattice.hospitalmanagmentsystem.pojo.Patient;
import com.lattice.hospitalmanagmentsystem.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	public Patient addPatient(Patient patient) {
		Patient patientAdeed= patientRepository.save(patient);
		System.out.println(patientAdeed);
		return patientAdeed;
	}
	
	public Patient findPatientById(long id) {
		Optional<Patient> optional=patientRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	public Patient removePatient(long id) {
		Patient patient=findPatientById(id);
		patientRepository.deleteById(id);
		return patient;
		
	}
	

}
