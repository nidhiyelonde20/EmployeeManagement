package com.example.assisment1.model;

import org.springframework.web.multipart.MultipartFile;

public class User {

	private Integer id;
	private String name;
    private String Department;
    private Double salary;
    private String address;
    private String hobbies;
    private String gender;
    private String upload;
    private MultipartFile file;
    
	public User() {
		
	}
	public User(Integer id, String name, String department, Double salary, String address, String hobbies,
			String gender, String upload, MultipartFile file) {
		super();
		this.id = id;
		this.name = name;
		Department = department;
		this.salary = salary;
		this.address = address;
		this.hobbies = hobbies;
		this.gender = gender;
		this.upload = upload;
		this.file = file;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUpload() {
		return upload;
	}
	public void setUpload(String upload) {
		this.upload = upload;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
    
    

	    
   
    
}
