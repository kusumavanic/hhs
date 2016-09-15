package com.alacriti.hhs.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.alacriti.hhs.vo.ProviderConsumer;
import com.alacriti.hhs.vo.ServiceProvider;


public class ProviderDatabase {
	static Logger l = Logger.getLogger(ProviderDatabase.class.getName());
	
	public boolean postServiceProviderDetails(Connection con,String providerName,String serviceType, String mobileNumber,
			String emailId, String location, String city,String password ) throws SQLException
	{
		Statement st = null;
		ResultSet set = null;
		ResultSet set1 = null;
		PreparedStatement ps;
		PreparedStatement ps1;
		try 
		{
		
			st=con.createStatement();
			con.setAutoCommit(false);
			String q1="select * from HHS_Services_Master_tbl where Ser_Type = '"+serviceType+"'";
			set= st.executeQuery(q1);	
			
			int value=0;
			while(set.next())
			{
				value=set.getInt(1);
			}
									
		ps=con.prepareStatement("insert into HHS_Service_Provider_tbl (Ser_Provid_Name,Ser_Provid_Mobile_Number,Ser_Provid_Email,Ser_Provid_Location,Ser_Provid_City,Ser_Provid_Password,Status) values(?,?,?,?,?,?,?)");
					ps.setString(1, providerName);		
					ps.setString(2, mobileNumber);
					ps.setString(3, emailId);
					ps.setString(4, location);
					ps.setString(5, city);
					ps.setString(6, password);	
					ps.setString(7, "Pending..");
					ps.executeUpdate();
		con.commit();
		
		int value2;
		String q2="select max(Ser_Provid_Id) from HHS_Service_Provider_tbl";
		set1= st.executeQuery(q2);
		
		    if(set1.next())
		    {
		    	value2 = set1.getInt(1);
			}
		    else
		    {
				value2=0;
			}
		ps1=con.prepareStatement("insert into HHS_Service_Provide_Relation_tbl values(?,?)");
		
		ps1.setLong(1, value2);		
		ps1.setLong(2, value);
		ps1.executeUpdate();
		con.commit();
		}
		catch(SQLException e)
		{
			l.warn("Posting new Provider details "+e);
		}
		finally{
			try {
				if(set!=null)
				{
					set.close();
				}
				if(set1!=null)
				{
					set.close();
				}
				if(st!=null)
				{
					st.close();
				}
				if(con!=null){
					con.close();
				}
				 
			} catch (SQLException e) {
					l.error("Posting new Provider details "+e);
			}
			
		l.info("new Provider details are posted...!!!");
		}
		return true;
	
	}
	
	
	public  ArrayList<ServiceProvider> getProviderName(Connection con) throws SQLException
	{
		ArrayList<ServiceProvider> list = new ArrayList<ServiceProvider>();
		Statement st = null;
		ResultSet set = null;
		try
		{
			st = con.createStatement();	
			con.setAutoCommit(false);
			String q2 = "select * from HHS_Service_Provider_tbl";		
			set = st.executeQuery(q2);		
		while(set.next()){			
			list.add(new ServiceProvider(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),
					set.getString(6),set.getString(7),set.getTimestamp(8),set.getString(9)));
		}
		con.commit();
		}
		catch(SQLException e)
		{
			l.warn("getting provider details"+e);
		}
		finally{
			try
			{
				if(set!=null)
				{
					set.close();
				}
				if(st!=null)
				{
					st.close();
				}
				if(con!=null){
					con.close();
				}
				 
			} catch (SQLException e) {
					l.error("getting provider details "+e);
			}
		}
			return list;
		}
	public  ArrayList<ServiceProvider> getRequestProviderName(Connection con) throws SQLException
	{
		ArrayList<ServiceProvider> list = new ArrayList<ServiceProvider>();
		Statement st = null;
		ResultSet set = null;
		try
		{
			st = con.createStatement();		 
			con.setAutoCommit(false);
			String q2 = "select * from HHS_Service_Provider_tbl where Status='Pending..'";		
			set = st.executeQuery(q2);	
			con.commit();
		while(set.next()){			
			list.add(new ServiceProvider(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),
					set.getString(6),set.getString(7),set.getTimestamp(8),set.getString(9)));
		}
		
	}
	
	catch(SQLException e)
	{
		l.warn("request Provider details"+e);
	}finally{
		try
		{
			if(set!=null)
			{
				set.close();
			}
			if(con!=null){
				con.close();
			}
			 
		} catch (SQLException e) {
				l.error("request Provider details "+e);
		}
	}
		return list;
	}
	public boolean getResponseProvider(Connection con,String response,int id) throws SQLException
	{	
		Statement st = null;
		try
		{		
			st = con.createStatement();
			con.setAutoCommit(false);
			String q ;		
			l.info("admin response :"+response);
			if(response.equals("accept")){
				 q = "update HHS_Service_Provider_tbl set Status = 'Available' where Ser_Provid_Id= '"+id+"'; ";
				 st.executeUpdate(q);			 
				 
			}if(response.equals("decline")){
				 q = "update HHS_Service_Provider_tbl set Status = 'NotAvailable' where Ser_Provid_Id= '"+id+"'; ";
				 st.executeUpdate(q);
		}		
		con.commit();
	}
	catch(SQLException e)
	{
		l.warn("get response provider details "+e);
	}finally{
		try
		{
			if(con!=null){
				con.close();
			}
			 
		} catch (SQLException e) {
				l.error("get response provider details "+e);
		}
	}
		return true;
	}
	

	public String getResponseProvider(Connection con, String email,
			String mobileNumber, String password, int id) throws SQLException {
		Statement st = null;
		try
		{
			st=con.createStatement();
			con.setAutoCommit(false);
			String q1="update HHS_Service_Provider_tbl set Ser_Provid_Email='"+email+"',Ser_Provid_Mobile_Number='"+mobileNumber+"',Ser_Provid_Password='"+password+"' where Ser_Provid_Id='"+id+"';";
			st.executeUpdate(q1);
			con.commit();
		}
		catch(SQLException e)
		{
			l.warn("updating provider details "+e);
		}finally{
			try
			{
				if(con!=null){
					con.close();
				}
				 
			} catch (SQLException e) {
					l.error("updating provider details "+e);
			}
		}
		return "edited successfully...!!!";
		
	}



	public ArrayList<ProviderConsumer> sentRequest(Connection con, String catogeory, String id) throws SQLException {
		ArrayList<ProviderConsumer> list=new ArrayList<ProviderConsumer>();
		Statement st = null;
		try
		{
		st = con.createStatement();
		con.setAutoCommit(false);
		
		String q3="select * from HHS_Service_Provider_tbl where Ser_Provid_Id in(select Ser_Provid_Id from "
				+ "HHS_Service_Provide_Relation_tbl where Ser_Id in(select Ser_Id from HHS_Services_Master_tbl "
				+ "where Ser_Type='"+catogeory+"'));";
		ResultSet set = st.executeQuery(q3);
		while(set.next()){
           list.add(new ProviderConsumer(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),
					set.getString(6),set.getString(7), set.getTimestamp(8),set.getString(9),id));
        } 
		con.commit();
        set.close();      
		}
	
		catch(SQLException e)
		{
			l.warn("sending request to provider "+e);
		}finally{
			try
			{
				if(con!=null){
					con.close();
				}
				 
			} catch (SQLException e) {
					l.error("sending request to provider "+e);
			}
		}
		return list;
		
	}

	public void requestToProvider(Connection con, int consumerId,int providerId) throws SQLException {
		try{
			
			Statement st = con.createStatement();
			con.setAutoCommit(false);
			String q2="insert into HHS_Provider_Consumer_tbl(provider_Id,consumer_Id) values('"+providerId+"','"+consumerId+"');";
			st.executeUpdate(q2);
			con.commit();

		}
		catch(SQLException e)
		{
			l.warn("sending request to provider "+e);
		}finally{
			try
			{
				if(con!=null){
					con.close();
				}
				 
			} catch (SQLException e) {
					l.error("sending request to provider "+e);
			}

		}
	}
}
	
	
	




