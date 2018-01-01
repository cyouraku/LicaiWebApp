package com.servlet.testing;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.costuary.bean.WebInputBean;

/**
 * Servlet implementation class CostuaryMenuServlet
 */
@WebServlet("/CostuaryMenuServlet")
public class CostuaryMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CostuaryMenuServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("typeId", "1");
		request.setAttribute("currencyId", "102");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/CostuaryMenu.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		WebInputBean inputBean = (WebInputBean)session.getAttribute("inputBean");
		String subcatId = (String)request.getParameter("SUBCAT_ID");
		inputBean.setSubcatId(subcatId);
		session.setAttribute("inputBean", inputBean);
		//debug:
		System.out.println("debug typeId: " + inputBean.getTypeId());
		System.out.println("debug currencyId: " + inputBean.getCurrencyId());
		System.out.println("debug subcatId: " + inputBean.getSubcatId());

		RequestDispatcher dispatcher = request.getRequestDispatcher("/InsertExpense.jsp");
		dispatcher.forward(request, response);
	}

}
