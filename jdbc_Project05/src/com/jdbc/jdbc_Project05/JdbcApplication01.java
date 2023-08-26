package com.jdbc.jdbc_Project05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcApplication01 {

	public static void main(String[] args) {
		Connection con =null;
		Statement st = null;
		ResultSet rs = null;
		Scanner sc = null;
		
		try {
			String tableName =null;
			String colName = null;
			String colFirstChar = null;
			String query = null;
			int colNumberPosition =0;
			sc = new Scanner(System.in);
			while(true) {
				if(sc!=null) {
					System.out.println("Enter the table name : ");
					tableName= sc.next();
					
					System.out.print("Enter the column name : ");
					colName = sc.next();
					
					System.out.print(colName+" is which no column of your table "+tableName+" :  ");
					colNumberPosition=sc.nextInt();
					
					System.out.print("Enter the first character of "+colName+" values you want to check : ");
					colFirstChar = sc.next().toUpperCase();
					System.out.println();
				}
//				colFirstChar = "'"+colFirstChar;
				query = "SELECT * FROM "+tableName+" WHERE "+colName+" LIKE '"+colFirstChar+"%'";
				System.out.println("Your query is : "+query);
				System.out.println();
//				select * from employeedetails where empname like 'R%';
				
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Pass0508");
				System.out.println("Connection interface implemented class"+con.getClass().getName());
				if(con!=null) {
					st = con.createStatement();
					System.out.println("Statement interface implemented class"+st.getClass().getName());
				}
				if(st!=null) {
					rs= st.executeQuery(query);
					System.out.println("Resultset interface implemented class"+con.getClass().getName());
					System.out.println();
				}
				if(rs!=null) {
					System.out.println("Your query is here with first character "+colFirstChar+" : ");
					System.out.println();
					int rotationCount=0;
					while(rs.next()!=false) {
						System.out.println(rs.getString(colNumberPosition));
						rotationCount++;
					}
					if(rotationCount==0){
						System.out.println("Sorry! there is no values with character "+colFirstChar);
						System.out.println();
					}
				}
				System.out.print("You want to do this again - [Yes || No ]  : ");
				String askForAgain = sc.next();
				if(askForAgain.equalsIgnoreCase("Yes")) {
					continue;
				}else {
					System.out.println("Thank you for using this application!!");
					break;
				}
			}
		}catch(SQLException se) {
			if(se.getErrorCode()>=900 && se.getErrorCode()<999) {
				System.out.println("Invalid column or table name,and sql keyword");
			}
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
			try {
				if(sc!=null) {
					sc.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
