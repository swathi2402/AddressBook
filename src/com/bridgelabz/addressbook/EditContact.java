package com.bridgelabz.addressbook;

import java.util.Scanner;

public class EditContact {
	private static void editContact(String name, int index) {

		System.out.println("Enter details in the order Lsat Name, Address, City, State, Pincode, Phone Number, Email Address");
		AllContacts addContact = new AllContacts();

		Scanner scanner = new Scanner(System.in);
		String lastName = scanner.next();
		String address = scanner.next();
		String city = scanner.next();
		String state = scanner.next();
		String ZIP = scanner.next();
		String phoneNumber = scanner.next();
		String email = scanner.next();
		scanner.close();

		addContact.getAllContacts()
				.add(new Contact(name, lastName, address, city, state, ZIP, phoneNumber, email));
		System.out.print("Name: " + addContact.getAllContacts().get(index).getFirstName() + " ");
		System.out.println(addContact.getAllContacts().get(index).getLastName());
		System.out.println("Phone Number: " + addContact.getAllContacts().get(index).getPhoneNumber());
		addContact.getAllContacts().remove(index);
	}
	
	public static void checkToEdit() {
		ContactObject contactObject = new ContactObject();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the First Name of the contact to be edit:");
		String firstName = scanner.next();
		int count = contactObject.getAllContact().getAllContacts().size();
		for (int index = 0; index < count; index++) {
			String name = contactObject.getAllContact().getAllContacts().get(index).getFirstName();
			if (firstName.equals(name)) {
				editContact(name, index);
				break;
			} else {
				System.out.print("Enter valid name");
				break;
			}
		}
		scanner.close();

	}

}
