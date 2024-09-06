package com.pj224.app.dto;

public class LikeDTO {
    private int hotplaceNumber;
    private int memberNumber;

    public LikeDTO(int hotplaceNumber, int memberNumber) {
        this.hotplaceNumber = hotplaceNumber;
        this.memberNumber = memberNumber;
    }

    public LikeDTO() {
		// TODO Auto-generated constructor stub
	}

	// getter와 setter 추가
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

	@Override
	public String toString() {
		return "LikeDTO [hotplaceNumber=" + hotplaceNumber + ", memberNumber=" + memberNumber + "]";
	}
    
    
}
