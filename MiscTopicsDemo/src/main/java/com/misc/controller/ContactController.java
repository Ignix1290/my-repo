package com.misc.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
	// Path parameter based versioning
	@GetMapping(value = "/api/contact/v1", produces = MediaType.APPLICATION_JSON_VALUE) // OLD API
	public Contact getContactV1() {
		return new Contact("Tom", 12345);
	}

	@GetMapping(value = "/api/contact/v2", produces = MediaType.APPLICATION_JSON_VALUE) // NEW API
	public ContactV2 getContactV2() {
		return new ContactV2("Tom", 12345);
	}

	// Query/Request parameter based versioning
	@GetMapping(value = "/api/contact", produces = MediaType.APPLICATION_JSON_VALUE, params = "version=v1") // OLD API
	public Contact getContactQueryV1() {
		return new Contact("Tom", 12345);
	}

	@GetMapping(value = "/api/contact", produces = MediaType.APPLICATION_JSON_VALUE, params = "version=v2") // NEW API
	public ContactV2 getContactQueryV2() {
		return new ContactV2("Tom", 12345);
	}

	// Header parameter based versioning
	@GetMapping(value = "/api/contact", produces = MediaType.APPLICATION_JSON_VALUE, headers = "version=v1") // OLD API
	public Contact getContactHeaderV1() {
		return new Contact("Tom", 12345);
	}

	@GetMapping(value = "/api/contact", produces = MediaType.APPLICATION_JSON_VALUE, headers = "version=v2") // OLD API
	public ContactV2 getContactHeaderV2() {
		return new ContactV2("Tom", 12345);
	}

	// Content Negotiation based versioning
	@GetMapping(value = "/api/contact", produces = "application/contact.v1+json") // OLD API
	public Contact getContactNegoV1() {
		return new Contact("Tom", 12345);
	}

	@GetMapping(value = "/api/contact", produces = "application/contact.v2+json") // NEW API
	public ContactV2 getContactNegoV2() {
		return new ContactV2("Tom", 12345);
	}

}

class Contact {
	private String name;
	private int mobile;

	public Contact() {
		super();
	}

	public Contact(String name, int mobile) {
		super();
		this.name = name;
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", mobile=" + mobile + "]";
	}

}

class ContactV2 {
	private String name;
	private int mobileno;

	public ContactV2() {
		super();
	}

	public ContactV2(String name, int mobileno) {
		super();
		this.name = name;
		this.mobileno = mobileno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMobileno() {
		return mobileno;
	}

	public void setMobileno(int mobileno) {
		this.mobileno = mobileno;
	}

	@Override
	public String toString() {
		return "ContactV2 [name=" + name + ", mobileno=" + mobileno + "]";
	}

}