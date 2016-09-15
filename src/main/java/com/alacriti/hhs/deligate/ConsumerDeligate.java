package com.alacriti.hhs.deligate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.alacriti.hhs.bo.ConsumerBo;
import com.alacriti.hhs.resource.EmailSendResource;
import com.alacriti.hhs.util.Database;
import com.alacriti.hhs.util.Index;
import com.alacriti.hhs.util.ValidationUtil;
import com.alacriti.hhs.vo.ProviderConsumer;

import freemarker.template.TemplateException;


public class ConsumerDeligate {
	Index index=new Index();
	Database db=new Database();
	Connection con=db.databaseConnection();
	EmailSendResource esr=new EmailSendResource();
	static Logger l = Logger.getLogger(ConsumerDeligate.class.getName());
	
	public String postConsumerDetails(String consumerName, String mobileNumber,
			String emailId, String altEmailId, String location, String city,
			String password,String cPassword) throws SQLException, IOException, TemplateException {
		ConsumerBo cb = new ConsumerBo();
		
		boolean flag=true;
		
		flag=ValidationUtil.validateName(consumerName);
			if(flag==false){
				return "enter valid name...!!";			
			}
		flag=ValidationUtil.validateName(location);
			if(flag==false){
				return "enter valid location...!!";			
			}
		flag=ValidationUtil.validateName(city);
			if(flag==false){
				return "enter valid city...!!";			
			}
		flag=ValidationUtil.validateEmailAddress(emailId);
			if(flag==false){
				return "enter valid emailID..!!";
		    }
		flag=ValidationUtil.validateEmailAddress(altEmailId);
			if(flag==false){
				return "enter valid emailID..!!";
			}
		flag=ValidationUtil.validatePassword(emailId, altEmailId);
			if(flag==true){
				flag=false;
				return "altemailId not equal to emailId...!!!";
			}
		flag=ValidationUtil.validatePhoneNumber(mobileNumber);
			if(flag==false){
				return "enter valid Mobile Number..!!";
			}
		flag=ValidationUtil.validatePassword(password, cPassword);
			if(flag==false){
				return "enter confirm password same as password...!!!";
			}
		if(flag==true){
			cb.postConsumer(con,consumerName, mobileNumber, emailId, altEmailId,
					location, city, password);
			esr.successRegistration(mobileNumber,emailId);
			l.debug("consumer details are posted...!!!");
			return index.consumer();
			}
		else{
			return "enter valid details...!!";
		}
	}

	public void editConsumer(String email, String altEmail,
			String mobileNumber, String password, int id) throws SQLException {
		ConsumerBo cb = new ConsumerBo();
		cb.editConsumer(con,email,altEmail,mobileNumber,password,id);
	}

	public ArrayList<ProviderConsumer> sentRequest(String catogeory, String id) throws SQLException {
		ConsumerBo cb = new ConsumerBo();
		return cb.sentRequest(con,catogeory,id);
		
	}

	public void requestToProvider(int consumerId, int providerId) throws SQLException {
		
		ConsumerBo cb = new ConsumerBo();
		cb.requestToProvider(con,consumerId,providerId);
	}
}
