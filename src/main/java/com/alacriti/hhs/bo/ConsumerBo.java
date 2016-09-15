package com.alacriti.hhs.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alacriti.hhs.dao.ConsumerDatabase;
import com.alacriti.hhs.dao.ProviderDatabase;
import com.alacriti.hhs.deligate.ConsumerDeligate;
import com.alacriti.hhs.vo.ProviderConsumer;
import com.alacriti.hhs.vo.ServiceConsumer;

public class ConsumerBo {
	ConsumerDeligate cd=new ConsumerDeligate();
public void postConsumer(Connection con, String consumerName,String mobileNumber,String emailId,String altEmailId,
			String location,String city,String password) throws SQLException{
	
	ConsumerDatabase cds=new ConsumerDatabase();
	ServiceConsumer sc=new ServiceConsumer();	
	
	sc.setConsumerName(consumerName);
	sc.setMobileNumber(mobileNumber);
	sc.setEmailId(emailId);
	sc.setAltEmailId(altEmailId);
	sc.setLocation(location);
	sc.setCity(city);
	sc.setPassword(password);
	
   cds.postServiceConsumerDetails(con,sc.getConsumerName(), sc.getMobileNumber(), sc.getEmailId(),sc.getAltEmailId(),
			sc.getLocation(),sc.getCity(), sc.getPassword());
	
}

public void editConsumer(Connection con, String email, String altEmail,String mobileNumber, String password, int id) throws SQLException {
	ConsumerDatabase cds=new ConsumerDatabase();	
	cds.editConsumer(con,email,altEmail,mobileNumber,password,id);
}
public ArrayList<ProviderConsumer> sentRequest(Connection con, String catogeory, String id) throws SQLException {
	
	ProviderDatabase pd=new ProviderDatabase();
	return pd.sentRequest(con,catogeory,id);	
}
public void requestToProvider(Connection con, int consumerId, int providerId) throws SQLException {
	
	ProviderDatabase pd=new ProviderDatabase();
	pd.requestToProvider(con,consumerId,providerId);
	}
}
