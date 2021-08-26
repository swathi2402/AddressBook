package com.bridgelabz.addressbook;

public class ContactObject {
	private static AllContacts addContact = new AllContacts();

	static {
		addContact.getAllContacts().add(new Contact("Swathi", "Hebbar", "Abcd Efgh", "Udupi", "Karnataka", "576224",
				"9900554433", "swathi.h@gmail.com"));
		
		addContact.getAllContacts().add(new Contact("Shilpa", "Adiga", "Abcd Zyz", "Udupi", "Karnataka", "576224",
				"889966554", "shilpa.a@gmail.com"));
	}
	public AllContacts getAllContact()
	{
		    return addContact;
	}
}
