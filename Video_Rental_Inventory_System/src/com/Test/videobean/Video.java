package com.Test.videobean;

public class Video {
	private String videoName;
	private boolean chechout;
	private int rating;
	public Video(String Name) {
		super();
		videoName = Name;
	}
	public String getName() {
		return videoName;
	}
	public void doCheckout() {
		chechout=true;
	}
	public void doReturn() {
		chechout=false;
	}
	public void reciveRating(int rating) {
		this.rating=rating;
	}
	public int getRating(){
		return rating;
	}
	public boolean getCheckout() {
		return chechout;
	}
}
