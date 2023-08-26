package com.wipro.factory;

import com.wipro.service.EmployeeService;
import com.wipro.service.EmployeeServiceImpl;

public class EmployeeServiceFactory {
	private static EmployeeService empService;
	static {
		empService = new EmployeeServiceImpl();
	}
	public static EmployeeService getEmployeeService() {
		return empService;
	}
}
