package com.servlet.testing;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.json.*;

import com.costuary.bean.LicaiBean;
import com.costuary.bean.WebInputBean;
import com.costuary.util.DateUtil;
import com.costuary.util.LicaiSqlUtil;

/**
 * Servlet implementation class ShowCurrentTimeServlet
 */
public class SelectMenuServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
//	private SqlBeanInterface sqlBeanInterface;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectMenuServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setAttribute("typeId", "1");
//		request.setAttribute("currencyId", "102");
		HttpSession session = request.getSession(true);
		WebInputBean inputBean = (WebInputBean)session.getAttribute("inputBean");
		if(inputBean == null){
			inputBean = new WebInputBean();
		}
		String typeId = inputBean.getTypeId();
		String currencyId = inputBean.getCurrencyId();
		if(typeId == null){
			typeId = "1";
		}
		if(currencyId  == null){
			currencyId = "102";
		}
		inputBean.setTypeId(typeId);
		inputBean.setCurrencyId(currencyId);
		session.setAttribute("inputBean", inputBean);
		//debug:
		System.out.println("GET debug: typeId = " + inputBean.getTypeId());
		System.out.println("GET debug: currencyId = " + inputBean.getCurrencyId());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/SelectMenu.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		WebInputBean inputBean = (WebInputBean)session.getAttribute("inputBean");
		//方法一：设定编码为UTF-8
		request.setCharacterEncoding("utf-8");
		String frDate= (String)request.getParameter("frDate");
		//check frDate format
		if(frDate.indexOf("/") > 0){
			frDate = DateUtil.parseToISOtimeFomart(frDate);
		}
		//debug:
		System.out.println("debug: frDate = " + frDate);

		String toDate = (String)request.getParameter("toDate");
		if(toDate == null){
			toDate = "";
		}
		//check toDate format
		if(toDate.indexOf("/") > 0){
			toDate = DateUtil.parseToISOtimeFomart(toDate);
		}
		//debug:
		System.out.println("debug: toDate = " + toDate);


		String subCatId = (String)request.getParameter("subCatId");
		if(subCatId == null){
			subCatId = "";
		}
		//debug:
		System.out.println("debug: subCatId = " + subCatId);

		String comment = (String)request.getParameter("comment");
		if(comment == null){
			comment = "";
		}
		//debug:
		System.out.println("debug: comment = " + comment);


		String typeId = inputBean.getTypeId();
		String currencyId = inputBean.getCurrencyId();
		if(typeId == null){
			typeId = "1";
		}
		if(currencyId  == null){
			currencyId = "102";
		}
		//debug:
		System.out.println("POST debug: typeId = " + typeId);
		System.out.println("POST debug: currencyId = " + currencyId);


		//方法二：对请求参数值重新编码为UTF-8
//		comment = StringUtil.getString(comment.getBytes("ISO-8859-1"), "UTF-8");
		inputBean.setDate(frDate);
		inputBean.setSubcatId(subCatId);
		inputBean.setComment(comment);
		inputBean.setTypeId(typeId);
		inputBean.setCurrencyId(currencyId);
		//debug:
//		System.out.println(frDate);
//		System.out.println(toDate);
//		System.out.println(subCatId);
//		System.out.println(comment);

		//select by LicaiSqlUtil
		List<LicaiBean> resultList =  LicaiSqlUtil.selectMenuSql(inputBean, toDate);
		String temp = "";
		int resultSize = resultList.size();
		if(resultSize > 0){
			temp = "查询结果如下";
			request.setAttribute("temp", temp);
//			request.setAttribute("resultList", resultList);
		}else if(resultSize == 0){
			temp = "未查询到结果";
			request.setAttribute("temp", temp);
//			resultList.add(null);
//			request.setAttribute("resultList", resultList);
		}
		//debug:
		System.out.println("POST debug: temp = " + temp);
//		JsonObject jo = new JsonObject();


		request.setAttribute("resultList", resultList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/SelectResult.jsp");
		dispatcher.forward(request, response);
	}

}
