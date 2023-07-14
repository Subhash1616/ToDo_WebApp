<%@page import="com.DAO.TodoDAO"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.entity.TodoDtls"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="component/all_css.jsp" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #f0f1f2">
<%@ include file="component/navbar.jsp" %>
<div class="container">
<div class="row p-5">
<div class="col-md-6 offset-md-3">
<div class="card">
<div class="card-body">
<h3 class="text-center text-success">Add To Do</h3>
<%
int id = Integer.parseInt(request.getParameter("id"));
TodoDAO dao = new TodoDAO(DBConnect.getcon());
TodoDtls t = dao.getTodoById(id);
%>

<form action="update" method="post">
<input type="hidden" value="<%=t.getId() %>" name="id">
<div class="form-group">
    <label for="exampleInputEmail1">Name</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="username" value="<%=t.getName()%>">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">To Do</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="todo" value="<%=t.getTodo()%>">
  </div>
  <div class="form-group">
      <label for="inputState">Status</label>
      <select id="inputState" class="form-control" name="status">
      <%
      if("Pending".equals(t.getStatus())){%>
          <option value="Pending">Pending</option>
         <option value="Complete">Complete</option>
      <% }else{%>
          <option value="Complete">Complete</option>
          <option value="Pending">Pending</option>
      <% }
      %>
      </select>
    </div>
  <div class="text-center">
  <button type="submit" class="btn btn-primary">Update</button>
  </div>
</form>
</div>
</div>
</div>
</div>
</div>

</body>
</html>