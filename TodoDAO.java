package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.TodoDtls;

public class TodoDAO {

	private Connection con;

	public TodoDAO(Connection con) {
		super();
		this.con = con;
	}
	public boolean addTodo(String name, String todo, String status,int uid) {
		boolean f=false;
		try {
			System.out.println(uid);
			String sql = "insert into todo_app(name,todo,status,uid) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, todo);
			ps.setString(3, status);
			ps.setInt(4, uid);
			int i = ps.executeUpdate();
			if(i==1) {
				System.out.println("uid");
				f=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	public List<TodoDtls> getTodo(int uid){
		List<TodoDtls> list = new ArrayList<TodoDtls>();
		TodoDtls t =null;
		try {
			String sql = "select * from todo_app where uid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs  = ps.executeQuery();
			while(rs.next()) {
				t=new TodoDtls();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setTodo(rs.getString(3));
				t.setStatus(rs.getString(4));
				list.add(t);
			}
			} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public TodoDtls getTodoById(int id) {
		TodoDtls t =null;
		try {
			String sql = "select * from todo_app where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				t=new TodoDtls();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setTodo(rs.getString(3));
				t.setStatus(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	public boolean updateTodo(TodoDtls t) {
		boolean f= false;
		int i=0;
		try {
			String sql = "update todo_app set name=?,todo=?,status=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getName());
			ps.setString(2, t.getTodo());
			ps.setString(3, t.getStatus());
			ps.setInt(4, t.getId());
			i=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(i==1) {
			f=true;
		}
		return f;
	}
	public boolean deleteTodo(int id) {
		boolean f=false;
		int i=0;
		try {
			String sql = "delete from todo_app where id=?";
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setInt(1, id);
		    i =ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(i==1) {
			f=true;
		}
		return f;
	}
}
