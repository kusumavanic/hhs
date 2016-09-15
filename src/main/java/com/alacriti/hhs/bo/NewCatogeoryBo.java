package com.alacriti.hhs.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alacriti.hhs.dao.NewCatogeoryDao;
import com.alacriti.hhs.vo.AddNewCatogeory;

public class NewCatogeoryBo {
	NewCatogeoryDao ncd=new NewCatogeoryDao();
	
	public  Object newCatogeory(Connection con, String catogeory,String icon) throws SQLException{
				
		return ncd.postNewCatogeory(con, catogeory, icon);
	}

	public ArrayList<AddNewCatogeory> getNewCatogeory(Connection con) throws SQLException{
		ArrayList<AddNewCatogeory> list=ncd.getNewCatogeory(con);
		return list;
	}
	
}
