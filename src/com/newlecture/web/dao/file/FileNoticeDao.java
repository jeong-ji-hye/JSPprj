package com.newlecture.web.dao.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;

public class FileNoticeDao implements NoticeDao {

	@Override
	public List<Notice> getList() {
		List<Notice> notices = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(
					"D:\\java\\workspace\\JSPPrj\\WebContent\\WEB-INF\\data\\notice-file.df");

			Scanner fscan = new Scanner(fis);
			String line = "";

			while (fscan.hasNextLine()) {
				line = fscan.nextLine();
				Notice notice = new Notice(line.split(","));
				notices.add(notice);
			}

			fscan.close();

			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return notices;
	}

	@Override
	public Notice get(int id) {
		Notice n = new Notice();
		List<Notice> notices = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(
					"D:\\java\\workspace\\JSPPrj\\WebContent\\WEB-INF\\data\\notice-file.df");
		Scanner fscan = new Scanner(fis);

		String line = "";

		

		//int id_ = Integer.parseInt(request.getParameter("id"));

		while (fscan.hasNextLine()) {
			line = fscan.nextLine();
			n = new Notice(line.split(","));
			notices.add(n);
		}

		fscan.close();
		fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//n = notices.get(3 - id_);
		return n;
	}

}
