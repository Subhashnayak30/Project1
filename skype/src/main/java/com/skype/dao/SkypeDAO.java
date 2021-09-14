package com.skype.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.skype.entity.SkypeUser;

public class SkypeDAO implements SkypeDAOInterface 
{

	public int createProfileDAO(SkypeUser su) 
	{
		int i=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/skypedb","root","Subhashnayak@1999");
			
			PreparedStatement ps=con.prepareStatement("insert into skypeuser values(?,?,?,?)");
			
			ps.setString(1, su.getName());
			ps.setString(2, su.getEmail());
			ps.setString(3, su.getAddress());
			ps.setString(4, su.getPassword());
			
			i=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}

	public SkypeUser viewProfile(SkypeUser su)
	{
		SkypeUser su1=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/skypedb","root","Subhashnayak@1999");
			
			PreparedStatement ps=con.prepareStatement("select * from skypeuser where name=?");

			ps.setString(1, su.getName());
						
			ResultSet res=ps.executeQuery();
			if(res.next()) 
			{
				su1=new SkypeUser();
				su1.setName(res.getString(1));
				su1.setEmail(res.getString(2));
				su1.setAddress(res.getString(3));
				su1.setPassword(res.getString(4));
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return su1;
	}
	
	public int deleteProfileDAO(SkypeUser su) 
	{
		int i=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/skypedb","root","Subhashnayak@1999");
			
			PreparedStatement ps=con.prepareStatement("delete from skypeuser where name=? and password=?");
				
			ps.setString(1, su.getName());
			ps.setString(2, su.getPassword());
			
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public int editProfileDAO(SkypeUser su1) 
	{
		int i=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/skypedb","root","Subhashnayak@1999");
			
			PreparedStatement ps=con.prepareStatement("update skypeuser set password=?,email=?,address=? where name=?");
			
			ps.setString(1, su1.getPassword());
			ps.setString(2, su1.getEmail());
			ps.setString(3, su1.getAddress());
			ps.setString(4, su1.getName());
			
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public List<SkypeUser> viewAllProfile(SkypeUser su) 
	{
		List<SkypeUser> ll=new ArrayList<SkypeUser>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/skypedb","root","Subhashnayak@1999");
			
			PreparedStatement ps=con.prepareStatement("select * from skypeuser");
			
			ResultSet res=ps.executeQuery();
			while(res.next()) 
			{
				SkypeUser sl=new SkypeUser();
				sl.setName(res.getString(1));		
				sl.setEmail(res.getString(2));
				sl.setAddress(res.getString(3));
				sl.setPassword(res.getString(4));
				
				ll.add(sl);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ll;
	}

}
