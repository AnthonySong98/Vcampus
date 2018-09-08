package vCampus.server.dao;

import vCampus.server.exception.*;
import vCampus.vo.*;

/**
 * StudentDao���Ѿ��ṩ��ѧ���˻���Ϣ�Ĳ�ѯ����
 * ѧ��ʵ����������˻����account��һ��ͨ���money����Ϣ
 * ��BankDao�н��ṩ�����˻���һ��ͨ��ֵ�Ĺ���
 */
public interface BankDao {
	/**
	 * ����Recharge, ����rechargeTime��д�����ݿ�ʱ����(���贫��)
	 * ��δ�ҵ���ǰѧ���������˺�����ʱ�ֱ��׳��쳣,SQL�쳣����false
	 * @param recharge
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws OutOfLimitException
	 */
	public boolean rechargeByBankAccount(Recharge recharge)throws OutOfLimitException,RecordNotFoundException;
	
}
