package com.alacriti.hhs.deligate;

import java.sql.Connection;
import java.util.ArrayList;

import com.alacriti.hhs.bo.SearchBo;
import com.alacriti.hhs.util.Database;
import com.alacriti.hhs.vo.PaginationVo;
import com.alacriti.hhs.vo.ServiceProvider;

public class SearchDelegate {
	 Database database=new Database();
	 SearchBo searchBo=new SearchBo();
		
	public  PaginationVo searchProvider(String searchName) {		 
		 Connection con=database.databaseConnection();
		 return searchBo.searchProvider(searchName,con); 		
	}
	public ArrayList<ServiceProvider> searchProviders(PaginationVo page) {
		Connection con=database.databaseConnection();
		return searchBo.searchProviders(con,page);
	}
	public PaginationVo searchProvidercatogeory(String catogeory,String searchName) {
		Connection con=database.databaseConnection();
		 return searchBo.searchProvider(catogeory,searchName,con); 
	}
	
}
