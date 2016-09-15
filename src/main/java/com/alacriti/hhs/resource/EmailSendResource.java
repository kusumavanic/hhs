package com.alacriti.hhs.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.ws.rs.FormParam;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;


@Path("/sendEmail")
public class EmailSendResource {
	
	static Logger l = Logger.getLogger(EmailSendResource.class.getName());
	@POST
	@Path("/request")
	public Response sendRequestByEmail(@FormParam("fromEmail") final String fromEmail,
								   @FormParam("password") final String password,
								   @FormParam("toEmail") String toEmail,
								   @FormParam("subject") String subject,
								   @FormParam("body") String body) throws URISyntaxException,AuthenticationFailedException{
				
			
			String to=toEmail;  
			Properties props = new Properties();  
			props.put("mail.smtp.host","smtp.gmail.com");  
			props.put("mail.smtp.socketFactory.port", "465");  
			props.put("mail.smtp.socketFactory.class",  
			           "javax.net.ssl.SSLSocketFactory");  
			props.put("mail.smtp.auth", "true");  
			props.put("mail.smtp.port", "25");  
			
			URI uri = new URI("/consumer/composeMail");
			Session session = Session.getInstance(props,new javax.mail.Authenticator() {  
			protected PasswordAuthentication getPasswordAuthentication() {  
				return new PasswordAuthentication(fromEmail,password);
			  }  
			 });
			try 
			{  
			  MimeMessage message = new MimeMessage(session);  
			  message.setFrom(new InternetAddress(fromEmail));  
			  message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
			  message.setSubject(subject);  
			  message.setText(body);  
			    
			  
			  Transport.send(message);  
			 
			  l.info("message sent successfully");  
			  
			} catch (MessagingException e) {
		 
			    throw new RuntimeException(e);
			}  
	return Response.seeOther(uri).build();
	}
	@POST
	public void successRegistration(String mobileNumber, String emailId){
		l.info("number :"+mobileNumber);
		l.info("email :"+emailId);
		String to=emailId;  
		Properties props = new Properties();  
		props.put("mail.smtp.host","smtp.gmail.com");  
		props.put("mail.smtp.socketFactory.port", "465");  
		props.put("mail.smtp.socketFactory.class",  
		           "javax.net.ssl.SSLSocketFactory");  
		props.put("mail.smtp.auth", "true");  
		props.put("mail.smtp.port", "25");  
		
		Session session = Session.getInstance(props,new javax.mail.Authenticator() {  
		protected PasswordAuthentication getPasswordAuthentication() {  
			return new PasswordAuthentication("kusumavanicool@gmail.com","9989017101");
		  }  
		 });
		try 
		{  
		  MimeMessage message = new MimeMessage(session);  
		  message.setFrom(new InternetAddress("kusumavanicool@gmail.com"));  
		  message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
		  message.setSubject("welcome..");  
		  message.setText("you are successfully registered in HOUSE HOLD SERVICES and your registered email is "+emailId+" and Mobile Number is "+mobileNumber);  
		    
		  
		  Transport.send(message);  
		 
		  l.info("message sent successfully");  
		  
		} catch (MessagingException e) {
	 
		    throw new RuntimeException(e);
		}  
	}
}
