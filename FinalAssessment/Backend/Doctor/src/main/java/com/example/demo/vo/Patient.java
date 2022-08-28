package com.example.demo.vo;

import java.util.Date;

import com.example.demo.entity.Doctor;

public class Patient {
	private long id;
	private String name;
	private String visitedDoctor;
	private String dateofVisit;
	private long age;
	private String prescription;
	private long docid;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVisitedDoctor() {
		return visitedDoctor;
	}
	public void setVisitedDoctor(String visitedDoctor) {
		this.visitedDoctor = visitedDoctor;
	}
	
	public String getDateofVisit() {
		return dateofVisit;
	}
	public void setDateofVisit(String dateofVisit) {
		this.dateofVisit = dateofVisit;
	}
	public long getAge() {
		return age;
	}
	public void setAge(long age) {
		this.age = age;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	
	public long getDocid() {
		return docid;
	}
	public void setDocid(long docid) {
		this.docid = docid;
	}
	
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", visitedDoctor=" + visitedDoctor + ", dateofVisit="
				+ dateofVisit + ", age=" + age + ", prescription=" + prescription + ", docid=" + docid + "]";
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(long id, String name, String visitedDoctor, String dateofVisit, long age, String prescription,
			long docid) {
		super();
		this.id = id;
		this.name = name;
		this.visitedDoctor = visitedDoctor;
		this.dateofVisit = dateofVisit;
		this.age = age;
		this.prescription = prescription;
		this.docid = docid;
	}	
	
}
