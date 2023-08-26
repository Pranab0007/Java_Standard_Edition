package com.Test.service;

import java.util.Scanner;

import com.Test.videobean.VideoStore;

public class VideoLauncher {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String vname;
			int ch;
			int rating;
			VideoStore vs = new VideoStore();
			System.out.print("Enter your user ID :  ");
			String uname = sc.nextLine();
			System.out.print("Enter your user password :  ");
			String pass = sc.nextLine();
			if(uname.equals("Pranab0007")&&pass.equals("P0007")) {
				System.out.println("Access granted - Enjoy the application :");
				System.out.println();
			}else {
				if(!uname.equals("Pranab0007")||!pass.equals("P0007")) {
					System.out.println("Be careful about your User ID and User Password.");
				}
				System.out.println("Sorry!....Access denied.");
				System.exit(0);
			}
			
			do {
				System.out.println("1.Add Videos : ");
				System.out.println("2.ChechOut Video : ");
				System.out.println("3.Return Video : ");
				System.out.println("4.Recive Rating : ");
				System.out.println("5.List Inventory : ");
				System.out.println("6.Exit : ");
				System.out.println("Enter your choice here : ");
				
				ch = sc.nextInt();
				sc.nextLine();
				switch(ch) {
					case 1:
						System.out.println("Enter the name of the video you want to add here : ");
						vname = sc.nextLine();
						vs.addVideo(vname);
						System.out.println("Video - "+vname+"  added successfully");
						break;
					case 2:
						System.out.println("Enter the name of the video you want to checkout :");
						vname = sc.nextLine();
						vs.doCheckout(vname);
						System.out.println("Video - "+vname+"  checked out successfully");
						break;
					case 3:
						System.out.println("Enter the name of the video you want to return");
						vname = sc.nextLine();
						vs.doReturn(vname);
						System.out.println("Video - "+vname+"  returned successfully");
						break;
					case 4:
						System.out.println("Enter the name of the video you want to rate : ");
						vname = sc.nextLine();
						System.out.println("Enter the rating you want to give : ");
						rating = sc.nextInt();
						
						vs.reciveRating(vname,rating);
						System.out.println("Rating - "+rating+"  has been maped to the video - "+vname+".");
						break;
					case 5:
						vs.listInventory();
						
						
						break;
					case 6:
						System.out.println("Thank you!!!...for using the application.");
						System.exit(0);
						break;
					default:
						System.out.println("Invalid choice , please run again");	
				}
			}while(true);
		}
	}
}
