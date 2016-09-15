package com.alacriti.hhs.bo;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import com.alacriti.hhs.dao.OAuthDao;
import com.alacriti.hhs.vo.ServiceConsumer;
import com.alacriti.hhs.vo.UserVo;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;


public class OAuthLoginBo {
	private static final String CLIENT_ID="518852838024-c2rbvo1r3do97r6ufp1k49an4qndqpah.apps.googleusercontent.com";
	private static final HttpTransport transport=new NetHttpTransport();
	private static final JacksonFactory jsonFactory= new JacksonFactory();



	public ArrayList<ServiceConsumer> getUserTokenId(Connection con, String idTokenString) throws GeneralSecurityException, IOException, SQLException {
		
		UserVo user=new UserVo();
		ArrayList<ServiceConsumer> list=new ArrayList<ServiceConsumer>();
		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
	    .setAudience(Arrays.asList(CLIENT_ID))
	    .setIssuer("accounts.google.com")
	    .build();
		GoogleIdToken idToken = verifier.verify(idTokenString);
		if (idToken != null)
		{
		  Payload payload = idToken.getPayload();

		  String email = payload.getEmail();
		  boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
		  String name = (String) payload.get("name");
		  String locale = (String) payload.get("locale");
		  
			  if(emailVerified)
			  {
				  user.setEmail(email);
				  user.setProfileName(name);
				  user.setLocation(locale);
			  }
			  else
			  {
				  System.out.println("Invalid");
			  }
		  OAuthDao oauthdao=new OAuthDao();
		  list=oauthdao.request(con,user.getEmail(),user.getProfileName(),user.getLocation());
		  return list;
		}
		return list; 
	}

}
