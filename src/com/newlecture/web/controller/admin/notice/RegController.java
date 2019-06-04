package com.newlecture.web.controller.admin.notice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.dao.oracle.OracleNoitceDao;
import com.newlecture.web.dao.oracle.OracleNoticeFileDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeFile;

@WebServlet("/admin/notice/reg")
//이것을 안하면 타이틀이 안읽어짐.
@MultipartConfig(location = "D:\\temp", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, // 5메가
		maxRequestSize = 1024 * 1024 * 5 * 5 // 5메가 5개까지
)

public class RegController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//req.setCharacterEncoding("UTF-8");// 입력 한글깨짐 방지, 필터에다가 사전에 실행.
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		//Integer id = Integer.parseInt(req.getParameter("id"));
//		String file = req.getParameter("file");
//		System.out.println(title);
		//D:\html5-1902
		Part filePart = req.getPart("file");
		//1.업로드 경로를 얻기
		String urlPath = "/upload";
		String path = req.getServletContext().getRealPath(urlPath);
		
		System.out.println(path);
		
		//2. 업로드된 파일명 얻기
		String fileName = filePart.getSubmittedFileName();
		
		//3. 경로구분자
		String filePath = path+File.separator+fileName; //File.separator-> "\\"
		System.out.println(filePath);
		
		//4. 경로가 없다는 오류 문제
		File pathFile = new File(path);
		if(!pathFile.exists())//존재하지 않으면
			pathFile.mkdirs();//생성해주세요
			
		//5. 동일한 파일명에 경로에 이미 존재하는 문제 aa.jpg->aa(1).jpg
//		File ? = new File(?);
//		
//		if(?존재한다면) {
//			꼬리(확장자)를 잘라낸 이름을 얻고 그 마지막에 소괄호()가 있는지 확인하고 있으면 번호를 알아내고 1증가된 값을 얻어서 fileName=?;
//		}
//		
		
//		규석오빠 코드
		File sameFile = new File(fileName);
		if (sameFile.exists()) {

			int n = fileName.lastIndexOf(".");
			String name = fileName.substring(0, n);
			String suffix = fileName.substring(n);

			int parenS = name.lastIndexOf("(");
			int parenE = name.lastIndexOf(")");

			if (parenS == -1)
				fileName = name + "(" + 1 + ")" + suffix;

			else {
				String indexC = name.substring(parenS + 1, parenE);

				int indexN = Integer.parseInt(indexC);
				indexN++;
				fileName = fileName.substring(0, parenS + 1) + indexN + ")" + suffix;
			}
		}
		
		//진협이
//		String tempPath = "D:\\tools\\photo.jpg";
//	      FileInputStream fis = new FileInputStream(tempPath);
//	   
//	      
//	      String fileName="photo.jpg";
//	      
//	      int n = fileName.lastIndexOf(".");
//	      String name = fileName.substring(0, n);
//	      String suffix = fileName.substring(n);
//	      String path = "D:\\java";
//	      
//	      String filePath = path + File.separator + fileName;
//	      
//	      FileOutputStream fos;
//	      File file = new File(filePath);
//	      int index=1;
//
//	      
//	      while(file.exists()) {
//	         file = new File(String.format("%s\\%s(%d)%s", path,name,index,suffix));
//	         index++;
//	      }
//
//	      fos = new FileOutputStream(file);
//
//	      byte[] buf = new byte[1024];
//	      int size=0;
//	      while((size=fis.read(buf)) != -1) {
//	         fos.write(buf, 0, size);
//	      }
//	      System.out.println("작업완료");
//
//	      fos.close();
//	      fis.close();
			
		InputStream fis = filePart.getInputStream();
		FileOutputStream fos = new FileOutputStream("D:\\html5-1902\\a.txt");
		byte[] buf = new byte[1024];
		int size=0;
		while((size=fis.read(buf))!=-1) {
			fos.write(buf, 0, size);
		}
		
		fis.close();
		fos.close();
		
//		
//		try {
//			noticeDao.update(new Notice(id,title,content,"",null,0 ));
//			req.setAttribute("notice",noticeDao.get(id));
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		req.getRequestDispatcher("/WEB-INF/view/notice/reg.jsp").forward(req, resp);
//	}
	//선생님 풀이
    
	//NoticeDao noticeDao  = new OracleNoticeDao();
	      
		Notice notice = new Notice();
	//	notice.setId(id);
		notice.setTitle(title);
		notice.setContent(content);
		
		NoticeDao noticeDao = new OracleNoitceDao();
		NoticeFileDao noticeFileDao = new OracleNoticeFileDao();
		int result=0;
	try {
		 //Enterprise JavaBeans EJB ->트랜잭션처리 할수있는 것. 다오 대신 쓰는것. 복잡.
	      result= noticeDao.insert(notice);
	      int noticeId = noticeDao.getLastId();
	      
	      NoticeFile noticeFile = new NoticeFile();
	      //noticeFile.setId(?);
	      noticeFile.setName(fileName);
	      noticeFile.setNoticeId(noticeId);
	      
	      noticeFileDao.insert(noticeFile);
	      
	} catch (ClassNotFoundException | SQLException e) {
	      e.printStackTrace();
	}
	   
	      
	if(result !=1)
	   resp.sendRedirect("error");
	else
	  resp.sendRedirect("list1");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// NoticeDao noticeDao = new OracleNoitceDao();
		// req.setAttribute("notice",
		// noticeDao.get(Integer.parseInt(req.getParameter("id"))));
		req.getRequestDispatcher("/WEB-INF/view/notice/reg.jsp").forward(req, resp);
	}
}
