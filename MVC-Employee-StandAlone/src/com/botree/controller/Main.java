package com.botree.controller;

import java.util.List;
import java.util.Scanner;

import com.botree.bean.Employee;
import com.botree.bean.User;
import com.botree.business.EmployeeBo;
import com.botree.business.LoginBo;
import com.botree.exception.DuplicateIdException;
import com.botree.exception.IdNotFoundException;
import com.botree.exception.InvalidUserException;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("Enter user name : ");
//		String name = sc.next();
//		
//		System.out.println("Enter Password : ");
//		String password = sc.next();
		
		//var user = new User(name, password);
		
		boolean flag = true;
		
		do {
		var user = login();
		
		var loginBo = new LoginBo();
		
		try {
			
	    flag = !loginBo.validateUser(user);
	    
		}catch(InvalidUserException e) {
			System.out.println(e.getMessage());
			flag=true;
		}
		
//	    if(flag) {
//	    System.out.println("Invalid username and password");
//	    
//	//	System.out.println(flag);
//		}
		}
		while(flag);
		
		
		do {
			System.out.println("Select option");
			
			System.out.println("""
					1. Register Employee \n 
					2. Find by Id \n 
					3. Update Employee \n 
					4. Delete Employee \n 
					5. Show All Employee \n
					6. Exit 
					""");
			//register
			//find
			//update
			//delete
			int option = sc.nextInt();
			
			switch(option) {
			case 1 -> register();
			
			case 2 -> find();
			
			case 3 -> update();

			case 4 -> delete();

			case 5 -> showAll();
			
			case 6 -> System.exit(0);

			default -> System.out.println("Wrong Choice");
			}
			
			
		}while(true);
	}
	
	public static void register() {
		
		System.err.println("Register Page");
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter id : ");
	     int id = sc.nextInt();
		
		System.out.println("Enter name : ");
		String name = sc.next();
		
		System.out.println("Enter salary : ");
		int salary = sc.nextInt();
		
		var emp = new Employee(id, name, salary);
		
		var empBo = new EmployeeBo();
		
		try {
		empBo.registerEmployee(emp);
		System.out.println(id+"registered successfully");
		
		}catch(DuplicateIdException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void find() {
		System.err.println("Search Page");
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter id : ");
		int id = sc.nextInt();
		
		var empBo = new EmployeeBo();
		try {
		System.out.println(empBo.findEmployee(id));
		}catch(IdNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void update() {
		System.err.println("Update Page");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter id : ");
		int id = sc.nextInt();
		
		System.out.println("Enter salary : ");
		int salary = sc.nextInt();
		
		var empBo = new EmployeeBo();
		try {
		System.out.println(empBo.updateEmployee(id,salary));
		}catch(IdNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

//	public static void delete() {
//		System.err.println("Delete Page");
//		
//		Scanner sc = new Scanner(System.in);
//
//		System.out.println("Enter id : ");
//		int id = sc.nextInt();
//			
//		var empBo = new EmployeeBo();
//		
//		try {
//		empBo.deleteEmployee(id);
//		System.out.println(id+"deleted successfully");
//		
//		}catch(IdNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
//	}
	
	public static void delete() {

		System.err.println("Delete page");
Scanner sc = new Scanner(System.in);
		System.out.println("enter the id to delete");

		int id = sc.nextInt();

		try {

			var f = EmployeeBo.deleteEmployee(id);

			if (!f) {

				throw new IdNotFoundException("");

			}

			System.out.println("delete success");

		} catch (Exception e) {
e.printStackTrace();
			System.out.println("Id not found");

		}

	}
	
	 public static void showAll() {
	        System.err.println("Display Page");

	        var empBo = new EmployeeBo();
	        List<Employee> employees = empBo.showAllEmployee();

	        if (employees.isEmpty()) {
	            System.out.println("No employees found.");
	        } else {
	            System.out.println("Employee List:");
	            for (Employee employee : employees) {
	                System.out.println(employee);
	            }
	        }
	    }

	public static User login() {

		System.err.println("Login Page");
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter user name : ");
		String name = sc.next();
		
		System.out.println("Enter Password : ");
		String password = sc.next();
		
		return new User(name, password);
	}
}
