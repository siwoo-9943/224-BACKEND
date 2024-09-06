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
        try {
            list = sqlSession.selectList("notice.showList");
        } finally {
            sqlSession.close();
        }
        return list;
    }
    
    public List<NoticeDTO> showDetail() {
        List<NoticeDTO> detail = null;
        try {
        	detail = sqlSession.selectList("notice.showDetail");
        } finally {
            sqlSession.close();
        }
        return detail;
    }

    public void write(NoticeDTO noticeDTO) {
        sqlSession.insert("notice.write", noticeDTO);
        sqlSession.commit();  
        // INSERT/UPDATE/DELETE 후에는 commit 필요
    }
}
