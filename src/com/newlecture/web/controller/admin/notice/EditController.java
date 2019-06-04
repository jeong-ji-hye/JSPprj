package com.newlecture.web.controller.admin.notice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.oracle.OracleNoitceDao;
import com.newlecture.web.entity.Notice;

@WebServlet("/admin/notice/edit")
public class EditController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("UTF-8");// 입력 한글깨짐 방지, 필터에다가 사전에 실행.
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		Integer id = Integer.parseInt(req.getParameter("id"));
		
		NoticeDao noticeDao = new OracleNoitceDao();
		
		try {
			noticeDao.update(new Notice(id,title,content,"",null,0 ));
			req.setAttribute("notice",noticeDao.get(id));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").forward(req, resp);
	}
	//선생님 풀이
    
	//NoticeDao noticeDao  = new OracleNoticeDao();
//	      
	//try {
//	      noticeDao.update(new Notice(id,title,content,"",null,0));
//	      request.setAttribute("notice",noticeDao.get(id));
	//} catch (ClassNotFoundException | SQLException e) {
//	      e.printStackTrace();
	//}
	      
	//Notice notice = new Notice();
	//notice.setId(id);
	//notice.setTitle(title);
	//notice.setContent(content);
	      
	//int result=0;
	//if(result !=1)
	//   response.sendRedirect("error");
	//else
	//   response.sendRedirect("detail?id="+id);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NoticeDao noticeDao = new OracleNoitceDao();
		req.setAttribute("notice",noticeDao.get(Integer.parseInt(req.getParameter("id"))));
		req.getRequestDispatcher("/WEB-INF/view/notice/edit.jsp").forward(req, resp);
	}
}
