package com.alacriti.hhs.deligate;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.core.Response;

import com.alacriti.hhs.bo.LoginBo;
import com.alacriti.hhs.util.Database;
import com.alacriti.hhs.vo.ServiceConsumer;
import com.alacriti.hhs.vo.ServiceProvider;
import com.alacriti.hhs.vo.consumerRequest;

public class LoginDeligate {
	Database db=new Database();
	Connection con= db.databaseConnection();
	
	public ArrayList<ServiceProvider> CheckProvider(String email, String password)
			throws URISyntaxException, SQLException {
		LoginBo lb = new LoginBo();
		return lb.CheckProvider(con,email, password);
	}

	public ArrayList<ServiceConsumer> CheckConsumer(String email, String password)
			throws URISyntaxException, SQLException {
		LoginBo lb = new LoginBo();
		ArrayList<ServiceConsumer> list=lb.CheckConsumer(con,email, password);
		return list;
	}

	public ArrayList<ServiceProvider> getProviders() throws SQLException {
		LoginBo lb = new LoginBo();
		return lb.getProviderList(con);
	}

	public Response checkAdmin(String name, String pass)throws URISyntaxException {
			
		LoginBo lb = new LoginBo();
		return lb.checkAdmin(con,name, pass);
	}

	public Object delCatogeory(String id) throws SQLException {
		LoginBo lb = new LoginBo();
		return lb.delCatogeory(con,id);

	}

	public Object delProvider(String id) throws SQLException {
		LoginBo lb = new LoginBo();
		return lb.delProvider(con,id);

	}

	public Object delConsumer(String id) throws SQLException {
		LoginBo lb = new LoginBo();
		return lb.delConsumer(con,id);
	}

	public ArrayList<ServiceProvider> viewProfile(String id) throws SQLException {
		LoginBo lb = new LoginBo();
		return lb.viewProfile(con,id);
	}

	//view consumer profile
	public ArrayList<ServiceConsumer> viewConsumerProfile(String id) throws SQLException {
		LoginBo lb = new LoginBo();
		return lb.viewConsumerProfile(con,id);
	}

	public ArrayList<consumerRequest> viewAdmin() {
		LoginBo lb = new LoginBo();
		return lb.viewAdmin(con);
		
	}

}
