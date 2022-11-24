package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visethboti.portfolio.schoolmanagementsystem.dao.AdminRepository;
import com.visethboti.portfolio.schoolmanagementsystem.entity.Admin;

@Service
public class AdminServiceImpl implements AdminService {

	
	private AdminRepository adminRepository;
	
	@Autowired
	public AdminServiceImpl(AdminRepository theAdminRepository) {
		this.adminRepository = theAdminRepository;
	}
	
	@Override
	public List<Admin> findAll() {
		return adminRepository.findAll();
	}

	@Override
	public Admin findById(int theAdminID) {
		Optional<Admin> result = adminRepository.findById(theAdminID);
		
		Admin theAdmin = null;
		
		if(result.isPresent()) {
			theAdmin = result.get();
		} else {
			// didnt find the admin
			throw new RuntimeException("Did not find admin id - " + theAdminID);
		}
		
		return theAdmin;
	}

	@Override
	public void save(Admin theAdmin) {
		adminRepository.save(theAdmin);
	}

	@Override
	public void deleteById(int theAdminID) {
		adminRepository.deleteById(theAdminID);
	}

}
