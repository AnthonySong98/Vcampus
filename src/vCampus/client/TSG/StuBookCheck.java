package vCampus.client.TSG;
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

public class StuBookCheck extends JPanel{


	
	public StuBookCheck() {
		
	super();
	JLabel lb0 = new JLabel("��ѯ");
	JTextField tf0 = new JTextField(20);
	
	
	JButton bt0=new JButton("");
	JButton bt1=new JButton("");
	
	this.setLayout(null);
	this.setSize(1650,1000);         
    
    Font font=new Font("ƻ�� ����",Font.CENTER_BASELINE,28);//���������ʽ�ʹ�С
   
    
    this.add(bt0);
    bt0.setBounds(880,196-90,60,60);
    bt0.setFont(font);
    // ���ð�ť��Ĭ��ͼƬ
    bt0.setIcon(new ImageIcon("img\\��ѯUI.png"));
    bt0.setBorder(null);
    
    this.add(bt1);
    bt1.setBounds(910-270, 910-80, 160, 80);
    bt1.setFont(font);
    // ���ð�ť��Ĭ��ͼƬ
    bt1.setIcon(new ImageIcon("img\\ȷ��.png"));
    bt1.setBorder(null);

    
    
    this.add(lb0);
    lb0.setBounds(456-270, 196-80, 101, 47);
    lb0.setFont(font);
    this.add(tf0);
    tf0.setBackground(Color.WHITE);
    tf0.setBounds(660-270, 196-80, 352, 47);
    tf0.setFont(font);
    tf0.setEditable(false);
    tf0.setBorder(null);
  
    }
    	


    

}
