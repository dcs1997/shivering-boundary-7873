package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Exception.CourseException;
import com.Exception.StudentException;
import com.Model.Student;
import com.Utility.DButil;


public class StudentDAOImpl implements StudentDao {

	@Override
	public String registerStudent(Student student) throws StudentException {
		// TODO Auto-generated method stub
		
		String res="Not registered";
		
		try (Connection conn=DButil.getConnection()){
			
		PreparedStatement ps=	conn.prepareStatement("Insert into Student(sid,sName,sEmail,sPassword) values(?,?,?,?)");
			ps.setInt(1, student.getSid());
			ps.setString(2, student.getName());
			ps.setString(3, student.getEmail());
			ps.setString(4, student.getPassword());
			
			int x= ps.executeUpdate();
			if(x>0) {
				res= student.getName()+" is successfully registered as student";
				
				
			}
			else System.out.println("invalid details");
			
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new StudentException(e.getMessage());
		}
		
		
		return res;
	}

	@Override
	public Student StudentLogin(String email, String password) throws StudentException {
		// TODO Auto-generated method stub
		Student st=null;
		try(Connection conn=DButil.getConnection()){
			
			PreparedStatement ps=	conn.prepareStatement("Select * from Student where sEmail=? AND sPassword=?");
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				st= new Student();
				st.setSid(rs.getInt("sid"));
				st.setName(rs.getString("sname"));
				st.setEmail(rs.getString("semail"));
				st.setPassword(rs.getString("spassword"));
			
				
			}
			else throw new StudentException("Please enter a valid user");
 
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();	
			throw new StudentException(e.getMessage());
		}
		
		return st;
	}

	

	@Override
	public String StudentUpdateName(int sid, String name, String password) throws StudentException {
		// TODO Auto-generated method stub
		String response="Name is not updated";
		
		try(Connection conn=DButil.getConnection()) {
			
			PreparedStatement ps =	conn.prepareStatement("UPDATE Student SET sName=? where sid=? AND sPassword=?");
			ps.setString(1,name);
			ps.setInt(2, sid);
			ps.setString(3, password);
			
			int x=ps.executeUpdate();
			if(x>0) {
				response="Student name has been updated to "+name;
			}
			else throw new StudentException("Please enter a valid user");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();	
			throw new StudentException(e.getMessage());
		}
		
		return response;
	}

	@Override
	public String StudentUpdateEmail(int sid, String email, String password) throws StudentException {
     String response="Name is not updated";
		
		try(Connection conn=DButil.getConnection()) {
			
			PreparedStatement ps =	conn.prepareStatement("UPDATE Student SET sEmail=? where sid=? AND sPassword=?");
			ps.setString(1,email);
			ps.setInt(2, sid);
			ps.setString(3, password);
			
			int x=ps.executeUpdate();
			if(x>0) {
				response="Student email has been updated to "+email;
			}
			else throw new StudentException("Please enter a valid user");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();	
			throw new StudentException(e.getMessage());
		}
		
		return response;	
	}

	@Override
	public String StudentUpdatePassword(int sid, String oldPassword, String newPassword) throws StudentException{
		 String response="Password is not updated";
			
			try(Connection conn=DButil.getConnection()) {
				
				PreparedStatement ps =	conn.prepareStatement("UPDATE Student SET sPassword=? where sid=? AND sPassword=?");
				ps.setString(1,newPassword);
				ps.setInt(2, sid);
				ps.setString(3, oldPassword);
				
				int x=ps.executeUpdate();
				
				if(x>0) {
					response="Student password has been updated to "+newPassword;
				}
				else throw new StudentException("Please enter a valid user");
				
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();	
				throw new StudentException(e.getMessage());
			}
			
			return response;	
	}

	@Override
	public String availableCoursesAndSeats()
			throws StudentException, CourseException {
		// TODO Auto-generated method stub
		String response="Seats for all course are filled";
		
		try(Connection conn=DButil.getConnection()) {
			
			PreparedStatement ps =	conn.prepareStatement("select cName, cSeats from courses where cSeats > 0");
			
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			
			String cname = rs.getString("cName");
			
			int seats = rs.getInt("cSeats");
			
			System.out.println("Course Name: " + cname + " seats: " + seats);
			response="";
		}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();	
			throw new StudentException(e.getMessage());
		}
		return response;
	}

	
	
	

}
