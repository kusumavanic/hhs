package com.alacriti.hhs.bo;

import java.sql.Connection;
import java.util.ArrayList;

import com.alacriti.hhs.dao.SearchDao;
import com.alacriti.hhs.vo.PaginationVo;
import com.alacriti.hhs.vo.ServiceProvider;

public class SearchBo {
	SearchDao searchDao=new SearchDao();
	 

	public PaginationVo searchProvider(String searchName, Connection con) {		
		return searchDao.searchProvider(searchName,con);
	}

	public ArrayList<ServiceProvider> searchProviders(Connection con,PaginationVo page) {
		 ArrayList<ServiceProvider> list=new  ArrayList<ServiceProvider>();
		return searchDao.searchProviders(page,list,con);
	}

	public PaginationVo searchProvider(String catogeory, String searchName,
			Connection con) {
		return searchDao.searchProvider(catogeory,searchName,con);
	}

}
