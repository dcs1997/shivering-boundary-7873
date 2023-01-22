package com.Usecase;

import com.DAO.StudentDAOImpl;
import com.DAO.StudentDao;
import com.Exception.CourseException;
import com.Exception.StudentException;

public class CourseAndSeatsAvailablity {
	
	public static void main(String[] args) {
		
		StudentDao st= new StudentDAOImpl();
		
		try {
			String ans=st.availableCoursesAndSeats();
			System.out.println(ans);
		} catch (StudentException | CourseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		}
		
	}

}
