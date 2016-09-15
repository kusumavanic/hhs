package com.alacriti.hhs.resource;



import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.alacriti.hhs.dao.ProviderDatabase;
import com.alacriti.hhs.deligate.ProviderDeligate;
import com.alacriti.hhs.util.Providerftl;

import freemarker.template.TemplateException;



@Path("/provider")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.TEXT_HTML)
public class ServiceProviderResource {
	static Logger l = Logger.getLogger(ServiceProviderResource.class.getName());
	ProviderDatabase db=new ProviderDatabase();
	@POST
	public String addServiceProvider(@FormParam("providerName") String providerName,
			@FormParam("serviceType") String serviceType,
			@FormParam("mobileNumber") String mobileNumber,
			@FormParam("emailId") String emailId,
			@FormParam("location") String location,
			@FormParam("city") String city,
			@FormParam("password") String password,
			@FormParam("confirmPassword") String cPassword) throws URISyntaxException, SQLException, IOException, TemplateException{
		
			ProviderDeligate pd=new ProviderDeligate();
			
			l.info("provider is successfully registered...!!!");
			return pd.postProviderDetails(providerName,serviceType, mobileNumber, emailId, location, city, password,cPassword);
		    
		
		}	
	
	@GET
	@Path("/respon")
	public Response responseProvid(@QueryParam("respon") String response,@QueryParam("id") int id) throws SQLException, URISyntaxException 
	{
		URI uri= new URI("/login/requestprovider");
		ProviderDeligate pd=new ProviderDeligate();
		pd.getResponseProvider(response,id);
		l.info("Provider status is updated...!!!");
		return Response.seeOther(uri).build();
			
	}
	@POST
	@Path("/editProvider/{id}")
	public Response editProvider(@PathParam("id") int id,
							   @FormParam("email") String email,
							   @FormParam("mobileNumber") String mobileNumber,
							   @FormParam("password") String password) throws SQLException, URISyntaxException
	{
		URI uri= new URI("/login/"+id);
		ProviderDeligate pd=new ProviderDeligate();
		pd.editProvider(email,mobileNumber,password,id);
		l.info("provider detils are successfully edited..!!");
		return Response.seeOther(uri).build();
	}
	@GET
	@Path("requestConsumer/{id}")
	public String requestConsumers(@PathParam("id") String id) throws IOException, TemplateException, SQLException{
		
		Providerftl pf=new Providerftl();	
		l.info("these are requested consumers...!!");
		return pf.requestConsumers(id);
	}
	

}
