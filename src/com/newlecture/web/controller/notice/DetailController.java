package com.newlecture.web.controller.notice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.dao.oracle.OracleNoitceDao;
import com.newlecture.web.dao.oracle.OracleNoticeFileDao;

@WebServlet("/notice/detail")
public class DetailController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NoticeDao noticeDao = new OracleNoitceDao();
		NoticeFileDao noticeFileDao = new OracleNoticeFileDao();
		
		try {
			req.setAttribute("noticeFiles", noticeFileDao.getListByNoticeId(Integer.parseInt(req.getParameter("id"))));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("notice",noticeDao.get(Integer.parseInt(req.getParameter("id"))));
		req.setAttribute("prev",noticeDao.getPrev(Integer.parseInt(req.getParameter("id"))));
		req.setAttribute("next",noticeDao.getNext(Integer.parseInt(req.getParameter("id"))));
		req.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").forward(req, resp);
	}
}
