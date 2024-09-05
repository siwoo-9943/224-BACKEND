package com.pj224.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.pj224.app.dto.HotplaceDTO;
import com.pj224.app.dto.LikeDTO;

public class HotplaceDAO {
    private SqlSession sqlSession;

    public HotplaceDAO() {
        sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
    }

    // 핫플레이스 정보 조회 메소드
    public List<HotplaceDTO> showInfo(String station) {
        return sqlSession.selectList("hotplace.showInfo", station);
    }

    // 핫플레이스를 "pick"하는 메소드 추가
    public void pickHotplace(int hotplaceNumber, int memberNumber) {
        // 좋아요를 DB에 저장하는 SQL 호출
        sqlSession.insert("hotplace.pickHotplace", new LikeDTO(hotplaceNumber, memberNumber));
        sqlSession.commit();
    }
}
