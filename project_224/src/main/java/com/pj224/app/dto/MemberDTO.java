package com.pj224.app.dto;

public class MemberDTO {
//			   MEMBER_NUMBER NUMBER PRIMARY KEY,
//			   MEMBER_EMAIL VARCHAR2(1000) NOT NULL CONSTRAINT UK_EMAIL UNIQUE,
//			   MEMBER_PW VARCHAR2(1000) NOT NULL,
//			   MEMBER_NAME VARCHAR2(1000) NOT NULL,
//			   MEMBER_NICKNAME VARCHAR2(1000) NOT NULL,
//			   MEMBER_PHONE VARCHAR2(1000) NOT NULL,
//			   MEMBER_PHONE_INPUT VARCHAR2(1000) NULL,
//			   MEMBER_GENDER CHAR(1) DEFAULT NULL,
//			   MEMBER_BIRTH DATE NOT NULL,
//			   MEMBER_TERMS CHAR(1) NOT NULL
	
	private int memberNumber;
	private String memberEmail;
	private String memberPw;
	private String memberName;
	private String memberNickname;
	private int memberPhone;
	private int memberPhoneInput;
	private String memberGender;
	private int memberBirth;
	private String memberTerms;
	
	//getter, setter
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
	public String getMemberNickname() {
		return memberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
	public int getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(int memberPhone) {
		this.memberPhone = memberPhone;
	}
	public int getMemberPhoneInput() {
		return memberPhoneInput;
	}
	public void setMemberPhoneInput(int memberPhoneInput) {
		this.memberPhoneInput = memberPhoneInput;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public int getMemberBirth() {
		return memberBirth;
	}
	public void setMemberBirth(int memberBirth) {
		this.memberBirth = memberBirth;
	}
	public String getMemberTerms() {
		return memberTerms;
	}
	public void setMemberTerms(String memberTerms) {
		this.memberTerms = memberTerms;
	}
	
	//오버라이드
	@Override
	public String toString() {
		return "MemberDTO [memberNumber = " + memberNumber + ", memberEmail = " + memberEmail + ", memberPw = " + memberPw +
				", memberName = " + memberName + ", memberNickname = " + memberNickname + ", memberPhone = " + memberPhone +
				", memberPhoneInput = " + memberPhoneInput + ", memberGender = " + memberGender + ", memberBrith = " + memberBirth + 
				", memberTerms = " + memberTerms + "]";
	}
	
	
	
	


}
