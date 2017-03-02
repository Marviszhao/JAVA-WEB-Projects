package com.zhiyou.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.glassfish.external.statistics.annotations.Reset;
import com.zhiyou.dao.UserDao;
import com.zhiyou.dao.UserModel;

/**
 * Servlet implementation class LSLoginServlet
 */
@WebServlet("/LSLoginServlet")
public class LSLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LSLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("LSLogin.jsp?code=2");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String user = request.getParameter("user");
		String password = request.getParameter("psw");
		String button = request.getParameter("button");	
		if(user.length() == 0 || password.length() == 0){
			response.sendRedirect("LSLogin.jsp?code=6");
			return;
		}
		UserDao userDao = new UserDao();
		if (button.equals("��¼")) {
			UserModel userModel = userDao.isHaveUser(user);
			if (userModel == null) {//���û�������
				response.sendRedirect("LSLogin.jsp?code=4");
			} else if (userModel.getU_password().equals(password)){
				//��¼�ɹ�
				request.getSession().setAttribute("user", userModel);
				request.getRequestDispatcher("LSChangePsw.jsp").forward(request, response);
			} else {//�������
				response.sendRedirect("LSLogin.jsp?code=5");				
			}
			return;
		}
		
		if (button.equals("ע��")) {
			if (userDao.isHaveUser(user) != null) {
				//���û��Ѿ�����
				response.sendRedirect("LSLogin.jsp?code=3");
			} else{
//				ע��ɹ�
				Cookie cookie = new Cookie("user", user);
				response.addCookie(cookie);
				UserModel newUser = new UserModel();
				newUser.setU_user(user);
				newUser.setU_password(password);
				userDao.addUser(newUser);
				response.sendRedirect("LSLogin.jsp?code=1");
						
			}
		}
		
	}
	
	
	
	
	
	

}
