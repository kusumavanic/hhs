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

import com.alacriti.hhs.dao.ConsumerDatabase;
import com.alacriti.hhs.dao.LoginDatabase;
import com.alacriti.hhs.dao.ProviderDatabase;
import com.alacriti.hhs.deligate.LoginDeligate;
import com.alacriti.hhs.util.Catogeory;
import com.alacriti.hhs.util.Index;
import com.alacriti.hhs.util.Providerftl;
import com.alacriti.hhs.vo.ServiceConsumer;
import com.alacriti.hhs.vo.ServiceProvider;
import com.alacriti.hhs.vo.UserVo;
import com.alacriti.hhs.vo.consumerRequest;

import freemarker.template.TemplateException;

@Path("/login")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public class LoginResource {
	static Logger l = Logger.getLogger(LoginResource.class.getName());
	Index index=new Index();
	ProviderDatabase db=new ProviderDatabase();
	ConsumerDatabase cd=new ConsumerDatabase();
	LoginDatabase ld=new LoginDatabase();
	Providerftl pf=new Providerftl();
	public static String type;
	@Context HttpServletRequest request;
	
	@Path("/consumerlog")
	@POST
	public String addServiceConsumer(@FormParam("email") String email,
			@FormParam("password") String password) throws URISyntaxException, IOException, TemplateException, SQLException {
		
		LoginDeligate ld=new LoginDeligate();		 	
		ArrayList<ServiceConsumer> list=ld.CheckConsumer(email, password);
		UserVo user=new UserVo();
		l.info("form dao "+LoginDatabase.result);
			if(LoginDatabase.result == true)
			{
				HttpSession session = request.getSession(true);
				session.setAttribute("email", email);
				session.setAttribute("password",password);
				type="consumer";
				int id=LoginDatabase.id1;
				session.setAttribute("id",id);
				user.setEmail(email);
				String sessionId=session.getId();
				l.info("provider id :"+id);
				l.info("session "+sessionId);
				return  pf.consumerLogin(list);
			}
			else{
				l.warn("consumer login failed");
				return index.consumerLogin();	
			}
							
	}
	@Path("/providerlog")
	@POST
	public String addServiceProvider(@FormParam("email") String email,
			@FormParam("password") String password) throws URISyntaxException, IOException, TemplateException, SQLException{
		 
		   LoginDeligate ld=new LoginDeligate();
	 	   ArrayList<ServiceProvider> list=ld.CheckProvider(email, password);
	 	   l.info("form dao "+LoginDatabase.result);
			 	if(LoginDatabase.result== true)
				{
					HttpSession session = request.getSession(true);
					session.setAttribute("email", email);
					type="provider";
					int id=LoginDatabase.id;
					session.setAttribute("id",id);
					session.setAttribute("password",password);
					String sessionId=session.getId();
					l.info("provider id :"+id);
					l.info("session "+sessionId);
					return pf.providerLogin(list);
				}
				else{
					l.warn("provider login failed");
					return index.providerLogin();	
				}
		}
	@POST
	@Path("/check")
	public Response checkDetails(@FormParam("name") String name,@FormParam("password") String pass ) throws URISyntaxException  {
		URI uri = new URI("/index/adminLogin");
        URI uri2= new URI("/newCatogeory/get/all/ad");
        	 if(name.equals("admin") && pass.equals("pass"))
	         {
        			HttpSession session = request.getSession(true);
        			session.setAttribute("email", name);
        			type="admin";
        			session.setAttribute("password",pass);
        			String sessionId=session.getId();
        			l.info("session "+sessionId);
        			l.info("admin login");
        	        return Response.seeOther(uri2).build();

	         }
	         else
	         {
	        	l.warn("admin login failed");
	            return Response.seeOther(uri).build();
	        }
	}
	@GET
	@Path("/provider")
	public String getProvider() throws IOException, TemplateException, SQLException{
		
		LoginDeligate ld=new LoginDeligate();
		ArrayList<ServiceProvider> list=ld.getProviders();
		return pf.getProviders(list);
	}
	@GET
	@Path("/providers")
	public String getProviders() throws IOException, TemplateException, SQLException{
		HttpSession session = request.getSession(false);
		if(session !=null){
			int id=(Integer) session.getAttribute("id");
			l.info("id :"+id);
			return pf.getProviders1(id);
		}
		else{
			return index.consumerLogin();
		}
	}
	@GET
	@Path("/requestprovider")
	public String getRequestProvider() throws IOException, TemplateException, SQLException{
		Providerftl pf=new Providerftl();
		return pf.getrequestProviders();
	}
	@GET
	@Path("/consumer")
	public String getConsumer() throws IOException, TemplateException, SQLException{
		Providerftl pf=new Providerftl();
		return pf.getConsumers();
	}
	@GET
	@Path("/service")
	public String getService() throws IOException, TemplateException, SQLException{
		Providerftl pf=new Providerftl();
		return pf.getServices();
	}
	
	@Path("/delete")
	@POST
	public Response getUserById(@FormParam("serviceType") String id) throws SQLException, URISyntaxException {
		URI uri= new URI("../delete.html");
		l.info("serviceType :"+id);
		LoginDeligate ld=new LoginDeligate();
		ld.delCatogeory(id);
		l.info("service type deleted successfully..!!!");
		return Response.seeOther(uri).build();
	}
	@GET
	@Path("/selectProvider")
	public String selectProvider() throws IOException, TemplateException, SQLException{
		Catogeory c=new Catogeory();
		return c.getDeleteProviders();	    
	}
	@GET
	@Path("/deleteProvider/{id}")
	public Response delProvider(@PathParam("id") String id) throws SQLException, URISyntaxException{
		URI uri= new URI("/login/selectProvider");
		LoginDeligate ld=new LoginDeligate();
		ld.delProvider(id);
		l.info("provider deleted successfully..!!!");
		return Response.seeOther(uri).build();
	    
	}
	@GET
	@Path("/selectConsumer")
	public String selectConsumer() throws IOException, TemplateException, SQLException{
		Catogeory c=new Catogeory();
		return c.getDeleteConsumers();	    
	}
	@GET
	@Path("/deleteConsumer/{id}")
	public Response delConsumer(@PathParam("id") String id) throws SQLException, URISyntaxException{
		URI uri= new URI("/login/selectConsumer");
		LoginDeligate ld=new LoginDeligate();
		ld.delConsumer(id);
		l.info("consumer deleted successfully..!!!");
		return Response.seeOther(uri).build();
	}
	
	// view provider Profile
	@GET
	@Path("/{id}")
	public String viewProfile(@PathParam("id") String id) throws IOException, TemplateException, SQLException, URISyntaxException{
		LoginDeligate ld=new LoginDeligate();
		ArrayList<ServiceProvider> list=ld.viewProfile(id);
		l.info("view provider profile");
	    return pf.viewProfile(list);
	}
	
	//view consumer profile
	@GET
	@Path("/consumer/{id}")
	public String viewConsumerProfile(@PathParam("id") String id) throws IOException, TemplateException, SQLException{
		LoginDeligate ld=new LoginDeligate();
		ArrayList<ServiceConsumer> list=ld.viewConsumerProfile(id);
		l.info("view consumer profile");
		return pf.viewConsumerProfile(list);
	}
	
	//admin can see requested consumers
	@GET
	@Path("/adminsee")
	public String viewAdmin() throws IOException, TemplateException{
		LoginDeligate ld=new LoginDeligate();
		ArrayList<consumerRequest> list=ld.viewAdmin();
		l.info("admin can see requested consumers");
		return pf.viewAdmin(list);
	}
}

