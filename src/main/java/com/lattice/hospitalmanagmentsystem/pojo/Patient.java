package com.lattice.hospitalmanagmentsystem.pojo;

import com.lattice.hospitalmanagmentsystem.enums.Symptom;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Name is required")
	@Size(min = 3, message = "Name should be at least 3 characters")
	private String name;

	@NotBlank(message = "City is required")
	@Size(max = 20, message = "City should be at most 20 characters")
	private String city;

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	private String email;

	@NotBlank(message = "Phone number is required")
	@Pattern(regexp = "^[0-9]{10}$", message = "Phone number should be 10 digits")
	private String phoneNumber;

	@Enumerated(EnumType.STRING)
	private Symptom symptom;

}
