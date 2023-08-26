package com.wipro.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.wipro.bean.Employee;
import com.wipro.factory.EmployeeServiceFactory;
import com.wipro.service.EmployeeService;

public class JdbcProjectApp1 {

	public static void main(String[] args) {
		BufferedReader br =null;
		Employee emp = null;
		
		int eno =0;
		String ename="";
		String edept="";
		float esal=0.0f;
		String eaddr ="";
		
		String status="";
		while(true) {
			System.out.println("1.Add Employee");
			System.out.println("2.Search Employee");
			System.out.println("3.Update Employee");
			System.out.println("4.Delete Employee");
			System.out.println("5.Exit");
			System.out.print("Enter your option -> [1,2,3,4,5] : ");
			
			int option;
			try {
				EmployeeService empService = new EmployeeServiceFactory().getEmployeeService();
				br = new BufferedReader(new InputStreamReader(System.in));
				option = Integer.parseInt(br.readLine());
				switch (option) {
				case 1:
					System.out.println();
					System.out.println("*******Employee ADD Module*******");
					System.out.println();
					System.out.print("Employee Number      : ");
					eno = Integer.parseInt(br.readLine());
					System.out.print("Employee Name        :");
					ename= br.readLine();
					System.out.print("Employee Department  :");
					edept= br.readLine();
					System.out.print("Employee Salary      :");
					esal =Float.parseFloat(br.readLine());
					System.out.print("Employee Address     :");
					eaddr= br.readLine();
					
					emp=new Employee();
					emp.setEno(eno);
					emp.setEname(ename);
					emp.setEdept(edept);
					emp.setEsal(esal);
					emp.setEaddr(eaddr);
					
					status =empService.addEmployee(emp);
					if(status.equalsIgnoreCase("Success")) {
						System.out.println("Status : Employee inserted successfully.");
					}else if(status.equalsIgnoreCase("Failure")) {
						System.out.println("Status : Employee insertion failure.");
					}else if(status.equalsIgnoreCase("Existed")) {
						System.out.println("Status : Employee already existed");
					}
					break;
				case 2:
					System.out.println();
					System.out.println("*******Employee SEARCH Module*******");
					System.out.println();
					System.out.print("Employee Number      : ");
					eno = Integer.parseInt(br.readLine());
					
					emp=empService.searchEmployee(eno);
					if(emp==null) {
						System.out.println("Status  : Employee not existed.");
						System.out.println();
					}else {
						System.out.println("Status  : Employee existed.");
						System.out.println();
						System.out.println("Employee number        :"+emp.getEno());
						System.out.println("Employee name          :"+emp.getEname());
						System.out.println("Employee department    :"+emp.getEdept());
						System.out.println("Employee salary        :"+emp.getEsal());
						System.out.println("Employee address       :"+emp.getEaddr());
						System.out.println();
					}
					break;
				case 3:
					System.out.println();
					System.out.println("*******Employee UPDATE Module*******");
					System.out.println();
					System.out.print("Employee Number      : ");
					eno = Integer.parseInt(br.readLine());
					emp = empService.searchEmployee(eno);
					if(emp==null) {
						System.out.println("Status : Employee not existed.");
					}else {
						Employee emp1 = new Employee();
						System.out.println("Which value you want to update -[1 - 4]");
						System.out.println();
						System.out.println("1.Employee No   2.Employee Name   3.Employee Dept   4.Employee Salary   5.Employee Address");
						System.out.print("Enter your value : ");
						int newOption = Integer.parseInt(br.readLine());
						switch (newOption) {
						case 1:
							System.out.print("Employee no : [Old-> "+emp.getEno()+"] New -> ");
							int val1 = Integer.parseInt(br.readLine());
							emp1.setEno(val1);
							emp1.setEname(emp.getEname());
							emp1.setEdept(emp.getEdept());
							emp1.setEsal(emp.getEsal());
							emp1.setEaddr(emp.getEaddr());
							break;
						case 2:
							System.out.print("Employee name : [Old-> "+emp.getEname()+"] New -> ");
							String val2 = br.readLine();
							emp1.setEname(val2);
							
							emp1.setEno(emp.getEno());
							emp1.setEdept(emp.getEdept());
							emp1.setEsal(emp.getEsal());
							emp1.setEaddr(emp.getEaddr());
							break;
						case 3:
							System.out.print("Employee dept : [Old-> "+emp.getEdept()+"] New -> ");
							String val3 = br.readLine();
							emp1.setEdept(val3);
							
							emp1.setEno(emp.getEno());
							emp1.setEname(emp.getEname());
							emp1.setEsal(emp.getEsal());
							emp1.setEaddr(emp.getEaddr());
							break;
						case 4:
							System.out.print("Employee salary : [Old-> "+emp.getEsal()+"] New -> ");
							float val4 =Float.parseFloat(br.readLine());
							emp1.setEsal(val4);
							
							emp1.setEdept(emp.getEdept());
							emp1.setEno(emp.getEno());
							emp1.setEname(emp.getEname());
							emp1.setEaddr(emp.getEaddr());
							break;
						case 5:
							System.out.print("Employee address : [Old-> "+emp.getEaddr()+"] New -> ");
							String val5 = br.readLine();
							emp1.setEaddr(val5);
							
							emp1.setEsal(emp.getEsal());
							emp1.setEdept(emp.getEdept());
							emp1.setEno(emp.getEno());
							emp1.setEname(emp.getEname());
							break;
						default:
							System.out.println("You have entered wrong choice!!!");
							break;
						}
						status=empService.updateEmployee(emp1);
						if(status.equalsIgnoreCase("Success")) {
							System.out.println("Status : Employee data updateded successfully.");
							System.out.println();
						}else if(status.equalsIgnoreCase("failure")){
							System.out.println("Status : Employee data updation failure.");
							System.out.println();
						}
					}
					break;
				case 4:
					System.out.println();
					System.out.println("*******Employee DELETE Module*******");
					System.out.println();
					System.out.print("Employee Number      : ");
					eno = Integer.parseInt(br.readLine());
					status = empService.deleteEmployee(eno);
					if(status.equalsIgnoreCase("Success")) {
						System.out.println("Status : Employee data deleted successfully.");
						System.out.println();
					}else if(status.equalsIgnoreCase("failure")){
						System.out.println("Status : Employee data deletion failure.");
						System.out.println();
					}else if(status.equalsIgnoreCase("not existed")) {
						System.out.println("Status : Employee not existed.");
						System.out.println();
					}
					break;
				case 5:
					System.out.println("===Thank you for using Employee application===");
					System.exit(0);
					break;
				default:
					System.out.println("Wrong choice, Please enter a valid option!!!");
					break;
				}			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
