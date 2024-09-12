package com.pj224.app.dto;

public class SubwayDTO {
	
	private int stationNumber;
	private String stationName;
	private String arriveTime;
	private String leftTime;

	public SubwayDTO() {
		super();
	}

	public String getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}

	public String getLeftTime() {
		return leftTime;
	}

	public void setLeftTime(String leftTime) {
		this.leftTime = leftTime;
	}
	
	public int getStationNumber() {
		return stationNumber;
	}

	public void setStationNumber(int stationNumber) {
		this.stationNumber = stationNumber;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[SubWayDTO] stationNumber : " + stationNumber + " stationName : " + stationName + " arriveTime : " + arriveTime
				+ " leftTime : " + leftTime;
	}
	
	
}
