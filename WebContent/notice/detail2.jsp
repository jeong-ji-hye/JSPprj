<%@page import="com.newlecture.web.dao.file.FileNoticeDao"%>
<%@page import="com.newlecture.web.dao.NoticeDao"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="com.newlecture.web.entity.Notice"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	NoticeDao noticeDao = new FileNoticeDao();
	Notice n = noticeDao.get(3);
	//Controler
   //MVC
   // Notice n = ?.getNotice(3);

   // Notice getNotice(int id){
   /* FileInputStream fis = new FileInputStream("D:\\java\\workspace\\JSPPrj\\WebContent\\WEB-INF\\data\\notice-file.df");
   Scanner fscan = new Scanner(fis);
   
   String line = "";
   
   //n이 model
   List<Notice> notices = new ArrayList<>();
   Notice n = new Notice();
   
   int id_ =Integer.parseInt(request.getParameter("id"));
   
   while(fscan.hasNextLine())
   { 
       line = fscan.nextLine();
    	n = new Notice(line.split(","));
    	notices.add(n);
    }
   
   fscan.close();
   fis.close();
   
   n = notices.get(3-id_); */
   //}
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>
</head>
<body>
	<h1>공지사항</h1>

	<table>
		<tr> <!-- 출력부분이 View -->
			<td>제목:</td>
			<td><%=n.getTitle() %></td>
		</tr>
		<tr>
			<td>작성자:</td>
			<td><%=n.getWriterId() %></td>
		</tr>
		<tr>
			<td>작성일</td>
			<td><%=n.getRegDate() %></td>
		</tr>
	</table>
</body>
</html>
