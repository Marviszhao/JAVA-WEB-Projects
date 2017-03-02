package com.bigdata.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigdata.service.BuyStockService;
import com.bigdata.service.StockService;
import com.bigdata.vo.BuyStockModel;
import com.bigdata.vo.StockModel;
import com.bigdata.vo.UserModel;

import java.util.List;

public class AddStockServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor of the object.
	 */
	public AddStockServlet() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("test");
		if (method != null) {
			System.out.println("------" + method + "-----");
		}
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	StockService stockService = new StockService();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		String method = request.getParameter("method");
		if (method == null) {
			System.err.println("method param can not be null");
			return;
		}
		
		if ("add".equals(method)) {
			addStock(request, response);
		} else if ("queryStocks".equals(method)){
			queryStockList(request, response);
		} else if("delete".equals(method)){
			deleteStock(request,response);
		} else if ("editStock".equals(method)) {
			editStock(request,response);
		} else if ("buyStockList".equals(method)){
			buyStockList(request,response);
		}	 else if ("buyStock".equals(method)){
			buyStock(request,response);
		}		
	}
	
	private void buyStock(HttpServletRequest request,
			HttpServletResponse response) {
		String stockID = request.getParameter("stockID");
		UserModel userModel = (UserModel)request.getSession().getAttribute("loginUser");
		int userID = userModel.getId();
		BuyStockModel model = new BuyStockModel();
		model.setStock_count(1);
		model.setUser_id(userID);
		model.setStock_id(Integer.parseInt(stockID));
		
		BuyStockService buyStockService = new BuyStockService();
		buyStockService.insertBuyStock(model);
		
		buyStockList(request,response);
	}

	private void editStock(HttpServletRequest request,
			HttpServletResponse response) {
		String stockID = request.getParameter("stockID");
		String stockName = request.getParameter("stockName");
		String stockPrice = request.getParameter("stockPrice");
		String stockDesc = request.getParameter("stockDes");
		
		StockModel stockModel = new StockModel();
		stockModel.setId(Integer.parseInt(stockID));
		stockModel.setStockName(stockName);
		stockModel.setStockComment(stockDesc);
		stockModel.setStockPrice(Double.parseDouble(stockPrice));
		
		System.err.println(stockModel.toString());
		
		stockService.editorStock(stockModel);
		
		queryStockList(request, response);
	}

	private void deleteStock(HttpServletRequest request,
			HttpServletResponse response) {
		String stockID = request.getParameter("id");
		if (stockID != null) {
			stockService.deleteStock(stockID);
			queryStockList(request, response);
		} else {
		}
		
	}

	public void addStock(HttpServletRequest request, HttpServletResponse response) {
		String stockName = request.getParameter("stock_name");
		String stockPrice = request.getParameter("stock_price");
		String stockComment = request.getParameter("stock_comment");
		if (stockName == null || stockPrice == null || stockComment == null) {
			return;
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("stockName", stockName);
		map.put("stockPrice", stockPrice);
		map.put("stockComment", stockComment);
		stockService.addStock(map);
		
		request.setAttribute("type", "insertSucc");
		try {
			request.getRequestDispatcher("/admin/addStock.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void buyStockList(HttpServletRequest request, HttpServletResponse response) {
		List list = stockService.queryStocks();
		request.setAttribute("stockList", list);
		try {
			request.getRequestDispatcher("/admin/buyStock.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void queryStockList(HttpServletRequest request, HttpServletResponse response) {
		List list = stockService.queryStocks();
		request.setAttribute("stockList", list);
		try {
			request.getRequestDispatcher("/admin/stockList.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
