package com.pj224.app.dto;

public class MainDTO {
	private String boardTitle;
	private String boardContent;
	private String boardCate;
	private String boardRegistDate;
	private int commentCount;
	private int recommendCount;

	private int hotplaceNumber;
	private String hotplaceStation;
	private String hotplaceTitle;
	private int likecount;

	private String searchInput;
	private int memberNumber;
	private String memberNickname;

	public MainDTO() {
		super();
	}

	public int getHotplaceNumber() {
		return hotplaceNumber;
	}

	public void setHotplaceNumber(int hotplaceNumber) {
		this.hotplaceNumber = hotplaceNumber;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getHotplaceStation() {
		return hotplaceStation;
	}

	public void setHotplaceStation(String hotplaceStation) {
		this.hotplaceStation = hotplaceStation;
	}

	public String getHotplaceTitle() {
		return hotplaceTitle;
	}

	public void setHotplaceTitle(String hotplaceTitle) {
		this.hotplaceTitle = hotplaceTitle;
	}

	public int getLikecount() {
		return likecount;
	}

	public void setLikecount(int likecount) {
		this.likecount = likecount;
	}

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
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
		return "MainDTO [input : " + searchInput + "]\n [boardTitle : " + boardTitle + " commentCount : " + commentCount
				+ " boardContent : " + boardContent + " boardCate : " + boardCate + " boardRegistDate : "
				+ boardRegistDate + " recommendCount : " + recommendCount + " memberNickname : " + memberNickname
				+ " likecount : " + likecount + " hotplaceNumber : " + hotplaceNumber + " memberNumber : " + memberNumber;

	}

}
