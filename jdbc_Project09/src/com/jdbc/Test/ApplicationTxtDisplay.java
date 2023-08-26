package com.jdbc.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ApplicationTxtDisplay {

	public static void main(String[] args) {
		Scanner sc =null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		FileOutputStream fos = null;
		try {
			sc = new Scanner(System.in);
			System.out.print("Enter the table name: ");
			String tableName = sc.next();
			System.out.print("Enter a .txt file name : ");
			String FileName =sc.next();
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","Pass0508");
			if(con!=null) {
				st = con.createStatement();
			}
			//select sroll,sname,sdept,scity,savg from studentdetails;
			String query = "select sroll,sname,sdept,scity,savg from "+tableName;
			
			
			if(st!=null) {
				rs=st.executeQuery(query);
			}
			String data = "";
			if(rs!=null) {
				data = "\t\t\t============ "+tableName+" values are given below=============\n";
				
				while(rs.next()) {
					data = data+rs.getInt(1)+" , ";
					data = data+rs.getString(2)+" , ";
					data = data+rs.getString(3)+" , ";
					data = data+rs.getString(4)+" , ";
					data = data+rs.getString(5)+"\n";
				}
				
				fos = new FileOutputStream("C:/Pranab Files/JAVA/Advance java Workspace/TextFiles/"+FileName+".txt");
				byte[] b = data.getBytes();
				fos.write(b);
				System.out.println(tableName+" table data transferred successfully.");
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
				if(fos!=null) {
					fos.close();
				}
			} catch (IOException ie) {
				ie.printStackTrace();
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
