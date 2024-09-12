package com.pj224.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.pj224.app.Result;
import com.pj224.app.dto.LikeDTO;
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
	
//	검색 핫플레이스
	public List<MainDTO> searchnoInfo(String inputsearch) {
		System.out.println("searchInfo");
		System.out.println("DAO 검색어 : " + inputsearch);
		return sqlSession.selectList("main.selectno", inputsearch);
	}
	
	public List<MainDTO> searchnoList() {
		System.out.println("검색결과");
		List<MainDTO> list = null;
		System.out.println(list);
		list = sqlSession.selectList("main.selectno");
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
	
	// 찜 체크
    public List<MainDTO> likeCheck(int memberNumber) {
    	System.out.println("회원번호 : " + memberNumber);
        return sqlSession.selectList("main.likecheck" , memberNumber);
    }

    // 찜하기
    public void pickHotplace(MainDTO mainDTO) {
    	System.out.println("찜하기DAO");
    	System.out.println(mainDTO);
        sqlSession.insert("main.pickhp", mainDTO);
    }

    // 찜 풀기
    public void unpickHotplace(MainDTO mainDTO) {
    	System.out.println("찜풀기DAO");
    	System.out.println(mainDTO);
        sqlSession.delete("main.unpickhp", mainDTO);
    }

}
