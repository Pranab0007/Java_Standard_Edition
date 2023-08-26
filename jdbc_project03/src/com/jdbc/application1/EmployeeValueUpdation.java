package com.jdbc.application1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class EmployeeValueUpdation {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		Scanner sc = null;
		
		try {
			int persIncrease=0;
			int minSal = 0;
			int maxSal = 0;
			int countRow=0;
			
			sc = new Scanner(System.in);
			if(sc!=null) {
				System.out.print("Enter the percentage of the salary to increase : ");
				persIncrease = sc.nextInt();
				
				System.out.print("Enter the minimun range : ");
				minSal = sc.nextInt();
				
				System.out.print("Enter the maximum range : ");
				maxSal = sc.nextInt();
			}
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","Pass0508");
			
			if(con!=null) {
				st = con.createStatement();
			}
			String query = "UPDATE EMPLOYEEDETAILS SET EMPSAL = EMPSAL+((EMPSAL*"+persIncrease+")/100) WHERE EMPSAL>"+minSal+" AND EMPSAL<"+maxSal+"";
	   	    //update employeedetails set empsal=empsal+500 where empsal>7000 and empsal<20000;
			System.out.println(query);
			if(st!=null) {
				countRow = st.executeUpdate(query);
				if(countRow==0) {
					System.out.println("Table not updated! No rows are affected.");
				}else {
					System.out.println("Table successfully updated, Rows are affected : "+countRow);
				}
			}			
		} catch (SQLException se) {
			if(se.getErrorCode()>=900 && se.getErrorCode()<=999) {
				System.out.println("Invalid colname or table name or SQL keyword");
			}else if(se.getErrorCode()==12899) {
				System.out.println("Do not insert values more than column size.");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
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
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(sc!=null) {
					sc.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
