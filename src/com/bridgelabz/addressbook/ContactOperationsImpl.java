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
//		System.out.println(contact[count]);
		System.out.println("Contact of " + contact[count].getFirstName() + " " + contact[count].getLastName() + " has bee added");
		count++;
	}

}
