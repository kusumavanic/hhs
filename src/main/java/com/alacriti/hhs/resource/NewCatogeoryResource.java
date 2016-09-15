package com.alacriti.hhs.resource;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.alacriti.hhs.deligate.NewCatogeoryDeligate;
import com.alacriti.hhs.util.Catogeory;
import com.alacriti.hhs.util.Index;
import com.alacriti.hhs.vo.AddNewCatogeory;
import com.alacriti.hhs.vo.Service;

import freemarker.template.TemplateException;

@Path("/newCatogeory")
public class NewCatogeoryResource {
	static Logger l = Logger.getLogger(NewCatogeoryResource.class.getName());
	NewCatogeoryDeligate ncd = new NewCatogeoryDeligate();
	Catogeory cy = new Catogeory();
	Index index=new Index();

	@POST
	public Response newCatogeoory(@FormParam("catogeory") String catogeory,
			@FormParam("icon") String icon) throws SQLException,
			URISyntaxException {
		URI uri = new URI("../AddNewCatogeory.html");
		ncd.newCatogeory(catogeory, icon);
		l.info("new catogeory is added");
		return Response.seeOther(uri).build();
	}

	@GET
	@Path("/get")
	 
	public Response getNewCatogeory() throws IOException, TemplateException,
			SQLException, URISyntaxException {
		
		URI uri = new URI("../AddNewCatogeory.html");
		ArrayList<AddNewCatogeory> list = ncd.getNewCatogeory();
		cy.serviceCatogeory(list);
 
		return Response.seeOther(uri).build();
	}

	@GET
	@Path("/get/all/ad")
	public String getNewProviderCatogeoryAd() throws IOException,
			TemplateException, SQLException {
		ArrayList<AddNewCatogeory> list = ncd.getNewCatogeory();
		return cy.serviceProviderDetailsad(list);
	}
	
	@Context HttpServletRequest request;
		
	@GET
	@Path("/get/all")
	public String getNewProviderCatogeory() throws IOException, TemplateException, SQLException{
		HttpSession session = request.getSession(false);
		l.debug("session :"+session);
		int consumerId=0;
		if(session!=null)
		{
			consumerId=(Integer) session.getAttribute("id");
			ArrayList<AddNewCatogeory> list=ncd.getNewCatogeory();
			return cy.serviceProviderDetails(list,consumerId);
		}
		else{
			return index.consumerLogin();
		}
	}

	@GET
	@Path("/option")
	public Response getNewOption() throws IOException, TemplateException,
			SQLException, URISyntaxException {
		URI uri = new URI("../AddNewCatogeory.html");
		ArrayList<AddNewCatogeory> list = ncd.getNewCatogeory();
		cy.AddOption(list);
		return Response.seeOther(uri).build();
	}

	@GET
	@Path("/{id}")
	public String getUserById(@PathParam("id") String id) throws IOException,
			TemplateException, SQLException {
		return cy.serviceProviderCatogeory(id);
	}

	@GET
	@Path("details/ad/{id}")
	public String getUserDetailById(@PathParam("id") String id)
			throws IOException, TemplateException, SQLException {
		return cy.serviceProviderDetailsCatogeory(id);
	}

	@GET
	@Path("details/{id}")
	public String getUserDetailsById(@PathParam("id") String id,
			@Context HttpServletRequest request) throws IOException,
			TemplateException, SQLException {
		HttpSession session = request.getSession(false);
		
		if(session != null)
		{			
			session.setAttribute("catogeory", id);
			int consumerId = (Integer) session.getAttribute("id");
			Service service = new Service();
			service.setProviderId(consumerId);
			service.setServiceType(id);
			ArrayList<Service> list = new ArrayList<Service>();
	
			list.add(new Service(service.getProviderId(), service.getServiceType()));
	
			l.info("consumerId :" + list.get(0).getProviderId());
			l.info("catogeory :" + list.get(0).getServiceType());
			return cy.serviceProviderDetailsCatogeory1(list);
		}
		else{
			return index.consumerLogin();
		}
	}
}
