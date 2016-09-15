package com.alacriti.hhs.resource;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.alacriti.hhs.deligate.ConsumerDeligate;
import com.alacriti.hhs.util.Index;
import com.alacriti.hhs.util.Providerftl;
import com.alacriti.hhs.util.SendEmail;
import com.alacriti.hhs.vo.Service;

import freemarker.template.TemplateException;

@Path("/consumer")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public class ServiceConsumerResource {
	static Logger l = Logger.getLogger(ServiceConsumerResource.class.getName());
	ConsumerDeligate cd = new ConsumerDeligate();
	Providerftl pf = new Providerftl();
	Index index=new Index();

	@POST
	public String addServiceConsumer(
			@FormParam("consumerName") String consumerName,
			@FormParam("mobileNumber") String mobileNumber,
			@FormParam("emailId") String emailId,
			@FormParam("altEmailId") String altEmailId,
			@FormParam("location") String location,
			@FormParam("city") String city,
			@FormParam("password") String password,
			@FormParam("confirmPassword") String cPassword)
			throws URISyntaxException, SQLException, IOException,
			TemplateException {

		l.info("Posting new consumer details");
		return cd.postConsumerDetails(consumerName, mobileNumber, emailId,
				altEmailId, location, city, password, cPassword);

	}

	@POST
	@Path("/editConsumer/{id}")
	public Response editProvider(@PathParam("id") int id,
			@FormParam("email") String email,
			@FormParam("altEmail") String altEmail,
			@FormParam("mobileNumber") String mobileNumber,
			@FormParam("password") String password) throws SQLException,
			URISyntaxException {
		URI uri = new URI("/login/consumer/" + id);
		ConsumerDeligate pd = new ConsumerDeligate();
		pd.editConsumer(email, altEmail, mobileNumber, password, id);
		l.info("edit consumer details");
		return Response.seeOther(uri).build();
	}

	@POST
	@Path("/sentRequest/{id}")
	public String sentProviderRequest(@PathParam("id") int id,
			@FormParam("serviceType") String serviceType) throws SQLException,
			IOException, TemplateException {
		ArrayList<Service> list = new ArrayList<Service>();
		list.add(new Service(id, serviceType));
		l.info("sending request to provider");
		return pf.sentRequest(list, id);

	}

	@GET
	@Path("/requestToProvider/{cId}/{pId}")
	public Response requestToProvider(@PathParam("cId") int ConsumerId,
			@PathParam("pId") int providerId) throws SQLException, IOException,
			TemplateException, URISyntaxException {
		URI uri = new URI("/newCatogeory/get/all");
		cd.requestToProvider(ConsumerId, providerId);
		
		l.info("sending request to provider");
		return Response.seeOther(uri).build();
	}

	@GET
	@Path("/composeMail")
	public String composeMail(@Context HttpServletRequest request)
			throws IOException, TemplateException {
		SendEmail se = new SendEmail();
		HttpSession session = request.getSession(false);
		if(session != null){
			int consumerId = (Integer) session.getAttribute("id");
			String catogeory = (String) session.getAttribute("catogeory");
			l.debug("consumerId : " + consumerId+"catogeory : "+catogeory);
	
			Service service = new Service();
			service.setProviderId(consumerId);
			service.setServiceType(catogeory);
			ArrayList<Service> list = new ArrayList<Service>();
	
			list.add(new Service(service.getProviderId(), service.getServiceType()));
	
			if (list.size() > 0) {
				l.debug("consumerId :" + list.get(0).getProviderId()+"catogeory : "+list.get(0).getServiceType());
			}
			return se.sendMail(list);
		}
		else{
			return index.consumerLogin();
		}
	}
	
}
