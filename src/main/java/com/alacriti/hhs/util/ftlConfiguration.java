package com.alacriti.hhs.util;

import java.io.File;
import java.io.IOException;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

public class ftlConfiguration {
	public Configuration configuration(){
		Configuration cfg=new Configuration();
		cfg.setClassForTemplateLoading(Providerftl.class, "/");
			try {
				cfg.setDirectoryForTemplateLoading(new File("/home/kusumavanic/workspace/hhs/src/main/webapp/ftl"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		return cfg;
		 
	}
}
