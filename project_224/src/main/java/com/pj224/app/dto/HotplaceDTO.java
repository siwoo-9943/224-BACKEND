package com.pj224.app.dto;

public class HotplaceDTO {
	private int hotplaceNumber;
	private String hotplaceStation;
	private String hotplaceTitle;
	private String hotplaceHours;
	private String hotplaceAddress;
	private String hotplaceLink;
	private int hotplaceRestNumber; // REST 번호
	private int hotplaceAttractionNumber; // ATTRACTION 번호
	private String hotplaceRestCuisine; // 음식점 정보
	private String hotplaceRestMenu; // 음식점 정보
	private String hotplaceAttractionContent; // 관광 명소 정보

	public int getHotplaceNumber() {
		return hotplaceNumber;
	}

	public void setHotplaceNumber(int hotplaceNumber) {
		this.hotplaceNumber = hotplaceNumber;
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

	public String getHotplaceHours() {
		return hotplaceHours;
	}

	public void setHotplaceHours(String hotplaceHours) {
		this.hotplaceHours = hotplaceHours;
	}

	public String getHotplaceAddress() {
		return hotplaceAddress;
	}

	public void setHotplaceAddress(String hotplaceAddress) {
		this.hotplaceAddress = hotplaceAddress;
	}

	public String getHotplaceLink() {
		return hotplaceLink;
	}

	public void setHotplaceLink(String hotplaceLink) {
		this.hotplaceLink = hotplaceLink;
	}

	public String getHotplaceRestCuisine() {
		return hotplaceRestCuisine;
	}

	public void setHotplaceRestCuisine(String hotplaceRestCuisine) {
		this.hotplaceRestCuisine = hotplaceRestCuisine;
	}

	public String getHotplaceRestMenu() {
		return hotplaceRestMenu;
	}

	public void setHotplaceRestMenu(String hotplaceRestMenu) {
		this.hotplaceRestMenu = hotplaceRestMenu;
	}

	public String getHotplaceAttractionContent() {
		return hotplaceAttractionContent;
	}

	public void setHotplaceAttractionContent(String hotplaceAttractionContent) {
		this.hotplaceAttractionContent = hotplaceAttractionContent;
	}

	
	public int getHotplaceRestNumber() {
		return hotplaceRestNumber;
	}

	public void setHotplaceRestNumber(int hotplaceRestNumber) {
		this.hotplaceRestNumber = hotplaceRestNumber;
	}

	public int getHotplaceAttractionNumber() {
		return hotplaceAttractionNumber;
	}

	public void setHotplaceAttractionNumber(int hotplaceAttractionNumber) {
		this.hotplaceAttractionNumber = hotplaceAttractionNumber;
	}

	@Override
	public String toString() {
		return "HotplaceDTO [hotplaceNumber=" + hotplaceNumber + ", hotplaceStation=" + hotplaceStation
				+ ", hotplaceTitle=" + hotplaceTitle + ", hotplaceHours=" + hotplaceHours + ", hotplaceAddress="
				+ hotplaceAddress + ", hotplaceLink=" + hotplaceLink + ", hotplaceRestNumber=" + hotplaceRestNumber
				+ ", hotplaceAttractionNumber=" + hotplaceAttractionNumber + ", hotplaceRestCuisine="
				+ hotplaceRestCuisine + ", hotplaceRestMenu=" + hotplaceRestMenu + ", hotplaceAttractionContent="
				+ hotplaceAttractionContent + "]";
	}

	

}
