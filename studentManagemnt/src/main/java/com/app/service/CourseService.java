package com.app.service;

import java.util.List;

import com.app.dto.CourseDTO;
import com.app.entity.Course;
import com.app.exceptions.SomethingWentWrong;

public interface CourseService {

	 Course uploadCourse(CourseDTO course) throws SomethingWentWrong;
	 void assignCourses(Long studentId, Long courseId) throws SomethingWentWrong;
	 List<Course> sreachCourseOrTopic(String courseOrTopic) throws SomethingWentWrong;

}
