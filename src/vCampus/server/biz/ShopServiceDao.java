package vCampus.server.biz;

import java.util.ArrayList;

import vCampus.server.exception.OutOfLimitException;
import vCampus.server.exception.RecordAlreadyExistException;
import vCampus.server.exception.RecordNotFoundException;
import vCampus.vo.ProductInformation;
import vCampus.vo.ProductPurchase;

public interface ShopServiceDao {
	/**
	 * ����userName����,����ArrayList<ProductPurchase>����,δ��ѯ�ɹ�������null
	 * @param String
	 * @return ArrayList<ProductPurchase>
	 */
	public ArrayList<ProductPurchase> queryAccountCurrentByUserName(String userName);
	
	/**
	 *����productID����,����ArrayList<ProductPurchase>����,δ��ѯ�ɹ�������null
	 * @param String
	 * @return ArrayList<ProductPurchase>
	 */
	public ArrayList<ProductPurchase> queryAccountCurrentByProductID(String productID);
	
	/**
	 *����productID����,����ProductInformation����,δ��ѯ�ɹ�������null
	 * @param String
	 * @return ProductInformation
	 */
	public ProductInformation queryProductInformation(String productID);
	
	/**
	 * �޴������,����ArrayList<ProductInformation>����,δ��ѯ�ɹ�������null
	 * @param String
	 * @return ArrayList<ProductInformation>
	 */
	public ArrayList<ProductInformation> queryAllProduct();
	
    /**
	 * ����buyProduct�Լ�type 0����ѧ�� 1������ʦ,SQL�쳣����false
	 * ����Ʒ������/��Ʒ���������������(��uMsg����)���׳��쳣
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws OutOfLimitException
	 */
	public boolean buyProduct(ProductPurchase buyProduct,int type)//type 0 student 1 teacher
			throws RecordNotFoundException,OutOfLimitException;

	/**
	 * ����ProductInformation,����������Ʒ�Ѿ��������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordAlreadyExistException
	 */
	public boolean addProductByAdmin(ProductInformation product)throws RecordAlreadyExistException;
	
	/**
	 * ����ProductInformation,����������Ʒ���������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
	public boolean updateProductByAdmin(ProductInformation product)throws RecordNotFoundException;
	
    /**
	 * ����productID,����Ʒ��Ϣ���������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
	public boolean deleteProductByAdmin(String productID)throws RecordNotFoundException;
}
