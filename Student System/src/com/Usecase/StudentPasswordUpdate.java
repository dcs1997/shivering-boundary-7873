package com.Usecase;

import java.util.Scanner;

import com.DAO.StudentDAOImpl;
import com.DAO.StudentDao;
import com.Exception.StudentException;
import com.Model.Student;

public class StudentPasswordUpdate {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
        Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter email update details");
		
		StudentDao stu= new StudentDAOImpl();
		
		while(true) {
		
			 System.out.println("Enter student id");
			 int id=sc.nextInt();
			 sc.nextLine();
			 System.out.println("Enter old Password ");
			 String oldpass=sc.nextLine();
			 
			 System.out.println("Enter new password");
			 String newpass=sc.nextLine();
			 
			 Student st= new Student();
			 st.setSid(id);
			 st.setEmail(oldpass);
			 st.setPassword(newpass);
			 
			 
			 try {
				String result= stu.StudentUpdatePassword(id, oldpass, newpass);
				System.out.println(result);
								
				
			} catch (StudentException e) {
			System.out.println(e.getMessage());
			}
			 
			 
			 System.out.println("Do you want to change name of any other Student? type (Y/N)");
			 String res=sc.nextLine();
			 
			 if(res.equalsIgnoreCase("N")) {
				 System.out.println("Thank you");
				 break;
			 }
			 
			 
		}
		sc.close();
}

}
