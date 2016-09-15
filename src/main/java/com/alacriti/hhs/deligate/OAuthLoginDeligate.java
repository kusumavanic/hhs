package com.alacriti.hhs.deligate;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alacriti.hhs.bo.OAuthLoginBo;
import com.alacriti.hhs.util.Database;
import com.alacriti.hhs.vo.ServiceConsumer;

public class OAuthLoginDeligate {
	Database db=new Database();
	
	public ArrayList<ServiceConsumer> getUserTokenId(String token_id)throws GeneralSecurityException, IOException, SQLException{ 
			
		OAuthLoginBo oAuthLoginbo=new OAuthLoginBo();
		Connection con=db.databaseConnection();
		ArrayList<ServiceConsumer> list=oAuthLoginbo.getUserTokenId(con,token_id);
		return list;
		
	}

}
