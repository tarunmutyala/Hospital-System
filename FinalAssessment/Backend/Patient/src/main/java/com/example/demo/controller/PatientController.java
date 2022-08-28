package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.Patient;
import com.example.demo.service.PatientService;
import com.example.demo.vo.Doctor;
import com.example.demo.vo.ResponseTemplate;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@PostMapping("/add-patient")
	public Patient addPatient(@RequestBody Patient patient) {
		return patientService.addPatient(patient);
	}
	
	@RequestMapping("/findById")
	public Patient findById(@RequestBody long patid) throws Exception {
		return patientService.findById(patid);
	}
	
	@GetMapping("/allpatient")
	public List<Patient> getAllDetails(){
		return patientService.getAllDetails();
		}
	
	@GetMapping("/patientname/{docid}")
		public List<Patient> retrivesPatientBydoctorId(@PathVariable long docid){
			return patientService.retrivesPatientBydoctorId(docid);
		}
	
	
	@PutMapping("/{patid}/{docid}")
	public String assignDoctor(@PathVariable long patid,@PathVariable long docid, Patient patient)
	{
		patient = patientService.assignDoctor(patid,docid);
		if(patient!=null)
		{
			return patient.toString();
		}
		return "Not Found";
	}
	
	@RequestMapping("/patientalongdoctor")
	public ResponseTemplate patientwithDoctor(@RequestBody long id) {
		return patientService.patientwithDoctor(id);
	}
	
//	@PutMapping("/{patid}/{docid}")
//	public String updateDoctor(@PathVariable long patid,@PathVariable long docid, Patient patient)
//	{
//		patient = patientService.assignDoctor(patid,docid);
//		if(patient!=null)
//		{
//			return patient.toString();
//		}
//		return "Not Found";
//	}
	
//	@RequestMapping("/fetchdoctor")
//	public ResponseTemplate fetchDoctor(Doctor doctors) {
//		return patientService.fetchDoctor(doctors);
//	}
	

	
//	@GetMapping("/doctor/")
//	public ResponseTemplate fetchDoctor(long docid) {
//		return patientService.fetchDoctor(docid);
//	}
	
//	

}
