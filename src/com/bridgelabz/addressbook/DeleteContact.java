package com.bridgelabz.addressbook;

import java.util.Scanner;

public class DeleteContact {
	
	private static void deleteContact(String name, int index, ContactObject contactObject) {
		try {			
			Contact deletedContact = contactObject.getAllContact().getAllContacts().get(index);
			System.out.print("Contact of " + deletedContact.getFirstName() + " has been deleted");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void checkToDelete() {
		boolean isValid = false;
		ContactObject contactObject = new ContactObject();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the First Name of the contact to be delete:");
		String firstName = scanner.next();
		int count = contactObject.getAllContact().getAllContacts().size();
		for (int index = 0; index < count; index++) {
			String name = contactObject.getAllContact().getAllContacts().get(index).getFirstName();
			if (firstName.equals(name)) {
				deleteContact(name, index, contactObject);
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
