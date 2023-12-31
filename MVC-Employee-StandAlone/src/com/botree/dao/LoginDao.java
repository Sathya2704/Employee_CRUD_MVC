package com.botree.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.botree.bean.User;
import com.botree.constants.QueryConstants;
import com.botree.util.DbUtil;

public class LoginDao {

	public User getUser(User user) {
		
		Connection conn = DbUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User u = null;
		
		try {
			pstmt = conn.prepareStatement(QueryConstants.LOGINSQL);
			pstmt.setString(1, user.username());
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				u=new User(user.username(), rs.getString("password"));
			}
			
		}catch(Exception e) {
			
		}
		
		return u;
		
	}
}
