package com.Usecase;

import java.util.Scanner;

import com.ConsoleColors.ConsoleColors;
import com.DAO.AdminDao;
import com.DAO.AdminDaoImpl;
import com.Exception.AdminException;
import com.Model.Admin;

public class RegisterAdminUseCase {
	
public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter admin details");
		
		AdminDao adm= new AdminDaoImpl();
		
		while(true) {
		
			 System.out.println(ConsoleColors.YELLOW+"Enter admin id");
			 int id=sc.nextInt();
			 
			 sc.nextLine();
			 System.out.println("Enter admin name");
			 String name=sc.nextLine();
			 
			 System.out.println("Enter admin Email id");
			 String email=sc.nextLine();
			 
			 System.out.println("Enter admin password");
			 String password=sc.nextLine();
			 
			 Admin ad= new Admin();
			 ad.setaId(id);
			 ad.setaName(name);
			 ad.setaEmail(email);
			 ad.setaPassword(password);
			 
			 
			 try {
				System.out.println(adm.registersAdmin(ad));
			} catch (AdminException e) {
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
