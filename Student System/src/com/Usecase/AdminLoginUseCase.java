package com.Usecase;

import java.util.Scanner;

import com.ConsoleColors.ConsoleColors;
import com.DAO.AdminDao;
import com.DAO.AdminDaoImpl;
import com.Exception.AdminException;
import com.Model.Admin;

public class AdminLoginUseCase {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Scanner sc=new Scanner(System.in);
		
		System.out.println(ConsoleColors.YELLOW+"Enter Login details");
		
		AdminDao adm= new AdminDaoImpl();
		
		while(true) {
		
			 
			 System.out.println("Enter admin Email id");
			 String username=sc.nextLine();
			 
			 System.out.println("Enter admin password");
			 String password=sc.nextLine();
			 
			 Admin ad= new Admin();
			 ad.setaEmail(username);
			 ad.setaPassword(password);
			 
			 
			 try {
				Admin admin= adm.AdminLogin(username,password);
				System.out.println("Welcome: "+ admin.getaName());
				
				
			} catch (AdminException e) {
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
