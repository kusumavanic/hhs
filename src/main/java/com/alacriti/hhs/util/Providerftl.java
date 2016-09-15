package com.alacriti.hhs.util;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.alacriti.hhs.vo.Service;
import com.alacriti.hhs.vo.ServiceConsumer;
import com.alacriti.hhs.vo.ServiceProvider;
import com.alacriti.hhs.vo.consumerRequest;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;




public class Providerftl {
	public String getProviders( ArrayList<ServiceProvider> list) throws IOException, TemplateException  {
		ftlConfiguration fc=new ftlConfiguration();
		Configuration cfg=fc.configuration();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("list", list);
		Template temp = cfg.getTemplate("allProvider.ftl");			    
		StringWriter str=new StringWriter();
		temp.process(map,str);
		
		return str.toString();
	}
	public String getrequestProviders() throws IOException, TemplateException  {
		ftlConfiguration fc=new ftlConfiguration();
		Configuration cfg=fc.configuration();
	    Template temp = cfg.getTemplate("RequestService.ftl");	    
	    StringWriter str=new StringWriter();
		temp.process(null,str);

	    return str.toString();
	}	
	public   String getConsumers() throws IOException, TemplateException  {

		ftlConfiguration fc=new ftlConfiguration();
		Configuration cfg=fc.configuration();
	
	    Template temp = cfg.getTemplate("consumer.ftl");
	    
	    Writer out = new OutputStreamWriter(System.out);
	    temp.process(null, out);
	    StringWriter str=new StringWriter();
		temp.process(null,str);

	    return str.toString();
	}
	public   String getServices() throws IOException, TemplateException  {

		ftlConfiguration fc=new ftlConfiguration();
		Configuration cfg=fc.configuration();
	    Template temp = cfg.getTemplate("service.ftl");
	    
	    Writer out = new OutputStreamWriter(System.out);
	    temp.process(null, out);
	    
	    StringWriter str=new StringWriter();
		temp.process(null,str);

	    return str.toString();
	}
	public String viewProfile(ArrayList<ServiceProvider> list) throws IOException, TemplateException {
		
		ftlConfiguration fc=new ftlConfiguration();
		Configuration cfg=fc.configuration();
	    Map<String,Object> map=new HashMap<String,Object>();
	    
	    map.put("list", list);
	    Template temp = cfg.getTemplate("viewProfile.ftl");
	    Writer out = new OutputStreamWriter(System.out);
	    temp.process(map, out);
	    StringWriter str=new StringWriter();
		temp.process(map,str);

	    return str.toString();
	}
	public String providerLogin(ArrayList<ServiceProvider> list) throws IOException, TemplateException {

		ftlConfiguration fc=new ftlConfiguration();
		Configuration cfg=fc.configuration();
	    Map<String,Object> map=new HashMap<String,Object>();	    
	    map.put("list", list);
	    
	    Template temp = cfg.getTemplate("provider.ftl");
	    
	    Writer out = new OutputStreamWriter(System.out);
	    temp.process(map, out);

	    StringWriter str=new StringWriter();
		temp.process(map,str);

	    return str.toString();
	}
	public String consumerLogin(ArrayList<ServiceConsumer> list) throws IOException, TemplateException {

		ftlConfiguration fc=new ftlConfiguration();
		Configuration cfg=fc.configuration();
		
	    Map<String,Object> map=new HashMap<String,Object>();	    
	    map.put("list", list);
	    
	    Template temp = cfg.getTemplate("loginConsumer.ftl");
	    
	    StringWriter str=new StringWriter();
		temp.process(map,str);
	    return str.toString();
	}
	public String viewConsumerProfile(ArrayList<ServiceConsumer> list) throws IOException, TemplateException {

		ftlConfiguration fc=new ftlConfiguration();
		Configuration cfg=fc.configuration();
	     
	    Map<String,Object> map=new HashMap<String,Object>();
	    
	    map.put("list", list);
	    Template temp = cfg.getTemplate("viewProfileConsumer.ftl");
	    
	    Writer out = new OutputStreamWriter(System.out);
	    temp.process(map, out);
	 
	    StringWriter str=new StringWriter();
		temp.process(map,str);

	    return str.toString();
	}
	public String sentRequest(ArrayList<Service> list, int id) throws IOException, TemplateException {

		ftlConfiguration fc=new ftlConfiguration();
		Configuration cfg=fc.configuration();
	     
	    Map<String,Object> map=new HashMap<String,Object>();
	    
	    map.put("list", list);
	    map.put("consumerId", id);
	    Template temp = cfg.getTemplate("sentProvider.ftl");
	    
	    Writer out = new OutputStreamWriter(System.out);
	    temp.process(map, out);
	    
	    StringWriter str=new StringWriter();
		temp.process(map,str);

	    return str.toString();
	}
	
