package com.newlecture.web;

//get,post요청 둘다
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
	
	/*
	 * @Override protected void doGet(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException {
	 * response.setCharacterEncoding("UTF-8");
	 * response.setContentType("text/html; charset=UTF-8");
	 * 
	 * int result = 0;
	 * 
	 * String result_ = request.getParameter("result");
	 * 
	 * if(result_!= null) result = Integer.parseInt(result_);
	 * 
	 * PrintWriter out = response.getWriter();
	 * 
	 * out.write("<!DOCTYPE html>"); out.write("<html>"); out.write("<head>");
	 * out.write("<meta charset=\"UTF-8\">");
	 * out.write("<title>Insert title here</title>"); out.write("</head>");
	 * out.write("<body>"); out.write("<form action=\"add\" method=\"post\">");
	 * out.write("<div>"); out.write("<label>x : </label>");
	 * out.write("<input type=\"text\" name=\"x\" />"); out.write("</div>");
	 * out.write("<div>"); out.write("<label>y : </label>");
	 * out.write(" <input type=\"text\" name=\"y\" />"); out.write("</div>");
	 * out.write("<div>"); out.write("<input type=\"submit\" value=\"덧셈\" />");
	 * out.write("</div>"); out.write("<div>"); out.write("결과:"); out.printf("%d",
	 * result); out.write("</div>"); out.write("</form>"); out.write("</body>");
	 * out.write("</html>"); }
	 * 
	 * @Override protected void doPost(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException {
	 */
	/*
	 * String x_ = request.getParameter("x"); String y_ = request.getParameter("y");
	 * 
	 * Integer x = 0; Integer y = 0;
	 * 
	 * if (x_ != null) x = Integer.parseInt(x_); if (y_ != null) y =
	 * Integer.parseInt(y_);
	 * 
	 * int result = x + y;
	 * 
	 * //서버에서 다른 서블릿을 요청하는 방법 // 1. 리디렉트 redirect 클라이언트가 새로 요청한거처럼 취소하고 다시시작하는 느낌
	 * response.sendRedirect("add?result="+result); // 2. 포워드 forward 현재 작업했던것을 가지고
	 * 이어가는것 GET->GET, POST->POST 무한루프빠질수있음. post->get을 못해
	 * //request.getRequestDispatcher("add").forward(request, response); }
	 */
	
	/*
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// get일때 의미없고 post일때 의미있음.
		int result = 0;

		// requst.getMethod() 의 반환값 GET,POST로 반환.
		//equals 대상의 내용비교(순수의값), == 주소의값 비교
		if (request.getMethod().equals("POST")) {
			String x_ = request.getParameter("x");
			String y_ = request.getParameter("y");

			Integer x = 0;
			Integer y = 0;

			if (x_ != null)
				x = Integer.parseInt(x_);
			if (y_ != null)
				y = Integer.parseInt(y_);

			result = x + y;
		}
		PrintWriter out = response.getWriter();

		// 웹문서를 출력하기. 서블릿이 나에게 계산할 수 있는 폼을 준거야.
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<form action=\"add\" method=\"post\">");
		out.write("<div>");
		out.write("<label>x : </label>");
		out.write("<input type=\"text\" name=\"x\" />");
		out.write("</div>");
		out.write("<div>");
		out.write("<label>y : </label>");
		out.write(" <input type=\"text\" name=\"y\" />");
		out.write("</div>");
		out.write("<div>");
		out.write("<input type=\"submit\" value=\"덧셈\" />");
		out.write("</div>");
		out.write("<div>");
		out.write("결과:");
		out.printf("%d", result);
		out.write("</div>");
		out.write("</form>");
		out.write("</body>");
		out.write("</html>");
	}*/
}
