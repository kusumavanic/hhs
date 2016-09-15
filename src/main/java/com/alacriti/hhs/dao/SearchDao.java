package com.alacriti.hhs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.alacriti.hhs.vo.PaginationVo;
import com.alacriti.hhs.vo.ServiceProvider;

public class SearchDao {
	static Logger l = Logger.getLogger(SearchDao.class.getName());


	public PaginationVo searchProvider(String searchName, Connection con) {
		
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
				String sql1="select max(query_id) as query_id from Service_Provider_Results_Lookup_tbl;";
				rs2=statement1.executeQuery(sql1);
				
				if(rs2!=null&&rs2.next())
				{
					l.info("before increment "+rs2.getInt("query_id"));
					query_id=(rs2.getInt("query_id")+1);
					l.info("after "+rs2.getInt("query_id"));
					
				}
				else{
					query_id=1000;
				}
				String q3="select Ser_Provid_Id,Ser_Provid_Name,Ser_Provid_Mobile_Number,Ser_Provid_Email,Ser_Provid_Location,Ser_Provid_City,Status from HHS_Service_Provider_tbl where Ser_Provid_Location LIKE '%"+searchName+"%'  or Ser_Provid_Name LIKE '%"+searchName+"%' or Ser_Provid_City LIKE '%"+searchName+"%';";
				l.info("query "+q3);
				l.info("selected item in db "+searchName);
				set = statement.executeQuery(q3);
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
					l.info("Page "+pagination.getQuery_id());
					
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
					l.info("Page 11 "+pagination.getQuery_id());
					return pagination;
				
		
	}


	public ArrayList<ServiceProvider> searchProviders(PaginationVo result,ArrayList<ServiceProvider> pageList,Connection con) {
		PreparedStatement statement = null;
		ResultSet set = null;
		try 
		{
			con.setAutoCommit(false);
			 statement = con.prepareStatement("select provider_id, provider_name,mobile_number,email,location,city,status from Service_Provider_Results_Lookup_tbl where query_id=? limit ?,?");
			 statement.setInt(1, result.getQuery_id());
			 statement.setInt(2, result.getStart());
			 statement.setInt(3,result.getOffset());
			 set=statement.executeQuery();
			 con.commit();
			while(set.next())
			{
				ServiceProvider providerList=new ServiceProvider(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),set.getString(6),set.getString(7));
				pageList.add(providerList);
			}
			
			l.info("pagelist provider name"+pageList.get(0).getProviderName());
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


	public PaginationVo searchProvider(String catogeory, String searchName,Connection con) {

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
				String sql1="select max(query_id) as query_id from Service_Provider_Results_Lookup_tbl;";
				rs2=statement1.executeQuery(sql1);
				
				if(rs2!=null&&rs2.next())
				{
					l.info("before increment "+rs2.getInt("query_id"));
					query_id=(rs2.getInt("query_id")+1);
					l.info("after "+rs2.getInt("query_id"));
					
				}
				else{
					query_id=1000;
				}
				String q3="select Ser_Provid_Id,Ser_Provid_Name,Ser_Provid_Mobile_Number,Ser_Provid_Email,Ser_Provid_Location,Ser_Provid_City,Status from HHS_Service_Provider_tbl where Ser_Provid_Id in(select Ser_Provid_Id from "
				+ "HHS_Service_Provide_Relation_tbl where Ser_Id in(select Ser_Id from HHS_Services_Master_tbl "
				+ "where Ser_Type='"+catogeory+"'))and (Ser_Provid_Location LIKE '%"+searchName+"%'  or Ser_Provid_Name LIKE '%"+searchName+"%' or Ser_Provid_City LIKE '%"+searchName+"%');";
				l.info("query "+q3);
				l.info("selected item in db "+searchName);
				set = statement.executeQuery(q3);
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
					l.info("Page "+pagination.getQuery_id());
					
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
					l.info("Page 11 "+pagination.getQuery_id());
					return pagination;
				
		
	}

}
