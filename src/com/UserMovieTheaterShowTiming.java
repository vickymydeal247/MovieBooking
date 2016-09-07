package com;

public class UserMovieTheaterShowTiming {
	
	private String userID;
	private String movieID;
	private String theaterID;
	private int showTime;
	private long mobile;
	private String date;
	public String getMovieID() {
		return movieID;
	}
	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}
	public String getTheaterID() {
		return theaterID;
	}
	public void setTheaterID(String theaterID) {
		this.theaterID = theaterID;
	}
	public int getShowTime() {
		return showTime;
	}
	public void setShowTime(int showTime) {
		this.showTime = showTime;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
