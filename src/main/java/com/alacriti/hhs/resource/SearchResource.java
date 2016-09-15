package com.alacriti.hhs.resource;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.alacriti.hhs.deligate.SearchDelegate;
import com.alacriti.hhs.util.Providerftl;
import com.alacriti.hhs.vo.PaginationVo;
import com.alacriti.hhs.vo.ServiceProvider;

import freemarker.template.TemplateException;

@Path("/search")
public class SearchResource {
	static Logger l = Logger.getLogger(SearchResource.class.getName());
	SearchDelegate searchDelegate=new SearchDelegate();
	PaginationVo pv=new PaginationVo();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{search}")
	public PaginationVo searchProvider(@PathParam("search") String searchName){
		l.info("search value :"+searchName);
		
		PaginationVo pag=searchDelegate.searchProvider(searchName);
		l.info("return resource query"+pag.getQuery_id()+"count "+pag.getCount());
		return pag;	
	}
	@Produces("text/html")
	@GET
	@Path("/providers")
	public String searchProviders(@QueryParam("query_id") int query_id,@QueryParam("start") int start,@QueryParam("offset") int offset) throws IOException, TemplateException{
		l.info("I came here...");
		Providerftl pf=new Providerftl();
		PaginationVo page=new PaginationVo(query_id, 0, start, offset);
		ArrayList<ServiceProvider> list= searchDelegate.searchProviders(page);
		return pf.getAllProvidersPagination(list);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{catogeory}/{search}")
	public PaginationVo searchProvidercatogeory(@PathParam("catogeory") String catogeory,
												@PathParam("search") String searchName){
		l.info("search value :"+searchName);
		
		PaginationVo pag=searchDelegate.searchProvidercatogeory(catogeory,searchName);
		l.info("return resource query"+pag.getQuery_id()+"count "+pag.getCount());
		return pag;	
	}
	@Produces("text/html")
	@GET
	@Path("/request/providers")
	public String requestProviders(@QueryParam("query_id") int query_id,@QueryParam("start") int start,@QueryParam("offset") int offset,@QueryParam("id") String id) throws IOException, TemplateException{
		l.info("I came here...");
		l.info("id "+id);
		Providerftl pf=new Providerftl();
		PaginationVo page=new PaginationVo(query_id, 0, start, offset);
		ArrayList<ServiceProvider> list= searchDelegate.searchProviders(page);
		
		return pf.sentRequestProvider(list,id);
	}
}
