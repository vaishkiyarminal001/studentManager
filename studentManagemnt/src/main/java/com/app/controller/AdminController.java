package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CourseDTO;
import com.app.dto.StudentAddressDTO;
import com.app.entity.Admin;
import com.app.entity.Course;
import com.app.entity.Student;
import com.app.entity.StudentAddress;
import com.app.exceptions.SomethingWentWrong;
import com.app.service.AdminService;
import com.app.service.CourseService;
import com.app.service.StudentAddressService;
import com.app.service.StudentService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private StudentAddressService studentAddressService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private CourseService courseService;

	@Autowired
	private AdminService adminService;
	
    @Autowired
	private PasswordEncoder passwordEncoder;
    
	@PostMapping("/signin")
	public ResponseEntity<String> logInUserHandler(Authentication auth){
		Admin admin = adminService.findByUsername(auth.getName()).get();
		return new ResponseEntity<>(admin.getUsername() + " Logged In Successfully", HttpStatus.ACCEPTED);
	}


	@PostMapping("/register")
	public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) {
		try {
			admin.setPassword(passwordEncoder.encode(admin.getPassword()));
			Admin registeredAdmin = adminService.registerAdmin(admin);
			return new ResponseEntity<>(registeredAdmin, HttpStatus.CREATED);
		} catch (SomethingWentWrong e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/uploadCourse")
	public ResponseEntity<?> uploadCourse(@RequestBody CourseDTO courseDTO) {
		try {
			Course savedCourse = courseService.uploadCourse(courseDTO);
			return new ResponseEntity<>("Course has beed saved "+savedCourse, HttpStatus.CREATED);
		} catch (SomethingWentWrong e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/assignCourseToStudent")
	public ResponseEntity<?> assignCourses(@RequestParam Long studentId, @RequestParam Long courseId) {
		try {
			courseService.assignCourses(studentId, courseId);
			return new ResponseEntity<>("Course hase bedd assigned ",HttpStatus.OK);
		} catch (SomethingWentWrong e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/addAddressOfStudent")
	public ResponseEntity<StudentAddress> addAddress(@RequestParam Long studentId,
			@RequestBody StudentAddressDTO studentAddressDTO) {
		try {
			StudentAddress addedAddress = studentAddressService.addAddress(studentId, studentAddressDTO);
			return new ResponseEntity<>(addedAddress, HttpStatus.CREATED);
		} catch (SomethingWentWrong e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/registerStudent")
	public ResponseEntity<Student> admitStudent(@RequestBody Student student) {
		try {
			
			student.setPassword(passwordEncoder.encode(student.getPassword()));
			Student admittedStudent = studentService.admitStudent(student);
			return new ResponseEntity<>(admittedStudent, HttpStatus.CREATED);
		} catch (SomethingWentWrong e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/searchStudentByName")
	public ResponseEntity<List<Student>> getStudentsByName(@RequestParam String name) {
		try {
			List<Student> students = studentService.getStudentsByName(name);
			return new ResponseEntity<>(students, HttpStatus.OK);
		} catch (SomethingWentWrong e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getStudents-by-course")
	public ResponseEntity<List<Student>> getStudentsByCourse(@RequestParam Long courseId) {
		try {
			List<Student> students = studentService.getStudentsByCourse(courseId);
			return new ResponseEntity<>(students, HttpStatus.OK);
		} catch (SomethingWentWrong e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
