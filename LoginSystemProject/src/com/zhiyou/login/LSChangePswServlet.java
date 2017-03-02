package com.zhiyou.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.zhiyou.dao.UserDao;
import com.zhiyou.dao.UserModel;

/**
 * Servlet implementation class LSChangePswServlet
 */
@WebServlet("/LSChangePswServlet")
public class LSChangePswServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LSChangePswServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		UserModel userModel = (UserModel)request.getSession().getAttribute("user");
		String oldPsw = request.getParameter("old_psw");
		String newPsw = request.getParameter("new_psw")	;
		String confirmPsw = request.getParameter("confirm_psw");
		if (!userModel.getU_password().equals(oldPsw)) {
			request.setAttribute("code", "1");
			request.getSession().setAttribute("sess", "sessiton1");
			request.getRequestDispatcher("LSChangePsw.jsp").forward(request, response);;
		} else if (oldPsw.equals(newPsw)) {
			request.setAttribute("code", "2");
			request.getSession().setAttribute("sess", "sessiton2");
			request.getRequestDispatcher("LSChangePsw.jsp").forward(request, response);
		} else if (!newPsw.equals(confirmPsw)) {
			request.setAttribute("code", "3");
			request.getSession().setAttribute("sess", "sessiton3");
			request.getRequestDispatcher("LSChangePsw.jsp").forward(request, response);
		}else {
			UserDao userDao = new UserDao();
			userDao.changedPassword(userModel, newPsw);
			response.sendRedirect("LSLogin.jsp?code=7");
		}
		
		
	}

}
