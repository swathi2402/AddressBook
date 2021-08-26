package com.bridgelabz.addressbook;

import java.util.Scanner;

public class AddressBook {

	public static void main(String[] args) {
		System.out.println("***** Welcome to Address Book Program *****");

		System.out.println("Press '1' to add, Press '2' to edit contact");
		Scanner scanner = new Scanner(System.in);
		int optionSelected = scanner.nextInt();

		switch (optionSelected) {
		case 1:
			AddContact.addContact();
			break;
		case 2:
			EditContact.checkToEdit();
			break;
		}

	}
}
