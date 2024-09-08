package com.pj224.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.pj224.app.dto.MainDTO;
import com.pj224.app.dto.MemberDTO;

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
	public List<MainDTO> searchInput(String inputsearch) {
	    System.out.println("검색어 DTO 입력: " + inputsearch);
	    MainDTO mainDTO = new MainDTO(inputsearch);
	    System.out.println(mainDTO);
	    List<MainDTO> results = sqlSession.selectList("searchmain.selectcm", mainDTO);
	    System.out.println("검색 결과: " + results);
	    System.out.println(mainDTO);
	    return results;
	}

	public List<MainDTO> searchPosts(String searchInput) {
		System.out.println("searchPosts");
		return sqlSession.selectList("main.selectcm", searchInput);
	}

	public List<MainDTO> searchInfo(String inputsearch) {
		System.out.println("searchInfo");
		System.out.println("DAO 검색어 : " + inputsearch);
		return sqlSession.selectList("main.selectcm", inputsearch);
	}

	public List<MainDTO> searchList() {
		System.out.println("검색결과");
		List<MainDTO> list = null;
		System.out.println(list);
		list = sqlSession.selectList("main.selectcm");

		return list;
	}
	
	public List<MainDTO> maincomulist() {
		System.out.println("maincomulist");
		return sqlSession.selectList("main.cmlist");
	}

}
