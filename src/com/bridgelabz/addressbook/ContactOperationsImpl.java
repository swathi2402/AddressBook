package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class ContactOperationsImpl implements ContactOperationsIF {

	Scanner scanner = new Scanner(System.in);
	private Map<String, List<Contact>> addressBook = new HashMap<String, List<Contact>>();

	public void addAddressBook(String addressBookName) {
		if (addressBook.containsKey(addressBookName)) {
			System.out.println(addressBookName + " Address Book alredy exists");
			return;
		} else {
			System.out.println(addressBookName + " Address Book created");
			addressBook.put(addressBookName, new ArrayList<Contact>());
		}
		System.out.println(addressBook);
	}

	@Override
	public void addContact(String addressBookName) {

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

		boolean isPresent = false;

		for (int index = 0; index < addressBook.get(addressBookName).size(); index++) {
			if (firstName.equals(addressBook.get(addressBookName).get(index).getFirstName())) {
				System.out.println("Contact for " + firstName + " " + lastName + " is already exists");
				isPresent = true;
				break;
			}
		}
		if (!isPresent) {
			Contact newContact = new Contact(firstName, lastName, address, city, state, ZIP, phoneNumber, email);
			addressBook.get(addressBookName).add(newContact);
			System.out.println("Contact for " + firstName + " " + lastName + " is added");

		}

	}

	@Override
	public void checkToEdit(String addressBookName) {

		if (addressBook.get(addressBookName).isEmpty()) {
			System.out.print("Address book is empty to edit");
		} else {
			boolean isValid = false;
			System.out.println("Enter the First Name of the contact to be edit:");
			String firstName = scanner.next();
			int size = addressBook.get(addressBookName).size();
			for (int index = 0; index < size; index++) {
				String name = addressBook.get(addressBookName).get(index).getFirstName();
				if (firstName.equals(name)) {
					editContact(addressBookName, name, index);
					isValid = true;
					break;
				}
			}
			if (!isValid) {
				System.out.print("Enter valid name");
			}
		}
	}

	private void editContact(String addressBookName, String name, int index) {

		System.out.println(
				"Enter details in the order Lsat Name, Address, City, State, Pincode, Phone Number, Email Address");

		String lastName = scanner.next();
		String address = scanner.next();
		String city = scanner.next();
		String state = scanner.next();
		String ZIP = scanner.next();
		String phoneNumber = scanner.next();
		String email = scanner.next();

		addressBook.get(addressBookName).remove(index);
		Contact contactToBeEdit = new Contact(name, lastName, address, city, state, ZIP, phoneNumber, email);
		addressBook.get(addressBookName).add(contactToBeEdit);
		System.out.println("Contact of " + name + " has been edited");
	}

	@Override
	public void deleteContact(String addressBookName) {

		if (addressBook.get(addressBookName).isEmpty()) {
			System.out.print("Address book is empty to delete");
		} else {
			boolean isValid = false;
			System.out.println("Enter the First Name of the contact to be delete:");
			String firstName = scanner.next();
			int size = addressBook.get(addressBookName).size();
			for (int index = 0; index < size; index++) {
				String name = addressBook.get(addressBookName).get(index).getFirstName();
				if (firstName.equals(name)) {
					Contact deletedContact = addressBook.get(addressBookName).remove(index);
					System.out.println("Contact of " + deletedContact.getFirstName() + " has been deleted");
					isValid = true;
					break;
				}
			}
			if (!isValid) {
				System.out.println("Enter valid name");
			}
		}
	}

	@Override
	public void SearchPerson(String nameToSearch) {

		for (Entry<String, List<Contact>> entry : addressBook.entrySet()) {

			for (int index = 0; index < entry.getValue().size(); index++) {
				if (nameToSearch.equals(entry.getValue().get(index).getFirstName())) {
					System.out.println("Address Book name: " + entry.getKey());
					System.out.println("Person Name: " + entry.getValue().get(index).getFirstName());
					System.out.println("State: " + entry.getValue().get(index).getState());
					System.out.println("City: " + entry.getValue().get(index).getCity());
				} else
					System.out.println("No Such person exits in addressbook " + entry.getKey());

			}
		}
	}

	@Override
	public void getPersonsInCity(String city) {
		Dictionary<String, String> personsInCity = new Hashtable<String, String>();
		for (Entry<String, List<Contact>> entry : addressBook.entrySet()) {

			for (int index = 0; index < entry.getValue().size(); index++) {
				if (city.equals(entry.getValue().get(index).getCity())) 
					personsInCity.put(entry.getValue().get(index).getFirstName(), entry.getValue().get(index).getCity());				
				
			}
		}
		System.out.println("Persons in city " + city + " :");
		for (Enumeration<String> personName = personsInCity.elements(); personName.hasMoreElements();)
        {
            System.out.println(personName.nextElement());
        }
	}

	@Override
	public void getPersonsInState(String state) {
		Dictionary<String, String> personsInState = new Hashtable<String, String>();
		for (Entry<String, List<Contact>> entry : addressBook.entrySet()) {

			for (int index = 0; index < entry.getValue().size(); index++) {
				if (state.equals(entry.getValue().get(index).getCity())) 
					personsInState.put(entry.getValue().get(index).getFirstName(), entry.getValue().get(index).getCity());				
				
			}
		}
		System.out.println("Persons in state " + state + " :");
		for (Enumeration<String> personName = personsInState.elements(); personName.hasMoreElements();)
        {
            System.out.println(personName.nextElement());
        }
	}
}
