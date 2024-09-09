package com.pj224.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.pj224.app.dto.CommunityDTO;

public class CommunityDAO {

	private SqlSession sqlSession;

	public CommunityDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	public List<CommunityDTO> selectAll() {
		System.out.println("여기로는 넘어감?");
		return sqlSession.selectList("community.selectAll");
	}

	
	
	
	public void insert(CommunityDTO communityDTO) {
		System.out.println("db에 값이 넘어갔느냐?");
		sqlSession.insert("community.insert", communityDTO);
	}

	public CommunityDTO comudetail(CommunityDTO communityDTO) {
		System.out.println("detailDAO 들어왔냐?");
		CommunityDTO detail = null;
		try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession()) {
			detail = sqlSession.selectOne("community.comudetail", communityDTO);
		}
		return detail;
	}

	public void update(CommunityDTO communityDTO) {
		System.out.println("수정값 넘어왔냐?");
		sqlSession.update("community.update", communityDTO);
	}

	public CommunityDTO getCommunityByBoardNumber(int boardNumber) {
		return sqlSession.selectOne("community.selectByBoardNumber", boardNumber);
	}

	public void deleteByBoardNumber(int boardNumber) {
		sqlSession.delete("community.deleteByBoardNumber", boardNumber);
	}

}
