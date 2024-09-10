package com.pj224.app.dto;

public class RecommendDTO {
	private int boardNumber;
	private int memberNumber;

	public RecommendDTO(int boardNumber, int memberNumber) {
		super();
		this.boardNumber = boardNumber;
		this.memberNumber = memberNumber;
	}

	public RecommendDTO(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public RecommendDTO() {

	}

	public int getBoardNumber() {
		return boardNumber;
	}

	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	@Override
	public String toString() {
		return "RecommendDTO [boardNumber=" + boardNumber + ", memberNumber=" + memberNumber + "]";
	}

}
