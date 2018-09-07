package vCampus.client.biz;

import vCampus.vo.Admin;

/**
 * @author SongZixing
 *
 */
public interface AdminService {

	public Admin getCacheAdmin();
	public String getExceptionCode();
	public boolean register(String userName,String password,String confirmedPassword);
	public boolean login(String userName,String password);
	public boolean updatePassword(String password);
	public boolean destoryAccount(String userType,String userName);
	
}
