package com.cust.qmsys.servlet.menuitem;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cust.qmsys.domain.Menuitem;
import com.cust.qmsys.service.menuitem.Add2DB;
import com.cust.qmsys.service.menuitem.AddForm;
import com.cust.qmsys.service.menuitem.MenuitemExistException;
import com.cust.qmsys.utils.WebUtils;

public class AddMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		AddForm form = WebUtils.request2Bean(request, AddForm.class);
		boolean b = form.validate();
		if(!b){
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/menu/addmenu.jsp").forward(request, response);
			return;
		}
		Menuitem menu = new Menuitem();
		Add2DB add = new Add2DB();
		WebUtils.copyBean(form, menu);
		try {
			Add2DB.add(menu);//���menu����
			request.setAttribute("message", "��ӳɹ�");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (MenuitemExistException e) {
			form.getMap().put("name", "�˵����Ѵ���");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/menu/addmenu.jsp").forward(request, response);
			return;
		}catch(Exception e){
			request.setAttribute("message", "����������δ֪�쳣");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
	}


	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
