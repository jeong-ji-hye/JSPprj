package com.newlecture.web.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.dao.oracle.OracleMemberDao;
import com.newlecture.web.entity.Member;

@WebServlet("/member/login")
public class LoginController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		Member member = null;
		//인증이라는 것을 해야한다 : 회원 테이블에 넘겨받은 정보가 있다면 인증에 성공
		//1.DB에서 id에 해당하는 회원데이터를 가져온다
		MemberDao memberDao = new OracleMemberDao();
		member = memberDao.get(id);
		//2.회원이 존재하지않는다면-로그인 페이지로 다시 복귀.. 대신 오류알림
		if(member==null)
			resp.sendRedirect("login?error=1");
		//3.회원이 존재하면서 비번이 일치하지 않는다면?-로그인 페이지로 다시 복귀.. 대신 오류알림
		else if(!member.getPwd().equals(pwd))
			resp.sendRedirect("login?error=1");
		else {
			HttpSession session = req.getSession();
			session.setAttribute("id", id);
			
			String returnURL = req.getParameter("return-url");
			
			if(returnURL != null)
				resp.sendRedirect(returnURL);
			else
				resp.sendRedirect("/index");
		}
	}
}
