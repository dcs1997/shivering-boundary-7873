package com.Usecase;

import java.util.Scanner;

import com.DAO.AdminDao;
import com.DAO.AdminDaoImpl;
import com.Exception.AdminException;
import com.Model.Course;

public class DeleteCourse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		AdminDao adm= new AdminDaoImpl();
		while(true) {
			
		System.out.println("Enter the course id which you want to delete");
		int id=sc.nextInt();
		
		Course st= new Course();
		 st.setcId(id);
		 
		 try {
				String result= adm.DeleteCourse(id);
				System.out.println(result);
								
				
			} catch (AdminException e) {
			System.out.println(e.getMessage());
			}
			 
			 
			 System.out.println("Do you want to change fee for any other course? type (Y/N)");
			 String res=sc.nextLine();
			 
			 if(res.equalsIgnoreCase("N")) {
				 System.out.println("Thank you");
				 break;
			 }
			 
			 
		}
		sc.close();


	}

}
