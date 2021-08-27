package com.bridgelabz.addressbook;

import java.util.Scanner;

public class ContactOperationsImpl implements ContactOperationsIF {

	public int count = 0;
	public int addressCount = 0;
	Contact[][] contacts = new Contact[2][2];
	String[] addressBook = new String[2];
	Scanner scanner = new Scanner(System.in);

	public ContactOperationsImpl() {
		boolean exitAddressBook = false;
		while (!exitAddressBook) {
			System.out.println("Press:\n1 to Add AddressBook name \n2 to Exit");
			int options = scanner.nextInt();

			switch (options) {
			case 1:
				System.out.println("Enter name for Address Book");
				String addressBookName = scanner.next();
				addressBook[addressCount] = new String(addressBookName);
				addressCount++;

				boolean exitContact = false;
				while(!exitContact) {
					System.out.println("Press:\n1 to Add contact \n2 to Edit contact \n3 to Delete \n4 to Exit");
					int optionSelected = scanner.nextInt();
					
					switch(optionSelected) {
					case 1:
						addContact();
						break;
					case 2:
						checkToEdit();
						break;
					case 3:
						checkToDelete();
						break;
					case 4:
						System.out.println("Exiting Contacts");
						exitContact = true;
						break;
					}
				}
				break;
			case 2:
				System.out.println("Exiting Address Book");
				exitAddressBook = true;
				scanner.close();
				break;
			}

		}
	}

	private void display() {
		for (int i = 0; i < contacts.length; i++) {
			for (int j = 0; j < contacts[i].length; j++) {
				System.out.print(contacts[i][j].getFirstName());
				System.out.println();
			}
		}
	}

	@Override
	public void addContact() {
		System.out.println(
				"Enter details in the order First Name, Lsat Name, Address, City, State, Pincode, Phone Number, Email Address");

		String firstName = scanner.next();
		String lastName = scanner.next();
		String address = scanner.next();
		String city = scanner.next();
		String state = scanner.next();
		String ZIP = scanner.next();
		String phoneNumber = scanner.next();
		String email = scanner.next();

		contacts[addressCount][count] = new Contact(firstName, lastName, address, city, state, ZIP, phoneNumber, email);
		System.out.println("Contact of " + contacts[addressCount][count].getFirstName() + " "
				+ contacts[addressCount][count].getLastName() + " has been added");
		count++;
	}

	@Override
	public void checkToEdit() {
		if (count < 0) {
			System.out.print("Address book is empty to edit");
		} else {
			boolean isValid = false;
			System.out.println("Enter the First Name of the contact to be edit:");
			String firstName = scanner.next();
			for (int index = 0; index < count; index++) {
				String name = contacts[addressCount][index].getFirstName();
				if (firstName.equals(name)) {
					editContact(name, index);
					isValid = true;
					break;
				}
			}
			if (!isValid) {
				System.out.print("Enter valid name");
			}
		}
	}

	private void editContact(String name, int index) {
		System.out.println(
				"Enter details in the order Lsat Name, Address, City, State, Pincode, Phone Number, Email Address");

		String lastName = scanner.next();
		String address = scanner.next();
		String city = scanner.next();
		String state = scanner.next();
		String ZIP = scanner.next();
		String phoneNumber = scanner.next();
		String email = scanner.next();
		contacts[addressCount][count] = new Contact(name, lastName, address, city, state, ZIP, phoneNumber, email);
		System.out.println("Contact of " + contacts[addressCount][count].getFirstName() + " has been edited");
	}

	@Override
	public void checkToDelete() {
		if (count < 0) {
			System.out.print("Address book is empty to delete");
		} else {
			boolean isValid = false;
			System.out.println("Enter the First Name of the contact to be delete:");
			String firstName = scanner.next();
			for (int index = 0; index < count; index++) {
				String name = contacts[addressCount][index].getFirstName();
				if (firstName.equals(name)) {
					deleteContact(name, index);
					isValid = true;
					break;
				}
			}
			if (!isValid) {
				System.out.print("Enter valid name");
			}
		}
	}

	private void deleteContact(String name, int index) {
		for (int c = 0; c < count; c++) {
			contacts[index] = contacts[index + 1];
		}
		count--;
		System.out.println("Contact of " + name + " has been deleted");
	}

}
