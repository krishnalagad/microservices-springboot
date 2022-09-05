package com.contact.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.contact.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	// fake list of contacts
	List<Contact> list = List.of(new Contact(1L, "contact1@gmail.com", "9876543456", 1010L),
			new Contact(2L, "contact2@gmail.com", "9098767898", 1011L),
			new Contact(3L, "contact3@gmail.com", "8987909809", 1010L));

	@Override
	public List<Contact> getContactsOfUser(Long id) {

		List<Contact> collect = this.list.stream().filter((contact) -> contact.getUserId().equals(id))
				.collect(Collectors.toList());
		return collect;
	}

}
