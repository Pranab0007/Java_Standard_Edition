package com.Test.videobean;

//import java.util.ArrayList;

public class VideoStore {
	private Video[] store;
	int counter;
	
//	ArrayList<Video> al = new ArrayList<>(); //Collection frameWork approach
	public void addVideo(String name) {
		int storeSize;
		Video video = new Video(name);
		try {
			storeSize=store.length;
		}catch(Exception e) {
			storeSize =0;
		}
		Video []  newStore = new Video[storeSize+1]; //array (Temporary storage ) approach
		
		newStore[storeSize]=video;
		for(int i=0;i<storeSize;i++) {
			newStore[i]=store[i];
		}
		store = newStore;
		counter++;
	}
	public void doCheckout(String name) {
		if(store.length==0) {
			System.out.println("Store is empty");
			return;
		}
		for(Video video:store) {
			if(video.getName().equals(name)) {
				video.doCheckout();
			}
		}
	}
	public void doReturn(String name) {
		if(store.length==0) {
			System.out.println("Store is empty");
			return;
		}
		for(Video video:store) {
			if(video.getName().equals(name)) {
				video.doReturn();
			}
		}
	}
	public void reciveRating(String name,int rating) {
		if(store.length==0) {
			System.out.println("Store is empty");
			return;
		}
		for(Video video:store) {
			if(video.getName().equals(name)) {
				video.reciveRating(rating);
			}
		}
	}
	public void listInventory() {
		System.out.println("------------------------------------------------------------------------");
		System.out.printf("\n%-22s\t|\t%-20s\t|\t%-10s","Video Name","CheckOut Status","Rating");
		for(int i=0;i<counter;i++) {
			System.out.printf("\n%-22s\t|\t%-25s\t|\t%-10s",store[i].getName(),store[i].getCheckout(),store[i].getRating());
			System.out.println();
		}
		System.out.println("------------------------------------------------------------------------");
	}
}
