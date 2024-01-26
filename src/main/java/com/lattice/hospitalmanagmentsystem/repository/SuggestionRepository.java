package com.lattice.hospitalmanagmentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lattice.hospitalmanagmentsystem.enums.Symptom;
import com.lattice.hospitalmanagmentsystem.pojo.Specialities;

public interface SuggestionRepository extends JpaRepository<Specialities, Long> {

	Specialities findBySymptom(Symptom symptom);

}
