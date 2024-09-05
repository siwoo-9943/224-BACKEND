package com.pj224.app.dao;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.pj224.app.dto.NoticeDTO;

public class NoticeDAO {
	private SqlSession sqlSession;

	public NoticeDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	public void write(NoticeDTO noticeDTO) {
		sqlSession.insert("notice.write", noticeDTO);
	}

	public boolean checkId(String memberId) {
		// selectOne() 반환타입 Object 타입이라 비교를 위해 Interger로 형 변환
		// DB에서 memberId가 존재하는지 확인하는 쿼리를 실행하고
		// 존재하면 true, 존재하지 않으면 false를 반환하도록 한다
		return (Integer) sqlSession.selectOne("member.checkId", memberId) <= 0;
		// 값이 0이하면 아이디가 존재하지 않음 => true 반환
		// 아이디가 존재하면 false 반환
	}

	// 쿠키/세션
//	public MemberDTO login(String memberId, String memberPassword) {
//		MemberDTO memberDTO = new MemberDTO();
//		memberDTO.setMemberId(memberId);
//		memberDTO.setMemberPassword(memberPassword);
//
//		return sqlSession.selectOne("member.login", memberDTO);
//	}

}
