package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

/**
 * Servlet implementation class Registe
 */
@WebServlet("/Registe")
public class Registe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding ("gb18030");
		User user = new User();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String name = (request.getParameter("name"));
		String phone = request.getParameter("phone");
		String errormsg = ""; 
		UserService us = new UserServiceImpl();
		boolean isRight = true;
		if(us.usernameIsExist(username)){
			isRight = false;
			errormsg += "，用户名已存在";
		}
		if(username.length() < 2 || username.length() > 15){
			isRight = false;
			errormsg += "，用户名长度不正确";
		}
		if(password.length()  < 2 || password.length() > 15){
			isRight = false;
			errormsg += "，密码过短或过长";
		}
		if(!password.equals(password2)){
			isRight = false;
			errormsg += "，两次密码不一致";
		}
		if(name.length()<2 || name.length()>10){
			isRight = false;
			errormsg += "，真是姓名不合法";
		}
		if(phone.length() != 11){
			isRight = false;
			errormsg += "，手机号码不正确";
	
		}
		
		if(isRight){
			user.setUsername(username);
			user.setPassword(password);
			user.setName(name);
			user.setPhone(phone);
			us.add(user);
			System.out.print("注册成功");
		}else{
			System.out.println(errormsg);
		}
	}

}
