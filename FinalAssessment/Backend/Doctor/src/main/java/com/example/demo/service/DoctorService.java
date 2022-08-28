package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Doctor;

import com.example.demo.repository.DoctorRepository;
import com.example.demo.vo.Patient;
import com.example.demo.vo.RequestTemplate;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private RestTemplate newRestTemplate;
	
	public Doctor addDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	public Doctor findById(long id) {
		if(doctorRepository.findById(id)==null)
		{
			return null;
		}
		return doctorRepository.findById(id).get();
	}
	
	public List<RequestTemplate> getDoctorAlongwithPatients() {
		List<RequestTemplate> details = new ArrayList<RequestTemplate>();
		List<Doctor> doctor = this.getAllDetails();
		Iterator<Doctor> iterate = doctor.iterator();
		while(iterate.hasNext())
		{
			Doctor doc = iterate.next();
			ResponseEntity<Patient[]> responseEntity =
					newRestTemplate.getForEntity(
							  "http://Patient-Service/patient/patientname/"+doc.getId(),
							Patient[].class);
			Patient[] pat = responseEntity.getBody();
			List<Patient> patients = Arrays.asList(pat);
 			RequestTemplate requestTemp = new RequestTemplate();
 			requestTemp.setDoctor(doc);
 			requestTemp.setPatientList(patients);
			details.add(requestTemp);
		}
		return details;
	}
	public List<Doctor> getAllDetails() {
		return doctorRepository.findAll();
	}
	public List<Doctor> getDoctorByName(String name) {
		
		return doctorRepository.getByName(name);
	}
	
	public List<Doctor> getOnlyName(String name) {
		return doctorRepository.getDoctorByName(name);
	}
	

}
