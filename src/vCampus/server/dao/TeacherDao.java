package vCampus.server.dao;

import java.sql.SQLException;


import vCampus.server.exception.*;
import vCampus.vo.Teacher;

public interface TeacherDao {
	/**
	 * ����userName����,����Teacher����,δ��ѯ�ɹ�������null
	 * @param String
	 * @return teacher
	 */
	public Teacher findByName(String userName);
	
	/**
	 * ����userName,password,��userName�Ѿ��������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordAlreadyExistException
	 */
	public boolean insertByUserNameAndPassword(String userName,String password)throws RecordAlreadyExistException;
	
	/**
	 * ����userName,password,��userName���������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
	public boolean updatePassword(String userName,String password)throws RecordNotFoundException;
	
	/**
	 * ����Teacher,��userName���������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
	public boolean updateSelfInformation(Teacher std)throws RecordNotFoundException;
	
	/**
	 * ����userName,��userName���������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
	public boolean deleteTeacher(String userName)throws RecordNotFoundException;
}
