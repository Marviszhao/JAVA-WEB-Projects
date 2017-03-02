package com.bigdata.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigdata.service.JudgeService;
import com.bigdata.vo.JudgeModel;
import com.bigdata.vo.UserModel;

public class JudgeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public JudgeServlet() {
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
		request.setCharacterEncoding("utf8");
		
		String function = request.getParameter("function");
		
		if ("insertJudge".equals(function)) {
			insertJudgeStock(request,response);
		} else if("queryJudgeList".equals(function)){
			queryJudgeList(request,response);
		} else if("delete_judge".equals(function)){
			deleteJudge(request,response);
		} 
		
	}

	private void deleteJudge(HttpServletRequest request,
			HttpServletResponse response) {
		int judgeID = Integer.parseInt(request.getParameter("judgeID")) ;
		
		JudgeService judgeService = new JudgeService();
		judgeService.deleteJudge(judgeID);
		queryJudgeList(request, response);
	}

	private void queryJudgeList(HttpServletRequest request,
			HttpServletResponse response) {
		String stockID = request.getParameter("stockID");
		JudgeService judgeService = new JudgeService();
		List list =  judgeService.queryJudgeList(Integer.parseInt(stockID));
		request.setAttribute("judge_list", list);
		try {
			request.getRequestDispatcher("/admin/judgeList.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void insertJudgeStock(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserModel userModel = (UserModel)request.getSession().getAttribute("loginUser");
		int userID = userModel.getId();
		String stockID = request.getParameter("stockid"); 
		String judgeStar = request.getParameter("judge_star");
		String judgeContent = request.getParameter("judge_content");
		String judge_secret = request.getParameter("judge_secret");
		
		if (stockID == null || judgeStar == null
				|| judgeContent == null || judge_secret == null) {
			System.err.println("输入参数非法----" + userID + stockID + judgeStar + judgeContent + judge_secret);
			return;
		}
		
		JudgeModel judgeModel = new JudgeModel();
		judgeModel.setJudge_content(judgeContent);
		judgeModel.setStock_id(Integer.parseInt(stockID));
		judgeModel.setUser_id(userID);
		judgeModel.setJudge_star(Integer.parseInt(judgeStar));
		judgeModel.setJudge_secret(Integer.parseInt(judge_secret));
		
		System.out.println("开始插入数据模型----" + judgeModel.toString());
		
		JudgeService judgeService = new JudgeService();
		judgeService.insertJudge(judgeModel);
		
		request.getRequestDispatcher("/servlet/BoughtStockServlet").forward(request, response);
		
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
