package com.jdbc.application01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DynamicInsertionMovies {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		Scanner sc = null;
		String query = null;
		try {
			sc=new Scanner(System.in);
			int movieNo = 0;
			String movieName ="";
			String movieBudget ="";
			float movieRating=0.0f;
			while(true) {
				if(sc!=null) {
					System.out.print("Enter the movie no you want to add : ");
					movieNo=sc.nextInt();
					
					System.out.print("Enter the movie name you want to add : ");
					movieName=sc.next();
					
					System.out.print("Enter the movie Budget you want to add : ");
					movieBudget=sc.next();
					
					System.out.print("Enter the movie rating you want to add : ");
					movieRating=sc.nextFloat();
					System.out.println();
				}
			
				movieName="'"+movieName+"'";
				movieBudget="'"+movieBudget+"'";
//				insert into moviestore values(1,'Dangal','120cr',7.3);
				
				query = "insert into moviestore values("+movieNo+","+movieName+","+movieBudget+","+movieRating+")";
				System.out.println(query);
				
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","Pass0508");
				if(con!=null) {
					st=con.createStatement();
				}
				int rowCount = 0;
				if(st!=null) {	
					rowCount=st.executeUpdate(query);
					System.out.println(movieName+" Movie Inserted Successfully into MovieStore.");
					++rowCount;
					System.out.println();
				}

				System.out.print("You want to add more values : [Yes / No ] :");
				String moreValues = sc.next();
				System.out.println();
				if(moreValues.equalsIgnoreCase("Yes")) {
					continue;
				}else {
					System.out.println("Total rows are affected : "+rowCount);
					System.out.println("Thank you for using the application!");
					break;
				}
			}
		} catch (SQLException se) {
			if(se.getErrorCode()>900 && se.getErrorCode()<999) {
				System.out.println("Invalid column, table name or sql keyword");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(st!=null){
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
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
