package com.alacriti.hhs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.alacriti.hhs.vo.ServiceConsumer;

public class OAuthDao {
	public static boolean result;
	static Logger l= Logger.getLogger(OAuthDao.class.getName());
	public ArrayList<ServiceConsumer> request(Connection con, String email, String name, String location){
		//ArrayList<ServiceProvider> list=new ArrayList<ServiceProvider>();
		ArrayList<ServiceConsumer> list1=new ArrayList<ServiceConsumer>();
		Statement st = null;
		PreparedStatement ps;
		ResultSet set1 = null;
		ResultSet set2 = null;
		//String q1="select Ser_Provid_Name,Ser_Provid_Email,Ser_Provid_Id from HHS_Service_Provider_tbl where Ser_Provid_Email='"+email+"';";
		/*ResultSet set=st.executeQuery(q1);
		while(set.next()){
	           list.add(new ServiceProvider(set.getString(1),set.getString(2),set.getInt(3)));
	           result=true;
	    }
		set.close();*/
		try
		{
		 st=con.createStatement();
		 con.setAutoCommit(false);
			String q2="select Ser_Consumer_Name,Ser_Consumer_Email,Ser_Consumer_Id from HHS_Service_Consumer_tbl where Ser_Consumer_Email='"+email+"';";
			set1 = st.executeQuery(q2);
			while(set1.next())
			{
		    	list1.add(new ServiceConsumer(set1.getString(1),set1.getString(2),set1.getInt(3)));
		    	result=true;
			} 
			
			if(result==false)
			{
					ps=con.prepareStatement("insert into HHS_Service_Consumer_tbl(Ser_Consumer_Name,Ser_Consumer_Mobile_Number,"
							+ "Ser_Consumer_Email,Ser_Consumer_Alt_Email,Ser_Consumer_Location,Ser_Consumer_City,Ser_Consumer_Password) values(?,?,?,?,?,?,?)");
						ps.setString(1, name);
						ps.setString(2, "-");
						ps.setString(3, email);
						ps.setString(4, "-");
						ps.setString(5, "-");
						ps.setString(6, "-");
						ps.setString(7, "-");
						int s=ps.executeUpdate();
							
							if(s==1)
							{
								String q3="select Ser_Consumer_Name,Ser_Consumer_Email,Ser_Consumer_id from HHS_Service_Consumer_tbl where Ser_Consumer_Email='"+email+"';";
							
								set2 = st.executeQuery(q3);
								while(set2.next()) {
									list1.add(new ServiceConsumer(set2.getString(1),set2.getString(2),set2.getInt(3)));
									result=true;
								} 
						     }
			}
		}
		catch(SQLException e)
		{
			l.error("OAuth "+e);
		}
		finally{
			try {
				con.commit();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try
			{
				if(set1!=null)
				{
					set1.close();
				}
				if(set2!=null)
				{
					set2.close();
				}
				if(st!=null)
				{
					st.close();
				}
				if(con!=null){
					con.close();
				}
				 
			} catch (SQLException e) {
					l.error("OAuth "+e);
			}
		}
		return list1;
	}

}
