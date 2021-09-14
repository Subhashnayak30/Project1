package com.skype.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.skype.controller.SkypeControllerInterface;
import com.skype.utility.ControllerFactory;

public class SkypeView {

	public static void main(String[] args) 
	{	
		String s="y";
		while(s.equals("y"))
		{
			System.out.println("*******SKYPE MENU*******");
			System.out.println("1. Create Profile.");
			System.out.println("2. Login/View Profile .");
			System.out.println("3. Edit Profile.");
			System.out.println("4. Delete Profile.");
			System.out.println("5. View All Profils.");
	
			try
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Enter your choice : ");
				int c=Integer.parseInt(br.readLine());
			
				SkypeControllerInterface sc=ControllerFactory.crateObject();
			
				switch(c)
				{
					case 1 : sc.createProfile();
							 break;
							
					case 2 : sc.loginProfile();
							 break;
					
					case 3 : sc.editProfile();
					 		 break;
					 		 
					case 4 : sc.deleteProfile();
							 break;
							 
					case 5 : sc.viewAllProfile();
					 		 break;
					 				
					default: System.out.println("\nYou entered wrong choice.");
				}
				System.out.println("\nDo you want to continue press y/n");
				s=br.readLine();

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
