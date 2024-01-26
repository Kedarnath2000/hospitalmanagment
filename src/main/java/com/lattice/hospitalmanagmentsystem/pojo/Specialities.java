package com.lattice.hospitalmanagmentsystem.pojo;

import com.lattice.hospitalmanagmentsystem.enums.Speciality;
import com.lattice.hospitalmanagmentsystem.enums.Symptom;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Specialities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private Symptom symptom;

	@Enumerated(EnumType.STRING)
	private Speciality speciality;

}
