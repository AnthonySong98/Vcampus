package vCampus.client.biz;

import java.util.ArrayList;

import vCampus.server.exception.OutOfLimitException;
import vCampus.server.exception.RecordAlreadyExistException;
import vCampus.server.exception.RecordNotFoundException;
import vCampus.vo.BookBorrow;
import vCampus.vo.BookInformation;

/**
 * @author SongZixing
 * @version 0.0
 *
 */
public interface LibraryService {
	
	
	/**
	 * get exception codes if there exists any exception or error
	 * @return String
	 */
	public String getExceptionCode();
	

	/**
	 * ����bookID����,����BookInformation����,δ��ѯ�ɹ�������null
	 * @param String
	 * @return courseInformation
	 */
	public BookInformation queryBookInformation(String bookID);
	
	/**
	 * ����bookName����,����ArrayList<BookInformation>����,δ��ѯ�ɹ�������null
	 * @param String
	 * @return ArrayList<BookInformation>
	 */
	public ArrayList<BookInformation> queryBook(String bookName);
	
	/**
	 * ����userName����,����ArrayList<BookBorrow>����,δ��ѯ�ɹ�������null
	 * @param String
	 * @return ArrayList<BookBorrow>
	 */
	public ArrayList<BookBorrow> queryBookBorrow(String userName);
	
    /**
	 * ����BookBorrow,ʱ����Ϊд�����ݿ��ʱ��(ʱ���������贫��),
	 * ���鲻����/���ʣ�������������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws OutOfLimitException
	 */
	public boolean borrowBook(BookBorrow borrow);
	
	/**
	 * ����BookBorrow,ʱ����Ϊд�����ݿ��ʱ��(ʱ���������贫��),��֮ǰ�н���ͬID������ˢ�½���ʱ�������
	 * ����Ŀ�����ڻ��߸�ѧ����δ����/�Ѿ�����������Ȼ�������������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws OutOfLimitException
	 */
	public boolean returnBook(BookBorrow borrow);
	
	
	/**
	 * ��ȡ������Ŀ,����ArrayList<BookInformation>����,δ��ѯ�ɹ�������null
	 * @param String
	 * @return ArrayList<BookInformation>
	 */
	public ArrayList<BookInformation> queryAllBook();
	
	/**
	 * ����BookInformation,��bookID�Ѿ��������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordAlreadyExistException
	 */
	public boolean addBookByAdmin(BookInformation book);
	/**
	 * ����BookInformation,��bookID���������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordAlreadyExistException
	 */
	public boolean updateBookByAdmin(BookInformation book);
	/**
	 * ����bookID,��bookID���������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordAlreadyExistException
	 */
	public boolean deleteBookByAdmin(String bookID);
	
}
