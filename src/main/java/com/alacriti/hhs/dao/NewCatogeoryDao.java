package com.alacriti.hhs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.alacriti.hhs.vo.AddNewCatogeory;



public class NewCatogeoryDao {
	static Logger l = Logger.getLogger(NewCatogeoryDao.class.getName());
	public Object postNewCatogeory(Connection con,String catogeory,String icon) throws SQLException{
		PreparedStatement ps;
		PreparedStatement ps1;
		try 
		{									
				ps=con.prepareStatement("insert into HHS_Service_New_Catogeory_tbl values(?,?)");
				ps.setString(1, catogeory);
				ps.setString(2, icon);
				ps.executeUpdate();
				
				ps1=con.prepareStatement("insert into HHS_Services_Master_tbl(Ser_Type) values(?)");
				ps1.setString(1,catogeory);
				ps1.executeUpdate();
			}
			catch(SQLException e)
			{
				l.error("Posting new Catogeory"+e);
			}
			finally{
				try
				{
					if(con!=null){
						con.close();
					}
					 
				} catch (SQLException e) {
						l.error("Posting new Catogeory "+e);
				}
			}
							
			return "values are inserted..!!";
	}
	public  ArrayList<AddNewCatogeory> getNewCatogeory(Connection con) throws SQLException
	{
		ArrayList<AddNewCatogeory> list = new ArrayList<AddNewCatogeory>();
		Statement st = null;
		ResultSet set = null;
		try
		{
		
			st = con.createStatement();
			con.setAutoCommit(false);
			String q2 = "select * from HHS_Service_New_Catogeory_tbl;";
			set = st.executeQuery(q2);
		
			while(set.next()){
				
				list.add(new AddNewCatogeory(set.getString(1),set.getString(2)));			
			}
			con.commit();
	}
	catch(SQLException e)
	{
		l.error("getting new Catogeory "+e);
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
				l.error("getting new Catogeory "+e);
		}
	}
	return list;
	}
	
	public  Object deleteCatogeory(Connection con, String id) throws SQLException
	{
		Statement st = null;
		try
		{
			st = con.createStatement();	
			con.setAutoCommit(false);
			l.info("catogeory from dao----"+id);
			String q2 = "delete from HHS_Service_New_Catogeory_tbl where catogeory='"+id+"';";
			l.info("query---"+q2);
			st.executeUpdate(q2);		
			con.commit();
		}	
		catch(SQLException e)
		{
			l.error("delete catogeory "+e);
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
					l.error("delete catogeory "+e);
			}
		}
		return "deleted...!!!";
}

	public  String deleteProvider(Connection con, String id) throws SQLException
	{
		Statement st = null;
		try
		{
			st = con.createStatement();
			con.setAutoCommit(false);
			String q2 = "update HHS_Service_Provider_tbl set Status = 'NotAvailable' where Ser_Provid_Id= '"+id+"';";
			st.executeUpdate(q2);
			con.commit();
	     }
	
		catch(SQLException e)
		{
			l.error("deleted Provider "+e);;
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
					l.error("deleted Provider "+e);
			}
		}
		return "Deleted...!!!";
}
	public  String deleteConsumer(Connection con, String id) throws SQLException
	{
		Statement st = null;
		try
		{
			st = con.createStatement();
			con.setAutoCommit(false);
			String q2 = "delete from HHS_Service_Consumer_tbl where Ser_Consumer_Id='"+id+"';";
			l.info(q2);
			st.executeUpdate(q2);
			con.commit();
		}
		catch(SQLException e)
		{
			l.error("delete consumer "+e);
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
					l.error("delete consumer "+e);
			}
		}
		return "deleted..!!";
}		
}
