package com.test.Application08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDetails {
	public static void main(String[] args) {
		Connection con = null;
		Statement st= null;
		ResultSet rs = null;
		String query = null;
		try {
			//Establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","Pass0508");
			//Create the statement object
			if(con!=null) {
				st = con.createStatement();
			}
//			 SELECT * FROM emp WHERE sal = (SELECT MIN(sal) FROM emp);
			
			//Create query to execute
			query =  "SELECT * FROM EMP WHERE SAL = (SELECT MIN(SAL) FROM EMP)";
			System.out.println("Query is :"+query);
			//Create resultset object
			
			if(st!=null) {
				rs = st.executeQuery(query);
			}
			String empNames="";
			while(rs.next()) {
				empNames = empNames+rs.getString("ename");
				System.out.println(empNames+" is having lowest salary");
//				System.out.println("Here the details is : "+rs.getInt("empno")+"\t"+rs.getString("ename")+"\t"+rs.getString("job")+"\t"+rs.getFloat("sal"));
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getFloat(4));
			}	
		} catch (SQLException se) {
			se.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(st!=null) {
					st.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
