package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Course;
import com.app.entity.Student;
import com.app.repository.CourseRepository;
import com.app.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class CourseServiceImpl implements CourseService{
	
	 @Autowired
	    private CourseRepository courseRepository;

	    @Autowired
	    private StudentRepository studentRepository;

	    @Override
	    public Course uploadCourse(Course course) {
	        return courseRepository.save(course);
	    }

	    @Override
	    public void assignCourses(Long studentId, List<Long> courseIds) {
	        Student student = studentRepository.findById(studentId)
	                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + studentId));

	        List<Course> courses = courseRepository.findAllById(courseIds);

	        student.getCourses().addAll(courses);
	        courses.forEach(course -> course.getStudents().add(student));
	    }

}