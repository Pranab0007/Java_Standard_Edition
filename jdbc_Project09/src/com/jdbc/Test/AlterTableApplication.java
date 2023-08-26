package com.jdbc.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AlterTableApplication {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		Scanner sc =  null;
		String query = "";
		String tableName = null;
		String columnName = null;
		String columnSize = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Welcome to Alter Table Application - (choose any one below)");
			System.out.println("1.Adding a column\n2.Removing a column\n3.Changing a column data type\n4.Renaming a Table\n5.Renaming a column");
			System.out.println();
			int OptionInput = sc.nextInt();
			switch (OptionInput) {
			case 1:
				//ALTER TABLE example ADD phone_number VARCHAR(10);
				System.out.print("Enter your table name : ");
				tableName = sc.next();
				System.out.println();
				System.out.print("Enter column name which you want to add:");
				columnName = sc.next();
				System.out.print("Enter column type with size:");
				columnSize = sc.next();
				query = query+"ALTER TABLE "+tableName+" ADD "+columnName+" "+columnSize;
				System.out.println(query);
				break;
			case 2:
				//ALTER TABLE example DROP COLUMN phone_number;
				System.out.print("Enter your table name : ");
				tableName = sc.next();
				System.out.println();
				System.out.print("Enter column name which you want to remove:");
				columnName = sc.next();
				query = query+"ALTER TABLE "+tableName+" DROP COLUMN "+columnName;
				System.out.println(query);
				break;
			case 3:
				//ALTER TABLE example MODIFY col1 number(10);
				System.out.print("Enter your table name : ");
				tableName = sc.next();
				System.out.println();
				System.out.print("Enter column name for Column type modification:");
				columnName = sc.next();
				System.out.print("Enter new column type with size:");
				columnSize = sc.next();
				query = query+"ALTER TABLE "+tableName+" MODIFY "+columnName+" "+columnSize;
				System.out.println(query);
				break;
			case 4:
				//ALTER TABLE example RENAME TO Employees;
				System.out.print("Enter your table name : ");
				tableName = sc.next();
				System.out.println();
				System.out.print("Enter New Table name:");
				String newTableName = sc.next();
				query = query+"ALTER TABLE "+tableName+" RENAME TO "+newTableName;
				System.out.println(query);
				break;
			case 5:
				//ALTER TABLE employees RENAME COLUMN col1 TO NewColumn;
				System.out.print("Enter your table name : ");
				tableName = sc.next();
				System.out.println();
				System.out.print("Enter Old Column name:");
				String oldColumnName = sc.next();
				System.out.println();
				System.out.print("Enter New Column name:");
				String newColumnName = sc.next();
				query = query+"ALTER TABLE "+tableName+" RENAME COLUMN "+oldColumnName+" TO "+newColumnName;
				System.out.println(query);
				break;
			default:
				System.out.println("You have chosen wrong option!!");
				System.exit(0);
			}
			//Established the connection 
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System","Pass0508");
			//Create statement
			if(con!=null) {
				st = con.createStatement();
			}
			//Process the query to the database
			int count=0;
			//Count the values of effected rows
			if(st!=null) {
				count = st.executeUpdate(query);
				count++;
			}
			if(count!=0) {
				System.out.println("Table altered successfully");
			}else {
				System.out.println("Altering table failed");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch(Exception e) {
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
