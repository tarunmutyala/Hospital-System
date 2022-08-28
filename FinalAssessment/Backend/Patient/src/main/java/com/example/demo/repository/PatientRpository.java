package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.demo.entity.Patient;

public interface PatientRpository extends JpaRepository<Patient, Long> {

	@Query(value="SELECT * FROM patient WHERE docidd=:docid ORDER BY name ", nativeQuery = true)
	List<Patient> retrivesPatientBydoctorId(@Param("docid") long docid);
	
	Patient findPatientById(long id);

}
