package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Course;
import com.app.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/upload")
    public ResponseEntity<Course> uploadCourse(@RequestBody Course course) {
    	Course uploadedCourse = courseService.uploadCourse(course);
        return new ResponseEntity<>(uploadedCourse, HttpStatus.CREATED);
    }

    @PostMapping("/assign/{studentId}")
    public ResponseEntity<Void> assignCourses(@PathVariable Long studentId, @RequestBody List<Long> courseIds) {
        courseService.assignCourses(studentId, courseIds);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
