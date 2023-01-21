package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	

}
