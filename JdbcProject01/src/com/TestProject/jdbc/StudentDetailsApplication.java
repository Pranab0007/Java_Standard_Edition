package com.TestProject.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDetailsApplication {
	public static void main(String[] args) {
		Scanner sc = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String city1=null,city2=null,city3=null;
		
		try {
			sc = new Scanner(System.in);
			if(sc!=null) { //for taking input of three different city names
				System.out.print("Enter your city name #City1: ");
				city1=sc.next().toUpperCase();
				System.out.print("Enter your city name #City2: ");
				city2=sc.next().toUpperCase();
				System.out.print("Enter your city name #City3: ");
				city3=sc.next().toUpperCase();
			}
			//convert into SQL query type value for increasing code readability
			city1= "'"+city1+"'";
			city2= "'"+city2+"'";
			city3= "'"+city3+"'";
			 //Establish connection with 
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","Pass0508");
			System.out.println("Connection interface implemented class : "+con.getClass().getName());
			if(con!=null) { //create statement object
				st = con.createStatement();
				System.out.println("Statement interface implemented class : "+st.getClass().getName());
			}
			
			//prepare the SQL query and print the query once
			//SELECT SROLL,SNAME,SDEPT,SCITY,SAGE FROM STUDENTDETAILS WHERE SCITY IN('MUM','PUNE','KOL') ORDER BY SCITY;
			String query = "SELECT SROLL,SNAME,SDEPT,SCITY,SAGE FROM STUDENTDETAILS WHERE SCITY IN("+city1+","+city2+","+city3+") ORDER BY SCITY";     
			System.out.println(query);
			
			if(st!=null) { //passing the select query as a argument
				rs = st.executeQuery(query);
				System.out.println("ResultSet interface implemented class : "+rs.getClass().getName());
			}
			
			if(rs!=null) { // printing the output
				System.out.println("Your query result is given below : ");
				System.out.println();
				System.out.println("Rollno \t\tStudent Name\t\tStudent Dept \t Student City \tStudent Avg");
				while(rs.next()!=false) {
					System.out.println(rs.getInt("SROLL")+"\t\t"+rs.getString("SNAME")+"\t\t"+rs.getString("SDEPT")+"\t\t  "+rs.getString("SCITY")+"\t\t   "+rs.getInt("SAVG"));
				}
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
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
			}catch(Exception se) {
				se.printStackTrace();
			}
			if(sc!=null) {
				sc.close();
			}
		}
	}
}
