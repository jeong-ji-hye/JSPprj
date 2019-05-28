package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��Ÿ���̶�. ��Ĺ�� ������ ���־���� ��Ĺ���� ����Ǵϱ� ������ ��Ÿ�ӽ����� ��Ĺ�̾�
//�̰��� ������ ������������. ��Ÿ������ ���ø�Ʈ false�� �ٲ�. �����ܺ����� ���� �ּ����� �ϴ°�.
@WebServlet("/hello")
public class Nana extends HttpServlet{
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//request�Է� response���
	//����� UTF-8�� ����
	response.setCharacterEncoding("UTF-8");
	//�ؼ��Ⱑ ������ ��� �о�� �ϴ��� �˷��ش�. ���������� �̰ŷ� �ν��ض�.
	response.setContentType("text/html; charset=UTF-8");
	
	// /hello?cnt=3
	// /hello? -> null
	// /hello -> null
	String cnt_ = request.getParameter("cnt");//�ӽú��� ���
	Integer cnt = 0;//�ʱⰪ ����
	
	if(cnt_!=null)
		cnt= Integer.parseInt(cnt_);
	
	//	response.getOutputStream();//����
	PrintWriter out = response.getWriter();//txt���� �ҷ����� �о����
	//ũ���� �׳� �ؽ�Ʈ������ �ν� �ٸ� ���������� �������� �ν�.
	for(int i=0; i<cnt; i++)
		out.println("Welcome Ȩ!!<br >");
}
}
