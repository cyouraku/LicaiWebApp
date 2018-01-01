package com.servlet.testing;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class SessionTrack
 */
public class SessionTrack extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTrack() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 如果不存在 session 会话，则创建一个 session 对象
//		HttpSession session = request.getSession(true);
 		//获取 session 创建时间
//		Date createTime = new Date(session.getCreationTime());
		// 获取该网页的最后一次访问时间
//		Date lastAccessTime = new Date(session.getLastAccessedTime());
	    // 设置日期输出的格式
//	    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//设定欢迎词
//		String title = "";

//		Integer visitCount = new Integer(0);
//		String visitCountKey = new String("visitCount");
//		String userIDKey = new String("userID");
//		String userID = "";
//		MyLoginBean bean;
//		String userIp = "";

//		Map<String,String> myMap =(Map<String,String>) session.getAttribute("Map");
//		if(myMap != null){
//			String sessionId = myMap.get("sessionId");
//			if(sessionId != null){
//				//debug:
//				System.out.println("Debug: " + sessionId);
//			}
//			userIp = myMap.get("userIp");
//			if(userIp != null){
//				//debug:
//				System.out.println("Debug: " + userIp);
//			}
//		}
//		bean =(MyLoginBean)session.getAttribute("userBean");
//		if(bean != null){
//			userID = bean.getUserName();
//			if(userID != null){
//				//debug:
//				System.out.println("Debug: " + userID);
//			}
//			String userPW = bean.getUserPw();
//			if(userPW != null){
//				//debug:
//				System.out.println("Debug: " + userPW);
//			}
//		}else{
//			//debug:
//			System.out.println("Debug: userBean is null!");
//		}
//		if (session.isNew()){
			//设定欢迎词
//			title = "Welcome!";
//		 	response.sendRedirect("UserLogin.jsp");
//		} else {
			//设定欢迎词
//			title = "Welcome back again!";
//		 	userID = (String)session.getAttribute(userIDKey);
//		 	if(userID == null){
//		 		userID = new String(bean.getUserName());
//		 		session.setAttribute(userIDKey, userID);
//		 		userID = (String)session.getAttribute(userIDKey);
//		 	}
//		 	visitCount = (Integer)session.getAttribute(visitCountKey);
//		 	if(visitCount == null){
//		 		visitCount = new Integer(0);
//		 		session.setAttribute(visitCountKey,  visitCount);
//		 		visitCount = (Integer)session.getAttribute(visitCountKey);
//		 	}
//			//Debug:
//		 	System.out.println("old session:");
//			System.out.println(userIDKey);
//			System.out.println(userID);
//		 	System.out.println(visitCountKey );
//			System.out.println(visitCount);
//		 	visitCount = visitCount + 1;
//			session.setAttribute(visitCountKey,  visitCount);
//		}
		//设置响应内容类型
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		String docType = "<!DOCTYPE html>\n";
//		out.println(docType +
//		        "<html>\n" +
//		        "<body bgcolor=\"#f0f0f0\">\n" +
//		        "<a href=\"AppMenu.jsp\">Return to menu</a>\n" +
//		        "<h1 align=\"center\">" + title + "</h1>\n" +
//		         "<h2 align=\"center\">Session 信息</h2>\n" +
//		         "<p>"+ title + "</p>\n" +
//		        "<table border=\"1\" align=\"center\">\n" +
//		        "<tr bgcolor=\"#949494\">\n" +
//		        "  <th>Session 信息</th><th>值</th></tr>\n" +
//		        "<tr>\n" +
//		        "  <td>id</td>\n" +
//		        "  <td>" + session.getId() + "</td></tr>\n" +
//		        "<tr>\n" +
//		        "  <td>创建时间</td>\n" +
//		        "  <td>" +  df.format(createTime) +
//		        "  </td></tr>\n" +
//		        "<tr>\n" +
//		        "  <td>最后访问时间</td>\n" +
//		        "  <td>" + df.format(lastAccessTime) +
//		        "  </td></tr>\n" +
//
//		        "<tr>\n" +
//		        "  <td>最后访问IP</td>\n" +
//		        "  <td>" + userIp +
//		        "  </td></tr>\n" +
//
//		        "<tr>\n" +
//		        "  <td>用户 ID</td>\n" +
//		        "  <td>" + userID +
//		        "  </td></tr>\n" +
//		        "<tr>\n" +
//		        "  <td>访问统计：</td>\n" +
//		        "  <td>" + visitCount + "</td></tr>\n" +
//		        "</table>\n" +
//		        "</body></html>");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/SessionTrack.jsp");
        dispatcher .forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/SessionTrack.jsp");
//        dispatcher .forward(request, response);
		doGet(request, response);
	}

}
