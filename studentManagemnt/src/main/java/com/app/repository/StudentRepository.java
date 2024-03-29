package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	 List<Student> findByName(String name);
	 Optional<Student> findByStudentCode(String studentCode);
}
