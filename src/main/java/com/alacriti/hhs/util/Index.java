package com.alacriti.hhs.util;

import java.io.IOException;
import java.io.StringWriter;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class Index {
	ftlConfiguration fc=new ftlConfiguration();
	
	
	public String indexPage() throws IOException, TemplateException{
		
		Configuration cfg=fc.configuration();
		
		Template temp = cfg.getTemplate("index.ftl");
		StringWriter str=new StringWriter();
		temp.process(null,str);
		
		return str.toString();
	}

	public String admin() throws IOException, TemplateException {
		Configuration cfg=fc.configuration();
		Template temp = cfg.getTemplate("adminlogin.ftl");
		StringWriter str=new StringWriter();
		temp.process(null,str);
		
		return str.toString();
	}

	public String provider() throws IOException, TemplateException {
		Configuration cfg=fc.configuration();
		Template temp = cfg.getTemplate("ServiceProvider.ftl");
		StringWriter str=new StringWriter();
		temp.process(null,str);
		
		return str.toString();
	}
	public String consumer() throws IOException, TemplateException {
		Configuration cfg=fc.configuration();
		Template temp = cfg.getTemplate("ServiceConsumer.ftl");
		StringWriter str=new StringWriter();
		temp.process(null,str);
		
		return str.toString();
	}

	public String providerLogin() throws IOException, TemplateException {
		Configuration cfg=fc.configuration();
		Template temp = cfg.getTemplate("ProviderLogin.ftl");
		StringWriter str=new StringWriter();
		temp.process(null,str);
		
		return str.toString();
	}
	public String consumerLogin() throws IOException, TemplateException {
		Configuration cfg=fc.configuration();
		Template temp = cfg.getTemplate("Login.ftl");
		StringWriter str=new StringWriter();
		temp.process(null,str);
		
		return str.toString();
	}

	public String guest() throws IOException, TemplateException {
		Configuration cfg=fc.configuration();
		Template temp = cfg.getTemplate("GuestLogin.ftl");
		StringWriter str=new StringWriter();
		temp.process(null,str);
		
		return str.toString();
	}

	public String getAdmin() throws IOException, TemplateException {
		Configuration cfg=fc.configuration();
		Template temp = cfg.getTemplate("Admin.ftl");
		StringWriter str=new StringWriter();
		temp.process(null,str);
		
		return str.toString();
	}
}
