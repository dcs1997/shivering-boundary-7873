package com.Usecase;

import java.util.Scanner;

import com.DAO.StudentDAOImpl;
import com.DAO.StudentDao;
import com.Exception.StudentException;
import com.Model.Student;

public class RegisterStudentUseCase {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter student details");
		
		StudentDao stu= new StudentDAOImpl();
		
		while(true) {
		
			 System.out.println("Enter Student id");
			 int id=sc.nextInt();
			 
			 System.out.println("Enter student name");
			 String name=sc.next();
			 
			 System.out.println("Enter student Email id");
			 String email=sc.next();
			 
			 System.out.println("Enter student password");
			 String password=sc.next();
			 
			 Student st= new Student();
			 st.setSid(id);
			 st.setName(name);
			 st.setEmail(email);
			 st.setPassword(password);
			 
			 
			 try {
				System.out.println(stu.registerStudent(st));
			} catch (StudentException e) {
			System.out.println(e.getMessage());
			}
			 
			 
			 System.out.println("Do you want to add new Student? type (Y/N)");
			 String result=sc.nextLine();
			 
			 if(result.equalsIgnoreCase("N")) {
				 System.out.println("Thank you for registration");
				 break;
			 }
			 
			 
		}
		sc.close();
	}
	

}
