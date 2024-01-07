package com.app.service;

import java.util.List;

import com.app.entity.Course;

public interface CourseService {

	 Course uploadCourse(Course course);
	 void assignCourses(Long studentId, List<Long> courseIds);

}
