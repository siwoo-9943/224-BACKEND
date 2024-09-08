package com.pj224.app.dto;

public class CommentDTO {
//	COMMENT_NUMBER NUMBER PRIMARY KEY,
//	COMMENT_CONTENT VARCHAR2(1000) NOT NULL,
//	COMMENT_REGIST_DATE DATE NOT NULL,
//	COMMENT_UPDATE_DATE DATE NOT NULL,
//	BOARD_NUMBER NUMBER NOT NULL,
//	MEMBER_NUMBER NUMBER NOT NULL
	
	private int commentNumber;
	private String commentContent;
	private String commentRegistDate;
	private String commentUpdateDate;
	private int BoardNumber;
	private int memberNumber;
	
	public int getCommentNumber() {
		return commentNumber;
	}
	public void setCommentNumber(int commentNumber) {
		this.commentNumber = commentNumber;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getCommentRegistDate() {
		return commentRegistDate;
	}
	public void setCommentRegistDate(String commentRegistDate) {
		this.commentRegistDate = commentRegistDate;
	}
	public String getCommentUpdateDate() {
		return commentUpdateDate;
	}
	public void setCommentUpdateDate(String commentUpdateDate) {
		this.commentUpdateDate = commentUpdateDate;
	}
	public int getBoardNumber() {
		return BoardNumber;
	}
	public void setBoardNumber(int boardNumber) {
		BoardNumber = boardNumber;
	}
	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	
	@Override
	public String toString() {
		return "CommentDTO [commentNumber=" + commentNumber + ", commentContent=" + commentContent
				+ ", commentRegistDate=" + commentRegistDate + ", commentUpdateDate=" + commentUpdateDate
				+ ", BoardNumber=" + BoardNumber + ", memberNumber=" + memberNumber + "]";
	}
	
	
}
