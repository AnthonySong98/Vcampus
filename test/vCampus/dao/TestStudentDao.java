/**
 * 
 */
package vCampus.dao;

import vCampus.server.dao.StudentDao;
import vCampus.server.dao.StudentDaoImpl;
import vCampus.server.exception.*;
import vCampus.vo.*;

/**
 * @author YangHangyuan, SongZixing
 *
 * @version 0.1
 * 
 */
public class TestStudentDao {
	
	private static void findByName(String userName)throws Exception {
		StudentDao stdImpl=new StudentDaoImpl();
		Student std=stdImpl.findByName(userName);
		if(std==null)throw new RecordNotFoundException();
		System.out.println(std.getUserName()+" "+std.getPassword());
	}
	
	private static boolean insertByUserNameAndPassword(String userName,String password)throws Exception {
		StudentDao stdImpl=new StudentDaoImpl();
		return stdImpl.insertByUserNameAndPassword(userName,password);
	}
	
	private static boolean updatePassword(String userName,String password)throws Exception {
		StudentDao stdImpl=new StudentDaoImpl();
		return stdImpl.updatePassword(userName, password);
	}
	
	private static boolean updateSelfInformation(String userName,Student std)throws Exception {
		StudentDao stdImpl=new StudentDaoImpl();
		return stdImpl.updateSelfInformation(userName,std);
	}
	
	private static boolean deleteStudent(String userName)throws Exception {
		StudentDao stdImpl=new StudentDaoImpl();
		return stdImpl.deleteStudent(userName);
	}
	
	public static void main(String[] args) {
		try {
			findByName("213160821");
			if(insertByUserNameAndPassword("213161268","gg")) {
				findByName("213161268");
			}else System.out.println("Error!");
			if(updatePassword("213161268","gga")) {
				findByName("213161268");
			}else System.out.println("Error!");
			Student std=new Student();
			std.setAccount(123.4);
			std.setBankAccount("cc");
			std.setClassNumber("asd");
			std.setDeptName("CSDN");
			std.setDormNumber("3B613");
			std.setEmailAddress("cc@seu.edu.cn");
			std.setIdCard("89461236472189374");
			std.setMajor("CS");
			std.setMoney(41.3);
			std.setPassword("102938094");
			std.setPhoneNumber("1239048901");
			std.setSex("male");
			std.setStudentEcardNumber("213147914");
			std.setStudentID("09016429");
			std.setUserName("cczuiqiang");
			if(updateSelfInformation("213161268",std)) {
				findByName("cczuiqiang");
			}else System.out.println("Error!");
			if(deleteStudent("cczuiqiang")) {
				findByName("cczuiqiang");
			}else System.out.println("Error!");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
