package com.servlet.testing;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.costuary.bean.ServerHealthInfoBean;
import com.costuary.sql.H515sTblSqlBasicImpl;
import com.costuary.sql.SqlBeanInterface;

/**
 * Servlet implementation class ServerHealthInfoServlet
 */
public class ServerHealthInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SqlBeanInterface sqlBeanInterface;
	private ServerHealthInfoBean bean;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServerHealthInfoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		sqlBeanInterface = new H515sTblSqlBasicImpl();
		bean = (ServerHealthInfoBean)sqlBeanInterface.resultSql(null);
		if(bean != null && bean instanceof ServerHealthInfoBean){
			request.setAttribute("result", "最近一次服务器温度数据：");
			request.setAttribute("serverHealthInfoBean", bean);
		}else{
			request.setAttribute("result", "未能获得服务器温度数据：");
			bean.setRecord_id("null");
			bean.setCpu_teperature("null");
			bean.setGpu_temperature("null");
			bean.setFan_speed("null");
			bean.setRecord_timeStamp("null");
			request.setAttribute("serverHealthInfoBean", bean);
		}
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ServerHealthInfo.jsp");
        dispatcher .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		sqlBeanInterface = new H515sTblSqlBasicImpl();
		ServerHealthInfoBean eBean = new ServerHealthInfoBean();
		String cpu = (String)request.getParameter("cpu").trim();
		//debug:
		System.out.println(cpu );
		eBean.setCpu_teperature(cpu);
		String gpu = (String)request.getParameter("gpu").trim();
		//debug:
		System.out.println(gpu);
		eBean.setGpu_temperature(gpu);
		String fan = (String)request.getParameter("fan").trim();
		//debug:
		System.out.println(fan);
		eBean.setFan_speed(fan);
		int result = sqlBeanInterface.insertSql(eBean);
		if(result > 0){
			doGet(request,response);
		}
	}
}
