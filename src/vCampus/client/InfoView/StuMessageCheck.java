package vCampus.client.InfoView;
/**
 * @author Yanhao Shen
 * @author2 CC
 * 
 * @date 9.3
 * @v1.1 data 9/7
 *
 */
import javax.swing.*;

import vCampus.client.biz.TeacherService;
import vCampus.client.register.RegisterView;
import vCampus.vo.Student;
import vCampus.vo.Teacher;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;

public class StuMessageCheck extends JPanel{

	static JTextField tf9 = new JTextField();
	static JTextField tf10 = new JTextField();
	
	public StuMessageCheck(Student stu) {
	super();
	
//	this.setBackground(Color.BLUE);
	
	JLabel lb1 = new JLabel("学号");
	JTextField tf1 = new JTextField(stu.getStudentID());
	JLabel lb2 = new JLabel("姓名");
	JTextField tf2 = new JTextField(stu.getRealName());
	JLabel lb3 = new JLabel("性别");
	JTextField tf3 = new JTextField(stu.getSex());
	JLabel lb4 = new JLabel("身份证号");
	JTextField tf4 = new JTextField(stu.getIdCard());
	JLabel lb5 = new JLabel("院系");
	JTextField tf5 = new JTextField(stu.getDeptName());
	JLabel lb6 = new JLabel("专业");
	JTextField tf6 = new JTextField(stu.getMajor());
	JLabel lb7 = new JLabel("班级");
	JTextField tf7 = new JTextField(stu.getClassNumber());
	JLabel lb8 = new JLabel("宿舍号");
	JTextField tf8 = new JTextField(stu.getDormNumber());
	JLabel lb9 = new JLabel("手机");
	tf9.setText(stu.getPhoneNumber());
	JLabel lb10 = new JLabel("邮箱");
	tf10.setText(stu.getEmailAddress());
	
	this.setLayout(null);
	this.setSize(1650,1000);         
    
    Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);//设置字体格式和大小


    
    this.add(lb1);
    lb1.setBounds(456-270, 196-80, 101, 47);
    lb1.setFont(font);
    this.add(tf1);
    tf1.setBackground(Color.WHITE);
    tf1.setBounds(660-270, 196-80, 402, 47);
    tf1.setFont(font);
    tf1.setEditable(false);
    tf1.setBorder(null);

    this.add(lb2);
    lb2.setBounds(1156-270, 196-80, 101, 47);
    lb2.setFont(font);
    this.add(tf2);
    tf2.setBackground(Color.WHITE);
  //  tf2.setText("11022");
    tf2.setBounds(1360-270, 196-80, 402, 47);
    tf2.setFont(font);
    tf2.setEditable(false);
    tf2.setBorder(null);
    
    this.add(lb3);
    lb3.setBounds(456-270, 307-80, 101, 47);
    lb3.setFont(font);
    this.add(tf3);
    tf3.setBackground(Color.WHITE);
    tf3.setBounds(660-270, 307-80, 402, 47);
    tf3.setFont(font);
    tf3.setEditable(false);
    tf3.setBorder(null);
    
    this.add(lb4);
    lb4.setBounds(1156-270, 307-80, 150, 47);
    lb4.setFont(font);
    this.add(tf4);
    tf4.setBackground(Color.WHITE);
    tf4.setBounds(1360-270, 307-80, 402, 47);
    tf4.setFont(font);
    tf4.setEditable(false);
    tf4.setBorder(null);
    
    this.add(lb5);
    lb5.setBounds(456-270, 418-80, 101, 47);
    lb5.setFont(font);
    this.add(tf5);
    tf5.setBackground(Color.WHITE);
    tf5.setBounds(660-270, 418-80, 402, 47);
    tf5.setFont(font);
    tf5.setEditable(false);
    tf5.setBorder(null);
    
    this.add(lb6);
    tf6.setBackground(Color.WHITE);
    lb6.setBounds(1156-270, 418-80, 101, 47);
    lb6.setFont(font);
    this.add(tf6);
    tf6.setBounds(1360-270, 418-80, 402, 47);
    tf6.setFont(font);
    tf6.setEditable(false);
    tf6.setBorder(null);
    
    this.add(lb7);
    tf7.setBackground(Color.WHITE);
    lb7.setBounds(456-270, 529-80, 101, 47);
    lb7.setFont(font);
    this.add(tf7);
    tf7.setBounds(660-270, 529-80, 402, 47);
    tf7.setFont(font);
    tf7.setEditable(false);
    tf7.setBorder(null);
    
    this.add(lb8);
    lb8.setBounds(1156-270, 529-80, 101, 47);
    lb8.setFont(font);
    this.add(tf8);
    tf8.setBackground(Color.WHITE);
    tf8.setBounds(1360-270, 529-80, 402, 47);
    tf8.setFont(font);
    tf8.setEditable(false);
    tf8.setBorder(null);
    
    this.add(lb9);
    lb9.setBounds(456-270, 640-80, 101, 47);
    lb9.setFont(font);
    this.add(tf9);
    tf9.setBackground(Color.WHITE);
    tf9.setBounds(660-270, 640-80, 402, 47);
    tf9.setFont(font);
    tf9.setEditable(false);
    tf9.setBorder(null);
    
