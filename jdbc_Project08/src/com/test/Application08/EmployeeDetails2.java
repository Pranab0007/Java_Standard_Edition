/*
 * jdbc application to get any number of max or min sal value */
package com.test.Application08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDetails2 {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter how many no of highest salary you want to get : ");
			String maxSalNo = br.readLine();
			//Established the connection 
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System","Pass0508");
			//Create statement
			if(con!=null) {
				st = con.createStatement();
			}
			//Prepare the SQl query
			// SELECT * FROM (SELECT * FROM employeedetails ORDER BY empsal DESC) WHERE ROWNUM <= 2;
			String query = "SELECT * FROM (SELECT * FROM employeedetails ORDER BY empsal DESC) WHERE ROWNUM <="+maxSalNo;
			
			//Create resultset object
			String names = "";
			if(st!=null) {
				rs = st.executeQuery(query);
				System.out.println("Details of employee is : ");
				System.out.println();
				while(rs.next()) {
					System.out.println(rs.getInt("Empno")+"\t"+rs.getString("Empname")+"\t"+rs.getFloat("Empsal")+"\t"+rs.getString("empaddr"));
					names = names+rs.getString("empname")+",";
				}
				System.out.println();
				System.out.println(names+"this "+maxSalNo+" persons has the highest salary");
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