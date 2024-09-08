package com.pj224.app.dto;

public class MainDTO {
	private String boardTitle;
	private int commentCount;
	private String boardContent;
	private String boardCate;
	private String boardRegistDate;
	private int recommendCount;
	private String searchInput;

	public MainDTO() {
		super();
	}
	
	public MainDTO(String searchInput) {
		super();
		this.searchInput = searchInput;
	}


	public String getSearchInput() {
		return searchInput;
	}

	public void setSearchInput(String searchInput) {
		this.searchInput = searchInput;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardCate() {
		return boardCate;
	}

	public void setBoardCate(String boardCate) {
		this.boardCate = boardCate;
	}

	public String getBoardRegistDate() {
		return boardRegistDate;
	}

	public void setBoardRegistDate(String boardRegistDate) {
		this.boardRegistDate = boardRegistDate;
	}

	public int getRecommendCount() {
		return recommendCount;
	}

	public void setRecommendCount(int recommendCount) {
		this.recommendCount = recommendCount;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MainDTO [input : " + searchInput + "]\n [boardTitle : " + boardTitle + " commentCount : " + commentCount + 
				" boardContent : " + boardContent + " boardCate : " + boardCate + " boardRegistDate : " + boardRegistDate +
				" recommendCount : " + recommendCount;
		
	}

}
