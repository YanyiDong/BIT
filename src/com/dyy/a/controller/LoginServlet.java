package com.dyy.a.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dyy.a.entity.Customer;
import com.dyy.a.service.UserService;
import com.dyy.a.service.impl.UserServiceImpl;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入servlet");
		//1.接受请求，取得请求参数
				String username = request.getParameter("username");
				String passwd = request.getParameter("password");
				
				Customer cust = new Customer();
				cust.setCustname(username);
				cust.setPasswd(passwd);
				
				//2.调用合适的Model层来处理业务逻辑
				UserService service = new UserServiceImpl();
				((UserServiceImpl) service).setCust(cust);
				int flag = service.Login();
				
				//HttpSession session = request.getSession();
				
				//3.根据返回结果进行页面跳转
				if (flag == 0) {
					// 使用请求属性传递数据
					request.setAttribute("msg", "正在审核，请等待。");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				} else if (flag == 1) {	
					HttpSession session = request.getSession();
					session.setAttribute("username", username);
					request.getRequestDispatcher("/index.html").forward(request,
							  response);
				} else if (flag == 2) {
					request.setAttribute("msg", "审核未通过，重新注册。");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				} else if (flag == 3) {
					request.setAttribute("msg", "用户名或密码错误");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}

	}

}
