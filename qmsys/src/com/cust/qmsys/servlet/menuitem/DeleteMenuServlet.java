package com.cust.qmsys.servlet.menuitem;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cust.qmsys.dao.menuitem.impl.MenuitemDaoImpl;
import com.cust.qmsys.domain.Menuitem;
import com.cust.qmsys.service.menuitem.Add2DB;

public class DeleteMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Long mid = Long.parseLong(request.getParameter("mid"));
		MenuitemDaoImpl mdi = new MenuitemDaoImpl();
		if(mdi.isParent(mid)){//是父节点
			List<Menuitem> list = mdi.getChildMenuitemByMid(mid);//获取子节点
			for(int i = 0; i < list.size(); i++){//删除所有子节点
				Menuitem menu = list.get(i);
				Add2DB.del(menu.getMid());
			}
			Add2DB.del(mid);//删除父节点
			request.setAttribute("message", "成功删除");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}else{//子节点
			if(Add2DB.del(mid)>0){
				request.setAttribute("message", "成功删除");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
			}
			request.setAttribute("message", "删除失败");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
