package com.lattice.hospitalmanagmentsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lattice.hospitalmanagmentsystem.enums.Speciality;
import com.lattice.hospitalmanagmentsystem.pojo.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	List<Doctor> findBySpeciality(Speciality speciality);

	List<Doctor> findByCityAndSpeciality(String city, Speciality speciality);

}
