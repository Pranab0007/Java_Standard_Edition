package com.library.beans;

public class Book {
	private String bookTitle;
	private String authorName;
	private double price;
	private int numberOfCopies;
	public Book(String bookTitle,String authorName) {
	
		this.bookTitle = bookTitle;
		this.authorName = authorName;
		this.price =0.0;
		this.numberOfCopies = 0;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	public double getPrice() {
		return price;
	}
	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies=numberOfCopies;
	}
	public int getNumberOfCopies() {
		return numberOfCopies;
	}
}
