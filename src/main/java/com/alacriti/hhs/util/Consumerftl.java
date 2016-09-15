package com.alacriti.hhs.util;


import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.alacriti.hhs.vo.ServiceConsumer;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


public class Consumerftl {
	public   String getConsumers( ArrayList<ServiceConsumer> list) throws IOException, TemplateException  {

		ftlConfiguration fc=new ftlConfiguration();
		Configuration cfg=fc.configuration();
		     
		    Map<String,Object> map=new HashMap<String,Object>();
		    
		    map.put("list", list);
		    Template temp = cfg.getTemplate("consumerName.ftl");
		    
		    Writer out = new OutputStreamWriter(System.out);
		    temp.process(map, out);
		    StringWriter str=new StringWriter();
			temp.process(map,str);
	
		    return str.toString();
	 }
	
	

}
