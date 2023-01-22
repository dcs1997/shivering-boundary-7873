package com.DAO;

import com.Exception.CourseException;
import com.Exception.StudentException;
import com.Model.Student;

public interface StudentDao  {

	public String registerStudent(Student student) throws StudentException;
	public Student StudentLogin(String email, String password) throws StudentException;
	public String StudentUpdateName( int sid, String name,String password ) throws StudentException;
	public String StudentUpdateEmail( int sid, String email,String password ) throws StudentException;
	public String StudentUpdatePassword( int sid, String oldPassword,String newPassword ) throws StudentException;
	public String availableCoursesAndSeats() throws StudentException, CourseException;
}
