package com.servlet.testing;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.costuary.bean.MyLoginBean;
import com.costuary.util.StringUtil;

/**
 * Servlet implementation class ShowCurrentTimeServlet
 */
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String alertInfo = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String userIp = request.getRemoteAddr();
//		request.setAttribute("userIp", userIp);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/UserLogin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		//方法一：设定编码为UTF-8
		request.setCharacterEncoding("utf-8");//pls use code filter in production env
		//Acquire userNm/Pw and post to AppMenu.jsp

		RequestDispatcher dispatcher;
		MyLoginBean uBean = new MyLoginBean();
		//check user name input rules
		String userNm = (String)request.getParameter("USER_NM");
		String userPw = (String)request.getParameter("USER_PW");
		if(StringUtil.checkInputStrLength(userNm)){
			uBean.setUserName(userNm);
			//check user password input rules
			//To do list
			uBean.setUserPw(userPw);
			if(loginTest(userNm,userPw)){
				session.setAttribute("userBean", uBean);
			}else{
				//Debug:
				Logger.getLogger(UserLoginServlet.class.getName()).info("debug: alertInfo = " + alertInfo);
				request.setAttribute("alertInfo", alertInfo);
				dispatcher = request.getRequestDispatcher("/UserLogin.jsp");
				dispatcher.forward(request, response);
			}
			//Debug:
			Logger.getLogger(UserLoginServlet.class.getName()).info("debug: userNm = " + userNm);
			Logger.getLogger(UserLoginServlet.class.getName()).info("debug: userPw = " + userPw);
			dispatcher = request.getRequestDispatcher("/AppMenu.jsp");
			dispatcher.forward(request, response);
		}else{
			alertInfo = "用户名超过字符长度，请重新输入！";
			//Debug:
			Logger.getLogger(UserLoginServlet.class.getName()).info("debug: alertInfo = " + alertInfo);
			request.setAttribute("alertInfo", alertInfo);
			dispatcher = request.getRequestDispatcher("/UserLogin.jsp");
			dispatcher.forward(request, response);
		}
	}

	private boolean loginTest(String userName,String passWord){
		boolean loginFlag = false;
		//This is only a test method.Pls use database if in real production env.
		String[] name_one = {"zhang.le","Zhang.Le","Tim.Zhang","tim.zhang","Tim.Zhang1981","张乐","zhangle","赵雁红","zhaoyanhong"};
        String[] pwd_one = {"hury2017","hury2017","hury2017","hury2017","hury2017","hury2017","hury2017","hury2017","hury2017"};
        String name_two = "";
        String pwd_two = "";
        int length = name_one.length;
        for(int i=0;i<length;i++){
            name_two = name_one[i];
            pwd_two = pwd_one[i];
            if(userName.equals(name_two) && passWord.equals(pwd_two)){
            	loginFlag = true;
            }else{
            	alertInfo = "登录失败，请重新登录！";
            }
        }
		return loginFlag;
	}

}
