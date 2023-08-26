package com.wipro.factory;

import com.wipro.dao.EmployeeDao;
import com.wipro.dao.EmployeeDaoImpl;

public class EmployeeDaoFactory {
	private static EmployeeDao empDao;
	static {
		empDao= new EmployeeDaoImpl();
	}
	public static EmployeeDao getEmployeeDao() {
		return empDao;
	}
}
