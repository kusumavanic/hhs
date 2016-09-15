package com.alacriti.hhs.util;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.alacriti.hhs.vo.Service;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class SendEmail {
	public String sendMail( ArrayList<Service> list) throws IOException, TemplateException  {
		ftlConfiguration fc=new ftlConfiguration();
		Configuration cfg=fc.configuration();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("list", list);
		Template temp = cfg.getTemplate("SendMail.ftl");			    
		StringWriter str=new StringWriter();
		temp.process(map,str);
		
		return str.toString();
	}
}