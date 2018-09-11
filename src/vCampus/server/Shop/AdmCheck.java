package vCampus.server.Shop;
/**
 * @author SYH
 * 
 * @date 9.3
 *
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import vCampus.client.biz.AdminService;
import vCampus.client.biz.ShopService;
import vCampus.client.biz.ShopServiceImpl;
import vCampus.client.register.RegisterView;
import vCampus.vo.ProductInformation;
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

public class AdmCheck extends JPanel{


	
	
	DefaultTableModel dtm = null;

	
	public AdmCheck(AdminService admin) {
		
	super();


	
	this.setLayout(null);
	this.setSize(1650,1000);         
    
    Font font=new Font("ƻ�� ����",Font.CENTER_BASELINE,28);//���������ʽ�ʹ�С

    ShopService SPS = new ShopServiceImpl(3,admin.getCacheAdmin().getAdminID());
    ArrayList<ProductInformation> allProducts = SPS.queryAllProduct();
    
	/*
	 * ����JTable������
	 */
	String[] columnNames =
	{ "��Ʒ��","��Ʒ��", "��������","������","����ʱ��","���ѽ��","��Ʒ����"};

	int typenum = allProducts.size();
	int[] num_eachtype= {0,0,0,0,0,0};
	int totalnum = 0;
	ArrayList<ProductPurchase> PurchaseRecords = new ArrayList<ProductPurchase>();
	for(int i=0;i<typenum;i++) {
		if(SPS.queryAccountCurrentByProductID(allProducts.get(i).getProductID())!=null) {
			//num_eachtype[i] = SPS.queryAccountCurrentByProductID(allProducts.get(i).getProductID()).size();
			totalnum += SPS.queryAccountCurrentByProductID(allProducts.get(i).getProductID()).size();
			PurchaseRecords.addAll(SPS.queryAccountCurrentByProductID(allProducts.get(i).getProductID()));
		}
	}
	//int num_borrow=2;
	Object[][] obj = new Object[totalnum][7];
	for (int i = 0; i < totalnum; i++)
	{
		//String ProductID = allProducts.get(i).getProductID();
		for (int j = 0; j < 7; j++)
		{
			if(PurchaseRecords.get(i)==null) break;
			switch (j)
			{
			case 0:
				obj[i][j] = PurchaseRecords.get(i).getProductID();
				break;
			case 1:
				obj[i][j] = PurchaseRecords.get(i).getProductName();
				break;
			case 2:
				obj[i][j] = PurchaseRecords.get(i).getPurchaseAmount();
				break;
			case 3:
				obj[i][j] = PurchaseRecords.get(i).getUserName();
				break;
			case 4:
				obj[i][j] = PurchaseRecords.get(i).getPurchaseTime();
				break;
			case 5:
				obj[i][j] = PurchaseRecords.get(i).getOneConsumption()*PurchaseRecords.get(i).getPurchaseAmount();
				break;
			case 6:
				obj[i][j] = PurchaseRecords.get(i).getOneConsumption();
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
	scroll.setSize(1022, 528);
	table.setSize(600, 800);
	
	add(scroll);

    
    
	}
}
