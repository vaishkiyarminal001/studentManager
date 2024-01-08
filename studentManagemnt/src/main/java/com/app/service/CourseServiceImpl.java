package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.CourseDTO;
import com.app.entity.Course;
import com.app.entity.Student;
import com.app.exceptions.SomethingWentWrong;
import com.app.repository.CourseRepository;
import com.app.repository.StudentRepository;

@Service
public class CourseServiceImpl implements CourseService{
	
	 @Autowired
	    private CourseRepository courseRepository;

	    @Autowired
	    private StudentRepository studentRepository;

	    @Override
	    public Course uploadCourse(CourseDTO courseDTO) throws SomethingWentWrong {
	      
	        Course course = new Course();
	        course.setCourseName(courseDTO.getCourseName());
	        course.setDescription(courseDTO.getDescription());
	        course.setCourseType(courseDTO.getCourseType());
	        course.setDuration(courseDTO.getDuration());
	       

	        return courseRepository.save(course);
	    }

	    @Override
	    public void assignCourses(Long studentId, Long courseId) throws SomethingWentWrong {
	       
	        Student student = studentRepository.findById(studentId)
	                .orElseThrow(() -> new SomethingWentWrong("Student not found with id: " + studentId));

	        Course course = courseRepository.findById(courseId)
	                .orElseThrow(() -> new SomethingWentWrong("Course not found with id: " + courseId));

	        student.getCourses().add(course);
	        studentRepository.save(student);
	    }

	
	    @Override
	    public List<Course> sreachCourseOrTopic(String courseOrTopic) throws SomethingWentWrong {
	     
	        if (courseOrTopic != null && !courseOrTopic.isEmpty()) {
	         
	            return courseRepository.findByCourseName(courseOrTopic);
	        } else {
	     
	            return courseRepository.findAll();
	        }
	    }


}
