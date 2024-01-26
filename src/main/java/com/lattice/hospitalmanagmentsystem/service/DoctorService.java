package com.lattice.hospitalmanagmentsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lattice.hospitalmanagmentsystem.enums.Speciality;
import com.lattice.hospitalmanagmentsystem.pojo.Doctor;
import com.lattice.hospitalmanagmentsystem.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	public Doctor addDoctor(Doctor doctor) {

		Doctor doctorAdded = doctorRepository.save(doctor);
		return doctorAdded;

	}

	public boolean isValidSpeciality(Speciality speciality) {
		for (Speciality validSpeciality : Speciality.values()) {
			if (validSpeciality.equals(speciality)) {
				return true;
			}
		}
		return false;
	}

	public Doctor findDoctorById(long id) {
		Optional<Doctor> optional = doctorRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}

	}

	public Doctor removeDoctor(long id) {
		Doctor doctor = findDoctorById(id);
		doctorRepository.deleteById(id);
		return doctor;
	}

}
