package com.skype.utility;

import com.skype.dao.SkypeDAO;
import com.skype.dao.SkypeDAOInterface;

public class DAOFactory {

	public static SkypeDAOInterface myMethod() {
		// TODO Auto-generated method stub
		return new SkypeDAO();
	}

}
