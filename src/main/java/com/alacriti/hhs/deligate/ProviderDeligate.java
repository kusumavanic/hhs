package com.alacriti.hhs.deligate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.alacriti.hhs.bo.ProviderBo;
import com.alacriti.hhs.util.Database;
import com.alacriti.hhs.util.Index;
import com.alacriti.hhs.util.ValidationUtil;

import freemarker.template.TemplateException;



public class ProviderDeligate {
	
	static Logger l = Logger.getLogger(ProviderDeligate.class.getName());
	Database db=new Database();
	Index index=new Index();
	Connection con=db.databaseConnection();

	public String postProviderDetails(String providerName, String serviceType,String mobileNumber, String emailId, String location, String city,
			String password,String cPassword) throws SQLException, IOException, TemplateException {
		ProviderBo pb = new ProviderBo();
		boolean flag=true;
		
		flag=ValidationUtil.validateName(providerName);
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
		flag=ValidationUtil.validatePhoneNumber(mobileNumber);
			if(flag==false){
				return "enter valid Mobile Number..!!";
			}
		flag=ValidationUtil.validatePassword(password, cPassword);
			if(flag==false){
				return "enter confirm password same as password...!!!";
			}
		if(flag==true){
			pb.postProvider(con,providerName, serviceType, mobileNumber, emailId,
					location, city, password);
			l.info("provider details validation is done");
			return index.provider();
			}
		else{
			l.info("enter valid details...!");
			return "enter valid details...!!";
			}
	
	}

	public void getResponseProvider(String response, int id) throws SQLException {
		ProviderBo pb = new ProviderBo();
		l.info(response);
		pb.responseProvider(con,response, id);

	}

	public void editProvider(String email, String mobileNumber, String password, int id) throws SQLException {
		ProviderBo pb = new ProviderBo();
		pb.editProvider(con,email,mobileNumber,password,id);
		
	}
}
