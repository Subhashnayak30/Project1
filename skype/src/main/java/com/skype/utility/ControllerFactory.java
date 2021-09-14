package com.skype.utility;

import com.skype.controller.SkypeController;
import com.skype.controller.SkypeControllerInterface;

public class ControllerFactory
{

	public static SkypeControllerInterface crateObject() {
		// TODO Auto-generated method stub
		return new SkypeController();
	}

}
