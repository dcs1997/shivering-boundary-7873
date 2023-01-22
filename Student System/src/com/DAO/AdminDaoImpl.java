package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Exception.AdminException;
import com.Exception.StudentException;
import com.Model.Admin;
import com.Model.Course;
import com.Utility.DButil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public String registersAdmin(Admin admin) throws AdminException {
		// TODO Auto-generated method stub
		
				String res="Not registered";
				
				try (Connection conn=DButil.getConnection()){
					
				PreparedStatement ps=	conn.prepareStatement("Insert into Admin(aid,aName,aEmail,aPassword) values(?,?,?,?)");
					ps.setInt(1, admin.getaId());
					ps.setString(2, admin.getaName());
					ps.setString(3, admin.getaEmail());
					ps.setString(4, admin.getaPassword());
					
					int x= ps.executeUpdate();
					if(x>0) {
						res= admin.getaName()+" is successfully registered as Admin";
						
						
					}
					else System.out.println("invalid details");
					
					
					
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
					throw new AdminException(e.getMessage());
				}
				
				
				return res;
	}

	@Override
	public Admin AdminLogin(String email, String password) throws AdminException {
		// TODO Auto-generated method stub
				Admin ad=null;
				try(Connection conn=DButil.getConnection()){
					
					PreparedStatement ps=	conn.prepareStatement("Select * from Admin where aEmail=? AND aPassword=?");
					ps.setString(1, email);
					ps.setString(2, password);
					
					ResultSet rs= ps.executeQuery();
					
					if(rs.next()) {
						ad= new Admin();
						ad.setaId(rs.getInt("aId"));
						ad.setaName(rs.getString("aname"));
						ad.setaEmail(rs.getString("aemail"));
						ad.setaPassword(rs.getString("apassword"));
					
						
					}
					else throw new AdminException("Please enter a valid user");
		 
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();	
					throw new AdminException(e.getMessage());
				}
				
				return ad;
				}

	@Override
	public String newCourse(int cid, String cName, int cFee, int cSeats) throws AdminException {
		// TODO Auto-generated method stub
		String response="new course details a re not added";
		
		try(Connection conn=DButil.getConnection()) {
			
			PreparedStatement ps=	conn.prepareStatement("INSERT into courses (cid, cName, cFee, cSeats) Values(?,?,?,?)");
			
			ps.setInt(1, cid);
			ps.setString(2, cName);
			ps.setInt(3, cFee);
			ps.setInt(4, cSeats);
			
			int x= ps.executeUpdate();
			if(x>0) {
				response= " data updated successfully. ";
				
				
			}
			else System.out.println("data is not updated");
			
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new AdminException("data is not updated");

		}
		
		
		return response;
	}

	@Override
	public String updateCourseFee(int cid, String name, int cFee) throws AdminException {
		 String response="Name is not updated";
			
			try(Connection conn=DButil.getConnection()) {
				
				PreparedStatement ps =	conn.prepareStatement("UPDATE courses SET cFee=? where cid=?");
			
				ps.setInt(1, cFee);
				ps.setInt(2, cid);
				
				int x=ps.executeUpdate();
				if(x>0) {
					response="fee has been updated to "+name;
				}
				else throw new AdminException("Fee is not updated");
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();	
				throw new AdminException(e.getMessage());
			}
			
			return response;
	}

	@Override
	public String DeleteCourse(int cid) throws AdminException {
		// TODO Auto-generated method stub
		 String response="Name is not updated";
		 
		 try(Connection conn=DButil.getConnection()) {
			 
			PreparedStatement ps =	conn.prepareStatement("DELETE FROM Courses where cid=?");

			ps.setInt(1, cid);
			
			int x=ps.executeUpdate();
			if(x>0) {
				response="row Deleted successfully ";
			}
			else throw new AdminException("Fee is not updated");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();	
			throw new AdminException(e.getMessage());
		}
		 
		return response;
	}

	@Override
	public List<Course> showTables() {
		// TODO Auto-generated method stub
		
		List<Course> list= new ArrayList<>();
		
		try (Connection conn=DButil.getConnection()){
			
			PreparedStatement ps =	conn.prepareStatement("Select * from Courses");
			
			ResultSet rs=ps.executeQuery();
			
//			if(list.isEmpty()) System.out.println("No data found!!");
//			else {
//				list.forEach(System.out::println);
//			}	
			
			while(rs.next()) {
				int id= rs.getInt("cid");
				String name=rs.getString("cName");
				int fee=rs.getInt("cFee");
				int seats=rs.getInt("cSeats");
				
				Course cs=new Course(id, name, fee, seats);
				
				list.add(cs);
				
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
		return list;
	}

	

	

	
	
	

}
