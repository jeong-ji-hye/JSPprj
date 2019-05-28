package com.newlecture.web.controller.notice;

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

@WebServlet("/notice/list1")
public class ListController extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	NoticeDao nd = new OracleNoitceDao();
	
	try {
		req.setAttribute("list",nd.getList());
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
}
