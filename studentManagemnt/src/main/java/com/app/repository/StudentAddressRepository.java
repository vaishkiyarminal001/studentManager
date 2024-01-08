package com.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.entity.StudentAddress;

public interface StudentAddressRepository extends CrudRepository<StudentAddress, Long> {
	

}
