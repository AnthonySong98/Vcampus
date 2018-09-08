package vCampus.server.dao;

import vCampus.vo.Admin;
import vCampus.server.exception.*;

public interface AdminDao {	
	/**
	 * ����admin����������Admin����δ��ѯ�ɹ�������null
	 * @param String
	 * @return admin
	 */
	public Admin selectAdmin(String adminID);
	
	/**
	 * ����adminID,password,��userName�Ѿ������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordAlreadyExistException
	 */
	public boolean insertAdmin(String adminID,String password)throws RecordAlreadyExistException;
	
	/**
	 * ����adminID,password,��userName�������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
	public boolean updatePassword(String adminID,String password)throws RecordNotFoundException;
	
	/**
	 * ����adminID,��userName�������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
	public boolean deleteAdmin(String adminID)throws RecordNotFoundException;
}

