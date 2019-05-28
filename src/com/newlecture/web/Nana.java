package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//런타임이란. 톰캣이 실행이 되있어야지 톰캣에서 실행되니까 얘한테 런타임실행이 톰캣이야
//이것이 있으면 맵핑지워도됨. 메타데이터 컴플리트 false로 바꿈. 설정외부파일 말고 주석으로 하는것.
@WebServlet("/hello")
public class Nana extends HttpServlet{
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//request입력 response출력
	//출력을 UTF-8로 보냄
	response.setCharacterEncoding("UTF-8");
	//해석기가 읽을때 어떻게 읽어야 하는지 알려준다. 브라우저에게 이거로 인식해라.
	response.setContentType("text/html; charset=UTF-8");
	
	// /hello?cnt=3
	// /hello? -> null
	// /hello -> null
	String cnt_ = request.getParameter("cnt");//임시변수 사용
	Integer cnt = 0;//초기값 설정
	
	if(cnt_!=null)
		cnt= Integer.parseInt(cnt_);
	
	//	response.getOutputStream();//파일
	PrintWriter out = response.getWriter();//txt파일 불러오기 읽어오기
	//크롬은 그냥 텍스트문서로 인식 다른 웹브라우저는 웹문서로 인식.
	for(int i=0; i<cnt; i++)
		out.println("Welcome 홈!!<br >");
}
}
