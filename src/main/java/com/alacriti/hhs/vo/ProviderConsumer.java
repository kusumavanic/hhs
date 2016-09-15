package com.alacriti.hhs.vo;

import java.sql.Timestamp;

public class ProviderConsumer {
	private int id;
	private String providerName;
	private String serviceType;
	private String mobileNumber;
	private String emailId;
	private String location;
	private String city;
	private String password;
	private Timestamp createdAt;
	private String Status;
	private String providerEmail;
	
	public ProviderConsumer() {
	}

	public ProviderConsumer(int id, String providerName, String serviceType,
			String mobileNumber, String emailId, String location, String city,
			Timestamp createdAt, String status,
			String providerEmail) {
		this.id = id;
		this.providerName = providerName;
		this.serviceType = serviceType;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.location = location;
		this.city = city;
		this.createdAt = createdAt;
		this.Status = status;
		this.providerEmail= providerEmail;
	}
	

	public ProviderConsumer(String providerName, String mobileNumber,
			String emailId, String location, String city, Timestamp createdAt) {
		super();
		this.providerName = providerName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.location = location;
		this.city = city;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getproviderEmail() {
		return providerEmail;
	}

	public void setproviderEmail(String providerEmail) {
		this.providerEmail = providerEmail;
	}
	
}
