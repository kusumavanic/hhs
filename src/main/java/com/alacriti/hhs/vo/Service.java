package com.alacriti.hhs.vo;

public class Service {
	private int providerId;
	private String serviceType;
	
	public Service() {
		
	}

	public Service(int providerId,String serviceType) {
		this.providerId = providerId;		
		this.serviceType = serviceType;
	}

	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	

}
