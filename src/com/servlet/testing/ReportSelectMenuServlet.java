package com.servlet.testing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.costuary.bean.LicaiBean;
import com.costuary.bean.WebInputBean;
import com.costuary.util.DateUtil;
import com.costuary.util.IJsonStrCreator;
import com.costuary.util.JsonStrFactory;
import com.costuary.util.LicaiSqlUtil;

/**
 * Servlet implementation class CostuaryMenuServlet
 */
public class ReportSelectMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int Annual = 0;
	private static final int Quater = 1;
	private static final int Monthly = 2;
	private static final int Weekly = 3;
	private static final int Dayly = 4;
	private int sumAmt = 0;
	private List<LicaiBean> beanList = new ArrayList<LicaiBean>();


    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportSelectMenuServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("typeId", "1");
		request.setAttribute("currencyId", "102");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ReportSelectMenu.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		WebInputBean inputBean = (WebInputBean)session.getAttribute("inputBean");
		String frDate = "";
		String toDate = "";

		if(inputBean == null){
			//to do list,show error msg page.
		}

		//获得查询报告类别

		String temp = (String)request.getParameter("reportType");
		int reportType = Integer.valueOf(temp);
		//Debug:
		System.out.println("Debug: reportType = " + reportType);
		switch(reportType){
			case Annual:
				frDate = DateUtil.getFirstDayOfCurrentYear();
				inputBean.setDate(frDate);
				toDate = DateUtil.getLastDayOfCurrentYear();
				break;
			case Quater:
				frDate = DateUtil.getFirstDayOfCurrentQuater();
				inputBean.setDate(frDate);
				toDate = DateUtil.getLastDayOfCurrentQuater();
				break;
			case Monthly:
				frDate = DateUtil.getFirstDayOfCurrentMonth();
				inputBean.setDate(frDate);
				toDate = DateUtil.getLastDayOfCurrentMonth();
				break;
			case Weekly:
				frDate = DateUtil.getFistDayOfCurrentWeek();
				inputBean.setDate(frDate);
				toDate = DateUtil.getLastDayOfCurrentWeek();
				break;
			case Dayly:
				frDate = DateUtil.getDateStrNow();
				inputBean.setDate(frDate);
				toDate = "";
				break;
		};
		session.setAttribute("inputBean", inputBean);
		//debug:
		System.out.println("debug typeId: " + inputBean.getTypeId());
		System.out.println("debug currencyId: " + inputBean.getCurrencyId());
		System.out.println("debug frDate: " + inputBean.getDate());
		System.out.println("debug toDate: " + toDate);
		//select by LicaiSqlUtil
//		List<LicaiBean> resultList =  LicaiSqlUtil.reportMenuSql(inputBean, toDate);
//		if(resultList.size() > 0){
//			request.setAttribute("temp", "查询结果如下");
//		}else{
//			request.setAttribute("temp", "请重新查询");
//		}
//		request.setAttribute("resultList", resultList);

		request.setAttribute("reportType", reportType);
		String jsonVal = "";
		jsonVal = getJSONinStringList(inputBean, toDate);
		if(!"".equals(jsonVal)){
			request.setAttribute("temp", "查询结果如下");
		}else{
			request.setAttribute("temp", "请重新查询");
		}
		request.setAttribute("jsonVal", jsonVal);
		request.setAttribute("sumAmt", sumAmt);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ReportSelectResult.jsp");
		dispatcher.forward(request, response);
	}

	private void initParams(){
		sumAmt = 0;
		beanList.clear();
	}

	private String getJSONinStringList(WebInputBean inputBean,String toDate){
		initParams();
		beanList =  LicaiSqlUtil.reportMenuSql(inputBean, toDate);
		String[] jsonValList;
		StringBuilder jsonVal = new StringBuilder();
		JsonStrFactory factory = new JsonStrFactory();
		//Get json creator for SelectResult
		IJsonStrCreator creator = factory.creatJsonStrCreatorReport();
		LicaiBean bean = null;
		float sum = 0;
		if (beanList != null) {
			Iterator<LicaiBean> iter = beanList.iterator();
			while (iter.hasNext()) {
				bean = iter.next();
				sum += bean.getAmt();
			}
		}
		sumAmt = Math.round(sum);
		//using StringBuilder to create json array object.
		jsonValList = creator.creatJsonStrList(beanList);
		int length = jsonValList.length;
		if (length >= 1) {
			jsonVal.append("[");
			for (int i = 0; i < (length - 1); i++) {
				jsonVal.append(jsonValList[i] + ",");
			}
			jsonVal.append(jsonValList[length - 1]);
			jsonVal.append("]");
		} else {
			jsonVal.append(creator.creatJsonStrNull());
		}
		return jsonVal.toString();
	}

}
