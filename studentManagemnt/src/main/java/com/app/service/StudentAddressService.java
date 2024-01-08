package com.app.service;

import com.app.dto.StudentAddressDTO;
import com.app.entity.StudentAddress;

public interface StudentAddressService {
 StudentAddress addAddress(Long studentId,StudentAddressDTO studentAddressDTO);
}
