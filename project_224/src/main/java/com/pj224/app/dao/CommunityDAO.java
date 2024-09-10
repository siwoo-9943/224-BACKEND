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

	public void deleteCommentsByBoardNumber(int boardNumber) {
		System.out.println("댓글 삭제됨?");
	    sqlSession.delete("community.deleteCommentsByBoardNumber", boardNumber);
	}
	
	public void deleteByBoardNumber(int boardNumber) {
		deleteCommentsByBoardNumber(boardNumber);
		sqlSession.delete("community.deleteRecommendByBoardNumber", boardNumber);
		sqlSession.delete("community.deleteByBoardNumber", boardNumber);
	}

	public List<CommentDTO> commentList(int boardNumber) {
		System.out.println("commutnityDAO - commentList");
		return sqlSession.selectList("community.commentList", boardNumber);
	}

	public List<MemberDTO> memberList() {
		System.out.println("commutnityDAO - memberList");
		return sqlSession.selectList("community.memberList");
	}

	public void commentUpdate(CommentDTO commentDTO) {
		System.out.println(commentDTO);
		sqlSession.update("community.commentUpdate", commentDTO);
	}

	public void deleteByCommentNumber(int commentNumber) {
		System.out.println("delete comment");
		sqlSession.delete("community.deleteByCommentNumber", commentNumber);
	}

	public void insertComment(CommentDTO commentDTO) {
		System.out.println("insert comment");
		sqlSession.insert("community.insertComment", commentDTO);
	}

	public List<RecommendDTO> checkRecommend(int memberNumber) {
		RecommendDTO recommendDTO = new RecommendDTO();
		recommendDTO.setMemberNumber(memberNumber);
		return sqlSession.selectList("community.checkRecommend", recommendDTO);
	}

	// 기존 메서드
	public void pickRecommend(RecommendDTO recommendDTO) {
		sqlSession.insert("community.pickRecommend", recommendDTO);
	}

	public boolean hasAlreadyRecommended(int boardNumber, int memberNumber) {
		Map<String, Integer> params = new HashMap<>();
		params.put("boardNumber", boardNumber);
		params.put("memberNumber", memberNumber);
		Integer result = sqlSession.selectOne("community.hasAlreadyRecommended", params);
		return result != null && result > 0;
	}

	public int getRecommendCount(int boardNumber) {
		return sqlSession.selectOne("community.getRecommendCount", boardNumber);
	}
	
}
