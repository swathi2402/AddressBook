package com.bridgelabz.addressbook;

import java.util.Scanner;

public class ContactOperationsImpl implements ContactOperationsIF {

	public int count = 0;
	Contact[] contact = new Contact[100];
	Scanner scanner = new Scanner(System.in);

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

		contact[count] = new Contact(firstName, lastName, address, city, state, ZIP, phoneNumber, email);
		System.out.println(
				"Contact of " + contact[count].getFirstName() + " " + contact[count].getLastName() + " has been added");
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
				String name = contact[index].getFirstName();
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
		contact[count] = new Contact(name, lastName, address, city, state, ZIP, phoneNumber, email);
		System.out.println("Contact of " + contact[count].getFirstName() + " has been edited");
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
				String name = contact[index].getFirstName();
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
			contact[index] = contact[index + 1];
		}
		count--;
		System.out.println("Contact of " + name + " has been deleted");
	}

}
