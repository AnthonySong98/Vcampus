package vCampus.server.dao;

import java.util.ArrayList;

import vCampus.server.exception.*;
import vCampus.vo.CourseChoose;
import vCampus.vo.CourseInformation;


public interface CourseChooseDao {
	/**
	 * ����courseID����,����CourseInformation����,δ��ѯ�ɹ�������null
	 * @param String
	 * @return courseInformation
	 */
    public CourseInformation findCourse(String courseID);
    
	/**
	 * ��ȡ���пγ���Ϣ,����ArrayList<CourseInformation>,δ��ѯ�ɹ�������null
	 * @param null
	 * @return ArrayList<courseInformation>
	 */
    public ArrayList<CourseInformation> allCourses();
    
    /**
	 * ����studentUserName����,����ArrayList<CourseChoose>,δ��ѯ�ɹ�������null
	 * @param String
	 * @return ArrayList<CourseChoose>
	 */
    public ArrayList<CourseChoose> courseQueryByStudent(String studentUserName);
    
    /**
	 * ����teacherUserName����,����ArrayList<CourseChoose>,δ��ѯ�ɹ�������null
	 * @param String
	 * @return ArrayList<CourseChoose>
	 */
    public ArrayList<CourseChoose> courseQueryByTeacher(String teacherUserName);
    
    /**
	 * ����courseID����,����ArrayList<CourseChoose>,δ��ѯ�ɹ�������null
	 * @param String
	 * @return ArrayList<CourseChoose>
	 */
    public ArrayList<CourseChoose> courseQueryByCourse(String courseID);
    
    /**
	 * ����studentUserName,courseID,��courseID������/�ÿγ�ѧ����ѡ/�����ﵽ�������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws RecordAlreadyExistException
	 * @throws OutOfLimitException
	 */
    public boolean addCourseByStudent(String studentUserName,String courseID)throws RecordNotFoundException,RecordAlreadyExistException,OutOfLimitException;
    
    /**
	 * ����studentUserName,courseID,��ѧ��δѡ�ÿγ�/�γ�����Ϊ0���׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws OutOfLimitException
	 */
    public boolean deleteCourseByStudent(String studentUserName,String courseID)throws RecordNotFoundException,OutOfLimitException;
    
    /**
	 * ����ArrayList<CourseChoose>����ѧ��ѡ���Լ���Ӧ�ķ�����Ϣ,��ѧ��δѡ�ÿγ����׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
    public boolean updateScoreByTeacher(ArrayList<CourseChoose> scoreList)throws RecordNotFoundException;
    
    /**
	 * ����CourseInformation,����������ʦ��Ϣ�����ڻ��߿γ���Ϣ�Ѿ��������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws RecordAlreadyExistException
	 */
    public boolean addCourseByAdmin(CourseInformation course)throws RecordAlreadyExistException,RecordNotFoundException;
    
    /**
	 * ����CourseInformation,����������ʦ��Ϣ�����ڻ��߿γ̲��������׳��쳣(��uMsg������),SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
    public boolean updateCourseByAdmin(CourseInformation course)throws RecordNotFoundException;
    
    /**
	 * ����CourseInformation,���γ���Ϣ���������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
    public boolean deleteCourseByAdmin(String courseID)throws RecordNotFoundException;
}
