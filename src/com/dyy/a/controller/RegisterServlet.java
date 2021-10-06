package com.dyy.a.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dyy.a.entity.Customer;
import com.dyy.a.service.UserService;
import com.dyy.a.service.impl.UserServiceImpl;


@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("inputText");
		String passwd = request.getParameter("inputText2");

		Customer customer = new Customer();
		customer.setCustname(username);
		customer.setPasswd(passwd);

		UserService service = new UserServiceImpl();
		((UserServiceImpl) service).setCust(customer);
		int flag = service.insertCust();

		if (flag != 0) {
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("/register.jsp")
					.forward(request, response);
		}

	}

}
