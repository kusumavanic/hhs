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
import com.alacriti.hhs.vo.UserVo;

import freemarker.template.TemplateException;

@Path("/index")
public class IndexResource {
	static Index index=new Index();
	UserVo user=new UserVo();
	static Logger l = Logger.getLogger(IndexResource.class.getName());
	@Context HttpServletRequest request;
	@GET
	public Response indexPage() throws IOException, TemplateException, URISyntaxException{
		URI uri= new URI("/login/consumerlog");
		URI uri2= new URI("/login/providerlog");
		URI uri3= new URI("/index/Admin");
		HttpSession session = request.getSession(false);
		l.info("session"+session);
		if(session != null){
			if(LoginResource.type=="consumer"){
				return Response.seeOther(uri).build();
			}
			if(LoginResource.type=="provider"){
				return Response.seeOther(uri2).build();
			}
			if(LoginResource.type=="admin"){
				return Response.seeOther(uri3).build();
			}
			else{
				return Response.status(200).entity(index.indexPage()).build();
			}
		}
		else
		{
			return Response.status(200).entity(index.indexPage()).build();
		}
	}
	@GET
	@Path("/adminLogin")
	public String admin() throws IOException, TemplateException{
		return index.admin();
	}
	@GET
	@Path("/providerLogin")
	public String providerLogin() throws IOException, TemplateException{
		return index.providerLogin();
	}
	@GET
	@Path("/consumerLogin")
	public String consumerLogin() throws IOException, TemplateException{
		return index.consumerLogin();
	}
	@GET
	@Path("/providerRegistration")
	public static String provider() throws IOException, TemplateException{
		return index.provider();
	}
	@GET
	@Path("/consumerRegistration")
	public static String consumer() throws IOException, TemplateException{
		return index.consumer();
	}
	@GET
	@Path("/guestLogin")
	public String guest() throws IOException, TemplateException{
		return index.guest();
	}
	@GET
	@Path("/Admin")
	public String getAdmin() throws IOException, TemplateException{
		return index.getAdmin();
	}
}
