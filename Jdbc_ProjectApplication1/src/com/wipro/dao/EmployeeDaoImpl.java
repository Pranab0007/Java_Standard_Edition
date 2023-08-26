package com.wipro.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.wipro.bean.Employee;
import com.wipro.factory.ConnectionFactory;

public class EmployeeDaoImpl implements EmployeeDao {
	
	public String add(Employee emp) {
		Connection con=null;
		Statement st = null;
		ResultSet rs = null;
		String status ="";
		
		try {
			con = ConnectionFactory.getConnection();
			if(con!=null) {
				st = con.createStatement();
			}
			if(st!=null) {
				rs = st.executeQuery("SELECT * FROM EMPLOYEEDETAILS WHERE EMPNO="+emp.getEno());
			}
			boolean b= rs.next();
			if(b==true) {
				status = "Existed";
			}else {
				int updateCount =st.executeUpdate("insert into employeedetails values("+emp.getEno()+",'"+emp.getEname()+"','"+emp.getEdept()+"',"+emp.getEsal()+",'"+emp.getEaddr()+"')");
				if(updateCount==1) {
					status="Success";
				}else {
					status="Failure";
				}
			}
		} catch (Exception e) {
			status = "Failure";
			e.printStackTrace();
		}
		return status;
	}
	int number=0;
	public Employee search(int eno) {
		Connection con = null;
		Statement st =null;
		ResultSet rs = null;
		Employee emp=null;
		number = eno;
		try {
			con = ConnectionFactory.getConnection();
			if(con!=null) {
				st = con.createStatement();
			}
			if(st!=null) {
				rs = st.executeQuery("SELECT * FROM EMPLOYEEDETAILS WHERE EMPNO="+eno);
			}
			if(rs!=null) {
				boolean b = rs.next();
				if(b==true) {
					emp= new Employee();
					emp.setEno(rs.getInt("EMPNO"));
					emp.setEname(rs.getString("EMPNAME"));
					emp.setEdept(rs.getString("EMPDEPT"));
					emp.setEsal(rs.getFloat("EMPSAL"));
					emp.setEaddr(rs.getString("EMPADDR"));	
				}else {
					emp=null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	public String update(Employee emp) {
		Connection con = null;
		Statement st =null;
		String status=null;
		
		try {
			con=ConnectionFactory.getConnection();
			if(con!=null) {
				st = con.createStatement();
			}
			int rowCount =0;
			if(st!=null) {
				//update employeedetails set empno=100,empname='Arijit Goswami',empdept='security',empsal=10000,empaddr='Hyd' where empno=21;
				rowCount=st.executeUpdate("update employeedetails set empno="+emp.getEno()+",empname='"+emp.getEname()+"',empdept='"+emp.getEdept()+"',empsal="+emp.getEsal()+",empaddr='"+emp.getEaddr()+"' where empno="+number);
			}
			if(rowCount==1) {
				status = "success";
			}else {
				status = "failure";
			}
		} catch (Exception e) {
			status= "failure";
			e.printStackTrace();
		}
		return status;
	}
	public String delete(int eno) {
		Connection con = null;
		Statement st =null;
		String status="";
	
		try {
			con = ConnectionFactory.getConnection();
			if(con!=null) {
				st = con.createStatement();
			}
			int rowCount=0;
			Employee emp = search(eno);
			if(emp==null) {
				status = "not existed";
			}else {
				if(st!=null) {
					rowCount = st.executeUpdate("DELETE FROM EMPLOYEEDETAILS WHERE EMPNO="+emp.getEno());
				}
				if(rowCount==1) {
					status = "success";
				}else {
					status = "failure";
				}
			}	
		} catch (Exception e) {
			status= "failure";
			e.printStackTrace();
		}
		return status;
	}
}
