package vCampus.client.Bank;
/**
 * @author Yanhao Shen ,CC
 * 
 * @date 9.3
 * 
 * @v1.1 edit by CC in 9/7
 *
 */
import javax.swing.*;

import vCampus.client.biz.StudentService;
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

public class StuCheck extends JPanel{

	static JTextField tf3 = new JTextField();
	
	public StuCheck(StudentService stu) {
	super();
	
//	this.setBackground(Color.BLUE);
	
	JLabel lb1 = new JLabel("一卡通号");
	JTextField tf1 = new JTextField(stu.getCacheStudent().getUserName());
	
	
	JLabel lb3 = new JLabel("余额");
	tf3.setText(String.valueOf(stu.getCacheStudent().getMoney()));


	this.setLayout(null);
	this.setSize(1650,1000);         
    
    Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);//设置字体格式和大小

// 
    
    this.add(lb1);
    lb1.setBounds(456-270, 196-80, 151, 47);
    lb1.setFont(font);
    this.add(tf1);
    tf1.setBackground(Color.WHITE);
    tf1.setBounds(660-270, 196-80, 352, 47);
    tf1.setFont(font);
    tf1.setEditable(false);
    tf1.setBorder(null);

    
    this.add(lb3);
    lb3.setBounds(456-270, 307-80, 101, 47);
    lb3.setFont(font);
    this.add(tf3);
    tf3.setBackground(Color.WHITE);
    tf3.setBounds(660-270, 307-80, 352, 47);
    tf3.setFont(font);
    tf3.setEditable(false);
    tf3.setBorder(null);
  

    }
    	

	public StuCheck(TeacherService tc) {
		super();
		
//		this.setBackground(Color.BLUE);
		
		JLabel lb1 = new JLabel("一卡通号");
		JTextField tf1 = new JTextField(tc.getCacheTeacher().getTeacherEcardNumber());
		
		
		JLabel lb3 = new JLabel("余额");
		tf3.setText(String.valueOf(tc.getCacheTeacher().getMoney()));


		this.setLayout(null);
		this.setSize(1650,1000);         
	    
	    Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);//设置字体格式和大小

	// 
	    
	    this.add(lb1);
	    lb1.setBounds(456-270, 196-80, 151, 47);
	    lb1.setFont(font);
	    this.add(tf1);
	    tf1.setBackground(Color.WHITE);
	    tf1.setBounds(660-270, 196-80, 352, 47);
	    tf1.setFont(font);
	    tf1.setEditable(false);
	    tf1.setBorder(null);

	    
	    this.add(lb3);
	    lb3.setBounds(456-270, 307-80, 101, 47);
	    lb3.setFont(font);
	    this.add(tf3);
	    tf3.setBackground(Color.WHITE);
	    tf3.setBounds(660-270, 307-80, 352, 47);
	    tf3.setFont(font);
	    tf3.setEditable(false);
	    tf3.setBorder(null);
	  

	}
    

}
