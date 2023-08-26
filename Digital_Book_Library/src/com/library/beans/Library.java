package com.library.beans;

import java.util.ArrayList;

public class Library {
	private ArrayList<Book> store;
	private boolean bool;
	public Library() {
		store = new ArrayList<>();
	}
	public void addBook(String bTitle,String aName,double bprice,int bCopies) {
		Book book  = new Book(bTitle,aName);
		book.setPrice(bprice);
		book.setNumberOfCopies(bCopies);
		store.add(book);
	}
//	public boolean removeBook(Book book) {
//		// This is given unnecessary....this is not in the problem statement.
//	}
	public boolean borrowBook(String str1) {
		if(store.size()==0) {
			System.out.println("No book is available, store is empty!!!");
			bool = true;
		}
		for(Book book1 : store) {
			if(book1.getBookTitle().equals(str1) && book1.getNumberOfCopies()>0) {
				book1.setNumberOfCopies(book1.getNumberOfCopies()-1);
				System.out.println(str1+" is checked out.");
				return true;
			}
		}
		if(bool==false) {
			System.out.println("Sorry! "+str1+" book is currently not available.");
		}
		return false;
	}
	public boolean returnBook(String str2) {
		if(store.size()==0) {
			System.out.println("No book is available, store is empty!!!");
			bool = true;
		}
		for(Book book1 : store) {
			if(book1.getBookTitle().equals(str2)) {
				book1.setNumberOfCopies(book1.getNumberOfCopies()+1);
				System.out.println(str2+" is returned");
				return true;
			}
		}
		if(bool==false) {
			System.out.println(str2+" can't be returned.");
		}
		return false;
	}
	public boolean isAvailable(String str3) {
		if(store.size()==0) {
			System.out.println("No book is available, store is empty!!!");
			bool = true;
		}
		for(Book book1: store) {
			if(book1.getBookTitle().equals(str3) && book1.getNumberOfCopies()>0) {
				System.out.println(str3+" book is available.");
				return true;
			}
		}
		if(bool==false) {
			System.out.println(str3+" - This book is not available");
		}
		return false;	
	}
	public void ListAllBooks() {
		if(store.size()==0) {
			System.out.println("No book is available, store is empty!!!");
		}else {
			for(Book book1: store) {
			    System.out.println("Book Name -> "+book1.getBookTitle()+"\n"+"Author Name -> "+book1.getAuthorName()+"\n"+"Book Price -> "+book1.getPrice()+"\n"+"Number of copies -> "+book1.getNumberOfCopies());
			    System.out.println();
			}
		}
	}
}
