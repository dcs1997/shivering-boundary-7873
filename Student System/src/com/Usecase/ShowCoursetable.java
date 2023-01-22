package com.Usecase;

import java.util.List;

import com.DAO.AdminDao;
import com.DAO.AdminDaoImpl;
import com.Model.Course;



public class ShowCoursetable {

	
	public static void main(String[] args) {
		
		
		AdminDao adm = new AdminDaoImpl();
		
		List<Course> res = adm.showTables();
		
		if(res.isEmpty()) System.out.println("No data Found");
		
		else {
			res.forEach(System.out::println);
		}
		
	}

}
