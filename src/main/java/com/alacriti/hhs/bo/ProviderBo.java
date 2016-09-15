package com.alacriti.hhs.bo;

import java.sql.Connection;
import java.sql.SQLException;

import com.alacriti.hhs.dao.ProviderDatabase;
import com.alacriti.hhs.deligate.ProviderDeligate;
import com.alacriti.hhs.vo.ServiceProvider;

public class ProviderBo {
	ProviderDeligate pd=new ProviderDeligate();
	ProviderDatabase pds=new ProviderDatabase();
	public void postProvider(Connection con, String providerName, String serviceType,
			String mobileNumber, String emailId, String location, String city,
			String password) throws SQLException {
		ServiceProvider sp=new ServiceProvider();	
		ProviderDatabase pds=new ProviderDatabase();
		
		sp.setProviderName(providerName);
		sp.setServiceType(serviceType);
		sp.setMobileNumber(mobileNumber);
		sp.setEmailId(emailId);
		sp.setLocation(location);
		sp.setCity(city);
		sp.setPassword(password);
		
	   pds.postServiceProviderDetails(con,sp.getProviderName(),sp.getServiceType(), sp.getMobileNumber(), sp.getEmailId(),
				sp.getLocation(),sp.getCity(), sp.getPassword());
		
	}
	

	public void responseProvider(Connection con, String response, int id) throws SQLException {		
		pds.getResponseProvider(con,response, id);		
	}

	public void editProvider(Connection con, String email, String mobileNumber, String password, int id) throws SQLException {
		pds.getResponseProvider(con,email,mobileNumber,password,id);		
	}
}
