package com.Usecase;

import java.util.Scanner;

import com.DAO.StudentDAOImpl;
import com.DAO.StudentDao;
import com.Exception.StudentException;
import com.Model.Student;

public class StudentLoginUseCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
        Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Login details");
		
		StudentDao stu= new StudentDAOImpl();
		
		while(true) {
		
			 
			 System.out.println("Enter student Email id");
			 String username=sc.nextLine();
			 
			 System.out.println("Enter student password");
			 String password=sc.nextLine();
			 
			 Student st= new Student();
			 st.setEmail(username);
			 st.setPassword(password);
			 
			 
			 try {
				Student student= stu.StudentLogin(username,password);
				System.out.println("Welcome: "+ student.getName());
				
				
			} catch (StudentException e) {
			System.out.println(e.getMessage());
			}
			 
			 
			 System.out.println("Do you want to log in another Student? type (Y/N)");
			 String res=sc.nextLine();
			 
			 if(res.equalsIgnoreCase("N")) {
				 System.out.println("Thank you");
				 break;
			 }
			 
			 
		}
		sc.close();
	}

}
