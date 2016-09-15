package com.alacriti.hhs.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GuestLogin {
	private String userName;
	private String mobileNumber;
	private String emailId;	
	
	public GuestLogin() {
		
	}

	public GuestLogin(String userName, String mobileNumber, String emailId) {
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
	
	
	
}
