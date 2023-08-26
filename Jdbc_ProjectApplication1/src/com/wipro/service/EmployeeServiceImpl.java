package com.wipro.service;

import com.wipro.bean.Employee;
import com.wipro.dao.EmployeeDao;
import com.wipro.factory.EmployeeDaoFactory;

public class EmployeeServiceImpl implements EmployeeService {

	public String addEmployee(Employee emp) {
		EmployeeDao empDao = EmployeeDaoFactory.getEmployeeDao();
		String status = empDao.add(emp);
		return status;
	}

	public Employee searchEmployee(int eno) {
		EmployeeDao empDao = EmployeeDaoFactory.getEmployeeDao();
		Employee emp= empDao.search(eno);
		return emp;
	}

	public String updateEmployee(Employee emp) {
		EmployeeDao empdaDao = EmployeeDaoFactory.getEmployeeDao();
		String status =empdaDao.update(emp);
		return status;
	}

	public String deleteEmployee(int eno) {
		EmployeeDao empDao = EmployeeDaoFactory.getEmployeeDao();
		String status = empDao.delete(eno);
		return status;
	}

}
