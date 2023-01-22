package com.Main;

import java.util.Scanner;

import com.ConsoleColors.ConsoleColors;
import com.Usecase.AddCourse;
import com.Usecase.AdminLoginUseCase;
import com.Usecase.CourseAndSeatsAvailablity;
import com.Usecase.DeleteCourse;
import com.Usecase.RegisterAdminUseCase;
import com.Usecase.StudentLoginUseCase;
import com.Usecase.updateFee;

public class Main {
	public static void main(String[] args) {
		stud_reg_sys();
	}
	
	static Scanner sc = new Scanner(System.in);
	
	public static void stud_reg_sys() {
		
		
		
		System.out.println(ConsoleColors.GREEN_BOLD
							+"+============================================+"+"\n"
							+"|   Welcome to Student Registration System   |"+"\n"
							+"+============================================+"+"\n"
							+"|                                            |"+"\n"
							+"|  1. Login as Admin                         |"+"\n"
							+"|  2. Login/SignUp as Student                |"+"\n"
							+"|  3. Exit                                   |"+"\n"
							+"|                                            |"+"\n"
							+"+============================================+"+"\n"
							+ConsoleColors.RESET);
		
		String out = sc.next();
		int n=Integer.parseInt(out);
		
		while(true) {
			
			if(n==1) {
				
				AdminLoginUseCase.main(null);
				
				AdminFunctionality();
				
				stud_reg_sys();
			
			}
			
			else if(n==2) {
				StudentLoginUseCase.main(null);
				
				StudentFunctionality();
				
				stud_reg_sys();
			}
			
			else break;
		}
		
	}
	
	public static void AdminFunctionality() {
		
		System.out.println(ConsoleColors.GREEN_BOLD
							+"+============================================+"+"\n"
							+"|          Welcome to Admin Section          |"+"\n"
							+"+============================================+"+"\n"
							+"|                                            |"+"\n"
							+"|  1. Register another Admin                 |"+"\n"
							+"|  2. Add a new Course                       |"+"\n"
							+"|  3. Update course fee                      |"+"\n"
							+"|  4. Delete course from batch               |"+"\n"
							+"|  5. View Courses                           |"+"\n"
							+"|  6. Create Batch under a course.           |"+"\n"
							+"|  7. Allocate courses to student            |"+"\n"
							+"|  8. Update total seats in batch.           |"+"\n"
							+"|  9. View batch details.                    |"+"\n"
							+"|  10. Back to main menu                     |"+"\n"
							+"|                                            |"+"\n"
							+"+============================================+"+"\n"
							+ConsoleColors.RESET);
		
		String out = sc.next();
		int n=Integer.parseInt(out);
		
//		while(true) {
			if(n==1) {
				
				RegisterAdminUseCase.main(null);
				AdminFunctionality();
				
			}
			
			else if(n==2) {
				AddCourse.main(null);
				AdminFunctionality();
			}
			
			
			else if(n==3) {
				updateFee.main(null);
				AdminFunctionality();
			}
			
			else if(n==4) {
				DeleteCourse.main(null);
				AdminFunctionality();
			}
			
			else if(n==5) {
				CourseAndSeatsAvailablity.main(null);
				AdminFunctionality();
			}
			
			else if(n==6) {
				AddCourse.main(null);
				AdminFunctionality();
			}
			
			else if(n==7) {
				AddCourse.main(null);
				AdminFunctionality();
			}
			
			
			else if(n==8) {
				AddCourse.main(null);
				AdminFunctionality();
			}
			
			else if(n==9) {
				AddCourse.main(null);
				AdminFunctionality();
			}
			
			else if(n==10) {
				stud_reg_sys();
				
			}
			
//		}
		

	}
	
	public static void StudentFunctionality() {
		
Scanner sc = new Scanner(System.in);
		
		System.out.println(ConsoleColors.GREEN_BOLD
							+"+============================================+"+"\n"
							+"|          Welcome to Admin Section          |"+"\n"
							+"+============================================+"+"\n"
							+"|                                            |"+"\n"
							+"|  1. Register new Student                   |"+"\n"
							+"|  2. Login as a student                     |"+"\n"
							+"|  3. Student Email Update                   |"+"\n"
							+"|  4. Student Password update                |"+"\n"
							+"|  5. Student Name Update                    |"+"\n"
							+"|  6. Course list and seat availabilty       |"+"\n"
							+"|  7. Back to main menu                      |"+"\n"
							+"|                                            |"+"\n"
							+"+============================================+"+"\n"
							+ConsoleColors.RESET);
		
		String out = sc.next();
		
		
		
		
	}
}
