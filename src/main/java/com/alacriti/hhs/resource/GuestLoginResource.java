package com.alacriti.hhs.resource;


import java.net.URISyntaxException;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.alacriti.hhs.deligate.guestLoginDelegate;




@Path("/guest")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)

public class GuestLoginResource {
	static Logger l = Logger.getLogger(IndexResource.class.getName());
@POST
public  Response addServiceProvider(@FormParam("userName") String userName,
									@FormParam("emailId") String emailId,
									@FormParam("mobileNumber") String mobileNumber) throws URISyntaxException, SQLException{
		l.info(userName);
		l.info(mobileNumber);
		guestLoginDelegate gld=new guestLoginDelegate();
		Response b=gld.postGuestDetails(userName, emailId, mobileNumber);
				
		return b;
			
}	
@Path("/response")
@GET
public String GuestResponse(){
		l.info("second time using service");
		return "You are using second time our service as a guest please register...!!!";
	
}


}
