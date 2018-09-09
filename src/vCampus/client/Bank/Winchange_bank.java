package vCampus.client.Bank;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import vCampus.client.biz.AdminService;
import vCampus.client.biz.StudentService;
import vCampus.client.biz.TeacherService;
import vCampus.vo.Admin;
import vCampus.vo.Student;
import vCampus.vo.Teacher;


/**
 * @author Yanhao Shen,CC
 *
 * @v1.1 edit by CC in 9/7
 * 
 * @v1.2 edit by CC in 9/8
 *
 */
public class Winchange_bank extends JPanel {
	
	JButton jb1=new JButton("��ѯ�˻�");
	JButton jb2=new JButton("��ֵת��");
	JButton jb3=new JButton("��ѯ���");
	
	public Winchange_bank(int identify,StudentService stu){
		super();
		//int identify=1;
	    CardLayout card=new CardLayout();
		JPanel cardpanel=new JPanel();
		
		StuCheck w1=new StuCheck(stu);
		StuAcountChange w2=new StuAcountChange(stu);
		
		
		Font font=new Font("ƻ�� ����",Font.CENTER_BASELINE,28);
		this.setLayout(null);
		
		
		//identify:1 ѧ�� ��ѯ
		//identify:2 ��ʦ 
		//identify:3 ����Ա ���ÿ۳�/�ǼǷ���
		
		
		//this.add(jb1);
	    jb1.setBounds(0, 0, 270, 80);
	    jb1.setFont(font);
	    jb1.setIcon(new ImageIcon("img\\��ѯ�˻����.png"));
	    jb1.addMouseListener(new WinchangeButtonPerformed());
	       	
	    //this.add(jb2);
	    jb2.setBounds(0, 80, 270, 80);
	    jb2.setFont(font);
	    jb2.setIcon(new ImageIcon("img\\��ֵת��.png"));
	    jb2.addMouseListener(new WinchangeButtonPerformed());
	    	    
	
	    
	    jb1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w1");
	        	w1.tf3.setText(String.valueOf(stu.getCacheStudent().getMoney()));
	        }
	    });
	    
	    jb2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w2");
	        }
	    });
	  
	  
		//Winchange2 w2=new Winchange2();
		cardpanel.setLayout(card);
		cardpanel.setBounds(270, 0, 1920-270, 1000);

		if(identify==1||identify==2)
		{
			cardpanel.add("w1",w1);
			cardpanel.add("w2",w2);
			this.add(jb1);
			this.add(jb2);
		
			
		}
	
		
		this.add(cardpanel);
		
	}
	
	
	public Winchange_bank(int identify,TeacherService tea) {
		super();
		//int identify=1;
	    CardLayout card=new CardLayout();
		JPanel cardpanel=new JPanel();
		
		StuCheck w1=new StuCheck(tea);
		StuAcountChange w2=new StuAcountChange(tea);
		
		
		Font font=new Font("ƻ�� ����",Font.CENTER_BASELINE,28);
		this.setLayout(null);
		
		//identify:1 ѧ�� ��ѯ
		//identify:2 ��ʦ 
		//identify:3 ����Ա ���ÿ۳�/�ǼǷ���
		
		
		//this.add(jb1);
	    jb1.setBounds(0, 0, 270, 80);
	    jb1.setFont(font);
	    jb1.setIcon(new ImageIcon("img\\��ѯ�˻����.png"));
	    jb1.addMouseListener(new WinchangeButtonPerformed());
	       	
	    //this.add(jb2);
	    jb2.setBounds(0, 80, 270, 80);
	    jb2.setFont(font);
	    jb2.setIcon(new ImageIcon("img\\��ֵת��.png"));
	    jb2.addMouseListener(new WinchangeButtonPerformed());
	    	    
	
	    
	    jb1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w1");
	        	w1.tf3.setText(String.valueOf(tea.getCacheTeacher().getMoney()));
	        }
	    });
	    
	    jb2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w2");
	        }
	    });
	  
	  
		//Winchange2 w2=new Winchange2();
		cardpanel.setLayout(card);
		cardpanel.setBounds(270, 0, 1920-270, 1000);

		if(identify==1||identify==2)
		{
			cardpanel.add("w1",w1);
			cardpanel.add("w2",w2);
			this.add(jb1);
			this.add(jb2);
		
			
		}
	
		
		this.add(cardpanel);
		
	}


	public Winchange_bank(int identify,AdminService adm) {
		super();
	    CardLayout card=new CardLayout();
		JPanel cardpanel=new JPanel();
		
		
		AdmAcountCheck w3=new AdmAcountCheck(adm);
		
		
		Font font=new Font("ƻ�� ����",Font.CENTER_BASELINE,28);
		this.setLayout(null);
		
		
		
		
		//identify:1 ѧ�� ��ѯ
		//identify:2 ��ʦ 
		//identify:3 ����Ա ���ÿ۳�/�ǼǷ���
		

	    //this.add(jb3);
	    jb3.setBounds(0, 00, 270, 80);
	    jb3.setFont(font);
	    jb3.setIcon(new ImageIcon("img\\��ѯ�����.png"));
	    jb3.addMouseListener(new WinchangeButtonPerformed());
	    	  
	  
	    jb3.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w3");
	        }
	    });
	  
		//Winchange2 w2=new Winchange2();
		cardpanel.setLayout(card);
		cardpanel.setBounds(270, 0, 1920-270, 1000);

		
		if(identify==3)
		{
		
			cardpanel.add("w3",w3);
			this.add(jb3);
		}
	
		
		this.add(cardpanel);
		
	}

	public void refresh() {
		jb1.setIcon(new ImageIcon("img\\��ѯ�˻�.png"));
		jb2.setIcon(new ImageIcon("img\\��ֵת��.png"));
		jb3.setIcon(new ImageIcon("img\\��ѯ���.png"));
	}
	
	public class WinchangeButtonPerformed implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==jb1) {
				refresh();
				jb1.setIcon(new ImageIcon("img\\��ѯ�˻����.png"));
			}
			if(e.getSource()==jb2) {
				refresh();
				jb2.setIcon(new ImageIcon("img\\��ֵת�˵��.png"));
			}
			if(e.getSource()==jb3) {
				refresh();
				jb3.setIcon(new ImageIcon("img\\��ѯ�����.png"));
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
