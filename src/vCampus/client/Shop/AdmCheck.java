package vCampus.client.Shop;
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

import vCampus.client.register.RegisterView;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;

public class AdmCheck extends JPanel{


	JLabel lb1 = new JLabel("���");
	JTextField tf1 = new JTextField("");
	
	
	DefaultTableModel dtm = null;

	
	public AdmCheck() {
		
	super();


	
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

	/*
	 * ����JTable������
	 */
	String[] columnNames =
	{ "��Ʒ��","��Ʒ��", "��������","������","����ʱ��","���ѽ��","�˻����"};

	int num_borrow=2;
	Object[][] obj = new Object[num_borrow][7];
	for (int i = 0; i < num_borrow; i++)
	{
		for (int j = 0; j < 7; j++)
		{
			switch (j)
			{
			case 0:
				obj[i][j] = "1";
				break;
			case 1:
				obj[i][j] = "���ƽ�";
				break;
			case 2:
				obj[i][j] = "3";
				break;
			case 3:
				obj[i][j] = "1993";
				break;
			case 4:
				obj[i][j] = "2";
				break;
			case 5:
				obj[i][j] = "3";
				break;
			case 6:
				obj[i][j] = "3";
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
