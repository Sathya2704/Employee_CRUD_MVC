package com.botree.constants;

public class QueryConstants {

	public static final String LOGINSQL="""
			select password from user where username=?
			""" ;
	
	public static final String INSERT_SQL="""
			insert into employee values(?,?,?);
			""";
	
	public static final String SEARCH_SQL="""
			select * from employee where id =?;
			""";
	
	public static final String UPDATE_NAME_SQL="""
			update employee set name=? where id =?;
			""";
	
	public static final String UPDATE_SALARY_SQL="""
			update employee set salary=? where id =?;
			""";
	
//	public static final String DELETE_SQL="""
//			delete from employee where id =?;
//			""";
	
	//using callable fn
	public static final String DELETE_SQL="""
			{call deleteEmp(?)}
			""";
	
	public static final String SELECT_SQL="""
			select * from employee;
			""";
}
