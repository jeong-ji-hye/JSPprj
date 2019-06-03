package com.newlecture.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.newlecture.web.dao.oracle.NoticeView;
import com.newlecture.web.entity.Notice;

public interface NoticeDao {

	List<NoticeView> getList() throws ClassNotFoundException, SQLException;
	List<NoticeView> getList(int page) throws ClassNotFoundException, SQLException;
	List<NoticeView> getList(int page, String field, String query) throws ClassNotFoundException, SQLException;
	
	Notice get(int id);
	Notice getPrev(int id);
	Notice getNext(int id);
	
	int insert(Notice notice) throws ClassNotFoundException, SQLException;
	int delete(int id) throws ClassNotFoundException, SQLException;
	int update(Notice notice) throws ClassNotFoundException, SQLException;
	int getLastId() throws ClassNotFoundException, SQLException;
}
