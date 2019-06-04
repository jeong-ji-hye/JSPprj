package com.newlecture.web.controller.admin.notice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.oracle.NoticeView;
import com.newlecture.web.dao.oracle.OracleNoitceDao;
import com.newlecture.web.entity.Notice;

@WebServlet("/admin/notice/list1")
public class ListController extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	int page = 1;
	String p_ = req.getParameter("p");
	if(p_!=null && !p_.equals(""))
		page = Integer.parseInt(p_);
	
	NoticeDao nd = new OracleNoitceDao();
	
	try {
		req.setAttribute("list",nd.getList(page));
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//forwarding ÁÖ¼Ò´Â?
	req.getRequestDispatcher("/WEB-INF/view/notice/list1.jsp").forward(req, resp);
}

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		
		NoticeDao nd = new OracleNoitceDao();
		Notice notice = nd.get(id);
		notice.setTitle(title);
		try {
			nd.update(notice);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.sendRedirect("list1");
	}
}
