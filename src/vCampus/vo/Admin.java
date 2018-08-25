package vCampus.vo;

import java.io.Serializable;
import vCampus.model.User;

/**
 * @author YangHangyuan
 *
 */
public class Admin extends User implements Serializable{
	private String adminID;
	private String password;
	
	public void setAdminID(String adminID){
		this.adminID=adminID;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getAdminID(){
		return adminID;
	}
	public String getPassword(){
		return password;
	}
}
