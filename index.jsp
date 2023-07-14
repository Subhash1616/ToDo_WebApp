
<%@page import="com.DAO.TodoDAO"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.entity.TodoDtls"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<%@ include file="component/all_css.jsp" %>
</head>
<body>
<%@ include file="component/navbar.jsp" %>
<h1 class="text-center text-success">TO DO APP</h1>
<%
String s = (String)session.getAttribute("sucMsg");
if(s!=null){
%>
	<div class="alert alert-success" role="alert">
    <%=s %>
    </div>
    <% 
    session.removeAttribute("sucMsg");
}
%>
<%
String f = (String)session.getAttribute("failedMsg");
if(f!=null){
%>
	<div class="alert alert-danger" role="alert">
    <%=f %>
    </div>
    <% 
    session.removeAttribute("failedMsg");
}
%>
<div class="container">
<table class="table table-striped" border="1px">
  <thead class="bg-success text-white">
    <tr>
      <%--<th scope="col">ID</th> --%>
      <th scope="col">Name</th>
      <th scope="col">To Do</th>
      <th scope="col">Status</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  
  <%
    UserDtls u = (UserDtls)session.getAttribute("user");
  if(u!=null){
	    TodoDAO dao =new TodoDAO(DBConnect.getcon());
	    List<TodoDtls> todo = dao.getTodo(u.getId());
	    for(TodoDtls t:todo){
	    	%>
	    	<tr>
	      <%-- <th scope="row"><%=t.getId() %></th> --%>
	      <th scope="col"><%=t.getName() %></th>
	      <td><%=t.getTodo() %></td>
	      <td><%=t.getStatus() %></td>
	      <td>
	      <a href="edit.jsp?id=<%=t.getId() %>" class="btn btn-sm btn-success">Edit</a>
	      <a href="delete?id=<%=t.getId() %>" class="btn btn-sm btn-danger">Delete</a>
	      </td>
	    </tr>
	    <%}
	    }else{
	    	response.sendRedirect("login.jsp");	
	    }
  
  %>
  
  </tbody>
</table>
</div>


</body>
</html>