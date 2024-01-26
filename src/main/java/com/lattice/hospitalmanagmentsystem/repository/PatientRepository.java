package com.lattice.hospitalmanagmentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lattice.hospitalmanagmentsystem.pojo.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	

}
