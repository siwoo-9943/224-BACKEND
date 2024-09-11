package com.pj224.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import com.mybatis.config.MyBatisConfig;
import com.pj224.app.dto.CommentDTO;
import com.pj224.app.dto.CommunityDTO;
import com.pj224.app.dto.MemberDTO;
import com.pj224.app.dto.RecommendDTO;

public class CommunityDAO {
    private SqlSession sqlSession;

    public CommunityDAO() {
        sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(false);
    }

    public List<CommunityDTO> selectAll() {
        try {
            List<CommunityDTO> result = sqlSession.selectList("community.selectAll");
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
            throw e;
        }
    }

    // 페이지네이션을 위한 새로운 메소드
    public List<CommunityDTO> selectAllPaged(int start, int itemsPerPage) {
        try {
            Map<String, Integer> params = new HashMap<>();
            params.put("start", start);
            params.put("end", start + itemsPerPage);
            List<CommunityDTO> result = sqlSession.selectList("community.selectAllPaged", params);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
            throw e;
        }
    }

    // 전체 게시글 수를 가져오는 메소드
    public int getTotalCount() {
        try {
            int result = sqlSession.selectOne("community.getTotalCount");
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
            throw e;
        }
    }

    public void insert(CommunityDTO communityDTO) {
        try {
            sqlSession.insert("community.insert", communityDTO);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
            throw e;
        }
    }

    public CommunityDTO comudetail(CommunityDTO communityDTO) {
        try {
            CommunityDTO detail = sqlSession.selectOne("community.comudetail", communityDTO);
            sqlSession.commit();
            return detail;
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
            throw e;
        }
    }

    public void update(CommunityDTO communityDTO) {
        try {
            sqlSession.update("community.update", communityDTO);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
            throw e;
        }
    }

    public CommunityDTO getCommunityByBoardNumber(int boardNumber) {
        try {
            CommunityDTO result = sqlSession.selectOne("community.selectByBoardNumber", boardNumber);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
            throw e;
        }
    }

    public void deleteCommentsByBoardNumber(int boardNumber) {
        try {
            sqlSession.delete("community.deleteCommentsByBoardNumber", boardNumber);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
            throw e;
        }
    }

    public void deleteByBoardNumber(int boardNumber) {
        try {
            deleteCommentsByBoardNumber(boardNumber);
            sqlSession.delete("community.deleteRecommendByBoardNumber", boardNumber);
            sqlSession.delete("community.deleteByBoardNumber", boardNumber);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
            throw e;
        }
    }

    public List<CommentDTO> commentList(int boardNumber) {
        try {
            List<CommentDTO> result = sqlSession.selectList("community.commentList", boardNumber);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
            throw e;
        }
    }

    public List<MemberDTO> memberList() {
        try {
            List<MemberDTO> result = sqlSession.selectList("community.memberList");
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
            throw e;
        }
    }

    public void commentUpdate(CommentDTO commentDTO) {
        try {
            sqlSession.update("community.commentUpdate", commentDTO);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
            throw e;
        }
    }

    public void deleteByCommentNumber(int commentNumber) {
        try {
            sqlSession.delete("community.deleteByCommentNumber", commentNumber);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
            throw e;
        }
    }

    public void insertComment(CommentDTO commentDTO) {
        try {
            sqlSession.insert("community.insertComment", commentDTO);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
            throw e;
        }
    }

    public List<RecommendDTO> checkRecommend(int memberNumber) {
        try {
            RecommendDTO recommendDTO = new RecommendDTO();
            recommendDTO.setMemberNumber(memberNumber);
            List<RecommendDTO> result = sqlSession.selectList("community.checkRecommend", recommendDTO);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
            throw e;
        }
    }

    public void pickRecommend(RecommendDTO recommendDTO) {
        try {
            sqlSession.insert("community.pickRecommend", recommendDTO);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
            throw e;
        }
    }

    public boolean hasAlreadyRecommended(int boardNumber, int memberNumber) {
        try {
            Map<String, Integer> params = new HashMap<>();
            params.put("boardNumber", boardNumber);
            params.put("memberNumber", memberNumber);
            Integer result = sqlSession.selectOne("community.hasAlreadyRecommended", params);
            sqlSession.commit();
            return result != null && result > 0;
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
            throw e;
        }
    }

    public int getRecommendCount(int boardNumber) {
        try {
            int result = sqlSession.selectOne("community.getRecommendCount", boardNumber);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
            throw e;
        }
    }

    public void close() {
        if (sqlSession != null) {
            try {
                sqlSession.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}