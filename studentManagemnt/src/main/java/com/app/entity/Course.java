package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long courseId;
	    private String courseName;
	    private String description;
	    private String courseType;
	    private int duration;
	    
	    
	    @JsonIgnore
	    @ManyToMany(mappedBy = "courses")
	    private List<Student> students = new ArrayList<>();
	    
	    
		public String getCourseName() {
			return courseName;
		}
		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getCourseType() {
			return courseType;
		}
		public void setCourseType(String courseType) {
			this.courseType = courseType;
		}
		public int getDuration() {
			return duration;
		}
		public void setDuration(int duration) {
			this.duration = duration;
		}
		public List<Student> getStudents() {
			return students;
		}
		public void setStudents(List<Student> students) {
			this.students = students;
		}
		@Override
		public String toString() {
			return "Course [courseId=" + courseId + ", courseName=" + courseName + ", description=" + description
					+ ", courseType=" + courseType + ", duration=" + duration + ", students=" + students + "]";
		}
		
		
	    
	    

	
	

}
