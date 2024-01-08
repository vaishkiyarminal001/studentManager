package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Admin;
import com.app.exceptions.SomethingWentWrong;
import com.app.repository.AdminRepository;


@Service
public class AdminServiceImpl implements AdminService {

	 @Autowired
	    private AdminRepository adminRepository;

	    @Override
	    public Admin registerAdmin(Admin admin) throws SomethingWentWrong {
	     
	        return adminRepository.save(admin);
	    }

	 
		@Override
		public Optional<Admin> findByUsername(String username) throws SomethingWentWrong {
			 try {
		            return adminRepository.findByUsername(username);
		        } catch (Exception e) {
		            throw new SomethingWentWrong("Error while fetching admin by username");
		        }
		
}
}