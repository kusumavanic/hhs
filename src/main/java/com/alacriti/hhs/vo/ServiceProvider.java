package com.alacriti.hhs.vo;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class ServiceProvider {
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
	
	
	
	public ServiceProvider() {
		
	}
	
	
	public ServiceProvider(String providerName, String emailId,int id) {
		this.providerName = providerName;
		this.emailId = emailId;
		this.id=id;
	}


	public ServiceProvider(String providerName) {
		this.providerName = providerName;
		
	}
	
	public ServiceProvider(int id,String providerName,
			String mobileNumber, String emailId, String location, String city,
			String password,Timestamp createdAt,String Status) 
	{
		this.id=id;
		this.providerName = providerName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.location = location;
		this.city = city;
		this.password = password;
		this.createdAt=createdAt;
		this.Status=Status;
	}
	
	
	
	
	
	public ServiceProvider(int id, String providerName, String mobileNumber,
			String emailId, String location, String city, String Status) {
		this.id = id;
		this.providerName = providerName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.location = location;
		this.city = city;
		this.Status = Status;
	}


	public ServiceProvider(int id, String providerName, String serviceType,
			String mobileNumber, String emailId, String location, String city,
			String password, Timestamp createdAt, String status) {
		this.id = id;
		this.providerName = providerName;
		this.serviceType = serviceType;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.location = location;
		this.city = city;
		this.password = password;
		this.createdAt = createdAt;
		this.Status = status;
	}


	public String getStatus() {
		return Status;
	}

	public void setStatus(String Status) {
		this.Status = Status;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
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
}
