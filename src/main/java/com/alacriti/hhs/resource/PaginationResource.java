package com.alacriti.hhs.resource;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.alacriti.hhs.deligate.PaginationDeligate;
import com.alacriti.hhs.util.Providerftl;
import com.alacriti.hhs.vo.PaginationVo;
import com.alacriti.hhs.vo.Service;
import com.alacriti.hhs.vo.ServiceConsumer;
import com.alacriti.hhs.vo.ServiceProvider;

import freemarker.template.TemplateException;

@Path("/pagination")
@Produces(MediaType.APPLICATION_JSON)
public class PaginationResource {
	static Logger l = Logger.getLogger(NewCatogeoryResource.class.getName());
	PaginationDeligate pd=new PaginationDeligate();
	
	//getting all provider details
	@POST
	public PaginationVo providerPagination(){
		return pd.providerPagination();
	}		
	@GET
	@Produces("text/html")
	@Path("/providers")
	public String getAllProvidersPagination(@QueryParam("query_id") int query_id,@QueryParam("start") int start,@QueryParam("offset") int offset) throws IOException, TemplateException{
		Providerftl pf=new Providerftl();
		PaginationVo page=new PaginationVo(query_id, 0, start, offset);
		ArrayList<ServiceProvider> list= pd.getAllProvidersPagination(page);
		return pf.getAllProvidersPagination(list);
	}
	
	//getting requested provider details
	@POST
	@Path("/request")
	public PaginationVo requestProviderPagination(){
		return pd.requestProviderPagination();
	}	
	@GET
	@Produces("text/html")
	@Path("/allreqest")
	public String getAllRequestProvidersPagination(@QueryParam("query_id") int query_id,@QueryParam("start") int start,@QueryParam("offset") int offset) throws IOException, TemplateException{
		Providerftl pf=new Providerftl();
		PaginationVo page=new PaginationVo(query_id, 0, start, offset);
		ArrayList<ServiceProvider> list= pd.getAllRequestProvidersPagination(page);
		return pf.getAllRequestProvidersPagination(list);
	}
	
	//getting index providers details
	@POST
	@Path("/indexRequest/{id}")
	public PaginationVo indexProviderPagination(@PathParam("id") String id){
		return pd.indexProviderPagination(id);
	}
	@GET
	@Produces("text/html")
	@Path("/indexProvidDetails")
	public String getIndexProvidersPagination(@QueryParam("query_id") int query_id,@QueryParam("start") int start,@QueryParam("offset") int offset) throws IOException, TemplateException{
		Providerftl pf=new Providerftl();
		PaginationVo page=new PaginationVo(query_id, 0, start, offset);
		ArrayList<ServiceProvider> list= pd.getIndexProvidersPagination(page);
		return pf.getIndexProvidersPagination(list);
	}
	
	//getting all provider details
	@Produces("text/html")
	@GET
	@Path("/allProvidDetails")
	public String getAllDetailsProviderPagination(@QueryParam("query_id") int query_id,@QueryParam("start") int start,@QueryParam("offset") int offset) throws IOException, TemplateException{
		Providerftl pf=new Providerftl();
		PaginationVo page=new PaginationVo(query_id, 0, start, offset);
		ArrayList<ServiceProvider> list= pd.getAllDetailsProviderPagination(page);
		return pf.getAllDetailsProviderPagination(list);
	}
	
	//getting consumer details
	@POST
	@Path("/consumer")
	public PaginationVo consumerPagination(){
		return pd.consumerPagination();
	}
	@Produces("text/html")
	@GET
	@Path("/consumerDetails")
	public String getConsumerPagination(@QueryParam("query_id") int query_id,@QueryParam("start") int start,@QueryParam("offset") int offset) throws IOException, TemplateException{
		Providerftl pf=new Providerftl();
		PaginationVo page=new PaginationVo(query_id, 0, start, offset);
		ArrayList<ServiceConsumer> list= pd.getConsumerPagination(page);
		return pf.getConsumerPagination(list);
	}
	
	//getting all services details
	@POST
	@Path("/service")
	public PaginationVo service(){
		return pd.service();
	}
	@Produces("text/html")
	@GET
	@Path("/serviceType")
	public String serviceType(@QueryParam("query_id") int query_id,@QueryParam("start") int start,@QueryParam("offset") int offset) throws IOException, TemplateException{
		Providerftl pf=new Providerftl();
		PaginationVo page=new PaginationVo(query_id, 0, start, offset);
		ArrayList<Service> list= pd.serviceType(page);
		return pf.serviceType(list);
	}
	
	//getting deleting provider details
	@Produces("text/html")
	@GET
	@Path("/delProvider")
	public String getDelProvider(@QueryParam("query_id") int query_id,@QueryParam("start") int start,@QueryParam("offset") int offset) throws IOException, TemplateException{
		Providerftl pf=new Providerftl();
		PaginationVo page=new PaginationVo(query_id, 0, start, offset);
		ArrayList<ServiceProvider> list= pd.getDelProvider(page);
		return pf.getDelProvider(list);
	}
	
	//getting deleting consumer details
	@Produces("text/html")
	@GET
	@Path("/delConsumer")
	public String getDelConsumer(@QueryParam("query_id") int query_id,@QueryParam("start") int start,@QueryParam("offset") int offset) throws IOException, TemplateException{
		Providerftl pf=new Providerftl();
		PaginationVo page=new PaginationVo(query_id, 0, start, offset);
		ArrayList<ServiceConsumer> list= pd.getDelConsumer(page);
		return pf.getDelConsumer(list);
	}
	
	//getting all provider details to see consumer
	@POST
	@Path("/sentRequestProvider")
	public PaginationVo sentRequestProvider(@QueryParam("id") String id,@QueryParam("catogeory") String catogeory){
		return pd.sentRequestProvider(id,catogeory);
	}
	@Produces("text/html")
	@GET
	@Path("/sentRequest")
	public String sentRequest(@QueryParam("id") String id,@QueryParam("query_id") int query_id,@QueryParam("start") int start,@QueryParam("offset") int offset) throws IOException, TemplateException{
		Providerftl pf=new Providerftl();
		PaginationVo page=new PaginationVo(query_id, 0, start, offset);
		ArrayList<ServiceProvider> list= pd.sentRequest(page);
		return pf.sentRequestProvider(list,id);
	}
	
	//getting consumer details to see provider
	@POST
	@Path("/getConsumer/{id}")
	public PaginationVo getConsumer(@PathParam("id") int id){
		return pd.getConsumer(id);
	}
	@Produces("text/html")
	@GET
	@Path("/getConsumer")
	public String getConsumer(@QueryParam("query_id") int query_id,@QueryParam("start") int start,@QueryParam("offset") int offset) throws IOException, TemplateException{
		Providerftl pf=new Providerftl();
		PaginationVo page=new PaginationVo(query_id, 0, start, offset);
		ArrayList<ServiceConsumer> list= pd.getConsumer(page);
		return pf.getConsumer(list);
	}
	
}
