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
<h3 class="text-center text-success">Login</h3>

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
<%
String lgMsg = (String)session.getAttribute("logoutMsg");
if(lgMsg!=null){%>
	<div class="alert alert-success" role="alert">
    <%=lgMsg %>
    </div>
<%
session.removeAttribute("logoutMsg");
}
%>
<form action="login" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Email ID</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Password</label>
    <input type="password" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="password">
  </div>
  <div class="text-center">
  <button type="submit" class="btn btn-primary">Login</button>
  </div>
</form>
</div>
</div>
</div>
</div>
</div>

</body>
</html>