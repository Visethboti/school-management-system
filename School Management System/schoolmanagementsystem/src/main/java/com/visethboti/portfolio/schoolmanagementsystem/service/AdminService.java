package com.visethboti.portfolio.schoolmanagementsystem.service;

import java.util.List;

import com.visethboti.portfolio.schoolmanagementsystem.entity.Admin;

public interface AdminService {
	public List<Admin> findAll();
	public Admin findById(int theAdminID);
	public void save(Admin theAdmin);
	public void deleteById(int theAdminID);
}
