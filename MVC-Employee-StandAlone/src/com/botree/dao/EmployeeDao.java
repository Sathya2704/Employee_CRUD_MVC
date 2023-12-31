package com.botree.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.botree.bean.Employee;
import com.botree.constants.QueryConstants;
import com.botree.exception.DuplicateIdException;
import com.botree.exception.IdNotFoundException;
import com.botree.util.DbUtil;

public class EmployeeDao {

	public boolean addEmployee(Employee emp) throws DuplicateIdException{
		
		Connection conn = DbUtil.getConnection();
		PreparedStatement pstmt = null;
		
		try {
		      pstmt=conn.prepareStatement(QueryConstants.INSERT_SQL);
		      pstmt.setInt(1, emp.id());
		      pstmt.setString(2, emp.name());
		      pstmt.setInt(3, emp.salary());
		      
		      pstmt.execute();
		      
		      return true;
		      
		}catch(Exception e) {
			throw new DuplicateIdException(emp.id()+"already exist");
		}
	}
	
	
	public Employee findEmployee(int id) throws IdNotFoundException {
		
	    Connection conn = DbUtil.getConnection();
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	        pstmt = conn.prepareStatement(QueryConstants.SEARCH_SQL);
	        pstmt.setInt(1, id);
	        
	        rs = pstmt.executeQuery();
	        
	        if (rs.next()) 
	        	
	            return new Employee(rs.getInt("id"), rs.getString("name"), rs.getInt("salary"));
	            
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
        throw new IdNotFoundException(id+" not found");

	}
	

	public boolean updateEmployee(int id, int salary) throws IdNotFoundException {

		Connection conn = DbUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(QueryConstants.UPDATE_SALARY_SQL);
			pstmt.setInt(1, salary);
			pstmt.setInt(2, id);

			 pstmt.execute();
			 
          return true;
          
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		throw new IdNotFoundException(id + " not found");

	}

	
	public boolean deleteEmployee(int id) throws IdNotFoundException {

		/*
		//Connection conn = DbUtil.getConnection();
		PreparedStatement pstmt = null;
		Connection conn = null;
        ResultSet rs = null;

		try {
//			pstmt = conn.prepareStatement(QueryConstants.DELETE_SQL);
//			pstmt.setInt(1, id);
//			
//			pstmt.execute();
//
//			return true;
			
			//using callable and stored procedure (this is direct callable should not do like this)
            Class.forName("com.mysql.cj.jdbc.Driver");
			
		    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Bsipl@123");
			
		    String sql1 = "{call deleteEmp(?)}";
		    
		            CallableStatement cs = conn.prepareCall(sql1);
		            cs.setInt(1, id);
		            cs.execute();
		              

		} catch (Exception e) {
			throw new IdNotFoundException(id + " not found");
		}
		return false;*/
		
		//using callable and stored procedure(correct method)
		
			Connection conn = DbUtil.getConnection();
			// Statement stmt=null;
			ResultSet rs = null;
			// PreparedStatement pstmt=null;

			CallableStatement cs = null;

			try {

				// pstmt=conn.prepareStatement(QueryConstants.DELETE_SQL);

				cs = conn.prepareCall(QueryConstants.DELETE_SQL);

				cs.setInt(1, id);

				int n = cs.executeUpdate();

				if (n == 1) {

					return true;

				} else {

					return false;

				}
			}

			catch (Exception e) {

				throw new IdNotFoundException(e.getMessage());

			}
		
	}
	
	
	public List<Employee> showAllEmployee()  {
		List<Employee> empList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = DbUtil.getConnection();
        try {
        pstmt = conn.prepareStatement(QueryConstants.SELECT_SQL);
        rs = pstmt.executeQuery();

        while (rs.next()) {
            Employee employee = new Employee(rs.getInt("id"), rs.getString("name"), rs.getInt("salary"));
            empList.add(employee);
        }
        }catch(Exception e) {
        	e.printStackTrace();
        }

        return empList;
    }



}
