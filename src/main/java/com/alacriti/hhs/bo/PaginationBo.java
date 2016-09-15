package com.alacriti.hhs.bo;

import java.sql.Connection;
import java.util.ArrayList;

import com.alacriti.hhs.dao.PaginationDao;
import com.alacriti.hhs.vo.PaginationVo;
import com.alacriti.hhs.vo.Service;
import com.alacriti.hhs.vo.ServiceConsumer;
import com.alacriti.hhs.vo.ServiceProvider;

public class PaginationBo {

	//getting all provider details
	public PaginationVo providerPagination(Connection con) {
		PaginationDao pd=new PaginationDao();		
		return pd.providerPagination(con);
	}

	public ArrayList<ServiceProvider> getAllProvidersPagination(Connection con,PaginationVo vo) {
		PaginationDao pd=new PaginationDao();	
		ArrayList<ServiceProvider> list=new ArrayList<ServiceProvider>();
		return pd.getAllProvidersPagination(vo,list,con);
	}

	//getting requested provider details
	public PaginationVo requestProviderPagination(Connection con) {
		PaginationDao pd=new PaginationDao();		
		return pd.requestProviderPagination(con);
	}
	public ArrayList<ServiceProvider> getAllRequestProvidersPagination(Connection con,PaginationVo vo) {
		PaginationDao pd=new PaginationDao();
		ArrayList<ServiceProvider> list=new ArrayList<ServiceProvider>();
		return pd.getAllRequestProvidersPagination(vo,list,con);
	}

	//getting index provider details
	public PaginationVo indexProviderPagination(Connection con, String id) {
		PaginationDao pd=new PaginationDao();		
		return pd.indexProviderPagination(con,id);
	}
	public ArrayList<ServiceProvider> getIndexProvidersPagination(Connection con,PaginationVo vo) {
		PaginationDao pd=new PaginationDao();	
		ArrayList<ServiceProvider> list=new ArrayList<ServiceProvider>();
		return pd.getIndexProvidersPagination(vo,list,con);
	}

	public ArrayList<ServiceProvider> getAllDetailsProviderPagination(Connection con, PaginationVo vo) {
		PaginationDao pd=new PaginationDao();	
		ArrayList<ServiceProvider> list=new ArrayList<ServiceProvider>();
		return pd.getAllDetailsProviderPagination(vo,list,con);
	}

	public PaginationVo consumerPagination(Connection con) {
		PaginationDao pd=new PaginationDao();
		
		return pd.consumerPagination(con);
	}

	public ArrayList<ServiceConsumer> getConsumerPagination(Connection con,PaginationVo vo) {
		PaginationDao pd=new PaginationDao();	
		ArrayList<ServiceConsumer> list=new ArrayList<ServiceConsumer>();
		return pd.getConsumerPagination(vo,list,con);
	}

	public PaginationVo service(Connection con) {
		PaginationDao pd=new PaginationDao();
		
		return pd.service(con);
	}

	public ArrayList<Service> serviceType(Connection con,PaginationVo vo) {
		PaginationDao pd=new PaginationDao();	
		ArrayList<Service> list=new ArrayList<Service>();
		return pd.serviceType(vo,list,con);
	}

	public ArrayList<ServiceProvider> getDelProvider(Connection con,PaginationVo vo) {
		PaginationDao pd=new PaginationDao();	
		ArrayList<ServiceProvider> list=new ArrayList<ServiceProvider>();
		return pd.getDelProvider(vo,list,con);
	}

	public ArrayList<ServiceConsumer> getDelConsumer(Connection con,PaginationVo vo) {
		PaginationDao pd=new PaginationDao();	
		ArrayList<ServiceConsumer> list=new ArrayList<ServiceConsumer>();
		return pd.getDelConsumer(vo,list,con);
	}

	public PaginationVo sentRequestProvider(Connection con, String id,String catogeory) {
		PaginationDao pd=new PaginationDao();
		
		return pd.sentRequestProvider(con,id,catogeory);
	}

	public ArrayList<ServiceProvider> sentRequest(Connection con,PaginationVo vo) {
		PaginationDao pd=new PaginationDao();	
		ArrayList<ServiceProvider> list=new ArrayList<ServiceProvider>();
		return pd.sentRequest(vo,list,con);
	}

	public PaginationVo getConsumer(Connection con, int id) {
		PaginationDao pd=new PaginationDao();		
		return pd.getRequestConsumer(con,id);
	}

	public ArrayList<ServiceConsumer> getConsumer(Connection con,PaginationVo vo) {
		PaginationDao pd=new PaginationDao();	
		ArrayList<ServiceConsumer> list=new ArrayList<ServiceConsumer>();
		return pd.getConsumer(vo,list,con);
	}
	
	}

