package com.example.demo.vo;

public class Doctor {

	private long id;
	private String name;
	private int age;
	private String gender;
	private String specialist;
	private long noOfPatients;
	
	
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(long id, String name, int age, String gender, String specialist,long noOfPatients ) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.specialist = specialist;
		this.noOfPatients=noOfPatients;
	}
	public long getNoOfPatients() {
		return noOfPatients;
	}
	public void setNoOfPatients(long noOfPatients) {
		this.noOfPatients = noOfPatients;
	}
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSpecialist() {
		return specialist;
	}
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", specialist="
				+ specialist + ", noOfPatients=" + noOfPatients + "]";
	}
}
