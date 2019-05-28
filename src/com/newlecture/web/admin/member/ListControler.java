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

@WebServlet("/admin/member/list") // ������̼�
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
		member.put("name", "�տ���");
		members.add(member);

		member = new HashMap<>();
		member.put("id", "moon");
		member.put("name", "������");
		members.add(member);
		//�����������= �����������
		// application(������ڰ� �����Ҽ��ִ�), session(�α����ϴ� ���ȿ� ����ϴ� �����,�� ����ڿ��Ը� ), request(��������迡����) ������ ���� ����Ҽ��ִ� �������
		req.setAttribute("members", members);// members��� Ű����� ������� ��������.
		
		//����Ұ�ü = ��������� = application/ session/ request/ page
		//EL-> MVC�� �����ϴ� ����п��� View���� ����ҷ� ��ü�κ��� �����͸� ���Բ����� ���� ����ϰ��ϴ� ���
		req.setAttribute("x", 10);
		req.setAttribute("member", member);
		req.setAttribute("y", new int[]{3,4,5});
		
		req.getRequestDispatcher("list.jsp").forward(req, resp);
	}
}
