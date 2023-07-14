package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.UserDtls;

public class UserDAO {

	private Connection con;

	public UserDAO(Connection con) {
		super();
		this.con = con;
	}
	public boolean addUser(UserDtls u) {
		boolean f=false;
		int i=0;
		try {
			String sql = "insert into user(fullname,email,password) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u.getFullname());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(i==1) {
			f=true;
		}
		return f;
	}
	public UserDtls loginUser(UserDtls u) {
		UserDtls ud = null;
		try {
			String sql = "select * from user where email=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ud=new UserDtls();
				ud.setId(rs.getInt("id"));
				ud.setFullname(rs.getString("fullname"));
				ud.setEmail(rs.getString("email"));		
			    ud.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ud;
	}
}
