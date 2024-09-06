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
	    return sqlSession.selectList("community.selectAll");
	}
	
	public void insert(CommunityDTO communityDTO) {
		sqlSession.insert("community.insert", communityDTO);
	}
	

}
