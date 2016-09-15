package com.alacriti.hhs.bo;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.alacriti.hhs.dao.ConsumerDatabase;
import com.alacriti.hhs.dao.LoginDatabase;
import com.alacriti.hhs.dao.NewCatogeoryDao;
import com.alacriti.hhs.dao.ProviderDatabase;
import com.alacriti.hhs.deligate.LoginDeligate;
import com.alacriti.hhs.resource.LoginResource;
import com.alacriti.hhs.vo.ServiceConsumer;
import com.alacriti.hhs.vo.ServiceProvider;
import com.alacriti.hhs.vo.consumerRequest;

public class LoginBo {
	public static boolean result;
	static Logger l = Logger.getLogger(LoginResource.class.getName());
	 LoginDeligate ldt=new LoginDeligate();
	 ProviderDatabase db=new ProviderDatabase();
	 ConsumerDatabase cd=new ConsumerDatabase();
	 NewCatogeoryDao nc=new NewCatogeoryDao();
	 
	 @Context HttpServletRequest request;
	 
	public Response checkAdmin(Connection con, String name,String pass) throws URISyntaxException {
		URI uri = new URI("/index/adminLogin");
        URI uri2= new URI("/index/Admin");
        	 if(name.equals("admin") && pass.equals("pass"))
	            {
        			
        			HttpSession session = request.getSession(true);
        			session.setAttribute("email", name);
        			session.setAttribute("password",pass);
        			String sessionId=session.getId();
        			l.info("session "+sessionId);
        	        return Response.seeOther(uri2).build();

	            }
	        else
	        {
	        	result=false;
	            return Response.seeOther(uri).build();
	        }
       
	}
	public ArrayList<ServiceConsumer> CheckConsumer(Connection con, String email,String password) throws URISyntaxException, SQLException{
		
        LoginDatabase ld=new LoginDatabase();
        ArrayList<ServiceConsumer> list = ld.ConsumerLogin(con,email,password);	
        return list;
	}
	public ArrayList<ServiceProvider> CheckProvider(Connection con, String email,String password) throws URISyntaxException, SQLException{
         LoginDatabase ld=new LoginDatabase();
        return ld.providerLogin(con, email, password);
        
	}
	public ArrayList<ServiceProvider> getProviderList(Connection con) throws SQLException {
		ArrayList<ServiceProvider> list =db.getProviderName(con);
		return list;
	}
	public Object delCatogeory(Connection con, String id) throws SQLException{
		return nc.deleteCatogeory(con,id);
	}
	public Object delProvider(Connection con, String id) throws SQLException {
		return nc.deleteProvider(con,id);
	}
	
	//delete consumer
	public Object delConsumer(Connection con, String id) throws SQLException {
		return nc.deleteConsumer(con,id);
	}
	
	//view provider profile
	public ArrayList<ServiceProvider> viewProfile(Connection con, String id) throws SQLException {
		 LoginDatabase ld=new LoginDatabase();
		 return ld.viewProfile(con,id);
	}
	
	//view consumer profile
	public ArrayList<ServiceConsumer> viewConsumerProfile(Connection con, String id) throws SQLException {
		 LoginDatabase ld=new LoginDatabase();
		 return ld.viewConsumerProfile(con,id);
	}
	
	//admin can see requested consumers
	public ArrayList<consumerRequest> viewAdmin(Connection con) {
		LoginDatabase ld=new LoginDatabase();
		 return ld.viewAdmin(con);
	}		
	}
	

