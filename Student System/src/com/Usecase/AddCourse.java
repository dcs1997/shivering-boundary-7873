package com.Usecase;

import java.util.Scanner;

import com.ConsoleColors.ConsoleColors;
import com.DAO.AdminDao;
import com.DAO.AdminDaoImpl;
import com.Exception.AdminException;
import com.Model.Course;

public class AddCourse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  Scanner sc=new Scanner(System.in);
			
			System.out.println(ConsoleColors.YELLOW+"Insert course details");
			
			AdminDao adm= new AdminDaoImpl();
			
			while(true) {
				
				System.out.println("Enter course id");
				 int cid=sc.nextInt();

				 sc.nextLine();
				 System.out.println("Enter course name ");
				 String username=sc.nextLine();
				
				 System.out.println("Enter course Fee");
				 int cFee=sc.nextInt();
				 
				 sc.nextLine();
				 
				 System.out.println("Enter seats in course");
				 int seats=sc.nextInt();
				 
				 sc.nextLine();
				 
				 Course ad= new Course();
				 ad.setcId(cid);
				 ad.setCname(username);
				 ad.setFees(cFee);
				 ad.setcSeats(seats);
				 
				 
				 try {
					String admin= adm.newCourse( cid,username, cFee, seats);
					System.out.println(admin);
					
					
				} catch (AdminException e) {
				System.out.println(e.getMessage());
				}
				 
				 
				 System.out.println("Do you want add another data? type (Y/N)");
				 String res=sc.nextLine();
				 
				 if(res.equalsIgnoreCase("N")) {
					 System.out.println("Thank you");
					 break;
				 }
				 
				 
			}
			sc.close();
		}

	}