    this.add(lb10);
    lb10.setBounds(1156-270, 640-80, 101, 47);
    lb10.setFont(font);
    this.add(tf10);
    tf10.setBackground(Color.WHITE);
    tf10.setBounds(1360-270, 640-80, 402, 47);
    tf10.setFont(font);
    tf10.setEditable(false);
    tf10.setBorder(null);
    }

	public StuMessageCheck(TeacherService tc) {
		super();
		
//		this.setBackground(Color.BLUE);
		
		JLabel lb1 = new JLabel("一卡通");
		JTextField tf1 = new JTextField(tc.getCacheTeacher().getTeacherEcardNumber());
		JLabel lb2 = new JLabel("姓名");
		JTextField tf2 = new JTextField(tc.getCacheTeacher().getRealName());
		JLabel lb3 = new JLabel("性别");
		JTextField tf3 = new JTextField(tc.getCacheTeacher().getSex());
		JLabel lb4 = new JLabel("身份证号");
		JTextField tf4 = new JTextField(tc.getCacheTeacher().getIdCard());
		JLabel lb5 = new JLabel("院系");
		JTextField tf5 = new JTextField(tc.getCacheTeacher().getDeptName());
		JLabel lb6 = new JLabel("职称");
		JTextField tf6 = new JTextField(tc.getCacheTeacher().getProfessionalTitle());
		JLabel lb7 = new JLabel("班级");
		JTextField tf7 = new JTextField(20);
		JLabel lb8 = new JLabel("宿舍号");
		JTextField tf8 = new JTextField("您没有入住校园宿舍");
		JLabel lb9 = new JLabel("手机");
		tf9.setText(tc.getCacheTeacher().getPhoneNumber());
		JLabel lb10 = new JLabel("邮箱");
		tf10.setText(tc.getCacheTeacher().getEmailAddress());
		
		this.setLayout(null);
		this.setSize(1650,1000);         
	    
	    Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);//设置字体格式和大小


	    
	    this.add(lb1);
	    lb1.setBounds(456-270, 196-80, 101, 47);
	    lb1.setFont(font);
	    this.add(tf1);
	    tf1.setBackground(Color.WHITE);
	    tf1.setBounds(660-270, 196-80, 352, 47);
	    tf1.setFont(font);
	    tf1.setEditable(false);
	    tf1.setBorder(null);

	    this.add(lb2);
	    lb2.setBounds(1156-270, 196-80, 101, 47);
	    lb2.setFont(font);
	    this.add(tf2);
	    tf2.setBackground(Color.WHITE);
	  //  tf2.setText("11022");
	    tf2.setBounds(1360-270, 196-80, 352, 47);
	    tf2.setFont(font);
	    tf2.setEditable(false);
	    tf2.setBorder(null);
	    
	    this.add(lb3);
	    lb3.setBounds(456-270, 307-80, 101, 47);
	    lb3.setFont(font);
	    this.add(tf3);
	    tf3.setBackground(Color.WHITE);
	    tf3.setBounds(660-270, 307-80, 352, 47);
	    tf3.setFont(font);
	    tf3.setEditable(false);
	    tf3.setBorder(null);
	    
	    this.add(lb4);
	    lb4.setBounds(1156-270, 307-80, 150, 47);
	    lb4.setFont(font);
	    this.add(tf4);
	    tf4.setBackground(Color.WHITE);
	    tf4.setBounds(1360-270, 307-80, 352, 47);
	    tf4.setFont(font);
	    tf4.setEditable(false);
	    tf4.setBorder(null);
	    
	    this.add(lb5);
	    lb5.setBounds(456-270, 418-80, 101, 47);
	    lb5.setFont(font);
	    this.add(tf5);
	    tf5.setBackground(Color.WHITE);
	    tf5.setBounds(660-270, 418-80, 352, 47);
	    tf5.setFont(font);
	    tf5.setEditable(false);
	    tf5.setBorder(null);
	    
	    this.add(lb6);
	    tf6.setBackground(Color.WHITE);
	    lb6.setBounds(1156-270, 418-80, 101, 47);
	    lb6.setFont(font);
	    this.add(tf6);
	    tf6.setBounds(1360-270, 418-80, 352, 47);
	    tf6.setFont(font);
	    tf6.setEditable(false);
	    tf6.setBorder(null);
	    
	    this.add(lb7);
	    tf7.setBackground(Color.WHITE);
	    lb7.setBounds(456-270, 529-80, 101, 47);
	    lb7.setFont(font);
	    this.add(tf7);
	    tf7.setBounds(660-270, 529-80, 352, 47);
	    tf7.setFont(font);
	    tf7.setEditable(false);
	    tf7.setBorder(null);
	    
	    this.add(lb8);
	    lb8.setBounds(1156-270, 529-80, 101, 47);
	    lb8.setFont(font);
	    this.add(tf8);
	    tf8.setBackground(Color.WHITE);
	    tf8.setBounds(1360-270, 529-80, 352, 47);
	    tf8.setFont(font);
	    tf8.setEditable(false);
	    tf8.setBorder(null);
	    
	    this.add(lb9);
	    lb9.setBounds(456-270, 640-80, 101, 47);
	    lb9.setFont(font);
	    this.add(tf9);
	    tf9.setBackground(Color.WHITE);
	    tf9.setBounds(660-270, 640-80, 352, 47);
	    tf9.setFont(font);
	    tf9.setEditable(false);
	    tf9.setBorder(null);
	    
	    this.add(lb10);
	    lb10.setBounds(1156-270, 640-80, 101, 47);
	    lb10.setFont(font);
	    this.add(tf10);
	    tf10.setBackground(Color.WHITE);
	    tf10.setBounds(1360-270, 640-80, 452, 47);
	    tf10.setFont(font);
	    tf10.setEditable(false);
	    tf10.setBorder(null);
	}
    	


    

}
