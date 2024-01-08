package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.StudentDTO;
import com.app.entity.Student;
import com.app.exceptions.SomethingWentWrong;

public interface StudentService {
	Student admitStudent(Student student) throws SomethingWentWrong;

	List<Student> getStudentsByName(String name) throws SomethingWentWrong;

	List<Student> getStudentsByCourse(Long courseId) throws SomethingWentWrong;

	Student updateStudentProfile(Long studentId,StudentDTO studentDTO) throws SomethingWentWrong;

	void leaveCourse(Long studentId, Long courseId) throws SomethingWentWrong;

	Optional<Student> findByStudentCode(String studentCode);

}
