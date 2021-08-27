package com.bridgelabz.addressbook;

import java.util.Scanner;

public class AddressBookMain {
	public static void main(String[] args) {
		System.out.println("***** Welcome to Address Book Program *****");
		
		boolean exit = false;
		ContactOperationsIF contactOperations = new ContactOperationsImpl();
		
		while(!exit) {
			System.out.println("Press:\n1 to Add contact \n2 to Edit contact \n3 to Delete \n4 to Exit");
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
			case 4:
				System.out.println("Exiting Address Book");
				exit = true;
				scanner.close();
				break;
			}
		}
	}
}
