package com.bigdata.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigdata.service.UserService;
import com.bigdata.vo.UserModel;


public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		
		String cmdStr = request.getParameter("cmdStr");
		
		if ("login_action".equals(cmdStr)) {
			loginAction(request,response);
		} else if("change_psw".equals(cmdStr)){
			changeUserPsw(request,response);
		}
	}

	private void changeUserPsw(HttpServletRequest request,
			HttpServletResponse response) {
		UserModel userModel = (UserModel)request.getSession().getAttribute("loginUser");
		String new_psw = request.getParameter("new_psw");
		UserService userService = new UserService();
		userService.updateUserPsw(userModel.getId(),new_psw);
		
		try {
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loginAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		String userName = request.getParameter("user_name");
		String userPassWord = request.getParameter("user_psw");
		System.out.println(userName + userPassWord);
		
		if (userName == null || userPassWord == null) {
			System.err.println("用户登录参数数为空" + userName + userPassWord);
			return;
		}
		
		UserService userService = new UserService();
		UserModel userModel = userService.checkUser(userName, userPassWord);
		if (userModel != null) {
			System.out.println("用户登录成功----" + userModel.toString());
			request.getSession().setAttribute("loginUser", userModel);
			request.getRequestDispatcher("/admin/result.jsp").forward(request, response);
		} else {
			System.err.print("用户登录失败，返回登录界面----" + userName + userPassWord);
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
