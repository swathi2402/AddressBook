package com.bridgelabz.addressbook;

import java.util.Scanner;

public class EditContact {
	private static void editContact(String name, int index, ContactObject contactObject) {

		System.out.println(
				"Enter details in the order Lsat Name, Address, City, State, Pincode, Phone Number, Email Address");
		Scanner scanner = new Scanner(System.in);
		String lastName = scanner.next();
		String address = scanner.next();
		String city = scanner.next();
		String state = scanner.next();
		String ZIP = scanner.next();
		String phoneNumber = scanner.next();
		String email = scanner.next();
		scanner.close();

		contactObject.getAllContact().getAllContacts().add(new Contact(name, lastName, address, city, state, ZIP, phoneNumber, email));
		Contact deletedContact = contactObject.getAllContact().getAllContacts().remove(index);
		System.out.print("Contact of " + deletedContact.getFirstName() + " has been edited");
		
	}

	public static void checkToEdit() {
		boolean isValid = false;
		ContactObject contactObject = new ContactObject();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the First Name of the contact to be edit:");
		String firstName = scanner.next();
		int count = contactObject.getAllContact().getAllContacts().size();
		for (int index = 0; index < count; index++) {
			String name = contactObject.getAllContact().getAllContacts().get(index).getFirstName();
			if (firstName.equals(name)) {
				editContact(name, index, contactObject);
				isValid = true;
				break;
			}
		}
		if (!isValid) {
			System.out.print("Enter valid name");
		}
		scanner.close();
	}
}
