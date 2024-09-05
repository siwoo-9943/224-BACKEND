package com.pj224.app.dto;

public class CommunityDTO {

//	   BOARD_NUMBER NUMBER PRIMARY KEY,
//	   BOARD_CATE VARCHAR2(1000) NOT NULL,
//	   BOARD_TITLE VARCHAR2(1000) NOT NULL,
//	   BOARD_CONTENT VARCHAR2(1000) NOT NULL,
//	   BOARD_REGIST_DATE DATE DEFAULT SYSDATE,
//	   BOARD_UPDATE_DATE DATE DEFAULT SYSDATE,
//	   MEMBER_NUMBER NUMBER NOT NULL,  

	private int boardNumber;
	private String boardCate;
	private String boardTitle;
	private String boardContent;
	private String boardRegistDate;
	private String boardUpdateDate;
	private int memberNumber;
	private int recommendCount;
	private int commentCount;

	public int getBoardNumber() {
		return boardNumber;
	}

	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}

	public String getBoardCate() {
		return boardCate;
	}

	public void setBoardCate(String boardCate) {
		this.boardCate = boardCate;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardRegistDate() {
		return boardRegistDate;
	}

	public void setBoardRegistDate(String boardRegistDate) {
		this.boardRegistDate = boardRegistDate;
	}

	public String getBoardUpdateDate() {
		return boardUpdateDate;
	}

	public void setBoardUpdateDate(String boardUpdateDate) {
		this.boardUpdateDate = boardUpdateDate;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public int getRecommendCount() {
		return recommendCount;
	}

	public void setRecommendCount(int recommendCount) {
		this.recommendCount = recommendCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	@Override
	public String toString() {
		return "CommunityDTO [boardNumber=" + boardNumber + ", boardCate=" + boardCate + ", boardTitle=" + boardTitle
				+ ", boardContent=" + boardContent + ", boardRegistDate=" + boardRegistDate + ", boardUpdateDate="
				+ boardUpdateDate + ", memberNumber=" + memberNumber + ", recommendCount=" + recommendCount
				+ ", commentCount=" + commentCount + "]";
	}

}
