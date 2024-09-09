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
//	public List<MainDTO> searchhpInput(String inputsearch) {
//	    System.out.println("검색어 DTO 입력: " + inputsearch);
//	    MainDTO mainDTO = new MainDTO(inputsearch);
//	    System.out.println(mainDTO);
//	    List<MainDTO> results = sqlSession.selectList("searchmain.selectcm", mainDTO);
//	    System.out.println("검색 결과: " + results);
//	    System.out.println(mainDTO);
//	    return results;
//	}

//	public List<MainDTO> searchcmPosts(String searchInput) {
//		System.out.println("searchPosts");
//		return sqlSession.selectList("main.selectcm", searchInput);
//	}

//	검색 커뮤니티
	public List<MainDTO> searchcmInfo(String inputsearch) {
		System.out.println("searchInfo");
		System.out.println("DAO 검색어 : " + inputsearch);
		return sqlSession.selectList("main.selectcm", inputsearch);
	}

	public List<MainDTO> searchcmList() {
		System.out.println("검색결과");
		List<MainDTO> list = null;
		System.out.println(list);
		list = sqlSession.selectList("main.selectcm");
		return list;
	}
	
//	검색 핫플레이스
	public List<MainDTO> searchhpInfo(String inputsearch) {
		System.out.println("searchInfo");
		System.out.println("DAO 검색어 : " + inputsearch);
		return sqlSession.selectList("main.selecthp", inputsearch);
	}
	
	public List<MainDTO> searchhpList() {
		System.out.println("검색결과");
		List<MainDTO> list = null;
		System.out.println(list);
		list = sqlSession.selectList("main.selecthp");
		return list;
	}
	
//	메인페이지 커뮤니티 목록
	public List<MainDTO> maincomuList() {
		System.out.println("maincomulist");
		return sqlSession.selectList("main.cmlist");
	}
//	메인페이지 핫플 목록 1번째 줄
	public List<MainDTO> hpList1(){
		System.out.println("핫플 1번째 줄");
		return sqlSession.selectList("main.hplist1");
	}
//	메인페이지 핫플 목록 2번째 줄
	public List<MainDTO> hpList2(){
		System.out.println("핫플 2번째 줄");
		return sqlSession.selectList("main.hplist2");		
	}

}
