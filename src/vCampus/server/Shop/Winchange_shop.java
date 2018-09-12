package vCampus.server.Shop;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import vCampus.client.biz.AdminService;
import vCampus.client.biz.LibraryService;
import vCampus.client.biz.LibraryServiceImpl;
import vCampus.client.biz.ShopService;
import vCampus.client.biz.ShopServiceImpl;
import vCampus.client.biz.StudentService;
import vCampus.client.biz.TeacherService;
import vCampus.vo.BookBorrow;
import vCampus.vo.BookInformation;
import vCampus.vo.ProductPurchase;


/**
 * @author Yanhao Shen
 *
 */
public class Winchange_shop extends JPanel {
	
	JButton jb1=new JButton();
	JButton jb2=new JButton();
	JButton jb3=new JButton();
	JButton jb4=new JButton();
	JButton jb5=new JButton();
	
	public Winchange_shop(int identify,StudentService ss){
		super();
//		int identify=2;
	    CardLayout card=new CardLayout();
		JPanel cardpanel=new JPanel();
		StuAccountCheck w1=new StuAccountCheck(ss);
		Stubuy w2=new Stubuy(ss);
		
		 
		
		Font font=new Font("ƻ�� ����",Font.CENTER_BASELINE,28);
		this.setLayout(null);
		
		
		
		//identify:1 ѧ�� �鿴�˻�/����
		//identify:2 ��ʦ 
		//identify:3 ��ѯ����/�����Ʒ/ɾ���޸�
		
		
		//this.add(jb1);
	    jb1.setBounds(0, 0, 270, 80);
	    jb1.setFont(font);
	    jb1.setIcon(new ImageIcon("img\\�˻������.png"));
	       	
	    //this.add(jb2);
	    jb2.setBounds(0, 80, 270, 80);
	    jb2.setFont(font);
	    jb2.setIcon(new ImageIcon("img\\������Ʒ.png"));
	
	    
	    jb1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w1");
	        	 jb1.setIcon(new ImageIcon("img\\�˻������.png"));
	        	 jb2.setIcon(new ImageIcon("img\\������Ʒ.png"));
	        	 w1.tf1.setText(String.valueOf(ss.getUpdatedStudent().getMoney()));
	        	
	        	 
	        		String[] columnNames =
	        			{ "��Ʒ��","��Ʒ��", "��������", "����ʱ��","���ѽ��","�˻����"};
	        			/*
	        			 * ��ʼ��JTable��������ֵ
	        			 */
	        			String username= ss.getCacheStudent().getUserName();
	        			ShopService SPS = new ShopServiceImpl(1,username);
	        			ArrayList<ProductPurchase> PurchaseRecord = SPS.queryAccountCurrentByUserName(username);


	        			int num_borrow = 0;
	        			if(PurchaseRecord!=null) num_borrow=PurchaseRecord.size();
	        			Object[][] obj = new Object[num_borrow][7];
	        			for (int i = 0; i < num_borrow; i++)
	        			{
	        				for (int j = 0; j < 6; j++)
	        				{
	        					switch (j)
	        					{
	        					case 0:
	        						obj[i][j] = PurchaseRecord.get(i).getProductID();
	        						break;
	        					case 1:
	        						obj[i][j] = PurchaseRecord.get(i).getProductName();
	        						break;
	        					case 2:
	        						obj[i][j] = PurchaseRecord.get(i).getPurchaseAmount();
	        						break;
	        					case 3:
	        						obj[i][j] = PurchaseRecord.get(i).getPurchaseTime();
	        						break;
	        					case 4:
	        						obj[i][j] = PurchaseRecord.get(i).getOneConsumption();
	        						break;
	        					case 5:
	        						obj[i][j] = PurchaseRecord.get(i).getCurrentAccount();
	        						break;
	        				
	        						
	        					}
	        				}
	        			
	        				
	        			}
	        			
	        			w1.dtm.setDataVector(obj,columnNames);//����������

	        			w1.dtm.fireTableStructureChanged();//������ʾ

	        	
	        	 
	        }
	    });
	    
	    jb2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w2");

	        	 jb1.setIcon(new ImageIcon("img\\�˻����.png"));
	        	 jb2.setIcon(new ImageIcon("img\\������Ʒ���.png"));
	        	
	        	 
	        	 
	        	 
	        	 
	        	 
	        	 
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
	
	
	public Winchange_shop(int identify,TeacherService tc) {
		super();
//		int identify=2;
	    CardLayout card=new CardLayout();
		JPanel cardpanel=new JPanel();
		StuAccountCheck w1=new StuAccountCheck(tc);
		Stubuy w2=new Stubuy(tc);
		
		
		
		Font font=new Font("ƻ�� ����",Font.CENTER_BASELINE,28);
		this.setLayout(null);
		
		
		
		//identify:1 ѧ�� �鿴�˻�/����
		//identify:2 ��ʦ 
		//identify:3 ��ѯ����/�����Ʒ/ɾ���޸�
		
		
		//this.add(jb1);
	    jb1.setBounds(0, 0, 270, 80);
	    jb1.setFont(font);
	    jb1.setIcon(new ImageIcon("img\\�˻������.png"));
	       	
	    //this.add(jb2);
	    jb2.setBounds(0, 80, 270, 80);
	    jb2.setFont(font);
	    jb2.setIcon(new ImageIcon("img\\������Ʒ.png"));
	
	    
	    jb1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w1");
	        	 jb1.setIcon(new ImageIcon("img\\�˻������.png"));
	        	 jb2.setIcon(new ImageIcon("img\\������Ʒ.png"));
	      	   
	        	 
	        	String[] columnNames =
	        			{ "��Ʒ��","��Ʒ��", "��������", "����ʱ��","���ѽ��","�˻����"};
	        			/*
	        			 * ��ʼ��JTable��������ֵ
	        			 */
	        			String username= tc.getCacheTeacher().getUserName();
	        			ShopService SPS = new ShopServiceImpl(2,username);
	        			ArrayList<ProductPurchase> PurchaseRecord = SPS.queryAccountCurrentByUserName(username);


	        			int num_borrow = 0;
	        			if(PurchaseRecord!=null) num_borrow=PurchaseRecord.size();
	        			Object[][] obj = new Object[num_borrow][7];
	        			for (int i = 0; i < num_borrow; i++)
	        			{
	        				for (int j = 0; j < 6; j++)
	        				{
	        					switch (j)
	        					{
	        					case 0:
	        						obj[i][j] = PurchaseRecord.get(i).getProductID();
	        						break;
	        					case 1:
	        						obj[i][j] = PurchaseRecord.get(i).getProductName();
	        						break;
	        					case 2:
	        						obj[i][j] = PurchaseRecord.get(i).getPurchaseAmount();
	        						break;
	        					case 3:
	        						obj[i][j] = PurchaseRecord.get(i).getPurchaseTime();
	        						break;
	        					case 4:
	        						obj[i][j] = PurchaseRecord.get(i).getOneConsumption();
	        						break;
	        					case 5:
	        						obj[i][j] = PurchaseRecord.get(i).getCurrentAccount();
	        						break;
	        				
	        						
	        					}
	        				}
	        			
	        				
	        			}
	        			
	        			w1.dtm.setDataVector(obj,columnNames);//����������

	        			w1.dtm.fireTableStructureChanged();//������ʾ

	        	
	        }
	    });
	    
	    jb2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w2");

	        	 jb1.setIcon(new ImageIcon("img\\�˻����.png"));
	        	 jb2.setIcon(new ImageIcon("img\\������Ʒ���.png"));
	        	
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
	
	
	public Winchange_shop(int identify,AdminService admin) {
		super();
//		int identify=2;
	    CardLayout card=new CardLayout();
		JPanel cardpanel=new JPanel();
		
		
		AdmCheck w3=new AdmCheck(admin);
		AdmAdd w4=new AdmAdd(admin);
		AdmDelete w5=new AdmDelete(admin);
		
		
		Font font=new Font("ƻ�� ����",Font.CENTER_BASELINE,28);
		this.setLayout(null);
		
		
		
		//identify:1 ѧ�� �鿴�˻�/����
		//identify:2 ��ʦ 
		//identify:3 ��ѯ����/�����Ʒ/ɾ���޸�
		

	    //this.add(jb3);
	    jb3.setBounds(0, 00, 270, 80);
	    jb3.setFont(font);
	    jb3.setIcon(new ImageIcon("img\\���۲�ѯ���.png"));


	    jb4.setBounds(0, 80, 270, 80);
	    jb4.setFont(font);
	    jb4.setIcon(new ImageIcon("img\\�����Ʒ.png"));
	    
	   
	    jb5.setBounds(0, 160, 270, 80);
	    jb5.setFont(font);
	    jb5.setIcon(new ImageIcon("img\\��ѯ�޸�.png"));
	
	    
	  
	    jb3.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w3");
	        	jb3.setIcon(new ImageIcon("img\\���۲�ѯ���.png"));
	        	jb4.setIcon(new ImageIcon("img\\�����Ʒ.png"));
	        	jb5.setIcon(new ImageIcon("img\\��ѯ�޸�.png"));
	        	
	        }
	    });
	    
	    jb4.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w4");
	          	jb3.setIcon(new ImageIcon("img\\���۲�ѯ.png"));
	        	jb4.setIcon(new ImageIcon("img\\�����Ʒ���.png"));
	        	jb5.setIcon(new ImageIcon("img\\��ѯ�޸�.png"));
	        }
	    });
	    
	    
	    jb5.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w5");
	          	jb3.setIcon(new ImageIcon("img\\���۲�ѯ.png"));
	        	jb4.setIcon(new ImageIcon("img\\�����Ʒ.png"));
	        	jb5.setIcon(new ImageIcon("img\\��ѯ�޸ĵ��.png"));
	        }
	    });
	  
		//Winchange2 w2=new Winchange2();
		cardpanel.setLayout(card);
		cardpanel.setBounds(270, 0, 1920-270, 1000);

		
		if(identify==3)
		{
			cardpanel.add("w3",w3);
			cardpanel.add("w4",w4);
			cardpanel.add("w5",w5);
			this.add(jb3);
			this.add(jb4);
			this.add(jb5);
		}
	
		
		
		this.add(cardpanel);
	}
	
}
