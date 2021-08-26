package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.List;

public class AllContacts {
	private List<Contact> allContacts;
	
	public List<Contact> getAllContacts() {
		if (allContacts == null) {
			  allContacts = new ArrayList<>();                
        }
		return allContacts;
	}

	public void setAllContacts(List<Contact> allContacts) {
		this.allContacts = allContacts;
	}
}
