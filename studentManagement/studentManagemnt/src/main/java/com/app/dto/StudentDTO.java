package com.app.dto;

import java.time.LocalDate;

public class StudentDTO {
	
	private String name;
    private LocalDate dateOfBirth;
    private String gender;
    private String StudentCode;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStudentCode() {
		return StudentCode;
	}
	public void setStudentCode(String studentCode) {
		StudentCode = studentCode;
	}
	
    
    
    

}
