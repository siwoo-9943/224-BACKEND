package com.pj224.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.pj224.app.dto.HotplaceDTO;

public class HotplaceDAO {
	private SqlSession sqlSession;
	
	public HotplaceDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
    public List<HotplaceDTO> showInfo(String station) {
        return sqlSession.selectList("hotplace.showInfo", station);
    }
}