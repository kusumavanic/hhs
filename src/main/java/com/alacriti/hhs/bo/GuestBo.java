package com.alacriti.hhs.bo;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.ws.rs.core.Response;

import com.alacriti.hhs.dao.LoginDatabase;
import com.alacriti.hhs.vo.GuestLogin;

public class GuestBo {

	public Response postGuestDetails(Connection con, String name, String email,
			String mobileNumber) throws URISyntaxException {
		Response r=null;
		try {
		GuestLogin gl=new GuestLogin();
		LoginDatabase db=new LoginDatabase();
		gl.setUserName(name);
		gl.setMobileNumber(mobileNumber);
		gl.setEmailId(email);
		boolean b=false;
		URI uri = new URI("../guest.html");
	    URI uri2= new URI("guest/response");
	    
		b = db.postGuestLoginDetails(con,gl.getUserName(), gl.getMobileNumber(), gl.getEmailId());
		
	    if(b==true)
		{
		       
			   return r=Response.seeOther(uri).build();
		}
	    if(b==false)
	    {	    		
	            return r=Response.seeOther(uri2).build();
	    }
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return r;
	   
	}

}
