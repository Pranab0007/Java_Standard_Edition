package com.jdbc.jdbc_Project07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeletOperation {
	public static void main(String[] args) {
		Scanner sc= null;
		Connection con=null;
		Statement st = null;
		String sno="";
		try {
			sc=new Scanner(System.in);
			System.out.println("Enter the student roll number to delete");
			sno=sc.next();
			while(true) {
				System.out.println("You want to add more for delete? [Yes / No]");
				String askForAgain = sc.next();
				if(askForAgain.equalsIgnoreCase("Yes")) {
					System.out.println("Enter student roll number");
					String againSno = sc.next();
					sno=sno+","+againSno;
				}else if(askForAgain.equalsIgnoreCase("No")) {
					break;
				}
			}
//			Establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","Pass0508");
			
//			delete from studentdetails where sroll in(30,40)
			String query = "DELETE FROM STUDENTDETAILS WHERE SROLL IN("+sno+")";
			System.out.println(query);
//			Create statement
			if(con!=null) {
				st=con.createStatement();
			}
//			Process the query to the database
			int count=0;
//			Count the values of effected rows
			if(st!=null) {
				count = st.executeUpdate(query);
			}
			if(count!=0) {
				System.out.println("No of rows got effected : "+count);
			}else {
				System.out.println("No rows got effected");
			}
		}catch (SQLException se) {
			if(se.getErrorCode()>=900 && se.getErrorCode()<999) {
				System.out.println("Invalid column or table name,and sql keyword");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
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
