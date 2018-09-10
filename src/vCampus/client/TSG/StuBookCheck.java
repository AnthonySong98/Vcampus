package vCampus.client.TSG;
/**
 * @author Yanhao Shen
 * 
 * @author2 CC
 * 
 * @date 9.3
 * 
 * @add front-end monitor in 9/10
 *
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import vCampus.client.biz.LibraryService;
import vCampus.client.biz.LibraryServiceImpl;
import vCampus.client.biz.StudentService;
import vCampus.client.biz.TeacherService;
import vCampus.client.register.RegisterView;
import vCampus.server.exception.RecordAlreadyExistException;
import vCampus.vo.BookBorrow;
import vCampus.vo.BookInformation;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*; 

public class StuBookCheck extends JPanel{
	
	
	DefaultTableModel dtm = null;
	JTextArea jtf=new JTextArea(20,1);
	
	
	/**
	 * 
	 */
	public StuBookCheck(StudentService ss) {
		
	super();
	 
	LibraryService LS = new LibraryServiceImpl(1,ss.getCacheStudent().getUserName());
	String username = ss.getCacheStudent().getUserName();
	
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
    bt1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			bt1.setIcon(new ImageIcon("img\\�黹���.png"));
		}
    	
    });
    
  
    
    this.add(lb1); 
    lb1.setBounds(456-270, 196-80, 151, 47);
    lb1.setFont(font);

	/*
	 * ����JTable������
	 */
	String[] columnNames =
	{ "���","����", "����", "������" };

	/*
	 * ��ʼ��JTable��������ֵ
	 */
	
	int num_borrow = 3;
	Object[][] obj = new Object[num_borrow][4];
	if(LS.queryBookBorrow(username)!= null) {
		//num_borrow = LS.queryBookBorrow(username).size();
		ArrayList<BookBorrow> borrowbooks = LS.queryBookBorrow(username);
		num_borrow = LS.queryBookBorrow(username).size();
		obj = new Object[num_borrow][4];
		ArrayList<BookInformation> bbsinfo = new ArrayList<BookInformation>();
		if(borrowbooks!=null) {
			for(int i=0;i<num_borrow;i++) {
				bbsinfo.add(LS.queryBookInformation(borrowbooks.get(i).getBookID()));
			}
		}
		for (int i = 0; i < num_borrow; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				String borrowedbookID = borrowbooks.get(i).getBookID();
				switch (j)
				{
				case 0:
					obj[i][j] = borrowedbookID;
				case 1:
					obj[i][j] = bbsinfo.get(i).getBookName();
					break;
				case 2:
					obj[i][j] = bbsinfo.get(i).getBookWriter();
					break;
				case 3:
					obj[i][j] = bbsinfo.get(i).getBookPress();
					break;
		
				}
			}
		}
		
	}
	else {
		for (int i = 0; i < num_borrow; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				//String borrowedbookID = LS.queryBookBorrow(username).get(i).getBookID();
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
		
				}
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
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				 int index = table.getSelectedRow();
				 //Object return_book=table.getValueAt(index,0);
				 //String returnbookID =  return_book.toString();
				 if(LS.queryBookBorrow(username).get(index)!=null) {
					 BookBorrow BB = LS.queryBookBorrow(username).get(index);
					 if(BB!=null) {
						 if(index!=-1) //����ѡ����
						 {
							 if(LS.returnBook(BB)==true) {
								 dtm.removeRow(index);
							 }
							 else JOptionPane.showMessageDialog(null, "�黹ʧ��");
						 }
						 else {
							 JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�黹��ͼ��");
						 }
					 }
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

	public StuBookCheck(TeacherService tc) {
		// TODO Auto-generated constructor stub
		
	super();
	 
	LibraryService LS = new LibraryServiceImpl(1,tc.getCacheTeacher().getUserName());
	String username = tc.getCacheTeacher().getUserName();
	
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
    bt1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			bt1.setIcon(new ImageIcon("img\\�黹���.png"));
		}
    	
    });
    
  
    
    this.add(lb1); 
    lb1.setBounds(456-270, 196-80, 151, 47);
    lb1.setFont(font);

	/*
	 * ����JTable������
	 */
	String[] columnNames =
	{ "���","����", "����", "������" };

	/*
	 * ��ʼ��JTable��������ֵ
	 */
	
	int num_borrow = 3;
	Object[][] obj = new Object[num_borrow][4];
	if(LS.queryBookBorrow(username)!= null) {
		//num_borrow = LS.queryBookBorrow(username).size();
		ArrayList<BookBorrow> borrowbooks = LS.queryBookBorrow(username);
		num_borrow = LS.queryBookBorrow(username).size();
		obj = new Object[num_borrow][4];
		ArrayList<BookInformation> bbsinfo = new ArrayList<BookInformation>();
		if(borrowbooks!=null) {
			for(int i=0;i<num_borrow;i++) {
				bbsinfo.add(LS.queryBookInformation(borrowbooks.get(i).getBookID()));
			}
		}
		for (int i = 0; i < num_borrow; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				String borrowedbookID = borrowbooks.get(i).getBookID();
				switch (j)
				{
				case 0:
					obj[i][j] = borrowedbookID;
				case 1:
					obj[i][j] = bbsinfo.get(i).getBookName();
					break;
				case 2:
					obj[i][j] = bbsinfo.get(i).getBookWriter();
					break;
				case 3:
					obj[i][j] = bbsinfo.get(i).getBookPress();
					break;
		
				}
			}
		}
		
	}
	else {
		for (int i = 0; i < num_borrow; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				//String borrowedbookID = LS.queryBookBorrow(username).get(i).getBookID();
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
		
				}
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
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				 int index = table.getSelectedRow();
				 //Object return_book=table.getValueAt(index,0);
				 //String returnbookID =  return_book.toString();
				 if(LS.queryBookBorrow(username).get(index)!=null) {
					 BookBorrow BB = LS.queryBookBorrow(username).get(index);
					 if(BB!=null) {
						 if(index!=-1) //����ѡ����
						 {
							 if(LS.returnBook(BB)==true) {
								 dtm.removeRow(index);
							 }
							 else JOptionPane.showMessageDialog(null, "�黹ʧ��");
						 }
						 else{
							 JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�黹��ͼ��");
						 }
					 }
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
