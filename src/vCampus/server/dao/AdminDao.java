package vCampus.server.dao;

import java.sql.ResultSet;


import java.sql.SQLException;

import vCampus.vo.Admin;

import java.sql.PreparedStatement;

public class AdminDao {	
	
	private DBConnection DBC=new DBConnection();
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
	/**��ȡ���ݿ���ĳ����Ա����Ϣ
	 * 
	 * @param adminID
	 * @return admin
	 */
	public Admin selectAdmin(String adminID){
		Admin admin=new Admin();
		String sql="SELECT * FROM vcampus.admin WHERE adminID=?";
		try {
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1,adminID);
			rs = stmt.executeQuery();
			if(rs.next()){
				admin.setAdminID(rs.getString("adminID"));
				admin.setPassword(rs.getString("password"));
			}
			else
				admin=null;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	} 	
	
	/**�����ݿ������ĳ����Ա����Ϣ
	 * 
	 * @param 
	 * @return NONE
	 */
	public void insertAdmin(String ID,String password){
		String sql="INSERT INTO vcampus.admin(adminID,password) VALUES (?,?)";
		try {
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1,ID);
			stmt.setString(2,password);
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}	 	
	
	/**�޸����ݿ���ĳ����Ա����
	 * 
	 * @param 
	 * @return NONE
	 */
	public void updatePassword(String password,String adminID){
		try{
			String sql="UPDATE vcampus.admin SET password=? WHERE adminID=?";
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1, password);
			stmt.setString(2, adminID);
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}


