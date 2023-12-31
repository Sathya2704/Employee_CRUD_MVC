package com.botree.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {

	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");            //Referenced Libraries -> mysql-connector-java-8.0.26.jar(#010) -> com.mysql.cj.jdbc(#package) -> Driver.class -> right click -> Copy Qualified Name (com.mysql.cj.jdbc.Driver.class) -> remove .class -> com.mysql.cj.jdbc.Driver     
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Bsipl@123");   //jdbc url (#in google)
		
		}catch(Exception e){
			
			e.printStackTrace();
		
		}
		return conn;
		
	}
}
