package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Student;
import com.app.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
    private StudentService studentService;

    @PostMapping("/admit")
    public ResponseEntity<Student> admitStudent(@RequestBody Student student) {
        Student admittedStudent = studentService.admitStudent(student);
        return new ResponseEntity<>(admittedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> getStudentsByName(@RequestParam String name) {
        List<Student> students = studentService.getStudentsByName(name);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Student>> getStudentsByCourse(@PathVariable Long courseId) {
        List<Student> students = studentService.getStudentsByCourse(courseId);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
	
	

}
