package com.pj224.app.dto;

public class NoticeDTO {

//	   NOTICE_NUMBER NUMBER PRIMARY KEY,
//	   NOTICE_CATE VARCHAR2(1000) NOT NULL,
//	   NOTICE_TITLE VARCHAR2(1000) NOT NULL,
//	   NOTICE_CONTENT VARCHAR2(1000) NOT NULL,
//	   NOTICE_REGIST_DATE DATE DEFAULT SYSDATE,
//	   NOTICE_UPDATE_DATE DATE DEFAULT SYSDATE,
//	   MEMBER_NUMBER NUMBER NOT NULL,
//	   CHECK(NOTICE_CATE IN ('안내', '이벤트'))

	// DTO는 계층 간 데이터 전송을 목적으로 사용되는 객체입니다. 
	// 보통 네트워크 통신이나 메서드 호출 간에 데이터를 전달할 때 사용됩니다.
	
	private int noticeNumber;
	private String noticeCate;
	private String noticeTitle;
	private String noticeContent;
	private String noticeRegistDate;
	private String noticeUpdateDate;
	private int memberNumber;

	public int getNoticeNumber() {
		return noticeNumber;
	}

	public void setNoticeNumber(int noticeNumber) {
		this.noticeNumber = noticeNumber;
	}

	public String getNoticeCate() {
		return noticeCate;
	}

	public void setNoticeCate(String noticeCate) {
		this.noticeCate = noticeCate;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeRegistDate() {
		return noticeRegistDate;
	}

	public void setNoticeRegistDate(String noticeRegistDate) {
		this.noticeRegistDate = noticeRegistDate;
	}

	public String getNoticeUpdateDate() {
		return noticeUpdateDate;
	}

	public void setNoticeUpdateDate(String noticeUpdateDate) {
		this.noticeUpdateDate = noticeUpdateDate;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}


	@Override
	public String toString() {
		return "NoticeDTO [noticeNumber = " + noticeNumber + ", noticeCate = " + noticeCate + ", noticeTitle = "
				+ noticeTitle + ", noticeContent = " + noticeContent + ", noticeRegistDate = " + noticeRegistDate + ", noticeUpdateDate = "
				+ noticeUpdateDate + ", memberNumber = " + memberNumber + "]";
	}

}

