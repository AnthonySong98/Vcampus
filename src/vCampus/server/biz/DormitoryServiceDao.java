package vCampus.server.biz;

import java.util.ArrayList;

import vCampus.server.exception.OutOfLimitException;
import vCampus.server.exception.RecordNotFoundException;
import vCampus.vo.Dormitory;

public interface DormitoryServiceDao {

	/**
	 * ����userName����,����ArrayList<Dormitory>,δ��ѯ�ɹ�������null
	 * @param String
	 * @return ArrayList<Dormitory>
	 */
	public ArrayList<Dormitory> queryDormitoryByUserName(String userName);
	
	/**
	 * ����dormNumber����,����ArrayList<Dormitory>,δ��ѯ�ɹ�������null
	 * @param String
	 * @return ArrayList<Dormitory>
	 */
	public ArrayList<Dormitory> queryDormitoryByDormNumber(String dormNumber);
	
    /**
	 * ����Dormitory,��ѧ��-������Ϣ���Ϸ����߲�����/һ��ͨ�������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws OutOfLimitException
	 */
	public boolean addDormitoryInfo(Dormitory dorm)throws RecordNotFoundException,OutOfLimitException;
}
