package com.skype.dao;

import java.util.List;

import com.skype.entity.SkypeUser;

public interface SkypeDAOInterface 
{

	int createProfileDAO(SkypeUser su);

	SkypeUser viewProfile(SkypeUser su);

	int editProfileDAO(SkypeUser su1);

	int deleteProfileDAO(SkypeUser su);

	List<SkypeUser> viewAllProfile(SkypeUser su);

	

}
