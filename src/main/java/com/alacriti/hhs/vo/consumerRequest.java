package com.alacriti.hhs.vo;

public class consumerRequest {
private int consumerId;
private int providerId;

public consumerRequest() {
	
}
public consumerRequest(int consumerId, int providerId) {
	
	this.consumerId = consumerId;
	this.providerId = providerId;
}
public int getConsumerId() {
	return consumerId;
}
public void setConsumerId(int consumerId) {
	this.consumerId = consumerId;
}
public int getProviderId() {
	return providerId;
}
public void setProviderId(int providerId) {
	this.providerId = providerId;
}




}
