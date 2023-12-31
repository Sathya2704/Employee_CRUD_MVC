package com.botree.business;

import java.util.List;

import com.botree.bean.Employee;
import com.botree.dao.EmployeeDao;
import com.botree.exception.DuplicateIdException;
import com.botree.exception.IdNotFoundException;

public class EmployeeBo {

    static EmployeeDao empDao = new EmployeeDao();
	
	
	public boolean registerEmployee(Employee emp) throws DuplicateIdException {
		
		return empDao.addEmployee(emp);
	}
	
	public Employee findEmployee(int id) throws IdNotFoundException{
		
		return empDao.findEmployee(id);
	}

	public boolean updateEmployee(int id, int salary) throws IdNotFoundException {

		return empDao.updateEmployee(id, salary);
	}

	public static boolean deleteEmployee(int id) throws IdNotFoundException {
		
		return empDao.deleteEmployee(id);
		
	}

	public List<Employee> showAllEmployee() {

		return empDao.showAllEmployee();

	}
	
}
