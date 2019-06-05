package com.newlecture.web.controller.notice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.oracle.NoticeView;
import com.newlecture.web.dao.oracle.OracleNoitceDao;
import com.newlecture.web.entity.Notice;

@WebServlet("/notice/list1")
public class ListController extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	int page = 1;
	String p_ = req.getParameter("p");
	if(p_!=null && !p_.equals(""))
		page = Integer.parseInt(p_);
	
	int count = 0;
	
	//��� �о����, ��Ⱑ �������̱� ������ �迭�� ��ƾ���.
	Cookie[] cookies = req.getCookies();
	for(int i=0; i<cookies.length; i++) 
		if(cookies[i].getName().equals("count")) {
			count = Integer.parseInt(cookies[i].getValue());
			System.out.println("cookie name:"+cookies[i].getName()+",value:"+cookies[i].getValue());
			count++;
			break;
		}
	
	//��Ű����
	Cookie cookie = new Cookie("count",String.valueOf(count));
	cookie.setMaxAge(10);//��Ű����� ���ʱ��� ������������
	cookie.setPath("/member/");//��Ű���� ������ url������
	resp.addCookie(cookie);
	
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
	//forwarding �ּҴ�?
	req.getRequestDispatcher("/WEB-INF/view/notice/list1.jsp").forward(req, resp);
}

}
