package com.alacriti.hhs.deligate;

import java.sql.Connection;
import java.util.ArrayList;

import com.alacriti.hhs.bo.PaginationBo;
import com.alacriti.hhs.util.Database;
import com.alacriti.hhs.vo.PaginationVo;
import com.alacriti.hhs.vo.Service;
import com.alacriti.hhs.vo.ServiceConsumer;
import com.alacriti.hhs.vo.ServiceProvider;

public class PaginationDeligate {
	Database db=new Database();
	Connection con=db.databaseConnection();
	
	//getting provider details
	public PaginationVo providerPagination(){		
		PaginationBo pb=new PaginationBo();
		return pb.providerPagination(con);
	}
	public ArrayList<ServiceProvider> getAllProvidersPagination(PaginationVo vo) {
		PaginationBo pb=new PaginationBo();
		return pb.getAllProvidersPagination(con,vo);
	}
	
	//getting requested provider details
	public PaginationVo requestProviderPagination() {
		PaginationBo pb=new PaginationBo();
		return pb.requestProviderPagination(con);
	}
	public ArrayList<ServiceProvider> getAllRequestProvidersPagination(PaginationVo vo) {
		PaginationBo pb=new PaginationBo();
		return pb.getAllRequestProvidersPagination(con,vo);
	}
	
	//getting indexprovider details
	public PaginationVo indexProviderPagination(String id) {
		PaginationBo pb=new PaginationBo();
		return pb.indexProviderPagination(con,id);
	}
	public ArrayList<ServiceProvider> getIndexProvidersPagination(PaginationVo vo) {
		PaginationBo pb=new PaginationBo();
		return pb.getIndexProvidersPagination(con,vo);
	}
	
	//getting all provider details
	public ArrayList<ServiceProvider> getAllDetailsProviderPagination(PaginationVo vo) {
		PaginationBo pb=new PaginationBo();
		return pb.getAllDetailsProviderPagination(con,vo);
	}
	
	//getting consumer details
	public PaginationVo consumerPagination() {
		PaginationBo pb=new PaginationBo();
		return pb.consumerPagination(con);
	}
	public ArrayList<ServiceConsumer> getConsumerPagination(PaginationVo vo) {
		PaginationBo pb=new PaginationBo();
		return pb.getConsumerPagination(con,vo);
	}
	
	//getting all service details
	public PaginationVo service() {
		PaginationBo pb=new PaginationBo();
		return pb.service(con);
	}
	public ArrayList<Service> serviceType(PaginationVo vo) {
		PaginationBo pb=new PaginationBo();
		return pb.serviceType(con,vo);
	}
	public ArrayList<ServiceProvider> getDelProvider(PaginationVo page) {
		PaginationBo pb=new PaginationBo();
		return pb.getDelProvider(con,page);
	}
	public ArrayList<ServiceConsumer> getDelConsumer(PaginationVo page) {
		PaginationBo pb=new PaginationBo();
		return pb.getDelConsumer(con,page);
	}
	public PaginationVo sentRequestProvider(String id, String catogeory) {
		PaginationBo pb=new PaginationBo();
		return pb.sentRequestProvider(con,id,catogeory);
	}
	public ArrayList<ServiceProvider> sentRequest(PaginationVo page) {
		PaginationBo pb=new PaginationBo();
		return pb.sentRequest(con,page);
	}
	public PaginationVo getConsumer(int id) {
		PaginationBo pb=new PaginationBo();
		return pb.getConsumer(con,id);
	}
	public ArrayList<ServiceConsumer> getConsumer(PaginationVo page) {
		PaginationBo pb=new PaginationBo();
		return pb.getConsumer(con,page);
	}
	
	
	}

