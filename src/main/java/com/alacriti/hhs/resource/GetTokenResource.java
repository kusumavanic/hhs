package com.alacriti.hhs.resource;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.alacriti.hhs.dao.OAuthDao;
import com.alacriti.hhs.deligate.OAuthLoginDeligate;
import com.alacriti.hhs.util.Index;
import com.alacriti.hhs.util.Providerftl;
import com.alacriti.hhs.vo.ServiceConsumer;

import freemarker.template.TemplateException;

 @Path("user")
public class GetTokenResource {
	 Index index=new Index();
	 NewCatogeoryResource ncr=new NewCatogeoryResource();
	 static Logger l = Logger.getLogger(GetTokenResource.class.getName());
	 
	 @Context HttpServletRequest request;
	 
	@GET
	@Path("/google")	
	public Response getUserTokenId(@QueryParam("idtoken") String token_id) throws GeneralSecurityException, IOException, SQLException, TemplateException{
		Providerftl pf=new Providerftl();
		l.info("resource called");
		OAuthLoginDeligate oAuthLoginDelegate = new OAuthLoginDeligate();
		ArrayList<ServiceConsumer> list=oAuthLoginDelegate.getUserTokenId(token_id);
		l.info(list.get(0).getConsumerName());
		l.info(list.get(0).getEmailId());
		l.info(OAuthDao.result);
		
	if(OAuthDao.result == true){
		HttpSession session = request.getSession(true);
		l.info("session------"+session);
		session.setAttribute("email", list.get(0).getEmailId());
		session.setAttribute("id", list.get(0).getId());
		//ncr.getNewProviderCatogeory(request);
		return Response.status(200).entity(pf.consumerLogin(list)).build();
	}
	else{
		return  Response.status(200).entity(index.indexPage()).build();
	}
}
	@GET
	@Path("/logout")
	public Response logOut() throws URISyntaxException{
		URI uri = new URI("/hhs/Login.html");
		return Response.seeOther(uri).build();
	}
	
}
