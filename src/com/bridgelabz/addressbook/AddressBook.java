package com.bridgelabz.addressbook;

import java.util.Scanner;

public class AddressBook {
	public static void main(String[] args) {
		System.out.println("***** Welcome to Address Book Program *****");
		
		AllContacts addContact = new AllContacts();
		System.out.println("Enter details in the order First Name, Lsat Name, Address, City, State, "
							+ "Pincode, Phone Number, Email Address");
		
		Scanner scanner = new Scanner(System.in);
		String firstName = scanner.next();
		String lastName = scanner.next();
		String address = scanner.next();
		String city = scanner.next();
		String state = scanner.next();
		String ZIP = scanner.next();
		String phoneNumber = scanner.next();
		String email = scanner.next();
		scanner.close();
		
		addContact.getAllContacts().add(new Contact(firstName, lastName, address, city, state, ZIP, phoneNumber, email));
		System.out.print("Name: " + addContact.getAllContacts().get(0).getFirstName() + " ");
		System.out.println(addContact.getAllContacts().get(0).getLastName());
		System.out.println("Phone Number: " + addContact.getAllContacts().get(0).getPhoneNumber());
		
	}
}
