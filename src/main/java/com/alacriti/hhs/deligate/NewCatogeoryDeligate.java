package com.alacriti.hhs.deligate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alacriti.hhs.bo.NewCatogeoryBo;
import com.alacriti.hhs.util.Database;
import com.alacriti.hhs.vo.AddNewCatogeory;


public class NewCatogeoryDeligate {
	Database db=new Database();
	Connection con =db.databaseConnection();

	public Object newCatogeory(String catogeory, String icon) throws SQLException {
		NewCatogeoryBo ncb = new NewCatogeoryBo();
		return ncb.newCatogeory(con,catogeory, icon);
	}

	public ArrayList<AddNewCatogeory> getNewCatogeory() throws SQLException {
		NewCatogeoryBo ncb = new NewCatogeoryBo();
		ArrayList<AddNewCatogeory> list = ncb.getNewCatogeory(con);
		return list;
	}

}
