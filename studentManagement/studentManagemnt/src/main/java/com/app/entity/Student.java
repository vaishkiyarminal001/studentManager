package com.app.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Student {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String name;
    private LocalDate dateOfBirth;
    private String gender;
    private String StudentCode;
    
   
    // student and studentAddress relationship
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentAddress> addresses = new ArrayList<>();
    
    
    // student and course relationship
    
    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses = new ArrayList<>();
    
    
    
    
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
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
	
	
	public List<StudentAddress> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<StudentAddress> addresses) {
		this.addresses = addresses;
	}
	
	
	
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", gender="
				+ gender + ", StudentCode=" + StudentCode + ", addresses=" + addresses + ", courses=" + courses + "]";
	}
	public void setAddress(Object address) {
		// TODO Auto-generated method stub
		
	}
	public void setMobileNumber(Object mobileNumber) {
		// TODO Auto-generated method stub
		
	}
	public void setEmail(Object email) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
    
    
    
    
    
    
	
	
	
	
}
