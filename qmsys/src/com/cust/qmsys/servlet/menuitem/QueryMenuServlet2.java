package com.cust.qmsys.servlet.menuitem;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cust.qmsys.domain.Menuitem;
import com.cust.qmsys.service.menuitem.Add2DB;
import com.cust.qmsys.service.menuitem.AddForm;
import com.cust.qmsys.utils.WebUtils;

public class QueryMenuServlet2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		AddForm form = WebUtils.request2Bean(request, AddForm.class);
		boolean b = form.validate2();
		if(!b){
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/menu/querymenu.jsp").forward(request, response);
			return;
		}
		Menuitem menu = new Menuitem();
		WebUtils.copyBean(form, menu);
		try {
			if(Add2DB.query(menu)>0){//添加menu对象
				request.setAttribute("message", "修改成功");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
			}else{
				request.setAttribute("message", "更新失败");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
			}
		} catch(Exception e){
			request.setAttribute("message", "服务器出现未知异常");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
