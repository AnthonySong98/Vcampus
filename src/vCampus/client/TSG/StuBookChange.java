package vCampus.client.TSG;
/**
 * @author Yanhao Shen
 * 
 * @date 9.3
 *
 */
import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

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
import java.awt.print.Book;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*; 

public class StuBookChange extends JPanel{

	JTextArea jtf=new JTextArea(20,1);
	
	public StuBookChange() {
		
	super();
	
	JLabel lb1 = new JLabel("��ѯ");
	JTextField tf1 = new JTextField(20);
	
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
    bt1.setBounds(910-270, 910-80, 120, 60);
    bt1.setFont(font);
    // ���ð�ť��Ĭ��ͼƬ
    bt1.setIcon(new ImageIcon("img\\ȷ��.png"));
    bt1.setBorder(null);

    this.add(lb1); 
    lb1.setBounds(456-270, 196-80, 151, 47);
    lb1.setFont(font);
    this.add(tf1);
   // tf1.setBackground(Color.WHITE);
    tf1.setBounds(710-270, 196-80, 352, 47);
    tf1.setFont(font);
   // tf1.setEditable(false);
    tf1.setBorder(null);

    
    this.add(bt1);
    bt1.setBounds(910-270, 910-80, 120, 60);
    bt1.setFont(font);
    // ���ð�ť��Ĭ��ͼƬ
   
    bt1.setContentAreaFilled(false);
    bt1.setIcon(new ImageIcon("img\\����.png"));
    bt1.setBorder(null);
    
    
    
    
    
	/*
	 * ����JTable������
	 */
	String[] columnNames =
	{ "���", "����", "������","���λ��","����","�������","�ѳ���" };

	/*
	 * ��ʼ��JTable��������ֵ����������һģһ����ʵ��"�Կ���"ѧ����
	 */
	
	
	
	int book_num=5;//�˴��޸��Ѿ������鼮��
	
	
	Object[][] obj = new Object[book_num][7];
	for (int i = 0; i < book_num; i++)
	{
		for (int j = 0; j < 7; j++)
		{
			switch (j)
			{
			case 0:
				obj[i][j] = "1";
				break;
			case 1:
				obj[i][j] = "QAQ";
				break;
			case 2:
				obj[i][j] = "";
				break;
			case 3:
				obj[i][j] = "3A21";
				break;
			case 4:
				obj[i][j] = "�⽨";
				break;
			case 5:
				obj[i][j] = "3";
				break;
			case 6:
				obj[i][j] = "2";
				break;	
			}
		}
		
		if (i % 2 == 0)
               setForeground(Color.pink);
        else if (i % 2 == 1)
        	  setForeground(Color.WHITE);;
		
	}
	
	
	/*
	 * JTable������һ�ֹ��췽��
	 */
	JTable table = new JTable(obj, columnNames) {
	public boolean isCellEditable(int row, int column)
    {
               return false;}//��������༭
    };
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
	scroll.setSize(1058, 528);
	table.setSize(600, 800);
	
	add(scroll);
	
	

    bt1.addMouseListener(new MouseListener() {
		@Override
		public void mouseEntered(MouseEvent e) {
			bt1.setIcon(new ImageIcon("img\\���ĵ��.png"));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			bt1.setIcon(new ImageIcon("img\\����.png"));
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			 int index = table.getSelectedRow();
			
			System.out.println(table.getValueAt(index,1));
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
