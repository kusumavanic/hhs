package com.alacriti.hhs.resource;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.alacriti.hhs.util.Index;

import freemarker.template.TemplateException;


@Path("/logout")
public class LogOutResource {
	static Logger l = Logger.getLogger(LogOutResource.class.getName());
	@Context HttpServletRequest request;

	@GET
	public Response logoutSession() throws URISyntaxException, IOException, TemplateException{
		Index index=new Index();
		URI uri= new URI("/index/providerLogin");
		URI uri2= new URI("/index/consumerLogin");
		URI uri3= new URI("/index/adminLogin");
		HttpSession session = request.getSession(false);
    	l.info("session expaired");
    	if(session != null){
    		session.invalidate();
    		if(LoginResource.type=="consumer"){
    			return Response.seeOther(uri2).build();
			}
			if(LoginResource.type=="provider"){
				return Response.seeOther(uri).build();
			}
			if(LoginResource.type=="admin"){
				return Response.seeOther(uri3).build();
			}
			else{
				return Response.status(200).entity(index.indexPage()).build();
			}
    	}
    	return Response.status(200).entity(index.indexPage()).build();		
	}
}
