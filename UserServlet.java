package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.TodoDAO;
import com.DAO.UserDAO;
import com.DB.DBConnect;
import com.entity.UserDtls;

@WebServlet("/register")
public class UserServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		UserDtls u = new UserDtls();
		u.setFullname(username);
		u.setEmail(email);
		u.setPassword(password);
		UserDAO dao = new UserDAO(DBConnect.getcon());
		boolean f = dao.addUser(u);
		HttpSession session = req.getSession();
		if(f) {
			session.setAttribute("sucMsg", "User Registration Successful");
			resp.sendRedirect("register.jsp");
		}else {
			session.setAttribute("failedMsg", "User Registration failed");
			resp.sendRedirect("register.jsp");
		}
	}

}
