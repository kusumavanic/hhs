package com.alacriti.hhs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.alacriti.hhs.bo.ConsumerBo;
import com.alacriti.hhs.resource.ServiceConsumerResource;
import com.alacriti.hhs.vo.ServiceConsumer;


public class ConsumerDatabase {
	ConsumerBo cb=new ConsumerBo();
	static Logger l = Logger.getLogger(ServiceConsumerResource.class.getName());
	public boolean postServiceConsumerDetails(Connection con,String consumerName, String mobileNumber,
			String emailId,String altEmailId,  String location, String city,String password) throws SQLException
	{
		PreparedStatement ps;
		try {
											
		ps=con.prepareStatement("insert into HHS_Service_Consumer_tbl(Ser_Consumer_Name,"
				+ "Ser_Consumer_Mobile_Number,Ser_Consumer_Email,Ser_Consumer_Alt_Email,Ser_Consumer_Location,"
				+ "Ser_Consumer_City,Ser_Consumer_Password) values(?,?,?,?,?,?,?)");
		ps.setString(1, consumerName);
		ps.setString(2, mobileNumber);
		ps.setString(3, emailId);
		ps.setString(4, altEmailId);
		ps.setString(5, location);
		ps.setString(6, city);
		ps.setString(7, password);
		ps.executeUpdate();
		
		}
		catch(SQLException e)
		{
			l.error("Posting service consumer details..!!"+e);
		}finally{
			try
			{
				if(con!=null){
					con.close();
				}
				 
			} catch (SQLException e) {
					l.error("Posting service consumer details..!! "+e);
			}
		}
		return true;
	
	}
	
	public  ArrayList<ServiceConsumer> getConsumerName(Connection con) throws SQLException
	{		
		ArrayList<ServiceConsumer> list = new ArrayList<ServiceConsumer>();
		Statement st = null;
		ResultSet set = null;
		try{
		st = con.createStatement();	
		con.setAutoCommit(false);
		String q2 = "select * from HHS_Service_Consumer_tbl";		
		set = st.executeQuery(q2);		
		while(set.next()){
			
			list.add(new ServiceConsumer(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),
					set.getString(6),set.getString(7),set.getString(8),set.getTimestamp(9)));
		}
		con.commit();
	}
	catch(SQLException e)
	{
		l.error("getting consumer details "+e);
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
				l.error("getting consumer details "+e);
		}
	}
	return list;
}

	public String editConsumer(Connection con, String email, String altEmail,String mobileNumber,
			String password, int id) throws SQLException {
		Statement st = null;
		try
		{
			st=con.createStatement();
			con.setAutoCommit(false);
			String q1="update HHS_Service_Consumer_tbl set Ser_Consumer_Email='"+email+"',Ser_Consumer_Alt_Email='"+altEmail+"',Ser_Consumer_Mobile_Number='"+mobileNumber+"',Ser_Consumer_Password='"+password+"' where Ser_Consumer_Id='"+id+"';";
			st.executeUpdate(q1);
			con.commit();
		}
		catch(SQLException e)
		{
			l.error("edit consumer "+e);
		}finally{
			try
			{
				if(st!=null)
				{
					st.close();
				}
				if(con!=null){
					con.close();
				}
				 
			} catch (SQLException e) {
					l.error("edit consumer "+e);
			}
		}
		return "edited successfully...!!!";
		
	}
		
	}

	

