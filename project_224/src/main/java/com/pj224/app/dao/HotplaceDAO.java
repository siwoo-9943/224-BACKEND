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
    
    public List<LikeDTO> checkLike(int memberNumber, int hotplaceNumber){
    	LikeDTO likeDTO = new LikeDTO(memberNumber, hotplaceNumber);
    	return sqlSession.selectList("hotplace.checkLike", likeDTO);
    }
    
    public void pickHotplace(LikeDTO likeDTO) {
        sqlSession.insert("hotplace.pickHotplace", likeDTO);
    }
    
    public void unpickHotplace(LikeDTO likeDTO) {
    	sqlSession.delete("hotplace.unpickHotplace", likeDTO);
    }
}
