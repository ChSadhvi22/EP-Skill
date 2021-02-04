package com.klu.crud;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.Scanner;
import com.klu.bean.StudentBean;
import com.klu.Connections.DBUtil;

public class StudentCRUD {
	static Scanner s=new Scanner(System.in);
	public int StudentInsert(StudentBean student) throws ClassNotFoundException, SQLException
	{
		Connection con=DBUtil.DBConnection();
		PreparedStatement St=con.prepareStatement("Insert into Student values(?,?,?)");
		St.setInt(1,student.getRegno());
		St.setString(2,student.getName());
		St.setString(3, student.getEmail());
		int i=St.executeUpdate();
		con.close();
		return i;
		
	}
	public int Sdelete() throws ClassNotFoundException, SQLException
	{
	  System.out.println("Enter the RegNo: ");
	  int reno=s.nextInt();
	  Connection con=DBUtil.DBConnection();
	  PreparedStatement delete=con.prepareStatement(" Delete from Student where regno=?");  
	  delete.setInt(1,reno);  
	  int k=delete.executeUpdate();    
	  con.close();  
	  return k;
	}
	public int Supdate() throws ClassNotFoundException, SQLException
	{
	  System.out.println("Enter the Column Name and RegNo ");
	  String col=s.next();
	  int reno=s.nextInt();
	  Connection con=DBUtil.DBConnection();
	  PreparedStatement update=con.prepareStatement("Update Student set name=? where regno=?");  
	  update.setString(1,col);
	  update.setInt(2,reno); 
	  int k=update.executeUpdate();    
	  con.close();  
	  return k;
	}

	public void Sdisplay() throws ClassNotFoundException, SQLException
	{
	  System.out.println("STUDENTS LIST ");
	  Connection con=DBUtil.DBConnection();
	  PreparedStatement display=con.prepareStatement("Select * from Student");  
	  ResultSet rs=display.executeQuery();    
	  while(rs.next()){  
	  System.out.println("Regno:- "+rs.getInt(1)+"----"+"Name:- "+rs.getString(2)+"----"+"Email:- "+rs.getString(3));  
	  }  
	  
	  con.close();  
	}

	}


