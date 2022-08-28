package com.example.demo;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.example.demo.controller.DoctorController;

import com.example.demo.entity.Doctor;

import com.example.demo.repository.DoctorRepository;

import com.example.demo.service.DoctorService;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

class DoctorApplicationTests {

	public static Logger logger = LoggerFactory.getLogger(DoctorApplicationTests.class);
	
	@Autowired
	private DoctorController doctorController = mock(DoctorController.class);
	
	
	@MockBean
	private DoctorRepository doctorRepositiry;
	
	@Autowired
	private DoctorService doctorService;
	
	@BeforeEach
	void setup() {
		doctorRepositiry.deleteAll();
	}
	@Test
	public void addDoctor() throws Exception {
		logger.info("save Students test executing");
		Doctor doctor = new Doctor(1,"Tarun",25,"Male","Heart",0);
		//Student student = new Student(103,"Sai","Male",25,1 );
		when(doctorController.addDoctor(doctor)).thenReturn(doctor);
		assertThat(doctor.getId()).isGreaterThan(0);
		assertEquals(doctorService.addDoctor(doctor),doctorController.addDoctor(doctor));
	}
	
	@Test
	public void getAllDetails() throws Exception {
		logger.info("Get Students test executing");
		when(doctorController.getAllDetails()).thenReturn(Stream
				.of(new Doctor(1,"Tarun",25,"Male","Heart",1), 
						new Doctor(1,"Tarun",25,"Male","Heart",2))
				.collect(Collectors.toList()));
		Assertions.assertFalse(doctorService.getAllDetails().isEmpty());
		assertEquals(2, doctorService.getAllDetails().size());
	}
	
	@Test
	public void getDoctorByIdTest() {
		logger.info("Get Doctor by Id test executing");
		long id = 1;
		Doctor doctor = new Doctor(1,"Tarun",25,"Male","Heart",0);
//		Optional<Doctor> doctor = Optional.ofNullable(new Doctor(1,"Tarun",25,"Male","Heart",0));
		when(doctorRepositiry.findDoctorById(id)).thenReturn(doctor);
		assertEquals(doctor, doctorRepositiry.findDoctorById(id));
	}
	
//	@Test
//	public void add() throws Exception {
//		logger.info("save Students test executing");
//		Student student = new Student(101,"Venkatesh","Male",23,1 );
//		//Student student = new Student(103,"Sai","Male",25,1 );
//		when(stucontroller.add(student)).thenReturn(student);
//		assertThat(student.getRoolno()).isGreaterThan(0);
//		assertEquals(studentservice.add(student),stucontroller.add(student));
//	}
//	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	

//	@Test
//	public void giveListofDoctors_whenAllDoctors_thenReturnEmployeelist() throws Exception{
//		//Doctor listoFDoctors = new Doctor();
//		Doctor listoFDoctors =(new Doctor(1,"Tarun",25,"Male","Heart",0));
//		//Doctor listoFDoctors.add(new Doctor(2,"Venkatesh",24,"Male","Eye",0));
//		doctorService.addDoctor(listoFDoctors);
//		ResultActions response =mockMvc.perform(get("http://localhost:8097/doctor"));
//		
//		response.andExpect(status().isOk())
//			.andDo(print())
//			.andExpect(jsonPath("$.size()",
//					is(listoFDoctors.size())));
//		}
		
//	public void saveDoctorTest() throws Exception {
//		logger.info("save Doctor test executing");
//		Doctor doctor = new Doctor(1,"Tarun",25,"Male","Heart",0);
//		when(doctorRepositiry.save(doctor)).thenReturn(doctor);
//		assertThat(doctor.getId()).isGreaterThan(0);
//		assertEquals("green", doctorService.addDoctor(doctor));
//	}
}
	

