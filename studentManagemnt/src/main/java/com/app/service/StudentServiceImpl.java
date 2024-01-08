package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.StudentDTO;
import com.app.entity.Course;
import com.app.entity.Student;
import com.app.exceptions.SomethingWentWrong;
import com.app.repository.CourseRepository;
import com.app.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
    private StudentRepository studentRepository;



    @Autowired
    private CourseRepository courseRepository;

 

    @Override
    public Student admitStudent(Student student) throws SomethingWentWrong {

        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudentsByName(String name) throws SomethingWentWrong {
  
        return studentRepository.findByName(name);
    }

    @Override
    public List<Student> getStudentsByCourse(Long courseId) throws SomethingWentWrong {
    
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            return course.getStudents();
        } else {
            throw new SomethingWentWrong("Course not found with id: " + courseId);
        }
    }

    @Override
    public Student updateStudentProfile(Long studentId, StudentDTO studentDTO) throws SomethingWentWrong {
      
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setName(studentDTO.getName());
            student.setDateOfBirth(studentDTO.getDateOfBirth());
            student.setGender(studentDTO.getGender());
            student.setStudentCode(studentDTO.getStudentCode());
            return studentRepository.save(student);
        } else {
            throw new SomethingWentWrong("Student not found with id: " + studentId);
        }
    }

    @Override
    public void leaveCourse(Long studentId, Long courseId) throws SomethingWentWrong {

        Optional<Student> studentOptional = studentRepository.findById(studentId);
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        
        if (studentOptional.isPresent() && courseOptional.isPresent()) {
            Student student = studentOptional.get();
            Course course = courseOptional.get();
            
            student.getCourses().remove(course);
            studentRepository.save(student);
        } else {
            throw new SomethingWentWrong("Student or Course not found with given ids");
        }
    }

    @Override
    public Optional<Student> findByStudentCode(String studentCode) throws SomethingWentWrong {
        try {
            return studentRepository.findByStudentCode(studentCode);
        } catch (Exception e) {
            throw new SomethingWentWrong("Error while fetching student by student code");
        }
    }
   

}
