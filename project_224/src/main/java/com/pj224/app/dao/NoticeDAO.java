package com.pj224.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.pj224.app.dto.MemberDTO;
import com.pj224.app.dto.NoticeDTO;

public class NoticeDAO {
	private SqlSession sqlSession;

	public NoticeDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	public List<NoticeDTO> showList() {
		try {
			List<NoticeDTO> list = null;
			list = sqlSession.selectList("notice.showList");
			System.out.println("showlist");
			System.out.println(list);
			return list;
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw e;
		}
	}

	public List<NoticeDTO> showDetail(String number) {
		try {
			return sqlSession.selectList("notice.showDetail", number);
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw e;
		}
	}

	public void write(NoticeDTO noticeDTO) {
		try {
			sqlSession.insert("notice.write", noticeDTO);
			System.out.println("글쓰기" + noticeDTO);
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw e;
		}
	}

	public NoticeDTO getNoticeByNoticeNumber(int noticeNumber) {
		try {
			return sqlSession.selectOne("notice.selectByNoticeNumber", noticeNumber);
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw e;
		}
	}

	public void delete(int noticeNumber) {
		try {
			sqlSession.delete("notice.noticeDelete", noticeNumber);
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw e;
		}
	}

	public void update(NoticeDTO noticeDTO) {
		try {
			System.out.println("수정값");
			System.out.println("Title: " + noticeDTO.getNoticeTitle());
			System.out.println("Content: " + noticeDTO.getNoticeContent());
			System.out.println("Number: " + noticeDTO.getNoticeNumber());
			sqlSession.update("notice.update", noticeDTO);
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw e;
		}
	}

	public List<MemberDTO> memberList() {
		try {
			System.out.println("noticeDAO - memberList");
			return sqlSession.selectList("notice.memberList");
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw e;
		}
	}

}
