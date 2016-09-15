package com.alacriti.hhs.vo;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ServiceConsumer {
	private int id;
	private String consumerName;
	private String mobileNumber;
	private String emailId;
	private String altEmailId;
	private String location;
	private String city;
	private String password;
	private Timestamp createdAt;
	
	
	
	public ServiceConsumer() {
	}
	public ServiceConsumer(int id,String consumerName, String mobileNumber,
			String emailId, String altEmailId, String location, String city,
			String password, Timestamp createdAt) {
		this.id=id;
		this.consumerName = consumerName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.altEmailId = altEmailId;
		this.location = location;
		this.city = city;
		this.password = password;
		this.createdAt=createdAt;
	}
	
	
	public ServiceConsumer(int id, String consumerName, String mobileNumber,
			String emailId, String altEmailId, String location, String city) {
		this.id = id;
		this.consumerName = consumerName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.altEmailId = altEmailId;
		this.location = location;
		this.city = city;
	}
	public ServiceConsumer(String emailId) {
		super();
		this.emailId = emailId;
	}
	public ServiceConsumer(String consumerName, String emailId,int id) {
		this.consumerName=consumerName;
		this.emailId=emailId;
		this.id=id;
		
	}
	
	public ServiceConsumer(String consumerName, String mobileNumber,
			String emailId, String location, String city,Timestamp createdAt) {
		
		this.consumerName = consumerName;
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
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
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
	public String getAltEmailId() {
		return altEmailId;
	}
	public void setAltEmailId(String altEmailId) {
		this.altEmailId = altEmailId;
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
