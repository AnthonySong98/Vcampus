package vCampus.client.biz;

import vCampus.server.exception.OutOfLimitException;
import vCampus.server.exception.RecordNotFoundException;
import vCampus.vo.Recharge;

public interface BankService {

	/**
	 * ����Recharge, ����rechargeTime��д�����ݿ�ʱ����(���贫��)
	 * ��δ�ҵ���ǰѧ���������˺�����ʱ�ֱ��׳��쳣,SQL�쳣����false
	 * @param recharge
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws OutOfLimitException
	 */
	public boolean rechargeByBankAccount(Recharge recharge);
	
}
