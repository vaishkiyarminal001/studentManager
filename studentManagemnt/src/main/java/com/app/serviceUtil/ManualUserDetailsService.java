package com.app.serviceUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.entity.Admin;
import com.app.entity.Student;
import com.app.repository.AdminRepository;
import com.app.repository.StudentRepository;


@Service
public class ManualUserDetailsService implements UserDetailsService {
    
	@Autowired
	 private StudentRepository studentRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	public boolean isAdmin(String username) {
	   Optional<Admin> admin = adminRepository.findByUsername(username);
		if(admin.isPresent()) return true;
		else return false;
	}
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if(isAdmin(username)) {
			Optional<Admin> admin = adminRepository.findByUsername(username);
			 
			 if(admin.isEmpty()) throw new UsernameNotFoundException("Admin not found");
			 Admin us = admin.get();
			 
			List<GrantedAuthority> authorities = new ArrayList<>() ;
			SimpleGrantedAuthority autho = new SimpleGrantedAuthority("ROLE_"+us.getRole()) ;
			authorities.add(autho) ;
			User secUser = new User(us.getUsername(), us.getPassword(),  authorities) ;
			return secUser ;
		}else {
			
			Optional<Student> myUser = studentRepository.findByStudentCode(username);
				 
				 if(myUser.isEmpty()) throw new UsernameNotFoundException("User not found");
				 Student us = myUser.get();
				 
				List<GrantedAuthority> authorities = new ArrayList<>() ;
				SimpleGrantedAuthority autho = new SimpleGrantedAuthority("ROLE_"+us.getRole()) ;
				authorities.add(autho) ;
				User secUser = new User(us.getStudentCode(), us.getPassword(),  authorities) ;
				return secUser ;

				
			}
		}


}
