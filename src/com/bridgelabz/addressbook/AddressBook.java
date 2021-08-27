package com.bridgelabz.addressbook;

import java.util.Scanner;

public class AddressBook {
	public static void main(String[] args) {
		System.out.println("***** Welcome to Address Book Program *****");
		ContactOperationsIF contactOperations = new ContactOperationsImpl();
		System.out.println("Press '1' to Add contact \nPress '2' to Edit contact \nPress '3' to Delete");
		Scanner scanner = new Scanner(System.in);
		int optionSelected = scanner.nextInt();
		
		switch(optionSelected) {
		case 1:
			contactOperations.addContact();
			break;
		case 2:
			contactOperations.checkToEdit();
			break;
		case 3:
			contactOperations.checkToDelete();
			break;
		}
		
	}
}
