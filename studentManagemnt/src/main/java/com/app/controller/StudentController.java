package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.StudentDTO;
import com.app.entity.Admin;
import com.app.entity.Course;
import com.app.entity.Student;
import com.app.exceptions.SomethingWentWrong;
import com.app.service.CourseService;
import com.app.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private CourseService courseService;
	
	
	@PostMapping("/signin")
	public ResponseEntity<String> logInUserHandler(Authentication auth){
		Student student = studentService.findByStudentCode(auth.getName()).get();
		return new ResponseEntity<>(student.getStudentCode() + " Logged In Successfully", HttpStatus.ACCEPTED);
	}


	@PutMapping("/update-profile/{studentId}")
	public ResponseEntity<Student> updateStudentProfile(@PathVariable Long studentId,
			@RequestBody StudentDTO studentDTO) {
		try {
			Student updatedStudent = studentService.updateStudentProfile(studentId, studentDTO);
			return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
		} catch (SomethingWentWrong e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/leave-course")
	public ResponseEntity<?> leaveCourse(@RequestParam Long studentId, @RequestParam Long courseId) {
		try {
			studentService.leaveCourse(studentId, courseId);
			return new ResponseEntity<>("Course has beed removed ",HttpStatus.OK);
		} catch (SomethingWentWrong e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/searchCourseTopic")
	public ResponseEntity<List<Course>> searchCourseOrTopic(@RequestParam String courseOrTopic) {
		try {
			List<Course> courses = courseService.sreachCourseOrTopic(courseOrTopic);
			return new ResponseEntity<>(courses, HttpStatus.OK);
		} catch (SomethingWentWrong e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
