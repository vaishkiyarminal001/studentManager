package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.StudentAddressDTO;
import com.app.entity.Student;
import com.app.entity.StudentAddress;
import com.app.exceptions.SomethingWentWrong;
import com.app.repository.StudentAddressRepository;
import com.app.repository.StudentRepository;


@Service
public class StudentAddressServieImpl implements StudentAddressService {
	
	@Autowired
	private StudentAddressRepository studentAddressRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
    public StudentAddress addAddress(Long studentId, StudentAddressDTO studentAddressDTO) throws SomethingWentWrong {
     
        
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new SomethingWentWrong("Student not found with id: " + studentId));

        StudentAddress studentAddress = new StudentAddress();
        studentAddress.setArea(studentAddressDTO.getArea());
        studentAddress.setState(studentAddressDTO.getState());
        studentAddress.setDistrict(studentAddressDTO.getDistrict());
        studentAddress.setPincode(studentAddressDTO.getPincode());

        studentAddress.setStudent(student);
        student.getAddresses().add(studentAddress);

        return studentAddressRepository.save(studentAddress);
    }

}
