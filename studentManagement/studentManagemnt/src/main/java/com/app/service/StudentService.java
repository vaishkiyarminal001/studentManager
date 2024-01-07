package com.app.service;

import java.util.List;

import com.app.entity.Student;
import com.app.entity.StudentAddress;

public interface StudentService {
	Student admitStudent(Student student, List<StudentAddress> addresses);
    List<Student> getStudentsByName(String name);
    List<Student> getStudentsByCourse(Long courseId);
    Student admitStudent(Student student);
		
	


}
