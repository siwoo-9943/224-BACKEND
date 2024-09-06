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
	

}
