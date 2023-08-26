package com.test.jdbc_project10;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HtmlApplication1 {

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
//			System.out.print("Enter a .html file name : ");
//			String FileName =sc.next();
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","Pass0508");
			if(con!=null) {
				st = con.createStatement();
			}
			//select sroll,sname,sdept,scity,savg from studentdetails;
			String query = "select * from "+tableName;
			
			
			if(st!=null) {
				rs=st.executeQuery(query);
			}
			String data = "";
			if(rs!=null) {
				data = data+"<html>\r\n"
						+ "<head>\r\n"
						+ "   <style>\r\n"
						+ "        *{\r\n"
						+ "    margin: 0;\r\n"
						+ "    padding: 0;\r\n"
						+ "    font-family: sans-serif;\r\n"
						+ "}\r\n"
						+ ".table-box{\r\n"
						+ "    margin: 50px auto;\r\n"
						+ "}\r\n"
						+ "h2{\r\n"
						+ "    text-align: center;\r\n"
						+ "    margin-top: 50px;\r\n"
						+ "    color: navy;\r\n"
						+ "    font-size: 30px;\r\n"
						+ "}\r\n"
						+ ".table-row{\r\n"
						+ "    display: table;\r\n"
						+ "    width: 80%;\r\n"
						+ "    margin: 10px auto;\r\n"
						+ "    padding: 12px;\r\n"
						+ "    background: transparent;\r\n"
						+ "    color: navy;\r\n"
						+ "    font-size: 15px;\r\n"
						+ "    box-shadow: 0 1px 4px 0 rgba(0, 0 , 50, 0.3);\r\n"
						+ "}\r\n"
						+ ".table-cell{\r\n"
						+ "    display: table-cell;\r\n"
						+ "    width: 10%;\r\n"
						+ "    text-align: center;\r\n"
						+ "    padding: 4px 0;\r\n"
						+ "    border-right: 1.5px solid black;\r\n"
						+ "}\r\n"
						+ ".last-table-cell{\r\n"
						+ "    display: table-cell;\r\n"
						+ "    width: 10%;\r\n"
						+ "    text-align: center;\r\n"
						+ "    padding: 4px 0;\r\n"
						+ "    /* border-right: 1.5px solid black; */\r\n"
						+ "}\r\n"
						+ ".table-head{\r\n"
						+ "    background: rgb(139, 53, 252);\r\n"
						+ "    color: azure;\r\n"
						+ "    font-weight: 600;\r\n"
						+ "    font-size: 17px;\r\n"
						+ "}\r\n"
						+ ".table-head .table-cell{\r\n"
						+ "    border-right: none ;\r\n"
						+ "}\r\n"
						+ ".done{\r\n"
						+ "    padding-inline: 12px;\r\n"
						+ "    padding-block: 5px;\r\n"
						+ "    border-radius: 15px;\r\n"
						+ "    background: rgba(144, 238, 144, 0.822);\r\n"
						+ "}\r\n"
						+ ".not-done{\r\n"
						+ "    padding-inline: 20px;\r\n"
						+ "    padding-block: 5px;\r\n"
						+ "    border-radius: 15px;\r\n"
						+ "    background: rgba(240, 128, 128, 0.781);\r\n"
						+ "    font-weight: 600;\r\n"
						+ "}\r\n"
						+ ".table-row:hover{\r\n"
						+ "    background: lightskyblue;\r\n"
						+ "    transition: 0.6s;\r\n"
						+ "}\r\n"
						+ ".table-head:hover{\r\n"
						+ "    background: rgb(139, 53, 252);\r\n"
						+ "}\r\n"
						+ "    </style>\r\n"
						+ "</head>\r\n"
						+ "\r\n"
						+ "<body>\r\n"
						+ "    <h2>Student payment details of 2023</h2>\r\n"
						+ "    <div class=\"table-box\">\r\n"
						+ "        <div class=\"table-row table-head\">\r\n"
						+ "            <div class=\"table-cell\">\r\n"
						+ "                <p>Roll no.</p>\r\n"
						+ "            </div>\r\n"
						+ "            <div class=\"table-cell\">\r\n"
						+ "                <p>First Name</p>\r\n"
						+ "            </div>\r\n"
						+ "            <div class=\"table-cell\">\r\n"
						+ "                <p>Last Name</p>\r\n"
						+ "            </div>\r\n"
						+ "            <div class=\"table-cell\">\r\n"
						+ "                <p>Discipline</p>\r\n"
						+ "            </div>\r\n"
						+ "            <div class=\"table-cell\">\r\n"
						+ "                <p>Year</p>\r\n"
						+ "            </div>\r\n"
						+ "            <div class=\"table-cell\">\r\n"
						+ "                <p>Date of Birth</p>\r\n"
						+ "            </div>\r\n"
						+ "            <div class=\"last-table-cell\">\r\n"
						+ "                <p>Payment Status</p>\r\n"
						+ "            </div>\r\n"
						+ "        </div>";
				
				while(rs.next()) {
					data = data+"<div class=\"table-row\">\r\n"
							+ "            <div class=\"table-cell\">";
					data = data+"<p>"+rs.getInt(1)+"</p> </div>";
					
					data = data+" <div class=\"table-cell\">";
					data = data+"<p>"+rs.getString(2)+"</p> </div>";
					
					data = data+" <div class=\"table-cell\">";
					data = data+"<p>"+rs.getString(3)+"</p> </div>";
					
					data = data+" <div class=\"table-cell\">";
					data = data+"<p>"+rs.getString(4)+"</p> </div>";
					
					data = data+" <div class=\"table-cell\">";
					data = data+"<p>"+rs.getInt(5)+"</p> </div>";
					
					data = data+" <div class=\"table-cell\">";
					data = data+"<p>"+rs.getString(6)+"</p> </div>";
					
					data = data+" <div class=\"last-table-cell\">";
					data = data+"<p>"+rs.getString(7)+"</p> </div>";
					
					data = data+"</div>";
				}
				data = data+"</div>\r\n"
						+ "</body>\r\n"
						+ "\r\n"
						+ "</html>";
				
				fos = new FileOutputStream("C:/Pranab Files/JAVA/Advance java Workspace/TextFiles/index.html");
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
