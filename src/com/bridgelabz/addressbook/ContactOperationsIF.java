package com.bridgelabz.addressbook;

public interface ContactOperationsIF {

	public void addAddressBook(String addressBookName);

	public void addContact(String addressBookName);

	public void checkToEdit(String addressBookName);

	public void deleteContact(String addressBookName);

	public void searchPerson(String nameToSearch);

	public void getPersonsInCity(String city);

	public void getPersonsInState(String state);

}
