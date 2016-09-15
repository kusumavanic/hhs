package com.alacriti.hhs.deligate;

import java.net.URISyntaxException;
import java.sql.Connection;

import javax.ws.rs.core.Response;

import com.alacriti.hhs.bo.GuestBo;
import com.alacriti.hhs.util.Database;


public class guestLoginDelegate {
	Database db=new Database();
	Connection con=db.databaseConnection();
	
	public Response postGuestDetails(String name,String email,String mobileNumber) throws URISyntaxException{
		
		GuestBo gb=new GuestBo();

		//String s=null;
		/*flag=ValidationUtil.validateName(name);
			if(flag==false){
				return s="enter valid name...!!";			
		}
		flag=ValidationUtil.validateEmailAddress(email);
		if(flag==false){
			return s="enter valid emailID..!!";
		}
		flag=ValidationUtil.validatePhoneNumber(mobileNumber);
		if(flag==false){
			return s="enter valid Mobile Number..!!";
		}*/
		
		return gb.postGuestDetails(con,name,email,mobileNumber);
		}
		
	}

