package com.bridgelabz.addressbook;

import java.util.Scanner;

public class ContactOperationsImpl implements ContactOperationsIF {

	public int count = 0;
	Contact[] contact = new Contact[100];
	
	
	@Override
	public void addContact() {
		System.out.println(
				"Enter details in the order First Name, Lsat Name, Address, City, State, Pincode, Phone Number, Email Address");

		Scanner scanner = new Scanner(System.in);
		String firstName = scanner.next();
		String lastName = scanner.next();
		String address = scanner.next();
		String city = scanner.next();
		String state = scanner.next();
		String ZIP = scanner.next();
		String phoneNumber = scanner.next();
		String email = scanner.next();

		contact[count] = new Contact (firstName, lastName, address, city, state, ZIP, phoneNumber, email);	
		System.out.println("Contact of " + contact[count].getFirstName() + " " + contact[count].getLastName() + " has bee added");
		count++;
	}


	@Override
	public void checkToEdit() {
		addContact();
		boolean isValid = false;
		Scanner scanner = new Scanner(System.in);
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


	private void editContact(String name, int index) {
		System.out.println("Enter details in the order Lsat Name, Address, City, State, Pincode, Phone Number, Email Address");
		
		Scanner scanner = new Scanner(System.in);
		String lastName = scanner.next();
		String address = scanner.next();
		String city = scanner.next();
		String state = scanner.next();
		String ZIP = scanner.next();
		String phoneNumber = scanner.next();
		String email = scanner.next();
		
		contact[count] = new Contact (name, lastName, address, city, state, ZIP, phoneNumber, email);
		System.out.println("Contact of " + contact[count].getFirstName() + " has bee edited");
	}

}
