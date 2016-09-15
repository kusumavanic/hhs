package com.alacriti.hhs.vo;

public class UserVo {
	private String email;
	private String profileName;
	private String location;
	
	
	public UserVo() {
	}
	
	public UserVo(String email, String profileName,String location) {
		this.email = email;
		this.profileName = profileName;
		this.location=location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
