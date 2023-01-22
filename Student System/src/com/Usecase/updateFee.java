package com.Usecase;

import java.util.Scanner;

import com.DAO.AdminDao;
import com.DAO.AdminDaoImpl;
import com.DAO.StudentDao;
import com.Exception.AdminException;
import com.Exception.StudentException;
import com.Model.Admin;
import com.Model.Course;
import com.Model.Student;

public class updateFee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter email update details");
		
		AdminDao adm= new AdminDaoImpl();
		
		while(true) {
		
			 System.out.println("Enter course id");
			 int id=sc.nextInt();
			 sc.nextLine();
			 
			 System.out.println("Enter course name ");
			 String name=sc.nextLine();
			 
			 System.out.println("Enter new fee");
			 int fee=sc.nextInt();
			 sc.nextLine();
			 
			Course st= new Course();
			 st.setcId(id);
			 st.setCname(name);
			 st.setFees(fee);
			 
			 
			 try {
				String result= adm.updateCourseFee(id, name, fee);
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
