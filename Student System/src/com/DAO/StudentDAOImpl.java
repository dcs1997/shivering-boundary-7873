package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new StudentException(e.getMessage());
		}
		
		
		return res;
	}

}
