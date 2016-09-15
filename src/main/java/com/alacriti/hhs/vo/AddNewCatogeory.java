package com.alacriti.hhs.vo;

public class AddNewCatogeory {
	private String catogeory;
	private String icon;
	
	public AddNewCatogeory() {
		super();
	}
	public AddNewCatogeory(String catogeory, String icon) {
		this.catogeory = catogeory;
		this.icon = icon;
	}
	public String getCatogeory() {
		return catogeory;
	}
	public void setCatogeory(String catogeory) {
		this.catogeory = catogeory;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
}
