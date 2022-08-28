package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	
	
	@Modifying
	@Transactional
	@Query(value="select * from doctor where name= ?1",nativeQuery=true)
	List<Doctor> getByName(String name);
	
	@Query(value="select * from doctor d where d.name= ?1",nativeQuery=true)
	List<Doctor> getDoctorByName(String name);

	Doctor findDoctorById(long id);
	
	
	
}
