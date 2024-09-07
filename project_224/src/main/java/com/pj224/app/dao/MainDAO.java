package com.pj224.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.pj224.app.dto.MainDTO;
import com.pj224.app.dto.MemberDTO;
import com.pj224.app.dto.NoticeDTO;

public class MainDAO {
	private SqlSession sqlSession;

	public MainDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	public void join(MemberDTO memberDTO) {
		sqlSession.insert("member.join", memberDTO);
	}

	// 쿠키 세션
	public MemberDTO login(String memberId, String memberPw) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMemberEmail(memberId);
		memberDTO.setMemberPw(memberPw);
		return sqlSession.selectOne("member.login", memberDTO);
	}

	// 검색-커뮤니티
//	public List<String> SearchInputResult(String search) {
//		String inputSearch = search;
//		System.out.println(inputSearch);
//		return sqlSession.selectList("mainsearch.selectcm");
//	}
	
	public List<MainDTO> searchList() {
        List<MainDTO> list = null;
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession()) {
            list = sqlSession.selectList("mainsearch.selectcm");
        }
        return list;
    }

	
	public List<MainDTO> searchInput(String inputsearch) {
	    MainDTO mainDTO = new MainDTO();
	    mainDTO.setSearchInput(inputsearch);
	    return sqlSession.selectList("main.selectcm", mainDTO);
	}
	
	public void select(MemberDTO memberDTO) {
//		sqlSession.select("mainsearch", memberDTO);
		sqlSession.selectList("mainsearch.selectcm", memberDTO);
	}


}
