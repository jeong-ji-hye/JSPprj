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
//�̰��� ���ϸ� Ÿ��Ʋ�� ���о���.
@MultipartConfig(location = "D:\\temp", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, // 5�ް�
		maxRequestSize = 1024 * 1024 * 5 * 5 // 5�ް� 5������
)

public class RegController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//req.setCharacterEncoding("UTF-8");// �Է� �ѱ۱��� ����, ���Ϳ��ٰ� ������ ����.
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		//Integer id = Integer.parseInt(req.getParameter("id"));
//		String file = req.getParameter("file");
//		System.out.println(title);
		//D:\html5-1902
		Part filePart = req.getPart("file");
		//1.���ε� ��θ� ���
		String urlPath = "/upload";
		String path = req.getServletContext().getRealPath(urlPath);
		
		System.out.println(path);
		
		//2. ���ε�� ���ϸ� ���
		String fileName = filePart.getSubmittedFileName();
		
		//3. ��α�����
		String filePath = path+File.separator+fileName; //File.separator-> "\\"
		System.out.println(filePath);
		
		//4. ��ΰ� ���ٴ� ���� ����
		File pathFile = new File(path);
		if(!pathFile.exists())//�������� ������
			pathFile.mkdirs();//�������ּ���
			
		//5. ������ ���ϸ� ��ο� �̹� �����ϴ� ���� aa.jpg->aa(1).jpg
//		File ? = new File(?);
//		
//		if(?�����Ѵٸ�) {
//			����(Ȯ����)�� �߶� �̸��� ��� �� �������� �Ұ�ȣ()�� �ִ��� Ȯ���ϰ� ������ ��ȣ�� �˾Ƴ��� 1������ ���� �� fileName=?;
//		}
//		
		
//		�Լ����� �ڵ�
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
		
		//������
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
//	      System.out.println("�۾��Ϸ�");
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
	//������ Ǯ��
    
	//NoticeDao noticeDao  = new OracleNoticeDao();
	      
		Notice notice = new Notice();
	//	notice.setId(id);
		notice.setTitle(title);
		notice.setContent(content);
		
		NoticeDao noticeDao = new OracleNoitceDao();
		NoticeFileDao noticeFileDao = new OracleNoticeFileDao();
		int result=0;
	try {
		 //Enterprise JavaBeans EJB ->Ʈ�����ó�� �Ҽ��ִ� ��. �ٿ� ��� ���°�. ����.
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
