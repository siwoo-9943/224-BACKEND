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
      System.out.println("다오");
   }

   public List<NoticeDTO> showList() {
      List<NoticeDTO> list = null;
      list = sqlSession.selectList("notice.showList");
      System.out.println("showlist");
      System.out.println(list);
      return list;
   }

   public List<NoticeDTO> showDetail(String title) {
      return sqlSession.selectList("notice.showDetail", title);
   }
   

   public void write(NoticeDTO noticeDTO) {
      sqlSession.insert("notice.write", noticeDTO);
      System.out.println("글쓰기" + noticeDTO);
   }
   
   public NoticeDTO getNoticeByNoticeNumber(int noticeNumber) {
      return sqlSession.selectOne("notice.selectByNoticeNumber", noticeNumber);
   }
   
   public void delete(int noticeNumber) {
      sqlSession.delete("notice.noticeDelete", noticeNumber);
   }

	public void update(NoticeDTO noticeDTO) {
		System.out.println("수정값");
	    System.out.println("Title: " + noticeDTO.getNoticeTitle());
	    System.out.println("Content: " + noticeDTO.getNoticeContent());
	    System.out.println("Number: " + noticeDTO.getNoticeNumber());
		sqlSession.update("notice.update", noticeDTO);
	}


	public List<MemberDTO> memberList() {
		System.out.println("noticeDAO - memberList");
		return sqlSession.selectList("notice.memberList");
	}

}
