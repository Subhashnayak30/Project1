package com.skype.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Logger;

import com.skype.dao.SkypeDAOInterface;
import com.skype.entity.SkypeUser;
import com.skype.utility.DAOFactory;

public class SkypeController implements SkypeControllerInterface 
{	
	private BufferedReader br;
	SkypeDAOInterface id;
	Logger log=Logger.getLogger("SkypeController");

	public SkypeController()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
		id=DAOFactory.myMethod();
	}
	
	public void createProfile()
	{
		try
		{
			System.out.println("Enter Name   :");
			String name=br.readLine();
			
			System.out.print("Enter Email    :");
			String email=br.readLine();
			
			System.out.print("Enter Adress   :");
			String address=br.readLine();
			
			System.out.print("Enter Password :");
			String password=br.readLine();
			
			SkypeUser su=new SkypeUser();
			
			su.setName(name);
			su.setEmail(email);
			su.setAddress(address);
			su.setPassword(password);
			
			//SkypeDAOInterface id=DAOFactory.myMethod(); look above every time we are call we can declare in constructor
			int i=id.createProfileDAO(su);
			
			if(i>0)
			{
				log.info("Profile Created.");
			}
			else
			{
				log.info("Profile Not Created.");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void loginProfile() 
	{
		try 
		{
			System.out.print("Enter name        : ");
			String name=br.readLine();
			
			SkypeUser su=new SkypeUser();
			su.setName(name);
			
			SkypeUser ss=id.viewProfile(su);
			if(ss!=null)
			{	
				System.out.print("\nYour profile details. \n");
				System.out.println("Name        : "+ss.getName());
				System.out.println("Email is    : "+ss.getEmail());
				System.out.println("Address is  : "+ss.getAddress());
				System.out.println("Password is : "+ss.getPassword());
			}
			else {
				log.info("Profile not found\n");
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	public void editProfile() 
	{
		try 
		{
			System.out.print("Enter name             : ");
			String name=br.readLine();
			
			SkypeUser su=new SkypeUser();
			su.setName(name);
			
			SkypeUser ss=id.viewProfile(su);
			if(ss!=null)
			{
				System.out.print("\nYour current profile details.\n ");
				System.out.println("Name      : "+ss.getName());
				System.out.println("Email     : "+ss.getEmail());
				System.out.println("Address   : "+ss.getAddress());
				System.out.println("Password  : "+ss.getPassword());
				
				System.out.print("\nEnter new email  : ");
				String nemail=br.readLine();
				System.out.print("Enter new address  : ");
				String naddress=br.readLine();
				System.out.print("Enter new password :");
				String npass=br.readLine();
				
				SkypeUser su1=new SkypeUser();
				su1.setName(name);
				su1.setEmail(nemail);
				su1.setAddress(naddress);
				su1.setPassword(npass);
				
				int i=id.editProfileDAO(su1);
				if(i>0) {
					log.info("\nProfile edited successfully");
				}
				else {
					log.info("\nCould not edit profile");
				}	
			}
			else
			{
				log.info("profile not found");
			}	
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}	
	}

	public void deleteProfile()
	{
		try 
		{
			System.out.println("Enter name");
			String name=br.readLine();
			System.out.println("Enter Password");
			String password=br.readLine();
			
			SkypeUser su=new SkypeUser();
			su.setName(name);
			su.setPassword(password);
		
			int i=id.deleteProfileDAO(su);
			if(i>0) 
			{
				log.info("Profile deleted successfully");
			}
			else 
			{
				log.info("Could not delete profile");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}

	public void viewAllProfile() 
	{
		try
		{				
			SkypeUser su=new SkypeUser();
			List<SkypeUser> sl=id.viewAllProfile(su);
			
			for(SkypeUser ww:sl)
			{
				System.out.println("******************************");
				System.out.println("Name     :"+ww.getName());
				System.out.println("Password : "+ww.getPassword());
				System.out.println("Email    : "+ww.getEmail());
				System.out.println("Address  : "+ww.getAddress());
				System.out.println("******************************\n");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}
