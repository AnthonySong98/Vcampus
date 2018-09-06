package vCampus.client.MainTable;

/**
 * @author SYH
 * 
 * @date 9.3
 *
 */

import javax.swing.*;

import vCampus.client.register.RegisterView;
import vCampus.client.InfoView.*;
import vCampus.client.JWC.*;
import vCampus.client.TSG.*;
import vCampus.client.Shop.*;
import vCampus.client.Dorm.*;
import vCampus.client.Bank.*;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;

public class StuInfoView_main extends JPanel{
	JFrame frame = new JFrame("��ʦ��Ϣ");
	BackgroundPanel bgp;
	
	
	JButton jb3 = new JButton();
	JButton jb4 = new JButton();
	JButton jb5 = new JButton();
	JButton jb6 = new JButton();
	JButton jb7 = new JButton();
	JButton jb8 = new JButton();
	
	public StuInfoView_main() {
	this.setLayout(null);
	this.setSize(1920,1080);         
    this.setLocation(0, 0);

    Font font=new Font("ƻ�� ����",Font.CENTER_BASELINE,28);//���������ʽ�ʹ�С

 //*******************************
 //��Ϊһ������
    
    CardLayout card=new CardLayout();
 	JPanel pn1=new JPanel();
 	
 	Winchange_test w1=new Winchange_test();
 	Winchange_JWC w2=new Winchange_JWC();
 	Winchange_TSG w3=new Winchange_TSG();
 	Winchange_shop w4=new Winchange_shop();
 	Winchange_dorm w5=new Winchange_dorm();
 	Winchange_bank w6=new Winchange_bank();
 	
 	w1.setBackground(null);
	w1.setOpaque(false);
 	
 	w2.setBackground(null);
	w2.setOpaque(false);
 	
 	w3.setBackground(null);
	w3.setOpaque(false);
	
	w4.setBackground(null);
	w4.setOpaque(false);
	
	w5.setBackground(null);
	w5.setOpaque(false);
 	
	w6.setBackground(null);
	w6.setOpaque(false);
 	
	
 	pn1.setLayout(card);
 	pn1.setBounds(0, 80, 1920, 1000);
    pn1.setBackground(null);
    pn1.setOpaque(false);

 	pn1.add("w1",w1);
	pn1.add("w2",w2);
	pn1.add("w3",w3);
	pn1.add("w4",w4);
	pn1.add("w5",w5);
	pn1.add("w6",w6);
	
	frame.add(pn1);
    
    
    frame.add(jb3);
    jb3.setBounds(270, 0, 250, 78);
    jb3.setFont(font);
    // ���ð�ť��Ĭ��ͼƬ
    //jb3.setIcon(new ImageIcon("img\\���˳���.png"));
    jb3.setIcon(new ImageIcon("img\\���˳���.png"));
    jb3.setBorder(null);
    // ���Ӱ�ť����¼�������
    jb3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	refresh();
        	jb3.setIcon(new ImageIcon("img\\���˵��.png"));
        	card.show(pn1,"w1");
        }
    });
    
    frame.add(jb4);
    jb4.setBounds(520, 0, 250, 78);
    jb4.setFont(font);
    // ���ð�ť��Ĭ��ͼƬ
    jb4.setIcon(new ImageIcon("img\\���г���.png"));
    jb4.setBorder(null);
    // ���Ӱ�ť����¼�������
    jb4.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	refresh();
        	jb4.setIcon(new ImageIcon("img\\���е��.png"));
        	card.show(pn1,"w6");
        }
    });
    
    frame.add(jb5);
    jb5.setBounds(770, 0, 250, 78);
    jb5.setFont(font);
    // ���ð�ť��Ĭ��ͼƬ
    jb5.setIcon(new ImageIcon("img\\ͼ�鳣��.png"));
    jb5.setBorder(null);
    // ���Ӱ�ť����¼�������
    jb5.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	refresh();
        	jb5.setIcon(new ImageIcon("img\\ͼ����.png"));
        	card.show(pn1,"w3");
        }
    });
    
    frame.add(jb6);
    jb6.setBounds(1020, 0, 250, 78);
    jb6.setFont(font);
    // ���ð�ť��Ĭ��ͼƬ
    jb6.setIcon(new ImageIcon("img\\�̵곣��.png"));
    jb6.setBorder(null);
    // ���Ӱ�ť����¼�������
    jb6.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	refresh();
        	jb6.setIcon(new ImageIcon("img\\�̵���.png"));
        	card.show(pn1,"w1");
        }
        
    });
    
    frame.add(jb7);
    jb7.setBounds(1270, 0, 250, 78);
    jb7.setFont(font);
    // ���ð�ť��Ĭ��ͼƬ
    jb7.setIcon(new ImageIcon("img\\���񳣹�.png"));
    jb7.setBorder(null);
 
    // ���Ӱ�ť����¼�������
    jb7.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	refresh();
        	jb7.setIcon(new ImageIcon("img\\������.png"));
        	card.show(pn1,"w2");
        	
        }
    });
    
    frame.add(jb8);
    jb8.setBounds(1520, 0, 250, 78);
    jb8.setFont(font);
    // ���ð�ť��Ĭ��ͼƬ
    jb8.setIcon(new ImageIcon("img\\����.png"));
    jb8.setBorder(null);
    // ���Ӱ�ť����¼�������
    jb8.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	refresh();
        	jb8.setIcon(new ImageIcon("img\\������.png"));
        	card.show(pn1,"w5");
        }
    });
    
	bgp=new BackgroundPanel((new ImageIcon("img\\bg2.png")).getImage());
	bgp.setBounds(0,0,1920,1080);
	frame.add(bgp);
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	frame.setSize(1920,1080);
	frame.setVisible(true);  
	frame.setResizable(true);
	}
	
	public void refresh() {
		jb3.setIcon(new ImageIcon("img\\���˳���.png"));
		jb4.setIcon(new ImageIcon("img\\���г���.png"));
		jb5.setIcon(new ImageIcon("img\\ͼ�鳣��.png"));
		jb6.setIcon(new ImageIcon("img\\�̵곣��.png"));
		jb7.setIcon(new ImageIcon("img\\���񳣹�.png"));
		jb8.setIcon(new ImageIcon("img\\����.png"));
	}
	

	public static void main(String[] args) {  
		StuInfoView_main SIV=new StuInfoView_main();  
    }
}
class BackgroundPanel extends JPanel{
	Image im;
	public BackgroundPanel(Image im)
	{
		this.im=im;
		this.setOpaque(true);
	}
	//Draw the back ground.
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
	}
}