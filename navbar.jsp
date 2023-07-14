<%@page import="com.entity.UserDtls"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="#">TO DO APP</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="add_todo.jsp">Add ToDo</a>
      </li>
      
    </ul>
    <%
    UserDtls user = (UserDtls)session.getAttribute("user");
    
    if(user!=null)
    {
    %>
    	<form class="form-inline">
    <button class="btn btn btn-primary border border-dark m-2" type="button"><%= user.getFullname() %></button>
    <a href="logoutServlet"><button class="btn btn btn-primary border border-dark m-2" type="button">Logout</button></a>
  </form>
    <%
    }
    else
    {
    %>
    	<form class="form-inline">
    <a href="register.jsp"><button class="btn btn btn-primary border border-dark m-2" type="button">Register</button></a>
    <a href="login.jsp"><button class="btn btn btn-primary border border-dark m-2" type="button">Login</button></a>
  </form>
    	
    <%
    }
    %>  
  </div>
</nav>