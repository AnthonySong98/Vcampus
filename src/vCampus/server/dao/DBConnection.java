package vCampus.server.dao;

import java.io.File;


import java.sql.*;

/**�����ݿ⽨����ϵ
 * 
 * @author YangHangyuan
 *
 */
public class DBConnection {
	private static String driver="com.hxtt.sql.access.AccessDriver";
	private static String dpath=new File("").getAbsolutePath().replace('\\', '/') + "/Database/vCampus.accdb";
	private static String url = "jdbc:Access:///"+dpath;
	public Connection con = null;
	public DBConnection(){
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url);
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}         
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
