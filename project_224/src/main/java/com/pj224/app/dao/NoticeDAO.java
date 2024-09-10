package com.pj224.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.pj224.app.dto.CommunityDTO;
import com.pj224.app.dto.LikeDTO;
import com.pj224.app.dto.NoticeDTO;

public class NoticeDAO {
	private SqlSession sqlSession;

	public NoticeDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	public List<NoticeDTO> showList() {
		List<NoticeDTO> list = null;
		list = sqlSession.selectList("notice.showList");
		return list;
	}

	public List<NoticeDTO> showDetail(String title) {
		return sqlSession.selectList("notice.showDetail", title);
	}
	
	public NoticeDTO noticedetail(NoticeDTO noticeDTO) {
		System.out.println("detailDAO 들어왔냐?");
		NoticeDTO detail = null;
		try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession()) {
			detail = sqlSession.selectOne("notice.noticedetail", noticeDTO);
		}
		return detail;
	}
	
	public void write(NoticeDTO noticeDTO) {
		sqlSession.insert("notice.write", noticeDTO);
		System.out.println("글쓰기" + noticeDTO);
	}
	
	public NoticeDTO getNoitceByNoticeNumber(int noticeNumber) {
		return sqlSession.selectOne("notice.selectByNoticeNumber", noticeNumber);
	}
	
	public void delete(int noticeNumber) {
		sqlSession.delete("notice.noticeDelete", noticeNumber);
	}


}
