package vCampus.client.Bank;
/**
 * @author Yanhao Shen
 * 
 * @date 9.3
 *
 */
import javax.swing.*;

import vCampus.client.register.RegisterView;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;

public class StuAcountChange extends JPanel{


	
	public StuAcountChange() {
	super();
	
//	this.setBackground(Color.BLUE);
	
	JLabel lb1 = new JLabel("�����");
	JTextField tf1 = new JTextField(20);
	JLabel lb2 = new JLabel("����");
	JTextField tf2 = new JTextField(20);
	JLabel lb3 = new JLabel("����");
	JTextField tf3 = new JTextField(20);
	JLabel lb4 = new JLabel("ˮ������");
	JTextField tf4 = new JTextField(20);

	this.setLayout(null);
	this.setSize(1650,1000);         
    
    Font font=new Font("ƻ�� ����",Font.CENTER_BASELINE,28);//���������ʽ�ʹ�С


    
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
    

    }
    	


    

}
