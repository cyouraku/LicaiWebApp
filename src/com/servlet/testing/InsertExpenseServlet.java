package com.servlet.testing;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.costuary.bean.LicaiBean;
import com.costuary.bean.WebInputBean;
import com.costuary.sql.LicaiTblSqlBasicImpl;
import com.costuary.sql.SqlBeanInterface;
import com.costuary.util.BeanTransUtil;
import com.costuary.util.DateUtil;
import com.costuary.util.IJsonStrCreator;
import com.costuary.util.JsonStrFactory;

/**
 * Servlet implementation class ShowCurrentTimeServlet
 */
public class InsertExpenseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private SqlBeanInterface sqlBeanInterface;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertExpenseServlet() {
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/InsertExpense.jsp");
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
		String date = (String)request.getParameter("DATE");
		//debug:
		System.out.println("debug: date = " + date);
		if(date == null){

		}
		//check date format
		if(date.indexOf("/") > 0){
			date = DateUtil.parseToISOtimeFomart(date);
		}

		String amt = (String)request.getParameter("AMT");
		inputBean.setAmt(amt);
		inputBean.setDate(date);
		String comment = (String)request.getParameter("COMMENT");
		//方法二：对请求参数值重新编码为UTF-8
//		comment = StringUtil.getString(comment.getBytes("ISO-8859-1"), "UTF-8");
		inputBean.setComment(comment);
		//debug:
		System.out.println("debug: date = " + date);
		System.out.println("debug: amt = " + amt);
		System.out.println("debug: comment = " + comment);

		//Transfert WebInputBean to LicaiBean
		LicaiBean licaiBean = BeanTransUtil.transinputBeanTolicaiBean(inputBean);

		//Insert into database
		sqlBeanInterface = new LicaiTblSqlBasicImpl();
		int result = sqlBeanInterface.insertSql(licaiBean);

		if(result>0){
			request.setAttribute("result", "增加支出成功！");
		}else{
			request.setAttribute("result", "增加支出失败！");
		}
		String jsonVal = getJSONinStringList(licaiBean);
		request.setAttribute("jsonVal", jsonVal);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/InsertResult.jsp");
		dispatcher.forward(request, response);
	}

	private String getJSONinStringList(LicaiBean licaiBean){
		JsonStrFactory factory = new JsonStrFactory();
		//Get json creator for SelectResult
		IJsonStrCreator creator = factory.creatJsonStrCreatorInsert();
		String jsonVal = creator.creatJsonStr(licaiBean );
		return jsonVal.toString();
	}

}
