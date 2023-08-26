package com.jdbc.application1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentValueUpdation {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		Scanner sc = null;
		
		try {
			int persIncrease=0;
			String newCity1="";
			String newCity2="";
			String newCity3="";
			int countRow=0;
			
			sc = new Scanner(System.in);
			if(sc!=null) {
				System.out.print("Enter the percentage of the avarage to increase : ");
				persIncrease = sc.nextInt();
				
				System.out.print("Enter 1st city name of students :");
				newCity1=sc.next().toUpperCase();
				
				System.out.print("Enter 2nd city name of students :");
				newCity2=sc.next().toUpperCase();
				
				System.out.print("Enter 3rd city name of students :");
				newCity3=sc.next().toUpperCase();
			}
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","Pass0508");
			
			if(con!=null) {
				st = con.createStatement();
			}
			//update studentdetails set savg=savg+10 where scity in('DEL','KOL','MUM');
			newCity1="'"+newCity1+"'";
			newCity2="'"+newCity2+"'";
			newCity3="'"+newCity3+"'";
			String query = "UPDATE STUDENTDETAILS SET SAVG = SAVG+((SAVG*"+persIncrease+")/100) where scity in("+newCity1+","+newCity2+","+newCity3+")";
			System.out.println(query);
			if(st!=null) {
				countRow = st.executeUpdate(query);
				if(countRow==0) {
					System.out.println("Table not updated successfully! No rows are affected.");
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