	public String requestConsumers(String id) throws IOException, TemplateException {

		ftlConfiguration fc=new ftlConfiguration();
		Configuration cfg=fc.configuration();
	     
	    Map<String,String> map=new HashMap<String,String>();
	    
	    map.put("list", id);
	    Template temp = cfg.getTemplate("getConsumer.ftl");
	    
	    Writer out = new OutputStreamWriter(System.out);
	    temp.process(map, out);
	   
	    StringWriter str=new StringWriter();
		temp.process(map,str);

	    return str.toString();
	}
	public String getAllProvidersPagination(ArrayList<ServiceProvider> list) throws IOException, TemplateException {
		ftlConfiguration fc=new ftlConfiguration();
		Configuration cfg=fc.configuration();
	     
	    Map<String,Object> map=new HashMap<String,Object>();
	    
	    map.put("list", list);
	    Template temp = cfg.getTemplate("page.ftl");
	    
	    Writer out = new OutputStreamWriter(System.out);
	    temp.process(map, out);
	   
	    StringWriter str=new StringWriter();
		temp.process(map,str);

	    return str.toString();
	}
	public String getAllRequestProvidersPagination(ArrayList<ServiceProvider> list) throws IOException, TemplateException {
		ftlConfiguration fc=new ftlConfiguration();
		Configuration cfg=fc.configuration();
	     
	    Map<String,Object> map=new HashMap<String,Object>();
	    
	    map.put("list", list);
	    Template temp = cfg.getTemplate("viewRequest.ftl");
	    
	    Writer out = new OutputStreamWriter(System.out);
	    temp.process(map, out);
	   
	    StringWriter str=new StringWriter();
		temp.process(map,str);

	    return str.toString();
	}
	public String getIndexProvidersPagination(ArrayList<ServiceProvider> list) throws IOException, TemplateException {
		ftlConfiguration fc=new ftlConfiguration();
		Configuration cfg=fc.configuration();
	     
	    Map<String,Object> map=new HashMap<String,Object>();
	    
	    map.put("list", list);
	    Template temp = cfg.getTemplate("indexdetail.ftl");
	    
	    Writer out = new OutputStreamWriter(System.out);
	    temp.process(map, out);
	   
	    StringWriter str=new StringWriter();
		temp.process(map,str);

	    return str.toString();
	}
	public String getAllDetailsProviderPagination(ArrayList<ServiceProvider> list) throws IOException, TemplateException {
		ftlConfiguration fc=new ftlConfiguration();
		Configuration cfg=fc.configuration();
	     
	    Map<String,Object> map=new HashMap<String,Object>();
	    
	    map.put("list", list);
	    Template temp = cfg.getTemplate("page.ftl");
	    
	    Writer out = new OutputStreamWriter(System.out);
	    temp.process(map, out);
	   
	    StringWriter str=new StringWriter();
		temp.process(map,str);

	    return str.toString();
	}
	public String getConsumerPagination(ArrayList<ServiceConsumer> list) throws IOException, TemplateException {
		ftlConfiguration fc=new ftlConfiguration();
		Configuration cfg=fc.configuration();
	     
	    Map<String,Object> map=new HashMap<String,Object>();
	    
	    map.put("list", list);
	    Template temp = cfg.getTemplate("consumerDetail.ftl");
	    
	    Writer out = new OutputStreamWriter(System.out);
	    temp.process(map, out);
	   
	    StringWriter str=new StringWriter();
		temp.process(map,str);

	    return str.toString();
	}
	public String serviceType(ArrayList<Service> list) throws IOException, TemplateException {
		ftlConfiguration fc=new ftlConfiguration();
		Configuration cfg=fc.configuration();
	     
	    Map<String,Object> map=new HashMap<String,Object>();
	    
	    map.put("list", list);
	    Template temp = cfg.getTemplate("ServiceType.ftl");
	    
	    Writer out = new OutputStreamWriter(System.out);
	    temp.process(map, out);
	   
	    StringWriter str=new StringWriter();
		temp.process(map,str);

	    return str.toString();
	}
	public String getDelProvider(ArrayList<ServiceProvider> list) throws IOException, TemplateException {
		ftlConfiguration fc=new ftlConfiguration();
		Configuration cfg=fc.configuration();
	     
	    Map<String,Object> map=new HashMap<String,Object>();
	    
	    map.put("list", list);
	    Template temp = cfg.getTemplate("deleteProvider.ftl");
	    
	    Writer out = new OutputStreamWriter(System.out);
	    temp.process(map, out);
	   
	    StringWriter str=new StringWriter();
		temp.process(map,str);

	    return str.toString();
	}
	public String getDelConsumer(ArrayList<ServiceConsumer> list) throws IOException, TemplateException {
		ftlConfiguration fc=new ftlConfiguration();
		Configuration cfg=fc.configuration();
	     
	    Map<String,Object> map=new HashMap<String,Object>();
	    
	    map.put("list", list);
	    Template temp = cfg.getTemplate("selDelConsumer.ftl");
	    
	    Writer out = new OutputStreamWriter(System.out);
	    temp.process(map, out);
	   
	    StringWriter str=new StringWriter();
		temp.process(map,str);

	    return str.toString();
	}
	public String sentRequestProvider(ArrayList<ServiceProvider> list, String id) throws IOException, TemplateException {
		ftlConfiguration fc=new ftlConfiguration();
		Configuration cfg=fc.configuration();
	     
	    Map<String,Object> map=new HashMap<String,Object>();
	    
	    map.put("list", list);
	    map.put("id", id);
	    Template temp = cfg.getTemplate("sentRequestProvider.ftl");
	    
	    Writer out = new OutputStreamWriter(System.out);
	    temp.process(map, out);
	   
	    StringWriter str=new StringWriter();
		temp.process(map,str);

	    return str.toString();
	}
	public String getConsumer(ArrayList<ServiceConsumer> list) throws IOException, TemplateException {
		ftlConfiguration fc=new ftlConfiguration();
		Configuration cfg=fc.configuration();
	     
	    Map<String,Object> map=new HashMap<String,Object>();
	    
	    map.put("list", list);
	    Template temp = cfg.getTemplate("getRequestConsumer.ftl");
	    
	    Writer out = new OutputStreamWriter(System.out);
	    temp.process(map, out);
	   
	    StringWriter str=new StringWriter();
		temp.process(map,str);

	    return str.toString();
	}
	public String getProviders1(int id) throws IOException, TemplateException {
		ftlConfiguration fc=new ftlConfiguration();
		Configuration cfg=fc.configuration();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("list", id);
		Template temp = cfg.getTemplate("allProvider1.ftl");			    
		StringWriter str=new StringWriter();
		temp.process(map,str);
		
		return str.toString();
	}
	public String viewAdmin(ArrayList<consumerRequest> list) throws IOException, TemplateException {
		ftlConfiguration fc=new ftlConfiguration();
		Configuration cfg=fc.configuration();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("list", list);
		Template temp = cfg.getTemplate("viewAdmin.ftl");			    
		StringWriter str=new StringWriter();
		temp.process(map,str);
		
		return str.toString();
	}
	
	
	
	
}

