package vCampus.server.Shop;
/**
 * @author Yanhao Shen
 * 
 * @date 9.3
 *
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import vCampus.client.biz.ShopService;
import vCampus.client.biz.ShopServiceImpl;
import vCampus.client.biz.StudentService;
import vCampus.client.biz.TeacherService;
import vCampus.client.register.RegisterView;
import vCampus.vo.ProductPurchase;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StuAccountCheck extends JPanel{


	JLabel lb1 = new JLabel("���");
	JTextField tf1 = new JTextField();
	
	
	DefaultTableModel dtm = null;

	
	public StuAccountCheck(StudentService ss) {
	super();
	
//	this.setBackground(Color.BLUE);
	
	
	this.setLayout(null);
	this.setSize(1650,1000);         
    
    Font font=new Font("ƻ�� ����",Font.CENTER_BASELINE,28);//���������ʽ�ʹ�С

    

    
    this.add(lb1);
    lb1.setBounds(456-270, 196-80, 151, 47);
    lb1.setFont(font);
    this.add(tf1);
    tf1.setBackground(Color.WHITE);
    tf1.setBounds(660-270, 196-80, 352, 47);
    tf1.setFont(font);
    tf1.setEditable(false);
    tf1.setBorder(null);
    tf1.setText(String.valueOf(ss.getCacheStudent().getMoney()));

    
    

	/*
	 * ����JTable������
	 */
	String[] columnNames =
	{ "��Ʒ��","��Ʒ��", "��������", "����ʱ��","���ѽ��","�˻����"};

	int initial_num_borrow=2;
	Object[][] obj = new Object[initial_num_borrow][7];
	for (int i = 0; i < initial_num_borrow; i++)
	{
		for (int j = 0; j < 6; j++)
		{
			switch (j)
			{
			case 0:
				obj[i][j] = "";
				break;
			case 1:
				obj[i][j] = "";
				break;
			case 2:
				obj[i][j] = "";
				break;
			case 3:
				obj[i][j] = "";
				break;
			case 4:
				obj[i][j] = "";
				break;
			case 5:
				obj[i][j] = "";
				break;
		
				
			}
		}
	
		
	}
	
	String username = ss.getCacheStudent().getUserName();
	ShopService SPS = new ShopServiceImpl(1,username);
	ArrayList<ProductPurchase> PurchaseRecord = SPS.queryAccountCurrentByUserName(username);

		int num_borrow = 0;
		if(PurchaseRecord!=null) num_borrow=PurchaseRecord.size();
		obj = new Object[num_borrow][7];
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
	
	
	/*
	 * JTable������һ�ֹ��췽��
	 */
    dtm=new DefaultTableModel(obj,columnNames){
		public boolean isCellEditable(int row, int column)
	    {
	               return false;}//��������༭
	    };
 

	JTable table = new JTable(dtm); 
	;
    table.setRowHeight(30);// ���ñ���п�
    
    JTableHeader head = table.getTableHeader(); // �������������
    head.setPreferredSize(new Dimension(head.getWidth(), 35));// ���ñ�ͷ��С
    head.setFont(font);// ���ñ������
   
	TableColumn column = null;
	int colunms = table.getColumnCount();
	for(int i = 0; i < colunms; i++)
	{
		column = table.getColumnModel().getColumn(i);
		column.setPreferredWidth(300);
	}
	

	table.setBounds(400, 365, 600, 800);
	table.setFont(font);
	
	/*��JScrollPaneװ��JTable������������Χ���оͿ���ͨ�����������鿴*/
	JScrollPane scroll = new JScrollPane(table);
	scroll.setLocation(186, 223);
	scroll.setSize(908, 528);
	table.setSize(600, 800);
	
	add(scroll);

    
    
    
    
    }


	public StuAccountCheck(TeacherService tc) {
		// TODO Auto-generated constructor stub
		super();
		
//		this.setBackground(Color.BLUE);
		
		
		this.setLayout(null);
		this.setSize(1650,1000);         
	    
	    Font font=new Font("ƻ�� ����",Font.CENTER_BASELINE,28);//���������ʽ�ʹ�С

	    

	    
	    this.add(lb1);
	    lb1.setBounds(456-270, 196-80, 151, 47);
	    lb1.setFont(font);
	    this.add(tf1);
	    tf1.setBackground(Color.WHITE);
	    tf1.setBounds(660-270, 196-80, 352, 47);
	    tf1.setFont(font);
	    tf1.setEditable(false);
	    tf1.setBorder(null);
	    tf1.setText(String.valueOf(tc.getCacheTeacher().getMoney()));

	    
	    

		/*
		 * ����JTable������
		 */
		String[] columnNames =
		{ "��Ʒ��","��Ʒ��", "��������", "����ʱ��","���ѽ��","�˻����"};

		int initial_num_borrow=2;
		Object[][] obj = new Object[initial_num_borrow][7];
		for (int i = 0; i < initial_num_borrow; i++)
		{
			for (int j = 0; j < 6; j++)
			{
				switch (j)
				{
				case 0:
					obj[i][j] = "";
					break;
				case 1:
					obj[i][j] = "";
					break;
				case 2:
					obj[i][j] = "";
					break;
				case 3:
					obj[i][j] = "";
					break;
				case 4:
					obj[i][j] = "";
					break;
				case 5:
					obj[i][j] = "";
					break;
			
					
				}
			}
		
			
		}
		
		String username = tc.getCacheTeacher().getUserName();
		ShopService SPS = new ShopServiceImpl(1,username);
		ArrayList<ProductPurchase> PurchaseRecord = SPS.queryAccountCurrentByUserName(username);

			int num_borrow = 0;
			if(PurchaseRecord!=null) num_borrow=PurchaseRecord.size();
			obj = new Object[num_borrow][7];
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
		
		
		/*
		 * JTable������һ�ֹ��췽��
		 */
	    dtm=new DefaultTableModel(obj,columnNames){
			public boolean isCellEditable(int row, int column)
		    {
		               return false;}//��������༭
		    };
	 

		JTable table = new JTable(dtm); 
		;
	    table.setRowHeight(30);// ���ñ���п�
	    
	    JTableHeader head = table.getTableHeader(); // �������������
	    head.setPreferredSize(new Dimension(head.getWidth(), 35));// ���ñ�ͷ��С
	    head.setFont(font);// ���ñ������
	   
		TableColumn column = null;
		int colunms = table.getColumnCount();
		for(int i = 0; i < colunms; i++)
		{
			column = table.getColumnModel().getColumn(i);
			column.setPreferredWidth(300);
		}
		

		table.setBounds(400, 365, 600, 800);
		table.setFont(font);
		
		/*��JScrollPaneװ��JTable������������Χ���оͿ���ͨ�����������鿴*/
		JScrollPane scroll = new JScrollPane(table);
		scroll.setLocation(186, 223);
		scroll.setSize(908, 528);
		table.setSize(600, 800);
		
		add(scroll);
	}
    	
}
