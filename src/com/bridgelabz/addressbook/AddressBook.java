package com.bridgelabz.addressbook;

public class AddressBook {
	public static void main(String[] args) {
		System.out.println("***** Welcome to Address Book Program *****");
		AllContacts addContact = new AllContacts();
		addContact.getAllContacts().add(new Contact("Swathi", "Hebbar", "Abcd Efgh",
				"Udupi", "Karnataka", "576224", "9900554433", "swathi.g@gmail.com"));
		System.out.print("Name: " + addContact.getAllContacts().get(0).getFirstName() + " ");
		System.out.println(addContact.getAllContacts().get(0).getLastName());
		System.out.println("Phone Number: " + addContact.getAllContacts().get(0).getPhoneNumber());
	}
}
