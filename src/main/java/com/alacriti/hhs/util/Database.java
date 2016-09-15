package com.alacriti.hhs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;*/

public class Database {
	Connection con;
	public Connection databaseConnection(){
			try {
				if (con == null) {
					//DataSource datasource;
					//InitialContext context= new InitialContext();
					//datasource = (DataSource) context.lookup("java:/MiniProject");
					//con=datasource.getConnection();
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(
							"jdbc:mysql://192.168.35.70:3306/houseservice_dev",
							"houseservice_dev", "houseservice_dev");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return con;
	}
	public void closeConnection() {
		try {
			if(con!=null)
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
