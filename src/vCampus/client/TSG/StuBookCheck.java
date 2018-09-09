package vCampus.client.TSG;
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
import javax.swing.table.TableModel;

import vCampus.client.register.RegisterView;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;
import javax.swing.*; 

public class StuBookCheck extends JPanel{

	
	
	DefaultTableModel dtm = null;
	JTextArea jtf=new JTextArea(20,1);
	
	/**
	 * 
	 */
	public StuBookCheck() {
		
	super();
	 
	JLabel lb1=new JLabel("�ѽ��ģ�");
	
	JButton bt1=new JButton("");
	
	this.setLayout(null);
	this.setSize(1650,1000);         
    
    Font font=new Font("ƻ�� ����",Font.CENTER_BASELINE,28);//���������ʽ�ʹ�С
   
    this.add(bt1);
    bt1.setBounds(910-270, 910-80, 120, 60);
    bt1.setFont(font);
    // ���ð�ť��Ĭ��ͼƬ
   
    bt1.setContentAreaFilled(false);
    bt1.setIcon(new ImageIcon("img\\�黹.png"));
    bt1.setBorder(null);
    
    
  
    
    this.add(lb1); 
    lb1.setBounds(456-270, 196-80, 151, 47);
    lb1.setFont(font);

	/*
	 * ����JTable������
	 */
	String[] columnNames =
	{ "���","����", "����", "������" };

	/*
	 * ��ʼ��JTable��������ֵ����������һģһ����ʵ��"�Կ���"ѧ����
	 */
	
	int num_borrow=2;
	Object[][] obj = new Object[num_borrow][4];
	for (int i = 0; i < num_borrow; i++)
	{
		for (int j = 0; j < 4; j++)
		{
			switch (j)
			{
			case 0:
				obj[i][j] = "�ߵ���ѧ";
				break;
			case 1:
				obj[i][j] = "���ƽ�";
				break;
			case 2:
				obj[i][j] = "SEU";
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
   //��ģ�ͽ�����;
	    

	JTable table = new JTable(dtm); 
	;
	/*
	 * ����JTable����Ĭ�ϵĿ�Ⱥ͸߶�
	 */
    table.setRowHeight(30);// ���ñ���п�
    
    JTableHeader head = table.getTableHeader(); // �������������
    head.setPreferredSize(new Dimension(head.getWidth(), 35));// ���ñ�ͷ��С
    head.setFont(font);// ���ñ������
   
	TableColumn column = null;
	int colunms = table.getColumnCount();
	for(int i = 0; i < colunms; i++)
	{
		column = table.getColumnModel().getColumn(i);
		/*��ÿһ�е�Ĭ�Ͽ������Ϊ100*/
		column.setPreferredWidth(300);
	}
	
	
	/*
	 * ����JTable�Զ������б��״̬���˴�����Ϊ�ر�
	 */
//	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	table.setBounds(400, 365, 600, 800);
	table.setFont(font);
	
	/*��JScrollPaneװ��JTable������������Χ���оͿ���ͨ�����������鿴*/
	JScrollPane scroll = new JScrollPane(table);
	scroll.setLocation(186, 223);
	scroll.setSize(908, 528);
	table.setSize(600, 800);
	
	add(scroll);
	
	  bt1.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt1.setIcon(new ImageIcon("img\\�黹���.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bt1.setIcon(new ImageIcon("img\\�黹.png"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				 int index = table.getSelectedRow();
				 Object return_book=table.getValueAt(index,0);
				
				 
				 //���ȷ��
				 //cc:���ص��������id��
				 
				  System.out.println(return_book);
				  if(index!=-1) //����ѡ����
				  {
					  dtm.removeRow(index);
				  }
				  else {
					
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
	    });
		
    
    }
	
}
