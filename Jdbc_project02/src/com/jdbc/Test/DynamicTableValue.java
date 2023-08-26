package com.jdbc.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DynamicTableValue{
	public static void main(String[] args) {
		Scanner sc =null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String primaryKey = "";
		
		try {
			int colCount=0;
			sc = new Scanner(System.in);
			System.out.print("Enter the table name you want to create  : ");
			String tableName = sc.next();
			String query = "create table "+tableName+"(";
			while(true) {
				System.out.print("Enter your column Name :");
				String colName = sc.next();
				System.out.print("Enter your column Type with size:");
				String colType = sc.next();
				
				System.out.print("Enter your column Size :");
				int colSize = sc.nextInt();  
//				float colSize = sc.nextFloat();
				
				System.out.print("Is it a Primary key - [ YES | NO ]  ");
				String primaryKeyColumn = sc.next();
				if(primaryKeyColumn.equalsIgnoreCase("Yes")) {
					if(colCount==0) {
						primaryKey=primaryKey+colName;
						colCount++;
					}else{
						primaryKey=primaryKey+","+colName;
					}
				}
				
				query=query+colName+" "+colType+"("+colSize+"),";
				//create table employees(empno number(3),empname varchar2(10),empsal float(10),empaddr varchar(10),empmob number,primary key(empno,empmob));
				System.out.print("You want to add more column : [YES / NO ] ");
				String addMoreColumn =sc.next();
				if(addMoreColumn.equalsIgnoreCase("Yes")) {
					continue;
				}else{
					query=query+"primary key("+primaryKey+"))";
					System.out.println(query);
					break;
				}
			}
			//Establish the connection 
			//class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","Pass0508");
			if(con!=null) {
				st = con.createStatement();
			}
			
			if(st!=null) {
				rs=st.executeQuery(query);
				System.out.println("Table created Successfully!");
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}