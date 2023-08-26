package com.TestProject.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeDetails {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs =null;
		Scanner sc= null;
		String empDept1=null,empDept2=null,empDept3=null;
		try {
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.print("Enter employee department #1 :: ");
				empDept1=sc.nextLine().toUpperCase();
				System.out.print("Enter employee department #2 :: ");
				empDept2=sc.nextLine().toUpperCase();
				System.out.print("Enter employee department #3 :: ");
				empDept3=sc.nextLine().toUpperCase();
				System.out.println();
			}
			
			empDept1="'"+empDept1+"'";
			empDept2="'"+empDept2+"'";
			empDept3="'"+empDept3+"'";
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","Pass0508");
			System.out.println("Connection interface implemented class : "+con.getClass().getName());
			if(con!=null) {
				st = con.createStatement();
				System.out.println("Statement interface implemented class : "+st.getClass().getName());
			}
			//SELECT EMPNO,EMPNAME,EMPDEPT,EMPSAL,EMPADDR FROM EMPLOYEEDETAILS WHERE EMPDEPT IN('SECURITY','SOCIAL MEDIA MANAGER','ADVERTISE MANAGER');
			String query = "SELECT EMPNO,EMPNAME,EMPDEPT,EMPSAL,EMPADDR FROM EMPLOYEEDETAILS WHERE EMPDEPT IN("+empDept1+","+empDept2+","+empDept3+") ORDER BY EMPDEPT";
			
			
			if(st!=null) {
				rs=st.executeQuery(query);
				System.out.println("ResultSet interface implemented class : "+rs.getClass().getName());
			}
			
			if(rs!=null) {
				System.out.println();
				System.out.println("Your query result is given below : ");
				System.out.println();
				while(rs.next()) {
					System.out.println(rs.getInt("EMPNO")+"\t"+rs.getString("EMPNAME")+"\t"+rs.getString("EMPDEPT")+"\t "+rs.getFloat("EMPSAL")+"\t  "+rs.getString("EMPADDR"));
				}
				
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
			}catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(st!=null) {
					st.close();
				}
			}catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null) {
					con.close();
				}
			}catch(SQLException se) {
				se.printStackTrace();
			}
			if(sc!=null) {
				sc.close();
			}
		}
	}
}
