package com.pj224.app.dto;

public class MypageDTO {
//	   MEMBER_NUMBER NUMBER PRIMARY KEY,
//	   MEMBER_EMAIL VARCHAR2(1000) NOT NULL CONSTRAINT UK_EMAIL UNIQUE,
//	   MEMBER_PW VARCHAR2(1000) NOT NULL,
//	   MEMBER_NAME VARCHAR2(1000) NOT NULL,
//	   MEMBER_NICKNAME VARCHAR2(1000) NOT NULL,
//	   MEMBER_PHONE VARCHAR2(1000) NOT NULL,
//	   MEMBER_PHONE_INPUT VARCHAR2(1000) NULL,
//	   MEMBER_GENDER CHAR(1) DEFAULT NULL,
//	   MEMBER_BIRTH DATE NOT NULL,
//	   MEMBER_TERMS CHAR(1) NOT NULL
	
		private int memberNumber;
		private String memberEmail;
		private String memberPw;
		private String memberName;
		private String memberNickname;
		private String memberPhone;
		private String memberPhoneInput;
		private String memberGender;
		private String memberBirth;
		private String memberTerms;
		
		private String boardCate;
		private String boardTitle;
		private String boardRegistDate;
		
		
		
		
		public int getMemberNumber() {
			return memberNumber;
		}
		public void setMemberNumber(int memberNumber) {
			this.memberNumber = memberNumber;
		}
		public String getMemberEmail() {
			return memberEmail;
		}
		public void setMemberEmail(String memberEmail) {
			this.memberEmail = memberEmail;
		}
		public String getMemberPw() {
			return memberPw;
		}
		public void setMemberPw(String memberPw) {
			this.memberPw = memberPw;
		}
		public String getMemberName() {
			return memberName;
		}
		public void setMemberName(String memberName) {
			this.memberName = memberName;
		}
		public String getmemberNickname() {
			return memberNickname;
		}
		public void setmemberNickname(String memberNickname) {
			this.memberNickname = memberNickname;
			
		}
		public String getMemberPhone() {
			return memberPhone;
		}
		public void setMemberPhone(String memberPhone) {
			this.memberPhone = memberPhone;
		}
		public String getMemberPhoneInput() {
			return memberPhoneInput;
		}
		public void setMemberPhoneInput(String memberPhoneInput) {
			this.memberPhoneInput = memberPhoneInput;
		}
		public String getMemberGender() {
			return memberGender;
		}
		public void setMemberGender(String memberGender) {
			this.memberGender = memberGender;
		}
		public String getMemberBirth() {
			return memberBirth;
		}
		public void setMemberBirth(String memberBirth) {
			this.memberBirth = memberBirth;
		}
		public String getMemberTerms() {
			return memberTerms;
		}
		public void setMemberTerms(String memberTerms) {
			this.memberTerms = memberTerms;
		}
		
		public String getMemberNickname() {
			return memberNickname;
		}
		public void setMemberNickname(String memberNickname) {
			this.memberNickname = memberNickname;
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
		public String getBoardRegistDate() {
			return boardRegistDate;
		}
		public void setBoardRegistDate(String boardRegistDate) {
			this.boardRegistDate = boardRegistDate;
		}
		
		@Override
		public String toString() {
			return "mypageDTO = [memberNumber : " + memberNumber + ",memberEmail : " + memberEmail + ",memberPw : " + memberPw + 
					",memberName : " + memberName + "memberNickname : " + memberNickname + "memberPhone : " + memberPhone + "memberPhoneInput : " + memberPhoneInput 
					+"memberGender : " + memberGender + "memberBirth : " + memberBirth + "memberTerms : " + memberTerms + "]";
		}

}
