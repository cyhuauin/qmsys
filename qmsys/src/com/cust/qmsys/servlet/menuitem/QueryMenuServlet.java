package com.cust.qmsys.servlet.menuitem;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cust.qmsys.dao.menuitem.impl.MenuitemDaoImpl;
import com.cust.qmsys.domain.Menuitem;

public class QueryMenuServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String str = request.getParameter("menu");
		MenuitemDaoImpl mdi = new MenuitemDaoImpl();
		Menuitem menu = mdi.getMenuBytoString(str);
		request.setAttribute("menu", menu);
		if(menu.getParentid() == 0){
			request.setAttribute("message", "0不能被修改");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/menu/querymenu.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
