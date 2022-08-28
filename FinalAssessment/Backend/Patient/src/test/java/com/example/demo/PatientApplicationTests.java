package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.example.demo.controller.PatientController;

import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRpository;
import com.example.demo.service.PatientService;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class PatientApplicationTests {
	
public static Logger logger = LoggerFactory.getLogger(PatientApplicationTests.class);
	
	@Autowired
	private PatientController patientController = mock(PatientController.class);
	
	
	@MockBean
	private PatientRpository patientRepository;
	
	@Autowired
	private PatientService patientService;
	
	@BeforeEach
	void setup() {
		patientRepository.deleteAll();
	}
	@Test
	public void addPatient() throws Exception {
		logger.info("save Students test executing");
		Patient patient = new Patient(1,"P1","Tarun","22/09/2022",25,"Take Care",2);
		when(patientController.addPatient(patient)).thenReturn(patient);
		assertThat(patient.getId()).isGreaterThan(0);
		assertEquals(patientService.addPatient(patient),patientController.addPatient(patient));
	}
	
	@Test
	public void getAllDetails() throws Exception {
		logger.info("Get Students test executing");
		when(patientController.getAllDetails()).thenReturn(Stream
				.of(new Patient(1,"P1","Tarun","22/09/2022",25,"Take Care",2), 
						new Patient(1,"P1","Tarun","22/09/2022",25,"Take Care",2))
				.collect(Collectors.toList()));
		Assertions.assertFalse(patientService.getAllDetails().isEmpty());
		assertEquals(2, patientService.getAllDetails().size());
	}
	
	@Test
	public void getDoctorByIdTest() throws Exception {
		logger.info("Get Doctor by Id test executing");
		long id = 1;
		Patient patient = new Patient(1,"P1","Tarun","22/09/2022",25,"Take Care",2);
//		Optional<Doctor> doctor = Optional.ofNullable(1,"P1","Tarun","22/09/2022",25,"Take Care",2);
		when(patientRepository.findPatientById(id)).thenReturn(patient);
		assertEquals(patient, patientRepository.findPatientById(id));
	}
	
//	@Test
//	void contextLoads() {
//	}

}
