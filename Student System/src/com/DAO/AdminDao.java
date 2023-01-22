package com.DAO;


import java.util.List;

import com.Exception.AdminException;
import com.Model.Admin;
import com.Model.Course;

public interface AdminDao {

	
	public String registersAdmin(Admin admin) throws AdminException;
	public Admin AdminLogin(String email, String password) throws AdminException;
	public  String newCourse(int cid, String cName, int cFee, int cSeats) throws AdminException;
	public String updateCourseFee( int cid, String name, int cFee) throws AdminException;
	public String DeleteCourse(int cid) throws AdminException;
	public List<Course> showTables();


}
