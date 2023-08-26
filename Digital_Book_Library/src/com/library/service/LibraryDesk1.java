package com.library.service;

import java.util.Scanner;

import com.library.beans.Library;

public class LibraryDesk1 {
	public static void main(String[] args) {
		Library lb = new Library();
		try (Scanner sc = new Scanner(System.in)) {
			forBack : while(true) {
				System.out.println("Library Owner enter 1 ");
				System.out.println("Cusomer enter 2 ");
				System.out.println("To exit enter 3");
				System.out.println("Enter your choice (1...3) : ");
				int mainMenu = sc.nextInt();
			do {
				switch(mainMenu) {
					case 1:
						System.out.println("1.Add Books : ");
						System.out.println("2.List All Books : ");
						System.out.println("3. Back ");
						System.out.println("4. Exit ");
						System.out.println("Enter your choice (1...4) : ");
						int ownerMenu = sc.nextInt();
						sc.nextLine();
						switch(ownerMenu) {
						case 1:
							System.out.println("Enter the name of the book : ");
							String bTitle = sc.nextLine();
							System.out.println("Enter the author name of the book : ");
							String aName=sc.nextLine();
							System.out.println("Enter the price of the book : ");
							double bprice = sc.nextDouble();
							System.out.println("Enter number of copies of the book : ");
							int bCopies = sc.nextInt();
							lb.addBook(bTitle, aName,bprice,bCopies);
							System.out.println("Book is added successfully");
							System.out.println();
							break;
						case 2:
							lb.ListAllBooks();
							break;
						case 3:
							continue forBack;
						case 4:
							System.out.println("Thank you! I appriciate you for using this Application ");
							System.exit(0);
							break;
						default :
							System.out.println("Kindly check your input...Thank You");
						}
						break;
					case 2:
						System.out.println("1.Check out Book : ");
						System.out.println("2.Return Book : ");
						System.out.println("3. Check availability : ");
						System.out.println("4. Back :");
						System.out.println("5.Exit ");
						System.out.println("Enter your choice (1...5) : ");
						int customerMenu= sc.nextInt();
						sc.nextLine();
						switch(customerMenu) {
						case 1:
							System.out.print("Enter the name of the book you want to borrow : ");
							String str1 = sc.nextLine();
							lb.borrowBook(str1);
							break;
						case 2:
							System.out.print("Enter the name of the book you want to return : ");
							String str2 = sc.nextLine();
							lb.returnBook(str2);
							break;
						case 3:
							System.out.println("Enter the name of the book to check availability : ");
							String str3 = sc.nextLine();
							lb.isAvailable(str3);
							break;
						case 4:
							continue forBack;
						case 5:
							System.out.println("Thank you! I appriciate you for using this Application ");
							System.exit(0);
							break;
						default :
							System.out.println("Kindly check your input...Thank You");
						}
						break;
					case 3:
						System.out.println("Thank you! I appriciate you for using this Application ");
						System.exit(0);
						break;
					default :
						System.out.println("Kindly check your input...Thank You");
					}
				}while(true);
			}
		}
	}
}
