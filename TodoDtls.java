package com.entity;

public class TodoDtls {
	private int id;
	private String name;
	private String todo;
	private String status;
	private UserDtls user;
	public TodoDtls(int id, String name, String todo, String status, UserDtls user) {
		super();
		this.id = id;
		this.name = name;
		this.todo = todo;
		this.status = status;
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public UserDtls getUser() {
		return user;
	}
	public void setUser(UserDtls user) {
		this.user = user;
	}
	public TodoDtls() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
