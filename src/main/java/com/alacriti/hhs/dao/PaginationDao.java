package com.alacriti.hhs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.alacriti.hhs.vo.PaginationVo;
import com.alacriti.hhs.vo.Service;
import com.alacriti.hhs.vo.ServiceConsumer;
import com.alacriti.hhs.vo.ServiceProvider;

//getting all provider details
public class PaginationDao {
	static Logger l = Logger.getLogger(PaginationDao.class.getName());
	
	public PaginationVo providerPagination(Connection con) {
		Statement statement = null;
		Statement statement1 = null;
		ResultSet set = null;
		ResultSet rs2=null;
		PreparedStatement psmt;
		PaginationVo pagination=new PaginationVo();
		
		int query_id=0;
		int i=0;
		try 
		{
				statement = con.createStatement();
				statement1 = con.createStatement();
				con.setAutoCommit(false);
				String sql1="select max(query_id) as query_id from Service_Provider_Results_Lookup_tbl;";
				rs2=statement1.executeQuery(sql1);
				if(rs2!=null&&rs2.next())
				{
					query_id=rs2.getInt("query_id")+1;
					
				}
				else{
					query_id=1000;
				}
				String q1="select Ser_Provid_Id,Ser_Provid_Name,Ser_Provid_Mobile_Number,Ser_Provid_Email,Ser_Provid_Location,Ser_Provid_City,Status from HHS_Service_Provider_tbl";
				set = statement.executeQuery(q1);
				while(set.next())
				{
					
					 
						psmt=con.prepareStatement("insert into Service_Provider_Results_Lookup_tbl values(?,?,?,?,?,?,?,?,?);");
						psmt.setLong(1, query_id);
						psmt.setLong(2, i);
						psmt.setInt(3,set.getInt("Ser_Provid_Id"));
						psmt.setString(4, set.getString("Ser_Provid_Name"));
						psmt.setString(5, set.getString("Ser_Provid_Mobile_Number"));
						psmt.setString(6, set.getString("Ser_Provid_Email"));
						psmt.setString(7,set.getString("Ser_Provid_Location"));
						psmt.setString(8, set.getString("Ser_Provid_City"));
						psmt.setString(9,set.getString("Status"));
						psmt.executeUpdate();
						i++;
					 
				}
				con.commit();
					pagination.setQuery_id(query_id);
					pagination.setCount(i+1);
					return pagination;
					}
					catch(SQLException e)
					{
							l.error("provider pagination"+e);
					}
					finally{
							try {
								if(set!=null)
								{
									set.close();
								}
								if(rs2!=null)
								{
									rs2.close();
								}
								if(statement!=null)
								{
									statement.close();
								}
								if(con!=null){
									con.close();
								}
								 
							} catch (SQLException e) {
									l.error("provider pagiantion "+e);
							}
					}
					return pagination;
				
				 
				
		}
	public ArrayList<ServiceProvider> getAllProvidersPagination(PaginationVo result,ArrayList<ServiceProvider> pageList,Connection con)
	{
		PreparedStatement statement = null;
		ResultSet set = null;
		try 
		{
			 statement = con.prepareStatement("select provider_id, provider_name,mobile_number,email,location,city,status from Service_Provider_Results_Lookup_tbl where query_id=? limit ?,?");
			 statement.setInt(1, result.getQuery_id());
			 statement.setInt(2, result.getStart());
			 statement.setInt(3,result.getOffset());
			 set=statement.executeQuery();
			while(set.next())
			{
				ServiceProvider providerList=new ServiceProvider(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),set.getString(6),set.getString(7));
				pageList.add(providerList);
			}
			return pageList;
		}
		catch(SQLException e)
		{
				l.error("get all providers pagination "+e);
		}
		finally{
			try {
				if(set!=null)
				{
					set.close();
				}
				if(statement!=null)
				{
					statement.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				 l.error("get all providers pagination"+e);
			}
		}
		
		return pageList;
		
	}
	//getting all requested provider details
	public PaginationVo requestProviderPagination(Connection con) {
		Statement statement = null;
		Statement statement1 = null;
		ResultSet set = null;
		ResultSet rs2=null;
		PreparedStatement psmt;
		PaginationVo pagination=new PaginationVo();
		int query_id=0;
		int i=0;
		try {
				statement = con.createStatement();
				statement1 = con.createStatement();
				con.setAutoCommit(false);
				String sql1="select max(query_id) as query_id from Request_Provider_Results_Lookup_tbl;";
				rs2=statement1.executeQuery(sql1);
				if(rs2!=null&&rs2.next())
				{
					query_id=rs2.getInt("query_id")+1;
					
				}
				else{
					query_id=1000;
				}
				l.info("query id :"+query_id);
				String q1="select Ser_Provid_Id,Ser_Provid_Name,Ser_Provid_Mobile_Number,Ser_Provid_Email,Ser_Provid_Location,Ser_Provid_City,Status from HHS_Service_Provider_tbl where Status='Pending..';";
				set = statement.executeQuery(q1);
				while(set.next())
				{
					
					 
						psmt=con.prepareStatement("insert into Request_Provider_Results_Lookup_tbl values(?,?,?,?,?,?,?,?,?);");
						psmt.setLong(1, query_id);
						psmt.setLong(2, i);
						psmt.setInt(3,set.getInt("Ser_Provid_Id"));
						psmt.setString(4, set.getString("Ser_Provid_Name"));
						psmt.setString(5, set.getString("Ser_Provid_Mobile_Number"));
						psmt.setString(6, set.getString("Ser_Provid_Email"));
						psmt.setString(7,set.getString("Ser_Provid_Location"));
						psmt.setString(8, set.getString("Ser_Provid_City"));
						psmt.setString(9,set.getString("Status"));
						psmt.executeUpdate();
						i++;
					 
				}
				con.commit();
					pagination.setQuery_id(query_id);
					pagination.setCount(i+1);
					return pagination;
					}
					catch(SQLException e)
					{
							e.printStackTrace();
					}
					finally{
							try {
								if(set!=null)
								{
									set.close();
								}
								if(rs2!=null)
								{
									rs2.close();
								}
								if(statement!=null)
								{
									statement.close();
								}
								if(con!=null){
									con.close();
								}
								 
							} catch (SQLException e) {
									l.error("request provider pagination "+e);
							}
					}
					return pagination;
				
	
				
	}	
	public ArrayList<ServiceProvider> getAllRequestProvidersPagination(PaginationVo result,ArrayList<ServiceProvider> pageList,Connection con)
	{
		PreparedStatement statement = null;
		ResultSet set = null;
		try 
		{
			 statement = con.prepareStatement("select provider_id, provider_name,mobile_number,email,location,city,status from Request_Provider_Results_Lookup_tbl where query_id=? limit ?,?");
			 statement.setInt(1, result.getQuery_id());
			 statement.setInt(2, result.getStart());
			 statement.setInt(3,result.getOffset());
			 set=statement.executeQuery();
			while(set.next())
			{
				ServiceProvider providerList=new ServiceProvider(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),set.getString(6),set.getString(7));
				pageList.add(providerList);
			}
			return pageList;
		}
		catch(SQLException e)
		{
			l.error("request providers pagiantion "+e);
		}
		finally{
			try {
				if(set!=null)
				{
					set.close();
				}
				if(statement!=null)
				{
					statement.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				 l.error("request providers pagiantion "+e);
			}
		}
		
		return pageList;
		
	}
	public PaginationVo indexProviderPagination(Connection con, String id) {
		Statement statement = null;
		Statement statement1 = null;
		ResultSet set = null;
		ResultSet rs2=null;
		PreparedStatement psmt;
		PaginationVo pagination=new PaginationVo();
		int query_id=0;
		int i=0;
		try {
				statement = con.createStatement();
				statement1 = con.createStatement();
				con.setAutoCommit(false);
				String sql1="select max(query_id) as query_id from Index_Provider_Results_Lookup_tbl;";
				rs2=statement1.executeQuery(sql1);
				if(rs2!=null&&rs2.next())
				{
					query_id=rs2.getInt("query_id")+1;
					
				}
				else{
					query_id=1000;
				}
				String q1="select * from HHS_Service_Provider_tbl where Ser_Provid_Id in(select Ser_Provid_Id from HHS_Service_Provide_Relation_tbl where Ser_Id in(select Ser_Id from HHS_Services_Master_tbl where Ser_Type = '"+id+"'));";
				set = statement.executeQuery(q1);
				while(set.next())
				{
						psmt=con.prepareStatement("insert into Index_Provider_Results_Lookup_tbl values(?,?,?,?,?,?,?,?,?);");
						psmt.setLong(1, query_id);
						psmt.setLong(2, i);
						psmt.setInt(3,set.getInt("Ser_Provid_Id"));
						psmt.setString(4, set.getString("Ser_Provid_Name"));
						psmt.setString(5, set.getString("Ser_Provid_Mobile_Number"));
						psmt.setString(6, set.getString("Ser_Provid_Email"));
						psmt.setString(7,set.getString("Ser_Provid_Location"));
						psmt.setString(8, set.getString("Ser_Provid_City"));
						psmt.setString(9,set.getString("Status"));
						psmt.executeUpdate();
						i++;
					 
				}
				con.commit();
					pagination.setQuery_id(query_id);
					pagination.setCount(i+1);
					return pagination;
					}
					catch(SQLException e)
					{
							l.error("Index provider pagination "+e);
					}
					finally{
							try {
								if(set!=null)
								{
									set.close();
								}
								if(rs2!=null)
								{
									rs2.close();
								}
								if(statement!=null)
								{
									statement.close();
								}
								if(con!=null){
									con.close();
								}
								 
							} catch (SQLException e) {
								l.error("Index provider pagination "+e);
							}
					}
					return pagination;
				
				 
	}
	public ArrayList<ServiceProvider> getIndexProvidersPagination(PaginationVo result,ArrayList<ServiceProvider> pageList,Connection con)
	{
		PreparedStatement statement = null;
		ResultSet set = null;
		try 
		{
			 statement = con.prepareStatement("select provider_id, provider_name,mobile_number,email,location,city,status from Index_Provider_Results_Lookup_tbl where query_id=? limit ?,?");
			 statement.setInt(1, result.getQuery_id());
			 statement.setInt(2, result.getStart());
			 statement.setInt(3,result.getOffset());
			 set=statement.executeQuery();
			while(set.next())
			{
				ServiceProvider providerList=new ServiceProvider(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),set.getString(6),set.getString(7));
				pageList.add(providerList);
			}
			return pageList;
		}
		catch(SQLException e)
		{
			l.error("get all Index provider pagination "+e);
		}
		finally{
			try {
				if(set!=null)
				{
					set.close();
				}
				if(statement!=null)
				{
					statement.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				l.error("get all Index provider pagination "+e);
			}
		}
		
		return pageList;
		
	}
	public ArrayList<ServiceProvider> getAllDetailsProviderPagination(PaginationVo result, ArrayList<ServiceProvider> pageList, Connection con) {
		PreparedStatement statement = null;
		ResultSet set = null;
		try 
		{
			 statement = con.prepareStatement("select provider_id, provider_name,mobile_number,email,location,city,status from Index_Provider_Results_Lookup_tbl where query_id=? limit ?,?");
			 statement.setInt(1, result.getQuery_id());
			 statement.setInt(2, result.getStart());
			 statement.setInt(3,result.getOffset());
			 set=statement.executeQuery();
			while(set.next())
			{
				ServiceProvider providerList=new ServiceProvider(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),set.getString(6),set.getString(7));
				pageList.add(providerList);
			}
			return pageList;
		}
		catch(SQLException e)
		{
			l.error("get all providers pagination"+e);
		}
		finally{
			try {
				if(set!=null)
				{
					set.close();
				}
				if(statement!=null)
				{
					statement.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				l.error("get all providers pagination"+e);
			}
		}
		
		return pageList;
	}
	public PaginationVo consumerPagination(Connection con) {
		Statement statement = null;
		Statement statement1 = null;
		ResultSet set = null;
		ResultSet rs2=null;
		PreparedStatement psmt;
		PaginationVo pagination=new PaginationVo();
		int query_id=0;
		int i=0;
		try {
				statement = con.createStatement();
				statement1 = con.createStatement();
				con.setAutoCommit(false);
				String sql1="select max(query_id) as query_id from Consumer_Results_Lookup_tbl;";
				rs2=statement1.executeQuery(sql1);
				if(rs2!=null&&rs2.next())
				{
					query_id=rs2.getInt("query_id")+1;
					
				}
				else{
					query_id=1000;
				}
				String q1="select Ser_consumer_Id,Ser_Consumer_Name,Ser_Consumer_Mobile_Number,Ser_Consumer_Email,Ser_Consumer_Alt_Email,Ser_Consumer_Location,Ser_Consumer_City from HHS_Service_Consumer_tbl";
				set = statement.executeQuery(q1);
				while(set.next())
				{
					
					 
						psmt=con.prepareStatement("insert into Consumer_Results_Lookup_tbl values(?,?,?,?,?,?,?,?,?);");
						psmt.setLong(1, query_id);
						psmt.setLong(2, i);
						psmt.setInt(3,set.getInt("Ser_consumer_Id"));
						psmt.setString(4, set.getString("Ser_Consumer_Name"));
						psmt.setString(5, set.getString("Ser_Consumer_Mobile_Number"));
						psmt.setString(6, set.getString("Ser_Consumer_Email"));
						psmt.setString(7,set.getString("Ser_Consumer_Alt_Email"));
						psmt.setString(8, set.getString("Ser_Consumer_Location"));
						psmt.setString(9,set.getString("Ser_Consumer_City"));
						psmt.executeUpdate();
						i++;
					 
				}
				con.commit();
					pagination.setQuery_id(query_id);
					pagination.setCount(i+1);
					return pagination;
					}
					catch(SQLException e)
					{
						l.error("consumer pagination"+e);
					}
					finally{
							try {
								if(set!=null)
								{
									set.close();
								}
								if(rs2!=null)
								{
									rs2.close();
								}
								if(statement!=null)
								{
									statement.close();
								}
								if(con!=null){
									con.close();
								}
								 
							} catch (SQLException e) {
								l.error("consumer pagination"+e);
							}
					}
					return pagination;
				
				 
				
	}
	public ArrayList<ServiceConsumer> getConsumerPagination(PaginationVo result,ArrayList<ServiceConsumer> pageList, Connection con) {
		PreparedStatement statement = null;
		ResultSet set = null;
		try 
		{
			 statement = con.prepareStatement("select consumer_id, consumer_name,mobile_number,email,alt_email,location,city from Consumer_Results_Lookup_tbl where query_id=? limit ?,?");
			 statement.setInt(1, result.getQuery_id());
			 statement.setInt(2, result.getStart());
			 statement.setInt(3,result.getOffset());
			 set=statement.executeQuery();
			while(set.next())
			{
				ServiceConsumer providerList=new ServiceConsumer(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),set.getString(6),set.getString(7));
				pageList.add(providerList);

			}			
			return pageList;
		}
		catch(SQLException e)
		{
			l.error("get consumer pagination");
		}
		finally{
			try {
				if(set!=null)
				{
					set.close();
				}
				if(statement!=null)
				{
					statement.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				l.error("get consumer pagination");
			}
		}
		
		return pageList;
	}
	public PaginationVo service(Connection con) {
		Statement statement = null;
		Statement statement1 = null;
		ResultSet set = null;
		ResultSet rs2=null;
		PreparedStatement psmt;
		PaginationVo pagination=new PaginationVo();
		int query_id=0;
		int i=0;
		try {
				statement = con.createStatement();
				statement1 = con.createStatement();
				con.setAutoCommit(false);
				String sql1="select max(query_id) as query_id from Service_Results_Lookup_tbl;";
				rs2=statement1.executeQuery(sql1);
				if(rs2!=null&&rs2.next())
				{
					query_id=rs2.getInt("query_id")+1;
					
				}
				else{
					query_id=1000;
				}
				String q1="select a.Ser_Provid_Id,c.Ser_Type from HHS_Service_Provider_tbl a,HHS_Services_Master_tbl c,"
				+ "HHS_Service_Provide_Relation_tbl b where a.Ser_Provid_Id=b.Ser_Provid_Id and b.Ser_Id=c.Ser_Id;";
				set = statement.executeQuery(q1);
				while(set.next())
				{
					
					 
						psmt=con.prepareStatement("insert into Service_Results_Lookup_tbl values(?,?,?,?);");
						psmt.setLong(1, query_id);
						psmt.setLong(2, i);
						psmt.setInt(3,set.getInt("Ser_Provid_Id"));
						psmt.setString(4,set.getString("Ser_Type"));
						psmt.executeUpdate();
						i++;
					 
				}
				con.commit();
					pagination.setQuery_id(query_id);
					pagination.setCount(i+1);
					return pagination;
					}
					catch(SQLException e)
					{
							e.printStackTrace();
					}
					finally{
							try {
								if(set!=null)
								{
									set.close();
								}
								if(rs2!=null)
								{
									rs2.close();
								}
								if(statement!=null)
								{
									statement.close();
								}
								if(con!=null){
									con.close();
								}
								 
							} catch (SQLException e) {
								l.error("get services "+e);
							}
					}
					return pagination;
				
				 
	}
	public ArrayList<Service> serviceType(PaginationVo result,ArrayList<Service> pageList, Connection con) {
		PreparedStatement statement = null;
		ResultSet set = null;
		try 
		{
			 statement = con.prepareStatement("select provider_id, service_type from Service_Results_Lookup_tbl where query_id=? limit ?,?");
			 statement.setInt(1, result.getQuery_id());
			 statement.setInt(2, result.getStart());
			 statement.setInt(3,result.getOffset());
			 set=statement.executeQuery();
			while(set.next())
			{
				Service providerList=new Service(set.getInt(1),set.getString(2));
				pageList.add(providerList);
			}
			return pageList;
		}
		catch(SQLException e)
		{
			l.error("service type "+e);
		}
		finally{
			try {
				if(set!=null)
				{
					set.close();
				}
				if(statement!=null)
				{
					statement.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				l.error("service type "+e);
			}
		}
		
		return pageList;
	}
	public ArrayList<ServiceProvider> getDelProvider(PaginationVo result,ArrayList<ServiceProvider> pageList, Connection con) {
		PreparedStatement statement = null;
		ResultSet set = null;
		try 
		{
			 statement = con.prepareStatement("select provider_id, provider_name,mobile_number,email,location,city,status from Service_Provider_Results_Lookup_tbl where query_id=? limit ?,?");
			 statement.setInt(1, result.getQuery_id());
			 statement.setInt(2, result.getStart());
			 statement.setInt(3,result.getOffset());
			 set=statement.executeQuery();
			while(set.next())
			{
				ServiceProvider providerList=new ServiceProvider(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),set.getString(6),set.getString(7));
				pageList.add(providerList);
			}
			
			return pageList;
		}
		catch(SQLException e)
		{
			l.error("get delete Provider "+e);
		}
		finally{
			try {
				if(set!=null)
				{
					set.close();
				}
				if(statement!=null)
				{
					statement.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				l.error("get del Provider "+e);
			}
		}
		return pageList;
	
}
	public ArrayList<ServiceConsumer> getDelConsumer(PaginationVo result,ArrayList<ServiceConsumer> pageList, Connection con) {
		PreparedStatement statement = null;
		ResultSet set = null;
		try {
			statement = con.prepareStatement("select consumer_id, consumer_name,mobile_number,email,alt_email,location,city from Consumer_Results_Lookup_tbl where query_id=? limit ?,?");
			 statement.setInt(1, result.getQuery_id());
			 statement.setInt(2, result.getStart());
			 statement.setInt(3,result.getOffset());
			 set=statement.executeQuery();
			while(set.next())
			{
				ServiceConsumer providerList=new ServiceConsumer(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),set.getString(6),set.getString(7));
				pageList.add(providerList);

			}			
			return pageList;
		}
		catch(SQLException e)
		{
			l.error("get del Provider "+e);
		}
		finally{
			try {
				if(set!=null)
				{
					set.close();
				}
				if(statement!=null)
				{
					statement.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				l.error("get del Provider "+e);
			}
		}
		
		return pageList;
	}
	public PaginationVo sentRequestProvider(Connection con, String id,String catogeory) {
		Statement statement = null;
		Statement statement1 = null;
		ResultSet set = null;
		ResultSet rs2=null;
		PreparedStatement psmt;
		PaginationVo pagination=new PaginationVo();
		int query_id=0;
		int i=0;
		try {
				statement = con.createStatement();
				statement1 = con.createStatement();
				con.setAutoCommit(false);
				String sql1="select max(query_id) as query_id from Index_Provider_Results_Lookup_tbl;";
				rs2=statement1.executeQuery(sql1);
				if(rs2!=null&&rs2.next())
				{
					query_id=rs2.getInt("query_id")+1;
					
				}
				else{
					query_id=1000;
				}
				String q1="select * from HHS_Service_Provider_tbl where Ser_Provid_Id in(select Ser_Provid_Id from HHS_Service_Provide_Relation_tbl where Ser_Id in(select Ser_Id from HHS_Services_Master_tbl where Ser_Type = '"+catogeory+"'));";
				set = statement.executeQuery(q1);
				while(set.next())
				{
					
					 
						psmt=con.prepareStatement("insert into Index_Provider_Results_Lookup_tbl values(?,?,?,?,?,?,?,?,?);");
						psmt.setLong(1, query_id);
						psmt.setLong(2, i);
						psmt.setInt(3,set.getInt("Ser_Provid_Id"));
						psmt.setString(4, set.getString("Ser_Provid_Name"));
						psmt.setString(5, set.getString("Ser_Provid_Mobile_Number"));
						psmt.setString(6, set.getString("Ser_Provid_Email"));
						psmt.setString(7,set.getString("Ser_Provid_Location"));
						psmt.setString(8, set.getString("Ser_Provid_City"));
						psmt.setString(9,set.getString("Status"));
						psmt.executeUpdate();
						i++;
					 
				}
				con.commit();
					pagination.setQuery_id(query_id);
					pagination.setCount(i+1);
					return pagination;
					}
					catch(SQLException e)
					{
						l.error("sent request Provider "+e);
					}
					finally{
							try {
								if(set!=null)
								{
									set.close();
								}
								if(rs2!=null)
								{
									rs2.close();
								}
								if(statement!=null)
								{
									statement.close();
								}
								if(con!=null){
									con.close();
								}
								 
							} catch (SQLException e) {
								l.error("sent request Provider "+e);
							}
					}
					return pagination;
				
				 
	}
	public ArrayList<ServiceProvider> sentRequest(PaginationVo result,ArrayList<ServiceProvider> pageList, Connection con) {
		PreparedStatement statement = null;
		ResultSet set = null;
		try 
		{
			 statement = con.prepareStatement("select provider_id, provider_name,mobile_number,email,location,city,status from Index_Provider_Results_Lookup_tbl where query_id=? limit ?,?");
			 statement.setInt(1, result.getQuery_id());
			 statement.setInt(2, result.getStart());
			 statement.setInt(3,result.getOffset());
			 set=statement.executeQuery();
			while(set.next())
			{
				ServiceProvider providerList=new ServiceProvider(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),set.getString(6),set.getString(7));
				pageList.add(providerList);
			}
			return pageList;
		}
		catch(SQLException e)
		{
			l.error("sent request Provider "+e);
		}
		finally{
			try {
				if(set!=null)
				{
					set.close();
				}
				if(statement!=null)
				{
					statement.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				l.error("sent request Provider "+e);
			}
		}
		
		return pageList;
	}
	
	public ArrayList<ServiceConsumer> getConsumer(PaginationVo result,ArrayList<ServiceConsumer> pageList, Connection con) {
		PreparedStatement statement = null;
		ResultSet set = null;
		try 
		{
			 statement = con.prepareStatement("select consumer_name,mobile_number,email,location,city,request_at from Get_Consumer_Results_Lookup_tbl where query_id=? limit ?,?");
			 statement.setInt(1, result.getQuery_id());
			 statement.setInt(2, result.getStart());
			 statement.setInt(3,result.getOffset());
			 set=statement.executeQuery();
			while(set.next())
			{
				ServiceConsumer providerList=new ServiceConsumer(set.getString(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),set.getTimestamp(6));
				pageList.add(providerList);

			}
			
			return pageList;
		}
		catch(SQLException e)
		{
			l.error("get consumer "+e);
		}
		finally{
			try {
				if(set!=null)
				{
					set.close();
				}
				if(statement!=null)
				{
					statement.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				l.error("get consumer "+e);
			}
		}
		
		return pageList;
	}
	public PaginationVo getRequestConsumer(Connection con, int id) {
		Statement statement = null;
		Statement statement1 = null;
		ResultSet set = null;
		ResultSet rs2=null;
		PreparedStatement psmt;
		PaginationVo pagination=new PaginationVo();
		int query_id=0;
		int i=0;
		try {
				statement = con.createStatement();
				statement1 = con.createStatement();
				con.setAutoCommit(false);
				String sql1="select max(query_id) as query_id from Get_Consumer_Results_Lookup_tbl;";
				rs2=statement1.executeQuery(sql1);
				if(rs2!=null&&rs2.next())
				{
					query_id=rs2.getInt("query_id")+1;
					
				}
				else{
					query_id=1000;
				}
				String q1="select a.Ser_Consumer_Name,a.Ser_Consumer_Mobile_Number,a.Ser_Consumer_Email,a.Ser_Consumer_Alt_Email,a.Ser_Consumer_Location,a.Ser_Consumer_City,b.request_at from HHS_Service_Consumer_tbl a join HHS_Provider_Consumer_tbl b on a.Ser_Consumer_Id=b.consumer_Id and b.provider_Id='"+id+"';";
				set = statement.executeQuery(q1);
				while(set.next())
				{
					
					 
						psmt=con.prepareStatement("insert into Get_Consumer_Results_Lookup_tbl values(?,?,?,?,?,?,?,?);");
						psmt.setLong(1, query_id);
						psmt.setLong(2, i);
						psmt.setString(3, set.getString("Ser_Consumer_Name"));
						psmt.setString(4, set.getString("Ser_Consumer_Mobile_Number"));
						psmt.setString(5, set.getString("Ser_Consumer_Email"));
						psmt.setString(6, set.getString("Ser_Consumer_Location"));
						psmt.setString(7, set.getString("Ser_Consumer_City"));
						psmt.setTimestamp(8, set.getTimestamp("request_at"));
						psmt.executeUpdate();
						i++;
					 
				}
				con.commit();
					pagination.setQuery_id(query_id);
					pagination.setCount(i+1);
					return pagination;
					}
					catch(SQLException e)
					{
						l.error("get consumer "+e);
					}
					finally{
							try {
								if(set!=null)
								{
									set.close();
								}
								if(rs2!=null)
								{
									rs2.close();
								}
								if(statement!=null)
								{
									statement.close();
								}
								if(con!=null){
									con.close();
								}
								 
							} catch (SQLException e) {
								l.error("get consumer "+e);
							}
					}
					return pagination;
				
	}
}

