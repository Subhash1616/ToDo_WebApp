package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.DB.DBConnect;
import com.entity.UserDtls;

@WebServlet("/login")
public class loginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		UserDtls u = new UserDtls();
		u.setEmail(email);
		u.setPassword(password);
		UserDAO dao = new UserDAO(DBConnect.getcon());
		UserDtls user = dao.loginUser(u);
		if(user!=null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			resp.sendRedirect("index.jsp");
		}else {
			HttpSession session = req.getSession();
			session.setAttribute("failedMsg", "Invalid username or password");
			resp.sendRedirect("login.jsp");
		}
	}

}
