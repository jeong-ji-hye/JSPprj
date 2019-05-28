package com.newlecture.web.admin.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/member/list") // 어노테이션
public class ListControler extends HttpServlet {// http://server/admin/member/list
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//	PrintWriter out = resp.getWriter();
//	out.write("hello");
		// super.service(req, resp);

		List<Map<String, String>> members = new ArrayList<>();
		/* List members = new ArrayList<>(); */
		Map<String, String> member;

		member = new HashMap<>();
		member.put("id", "dragon");
		member.put("name", "손오공");
		members.add(member);

		member = new HashMap<>();
		member.put("id", "moon");
		member.put("name", "문재인");
		members.add(member);
		//공유저장공간= 상태저장공간
		// application(모든사용자가 공유할수있는), session(로그인하는 동안에 사용하는 저장소,한 사용자에게만 ), request(포워드관계에서만) 공유를 위해 사용할수있는 저장공간
		req.setAttribute("members", members);// members라는 키워드로 상대편에서 쓸수있음.
		
		//저장소객체 = 공유저장소 = application/ session/ request/ page
		//EL-> MVC를 지향하는 방법론에서 View에서 저장소로 객체로부터 데이터를 쉽게꺼내고 쉽게 출력하게하는 언어
		req.setAttribute("x", 10);
		req.setAttribute("member", member);
		req.setAttribute("y", new int[]{3,4,5});
		
		req.getRequestDispatcher("list.jsp").forward(req, resp);
	}
}
