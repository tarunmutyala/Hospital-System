package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.Doctor;

import com.example.demo.service.DoctorService;
import com.example.demo.vo.RequestTemplate;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/add-doctor")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return doctorService.addDoctor(doctor);
	}
	
	@GetMapping("/id/{docid}")
	public Doctor findById(@PathVariable long docid) {
		return doctorService.findById(docid);
	}
	
	@GetMapping("/alldoctor")
	public List<Doctor> getAllDetails(){
		return doctorService.getAllDetails();
		}
	
	@GetMapping("/getalldoctorwithpatients")
	public List<RequestTemplate> getDoctorAlongwithPatients(){
		return doctorService.getDoctorAlongwithPatients();
	}
	@GetMapping("/name/{name}")
	public List<Doctor> getDoctorByName(@PathVariable String name){
		return doctorService.getDoctorByName(name);
		
	}
	
	@GetMapping("/docname/{name}")
	public List<Doctor> getOnlyName(@PathVariable String name) {
		return doctorService.getOnlyName(name);
	}
		
}
