package com.newlecture.web.controller.notice;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/notice/list1-ajax")
public class ListAjaxController extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	int page = 1;
	String p_ = req.getParameter("p");
	if(p_!=null && !p_.equals(""))
		page = Integer.parseInt(p_);
	
	
	NoticeDao nd = new OracleNoitceDao();
	List<NoticeView> list = null;
	
	try {
		list=nd.getList(page);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	resp.setCharacterEncoding("UTF-8");
	resp.setContentType("text/html");//MIME json content type
	PrintWriter out = resp.getWriter();
	
	//°­»ç´Ô²¨
	StringBuilder json = new StringBuilder();
	json.append("[");
	
	for(int i=0; i<list.size(); i++) {
		Notice n = list.get(i);
		
		json.append("{");
		
		json.append(String.format("\"id\":%d,", n.getId()));
		json.append(String.format("\"title\":\"%s\",", n.getTitle()));
		json.append(String.format("\"regDate\":\"%s\",", n.getRegDate()));
		json.append(String.format("\"writerId\":\"%s\",", n.getWriterId()));
		json.append(String.format("\"hit\":%d", n.getHit()));
		
		json.append("}");
		
		if(i<list.size()-1)
			json.append(",");
	}
	json.append("]");
	
	//³»°¡ÇÑ°Å
//	String json = "[";
//	int indx=0;
//	for (NoticeView noticeView : list) {
//		String str = "{"+ "\"id\":"+noticeView.getId()+",\"title\":"+noticeView.getTitle()+",\"regdate\":"+noticeView.getRegDate()+
//					",\"writer_id\":"+noticeView.getWriterId()+",\"hit\":"+noticeView.getHit()+",\"comment_count\":"+noticeView.getCommentCount()+"}";
//		if(indx<list.size()-1) {
//			indx++;
//			str+=",";
//			
//		}
//		json+=str;
//	}
//	json+=	"]";
	
	out.write(json.toString());
}

}
