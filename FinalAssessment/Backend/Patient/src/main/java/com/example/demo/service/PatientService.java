package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRpository;
import com.example.demo.vo.Doctor;
import com.example.demo.vo.ResponseTemplate;

@Service
public class PatientService {

	@Autowired
	PatientRpository patientRepository;
	
	@Autowired
	private RestTemplate newRestTemplate;
	
	public Patient addPatient(Patient patient) {
		return patientRepository.save(patient);
	}
	
	public Patient findById(long id) throws Exception{
		if(patientRepository.findById(id)==null)
		{
			return null;
		}
		return patientRepository.findById(id).get();
	}
	public List<Patient> getAllDetails() {
		return patientRepository.findAll();
	}
	public Patient assignDoctor(long patid, long docid) {
		Patient patient = patientRepository.findById(patid).get();
		Doctor doctor = newRestTemplate
				.getForObject("http://Doctor-Service/doctor/id/"+docid, Doctor.class);
		if(patient==null || doctor==null)
		{
			return null;
		}
		patient.setDocid(docid);
		patientRepository.save(patient);
		return patient;
	}
	

	public ResponseTemplate patientwithDoctor(long patid) {
		ResponseTemplate responseTemp = new ResponseTemplate();
		Patient patient = patientRepository.findById(patid).get();
		long docid = patient.getDocid();
		Doctor doctor = newRestTemplate.getForObject("http://Doctor-Service/doctor/getalldoctorwithpatients"+docid, Doctor.class);
		responseTemp.setDoctor(doctor);
		responseTemp.setPatient(patient);
		return responseTemp;
	}
	public List<Patient> retrivesPatientBydoctorId(long docid){
		return patientRepository.retrivesPatientBydoctorId(docid);
	}
	
	
//	public ResponseTemplate fetchDoctor(Doctor doctors) {
//		ResponseTemplate responseTemp = new ResponseTemplate();
//		Doctor doctor=newRestTemplate.getForObject("http://Doctor-Service/doctor/alldoctor", Doctor.class);
//		responseTemp.getDoctor();
//		return responseTemp;
//	}

}
