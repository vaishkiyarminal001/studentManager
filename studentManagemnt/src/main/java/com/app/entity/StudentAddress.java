package com.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class StudentAddress {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stuAdrid;
    private String area;
    private String state;
    private String district;
    private String pincode;
 
    
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    
    
	public Long getStuAdrid() {
		return stuAdrid;
	}

	public void setStuAdrid(Long stuAdrid) {
		this.stuAdrid = stuAdrid;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


    
    
    
	
    
    
    

}
