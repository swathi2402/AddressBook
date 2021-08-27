package com.bridgelabz.addressbook;

public class AddressBookMain {

	public static void main(String[] args) {
		System.out.println("***** Welcome to Address Book Program *****");

		try {
			new ContactOperationsImpl();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
