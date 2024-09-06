package com.pj224.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.pj224.app.dto.NoticeDTO;
public class NoticeDAO {
    private SqlSession sqlSession;

    public NoticeDAO() {
    	sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
    }

    public List<NoticeDTO> showList() {
        List<NoticeDTO> list = null;
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession()) {
            list = sqlSession.selectList("notice.showList");
        }
        return list;
    }

    public NoticeDTO showDetail() {
        NoticeDTO detail = null;
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession()) {
            detail = sqlSession.selectOne("notice.showDetail");
        }
        return detail;
    }

    public void write(NoticeDTO noticeDTO) {
        sqlSession.insert("notice.write", noticeDTO);
        sqlSession.commit();  
        // INSERT/UPDATE/DELETE 후에는 commit 필요
    }
}
