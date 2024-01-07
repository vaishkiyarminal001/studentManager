package com.app.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.StudentDTO;
import com.app.entity.Course;
import com.app.entity.Student;
import com.app.entity.StudentAddress;
import com.app.repository.CourseRepository;
import com.app.repository.StudentAddressRepository;
import com.app.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentAddressRepository studentAddressRepository;

    @Autowired
    private CourseRepository courseRepository;

	@Override
	public Student admitStudent(Student student, List<StudentAddress> addresses) {
		
		Student savedStudent = studentRepository.save(student);
		
		addresses.forEach(address -> {
            address.setStudent(savedStudent);
            studentAddressRepository.save(address);
        });
		
		 return savedStudent;
	}

	@Override
    public List<Student> getStudentsByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public List<Student> getStudentsByCourse(Long courseId) {
        return courseRepository.findById(courseId)
                .map(Course::getStudents)
                .orElse(Collections.emptyList());
    }

    @Override
    public Student admitStudent(Student student) {
        return studentRepository.save(student);
    }


    
   

}
