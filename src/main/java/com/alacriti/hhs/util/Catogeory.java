package com.alacriti.hhs.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import com.alacriti.hhs.vo.AddNewCatogeory;
import com.alacriti.hhs.vo.Service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


public class Catogeory {
	public String serviceCatogeory(ArrayList<AddNewCatogeory> list) throws IOException, TemplateException{
		
		ftlConfiguration fc=new ftlConfiguration();
		Configuration cfg=fc.configuration();
			Map<String,Object> map=new HashMap<String,Object>();		
			map.put("list", list);
			Template temp = cfg.getTemplate("add.ftl");			
			File file=new File("/home/kusumavanic/workspace/hhs/src/main/webapp/newCatogeory.html");
			Writer fileWriter = new FileWriter(file);
			try {
				  temp.process(map, fileWriter);
				  
			} finally {
				   fileWriter.close();
			}
			
			 StringWriter str=new StringWriter();
			 temp.process(map,str);
			
		 return str.toString();
}
public String AddOption(ArrayList<AddNewCatogeory> list) throws IOException, TemplateException
{
	ftlConfiguration fc=new ftlConfiguration();
	Configuration cfg=fc.configuration();
		 
			Map<String,Object> map=new HashMap<String,Object>();
		
			map.put("list", list);
			Template temp;
		
				temp = cfg.getTemplate("newOption.ftl");
			
			Writer out = new OutputStreamWriter(System.out);
			temp.process(map, out);
			File file=new File("/home/kusumavanic/workspace/hhs/src/main/webapp/newCatogeory4.html");
			Writer fileWriter = new FileWriter(file);
			try {
			   temp.process(map, fileWriter);
			  
			 } finally {
			   fileWriter.close();
			 }
		
		 StringWriter str=new StringWriter();
		 temp.process(map,str);
		
		 return str.toString();
}
public   String getDeleteProviders() throws IOException, TemplateException  {

	 	ftlConfiguration fc=new ftlConfiguration();
	 	Configuration cfg=fc.configuration();
     
	 		Template temp = cfg.getTemplate("selectDelProvider.ftl");
    
	 		Writer out = new OutputStreamWriter(System.out);
	 		temp.process(null, out);
	 		StringWriter str=new StringWriter();
	 		temp.process(null,str);

	 		return str.toString();
     }
public String getDeleteConsumers() throws IOException, TemplateException  {

	ftlConfiguration fc=new ftlConfiguration();
	Configuration cfg=fc.configuration();
		   Template temp = cfg.getTemplate("delConsumer.ftl");
		    
		   Writer out = new OutputStreamWriter(System.out);
		   temp.process(null, out);
		   
		
		   StringWriter str=new StringWriter();
		   temp.process(null,str);
		
		   return str.toString();
     }


public String serviceProviderCatogeory(String id) throws IOException, TemplateException{
	ftlConfiguration fc=new ftlConfiguration();
	Configuration cfg=fc.configuration();
		 
	Map<String,String> map=new HashMap<String,String>();
		
			map.put("list", id);
			Template temp;
		
			temp = cfg.getTemplate("providerName.ftl");
				
				Writer out = new OutputStreamWriter(System.out);
				temp.process(map, out);
						
			 StringWriter str=new StringWriter();
			 temp.process(map,str);
			
			 return str.toString();
	 }
public String serviceProviderDetailsad(ArrayList<AddNewCatogeory> list) throws IOException, TemplateException{
	
	ftlConfiguration fc=new ftlConfiguration();
	Configuration cfg=fc.configuration();
			Map<String,Object> map=new HashMap<String,Object>();
	
			map.put("list", list);
			Template temp;
		
				temp = cfg.getTemplate("addall1.ftl");
			
			Writer out = new OutputStreamWriter(System.out);
			temp.process(map, out);
			
		 StringWriter str=new StringWriter();
		 temp.process(map,str);
		
		 return str.toString();
 }
public String serviceProviderDetails(ArrayList<AddNewCatogeory> list, int consumerId) throws IOException, TemplateException{
	
	ftlConfiguration fc=new ftlConfiguration();
	Configuration cfg=fc.configuration();
			Map<String,Object> map=new HashMap<String,Object>();
	
			map.put("list", list);
			map.put("consumerId", consumerId);
			Template temp = cfg.getTemplate("addAll.ftl");
			
			Writer out = new OutputStreamWriter(System.out);
			temp.process(map, out);
			StringWriter str=new StringWriter();
			temp.process(map,str);
		
			return str.toString();
 }
public String serviceProviderDetailsCatogeory1(ArrayList<Service> list) throws IOException, TemplateException{

	ftlConfiguration fc=new ftlConfiguration();
	Configuration cfg=fc.configuration();
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("list", list);
			Template temp;	
				temp = cfg.getTemplate("catogeory1.ftl");
				
			Writer out = new OutputStreamWriter(System.out);
			temp.process(map, out);
			StringWriter str=new StringWriter();
			temp.process(map,str);
		
			return str.toString();
 }
public String serviceProviderDetailsCatogeory(String id) throws IOException, TemplateException{

	ftlConfiguration fc=new ftlConfiguration();
	Configuration cfg=fc.configuration();
	 
			Map<String,String> map=new HashMap<String,String>();
		
			map.put("list", id);
			Template temp;	
				temp = cfg.getTemplate("catogeory.ftl");
				
			Writer out = new OutputStreamWriter(System.out);
			temp.process(map, out);
			StringWriter str=new StringWriter();
			temp.process(map,str);
		
			return str.toString();
 }
	}

