package com.alacriti.hhs.dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.alacriti.hhs.vo.ServiceConsumer;
import com.alacriti.hhs.vo.ServiceProvider;
import com.alacriti.hhs.vo.consumerRequest;

public class LoginDatabase {
	public static boolean result=false;
	public static int id;
	public static int id1;
	static Logger l = Logger.getLogger(LoginDatabase.class.getName());
	public boolean postGuestLoginDetails(Connection con, String userName, String mobileNumber,String emailId) throws SQLException
	{
		Statement st = null;
		ResultSet set = null;
		boolean flag=false;
		try {
		
		st=con.createStatement();
		con.setAutoCommit(false);
		String q="select * from HHS_Service_Guest_tbl where Ser_Guest_Email='"+emailId+"';";
		set = st.executeQuery(q);
		l.info("true"+userName);
		l.info(mobileNumber);
		if(set.next()){
			flag =false;			
		}
		else{
			
			PreparedStatement ps=con.prepareStatement("insert into HHS_Service_Guest_tbl(Ser_Guest_Name,Ser_Guest_Mobile_Number,"
					+ "Ser_Guest_Email) values(?,?,?)");
			l.info("false"+userName);
			l.info(mobileNumber);
			ps.setString(1, userName);
			ps.setString(2, mobileNumber);
			ps.setString(3, emailId);
			ps.executeUpdate();
			flag=true;
		}
		
		}
		
		catch(SQLException e)
		{
			l.error("posting guest details...!!! "+e);;
		}
		finally{
			con.commit();
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
					l.error("posting guest details...!!! "+e);
			}
		}
		return flag;
	
	}	
	public  ArrayList<ServiceConsumer> ConsumerLogin(Connection con, String email, String password) throws URISyntaxException, SQLException
	{
		ArrayList<ServiceConsumer> list=new ArrayList<ServiceConsumer>();
		
		Statement st = null;
		ResultSet set = null;
		try{
		
		st = con.createStatement();
		con.setAutoCommit(false);
		String q2="select Ser_Consumer_Name,Ser_Consumer_Email,Ser_Consumer_Id from HHS_Service_Consumer_tbl where Ser_Consumer_Email='"+email+"' and Ser_Consumer_Password='"+password+"';";
		set = st.executeQuery(q2);
		
		    if (set.next()) {
		    	list.add(new ServiceConsumer(set.getString(1),set.getString(2),set.getInt(3)));
		    	result=true;
		    	id1=set.getInt(3);
		    	
	        } 
		    con.commit();
	    set.close();
		}
	    catch(SQLException e)
	    {
	    	l.error("consumer login "+e);
	    }finally{
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
					l.error("consumer login "+e);
			}
		}
		return list;
	    
	}
	public ArrayList<ServiceProvider> providerLogin(Connection con, String email, String password) throws SQLException {
		ArrayList<ServiceProvider> list=new ArrayList<ServiceProvider>();
		
		Statement st = null;
		ResultSet set1 = null;
		try{
		
		st = con.createStatement();
		con.setAutoCommit(false);
		String q3="select Ser_Provid_Name,Ser_Provid_Email,Ser_Provid_Id from HHS_Service_Provider_tbl where Ser_Provid_Email='"+email+"' and Ser_Provid_Password='"+password+"';";
		set1 = st.executeQuery(q3);
		while(set1.next()){
           list.add(new ServiceProvider(set1.getString(1),set1.getString(2),set1.getInt(3)));
           result=true;
           id=set1.getInt(3);
        } 
		con.commit();
		
		l.info("provider id :"+id);
		}			
		catch(SQLException e)
		{
			l.error("Provider login "+e);
		}finally{
			try
			{
				if(set1!=null)
				{
					set1.close();
				}
				if(st!=null)
				{
					st.close();
				}
				if(con!=null){
					con.close();
				}
				 
			} catch (SQLException e) {
					l.error("Provider login "+e);
			}
		}
			return list;
		}

public ArrayList<ServiceProvider> viewProfile(Connection con,String id) throws SQLException {
	ArrayList<ServiceProvider> list=new ArrayList<ServiceProvider>();

	Statement st = null;
	ResultSet set = null;
	try{
	st = con.createStatement();
	con.setAutoCommit(false);
	String q2 = "select a.* from HHS_Service_Provider_tbl a join HHS_Service_Provide_Relation_tbl b on a.Ser_Provid_Id=b.Ser_Provid_Id join HHS_Services_Master_tbl c on b.Ser_Id=c.Ser_Id where a.Ser_Provid_Id='"+id+"';";
	
	set=st.executeQuery(q2);
	while(set.next()){
		 list.add(new ServiceProvider(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),set.getString(6),
					set.getString(7),set.getTimestamp(8),set.getString(9)));
	}
	con.commit();
	}
	catch(SQLException e)
	{
		l.error("view provider profile "+e);
	}finally{
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
				l.error("view provider profile "+e);
		}
	}
		return list;
	}

public ArrayList<ServiceConsumer> viewConsumerProfile(Connection con, String id) throws SQLException {
	ArrayList<ServiceConsumer> list=new ArrayList<ServiceConsumer>();

	Statement st = null;
	ResultSet set = null;
	try
	{
		st = con.createStatement();
		con.setAutoCommit(false);
		String q2 = "select * from HHS_Service_Consumer_tbl where Ser_Consumer_Id='"+id+"';";
		set=st.executeQuery(q2);		
			while(set.next())
			{
				 list.add(new ServiceConsumer(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),
							set.getString(6),set.getString(7),set.getString(8),set.getTimestamp(9)));
			 }
		con.commit();	
	}
	catch(SQLException e)
	{
		l.error("view consumer profile "+e);
	}finally{
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
				l.error("view consumer profile "+e);
		}
	}
		return list;
	
}

public ArrayList<consumerRequest> viewAdmin(Connection con) {
	ArrayList<consumerRequest> list=new ArrayList<consumerRequest>();
	
	Statement st = null;
	ResultSet set = null;
	try{
	st = con.createStatement();
	con.setAutoCommit(false);
	String q2 = "select * from HHS_Provider_Consumer_tbl limit 0,7;";
	set=st.executeQuery(q2);
	while(set.next()){
		 list.add(new consumerRequest(set.getInt(1),set.getInt(2)));
	 }
	con.commit();	
	}
	catch(SQLException e)
	{
		l.error("view admin request sent by consumer "+e);
	}finally{
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
				l.error("view admin request sent by consumer "+e);
		}
	}
		return list;
	
}

}
