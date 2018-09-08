package vCampus.client.Bank;
/**
 * @author Yanhao Shen
 * 
 * @date 9.3
 *
 */
import javax.swing.*;

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
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
public class StuAcountChange extends JPanel{
	
	
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	
	int choice=0;
	
	public StuAcountChange(Student stu) {
	super();
	
//	this.setBackground(Color.BLUE);
	
	
	JLabel lb1 = new JLabel("ת�˽��");
	JTextField tf1 = new JTextField(20);
	JTextField tf2 = new JTextField(20);
	
	JButton bt1=new JButton();
	
	
	this.setLayout(null);
	this.setSize(1650,1000);         
    
    Font font=new Font("ƻ�� ����",Font.CENTER_BASELINE,28);//���������ʽ�ʹ�С
    Font font1=new Font("ƻ�� ����",Font.BOLD,36);//���������ʽ�ʹ�С
    
    this.add(bt1);
    bt1.setBounds(910-270, 910-80, 160, 80);
    bt1.setFont(font);
    // ���ð�ť��Ĭ��ͼƬ
    bt1.setIcon(new ImageIcon("img\\ȷ��.png"));
    bt1.setBorder(null);
    
    
    this.add(lb1);
    lb1.setBounds(456-270, 196-80, 151, 47);
    lb1.setFont(font);
    this.add(tf1);
    tf1.setBackground(Color.WHITE);
    tf1.setBounds(660-270, 196-80, 352, 47);
    tf1.setFont(font);
  //  tf1.setEditable(false);
    tf1.setBorder(null);
    
    this.add(tf2);
 
    tf2.setBounds(660-270, 600-80, 352, 47);
    tf2.setFont(font1);
    tf2.setEditable(false);
    tf2.setBorder(null);
    
    
    JRadioButton radioButton = new JRadioButton("��ֵ");
    radioButton.setFont(font);
    buttonGroup_1.add(radioButton);
    radioButton.setBounds(456-270+120, 307-80, 150, 47);
    add(radioButton);
    radioButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	choice=1;
        }
    });
    
    
    JRadioButton radioButton_1 = new JRadioButton("֧ȡ");
    radioButton_1.setFont(font);
    buttonGroup_1.add(radioButton_1);
    radioButton_1.setBounds(660-270+120, 307-80, 352, 47);
    add(radioButton_1);
    radioButton_1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	choice=2;
        }
    });
    
    bt1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           	if(choice==0)        	
        		tf2.setText("��ѡ���ֵ��֧ȡ������");
        	if(choice==1) {
        		try {
        			double moneychange = Double.parseDouble(tf1.getText());
        			if(moneychange<=0) throw new ArithmeticException();
        			tf2.setText("��ֵ�ɹ���");
        		}catch(NumberFormatException e1) {
        			tf2.setText("���벻�ܺ����ַ�");
        		}
        		catch(ArithmeticException e2) {
        			tf2.setText("�������������");
        		}
        	}
         	if(choice==2) {       	
         		//stu.setMoney(stu.getMoney()-Double.parseDouble(tf1.getText()));
         		
         		try {
        			double moneychange = Double.parseDouble(tf1.getText());
        			if(moneychange<=0) throw new ArithmeticException();
        			tf2.setText("֧ȡ�ɹ���");
        		}catch(NumberFormatException e1) {
        			tf2.setText("���벻�ܺ����ַ�");
        		}
        		catch(ArithmeticException e2) {
        			tf2.setText("�������������");
        		}
         	}
        }
    });
    

    
    
    }

	
	public StuAcountChange(Teacher tc) {
		super();
		
//		this.setBackground(Color.BLUE);
		
		
		JLabel lb1 = new JLabel("ת�˽��");
		JTextField tf1 = new JTextField(20);
		JTextField tf2 = new JTextField(20);
		
		JButton bt1=new JButton();
		
		
		this.setLayout(null);
		this.setSize(1650,1000);         
	    
	    Font font=new Font("ƻ�� ����",Font.CENTER_BASELINE,28);//���������ʽ�ʹ�С
	    Font font1=new Font("ƻ�� ����",Font.BOLD,36);//���������ʽ�ʹ�С
	    
	    this.add(bt1);
	    bt1.setBounds(910-270, 910-80, 160, 80);
	    bt1.setFont(font);
	    // ���ð�ť��Ĭ��ͼƬ
	    bt1.setIcon(new ImageIcon("img\\ȷ��.png"));
	    bt1.setBorder(null);
	    
	    
	    this.add(lb1);
	    lb1.setBounds(456-270, 196-80, 151, 47);
	    lb1.setFont(font);
	    this.add(tf1);
	    tf1.setBackground(Color.WHITE);
	    tf1.setBounds(660-270, 196-80, 352, 47);
	    tf1.setFont(font);
	  //  tf1.setEditable(false);
	    tf1.setBorder(null);
	    
	    this.add(tf2);
	 
	    tf2.setBounds(660-270, 600-80, 352, 47);
	    tf2.setFont(font1);
	    tf2.setEditable(false);
	    tf2.setBorder(null);
	    
	    
	    JRadioButton radioButton = new JRadioButton("��ֵ");
	    radioButton.setFont(font);
	    buttonGroup_1.add(radioButton);
	    radioButton.setBounds(456-270+120, 307-80, 150, 47);
	    add(radioButton);
	    radioButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	choice=1;
	        }
	    });
	    
	    
	    JRadioButton radioButton_1 = new JRadioButton("֧ȡ");
	    radioButton_1.setFont(font);
	    buttonGroup_1.add(radioButton_1);
	    radioButton_1.setBounds(660-270+120, 307-80, 352, 47);
	    add(radioButton_1);
	    radioButton_1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	choice=2;
	        }
	    });
	    
	    bt1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	           	if(choice==0)        	
	        		tf2.setText("��ѡ���ֵ������");
	        	if(choice==1) {       	
	        		tf2.setText("��ֵ�ɹ���");
	        	}
	         	if(choice==2) {       	
	            	tf2.setText("֧ȡ�ɹ���");
	         	}
	        }
	    });
	    	    
	    
	}

}
