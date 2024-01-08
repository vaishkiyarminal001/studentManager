package com.app.service;

import java.util.Optional;

import com.app.entity.Admin;
import com.app.exceptions.SomethingWentWrong;

public interface AdminService {
   Admin registerAdmin(Admin admin) throws SomethingWentWrong;
   Optional<Admin> findByUsername(String username) throws SomethingWentWrong;
}
