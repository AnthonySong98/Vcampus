package vCampus.client.TSG;
import javax.crypto.interfaces.PBEKey;
/**
 * @author Yanhao Shen
 * 
 * @date 9.3
 *
 */
import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableRow;

import org.omg.CORBA.OBJECT_NOT_EXIST;

import vCampus.client.biz.LibraryService;
import vCampus.client.biz.LibraryServiceImpl;
import vCampus.client.biz.StudentService;
import vCampus.client.biz.TeacherService;
import vCampus.client.register.RegisterView;
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
import java.awt.print.Book;
import java.io.ObjectStreamConstants;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*; 

public class StuBookChange extends JPanel{

	JLabel lb1 = new JLabel("");
	JTextArea jtf=new JTextArea(20,1);
	JButton bt0=new JButton();
	JButton bt1=new JButton();
	JTextField tf1 = new JTextField(20);
	
	/**
	 * @wbp.parser.constructor
	 */
	public StuBookChange(StudentService ss) {
		
	super();
	
	LibraryService LS = new LibraryServiceImpl(1,ss.getCacheStudent().getUserName());
	
	this.setLayout(null);
	this.setSize(1650,1000);            
    Font font=new Font("ƻ�� ����",Font.CENTER_BASELINE,28);//���������ʽ�ʹ�С
   
    
    
  //****************************��ʼ���б�*********************************
    
    
  	/*
  	 * ����JTable������
  	 */
  	String[] columnNames =
  	{ "���", "����", "������","���λ��","����","�������","�ѳ���" };

  	/*
  	 * ��ʼ��JTable��������ֵ
  	 */
  	int book_num=5;
  	
  	Object[][] obj = new Object[book_num][7];
  	for (int i = 0; i < book_num; i++){
  		for (int j = 0; j < 7; j++){
  			switch (j){
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
  				obj[i][j] = new String("");
  				break;
  			case 6:
  				obj[i][j] =new String(""); ;
  				break;	
  			}
  		}
  	}
  	

  	/*
  	 * JTable������һ�ֹ��췽��
  	 */
  	JTable table = new JTable(obj, columnNames) {
  		public boolean isCellEditable(int row, int column){
  				return false;//��������༭
      	}
  	
  	};
      table.setRowHeight(30);// ���ñ���п�
      
      JTableHeader head = table.getTableHeader(); // �������������
      head.setPreferredSize(new Dimension(head.getWidth(), 35));// ���ñ�ͷ��С
      head.setFont(font);// ���ñ������
     
  	TableColumn column = null;
  	int colunms = table.getColumnCount();
  	for(int i = 0; i < colunms; i++){
  		column = table.getColumnModel().getColumn(i);
  		/*��ÿһ�е�Ĭ�Ͽ������Ϊ100*/
  		column.setPreferredWidth(300);	
  	}
  	/*
  	 * ����JTable�Զ������б��״̬���˴�����Ϊ�ر�
  	 */
//  	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
  	table.setBounds(400, 365, 600, 800);
  	table.setFont(font);	
  	/*��JScrollPaneװ��JTable������������Χ���оͿ���ͨ�����������鿴*/
  	JScrollPane scroll = new JScrollPane(table);
  	scroll.setLocation(186, 223);
  	scroll.setSize(1226, 528);
  	table.setSize(600, 800);	
  	add(scroll);
    
    
    
    this.add(bt0);
    bt0.setBounds(880,196-90,60,60);
    bt0.setFont(font);
    // ���ð�ť��Ĭ��ͼƬ
    bt0.setIcon(new ImageIcon("img\\��ѯUI.png"));
    bt0.setBorder(null);
    
    bt0.addMouseListener(new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(tf1.getText()!="") {
				ArrayList<BookInformation> Books = LS.queryBook(tf1.getText());
				if(Books==null) {
					JOptionPane.showMessageDialog(null, "���޴���");
				}
				Object[][] obj = new Object[Books.size()][7];
				for (int i = 0; i < Books.size(); i++){
					for (int j = 0; j < 7; j++){
						switch (j){
						case 0:
							obj[i][j] = new String(Books.get(i).getBookID());
							break;
						case 1:
							obj[i][j] = new String(Books.get(i).getBookName());
							break;
						case 2:
							obj[i][j] = new String(Books.get(i).getBookPress());
							break;
						case 3:
							obj[i][j] = new String(Books.get(i).getBookAddress());
							break;
						case 4:
							obj[i][j] = new String(Books.get(i).getBookWriter());
							break;
						case 5:
							obj[i][j] = new String(String.valueOf(Books.get(i).getTotalAmount()));
							break;
						case 6:
							obj[i][j] = new String(String.valueOf(Books.get(i).getBorrowedAmount()));
							break;	
						}
					}
				}
				JTable table = new JTable(obj, columnNames) {
					public boolean isCellEditable(int row, int column){
							return false;//��������༭
			    	}
				
				};
			    table.setRowHeight(30);// ���ñ���п�
			    
			    JTableHeader head = table.getTableHeader(); // �������������
			    head.setPreferredSize(new Dimension(head.getWidth(), 35));// ���ñ�ͷ��С
			    head.setFont(font);// ���ñ������
			   
				TableColumn column = null;
				int colunms = table.getColumnCount();
				for(int i = 0; i < colunms; i++){
					column = table.getColumnModel().getColumn(i);
					/*��ÿһ�е�Ĭ�Ͽ������Ϊ100*/
					column.setPreferredWidth(300);	
				}
				/*
				 * ����JTable�Զ������б��״̬���˴�����Ϊ�ر�
				 */
//				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.setBounds(400, 365, 600, 800);
				table.setFont(font);	
				/*��JScrollPaneװ��JTable������������Χ���оͿ���ͨ�����������鿴*/
				JScrollPane scroll = new JScrollPane(table);
				scroll.setLocation(186, 223);
				scroll.setSize(1058, 528);
				table.setSize(600, 800);	
				add(scroll);
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
    	
    });
    

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
    bt1.setBounds(910-270, 910-80, 160, 80);
    bt1.setFont(font);
    // ���ð�ť��Ĭ��ͼƬ
   
    bt1.setContentAreaFilled(false);
    bt1.setIcon(new ImageIcon("img\\����.png"));
    bt1.setBorder(null);
    bt1.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		//	bt1.setIcon(new ImageIcon("img\\���ĵ��.png"));
		}
    });
    
    bt1.setContentAreaFilled(false);
    bt1.addMouseListener(new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int index = table.getSelectedRow();
			//Object NewbookID=table.getValueAt(index,0);//return the id of the book
			BookBorrow BB = new BookBorrow();
			BB.setBookID(table.getValueAt(index,0).toString());
				
			String s=new String();
				 
					
			//String s6=table.getValueAt(index,6).toString();
			//int n6 = Integer.valueOf(s6).intValue();
				 
			//String s5=table.getValueAt(index,5).toString();
			//int n5 = Integer.valueOf(s5).intValue();
				 
			if(LS.borrowBook(BB)) {
				s=table.getValueAt(index,6).toString();
				int n = Integer.valueOf(s).intValue()+1;
				s=String.valueOf(n);
				table.setValueAt(s, index, 6);
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
			bt1.setIcon(new ImageIcon("img\\���ĵ��.png"));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			bt1.setIcon(new ImageIcon("img\\����.png"));
			// TODO Auto-generated method stub
			
		}
    	
    });
    	
    
    
/*	
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
				 Object New_book=table.getValueAt(index,0);
				 //System.out.println(n5); 
					//cc:�ɽ����
					//���ȷ�Ϸ��ص��������id��
					
					 String s=new String();
					 
						
					 String s6=table.getValueAt(index,6).toString();
					 int n6 = Integer.valueOf(s6).intValue();
					 
					 String s5=table.getValueAt(index,5).toString();
					 int n5 = Integer.valueOf(s5).intValue();
					  
					 System.out.println(n6);
					 System.out.println(n5);
					 if (n6<n5) {
						 s=table.getValueAt(index,6).toString();
						 int n = Integer.valueOf(s).intValue()+1;
						 s=String.valueOf(n);
						 table.setValueAt(s, index, 6);		 
					}

					 
					 System.out.println(New_book);
					
				
				 
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
*/	
   
    
    }

	
	
	public StuBookChange(TeacherService tc) {
		// TODO Auto-generated constructor stub
		
		super();
		
		LibraryService LS = new LibraryServiceImpl(1,tc.getCacheTeacher().getUserName());
		
		this.setLayout(null);
		this.setSize(1650,1000);            
	    Font font=new Font("ƻ�� ����",Font.CENTER_BASELINE,28);//���������ʽ�ʹ�С
	   
	    
	    
	  //****************************��ʼ���б�*********************************
	    
	    
	  	/*
	  	 * ����JTable������
	  	 */
	  	String[] columnNames =
	  	{ "���", "����", "������","���λ��","����","�������","�ѳ���" };

	  	/*
	  	 * ��ʼ��JTable��������ֵ
	  	 */
	  	int book_num=5;
	  	
	  	Object[][] obj = new Object[book_num][7];
	  	for (int i = 0; i < book_num; i++){
	  		for (int j = 0; j < 7; j++){
	  			switch (j){
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
	  				obj[i][j] = new String("");
	  				break;
	  			case 6:
	  				obj[i][j] =new String(""); ;
	  				break;	
	  			}
	  		}
	  	}
	  	

	  	/*
	  	 * JTable������һ�ֹ��췽��
	  	 */
	  	JTable table = new JTable(obj, columnNames) {
	  		public boolean isCellEditable(int row, int column){
	  				return false;//��������༭
	      	}
	  	
	  	};
	      table.setRowHeight(30);// ���ñ���п�
	      
	      JTableHeader head = table.getTableHeader(); // �������������
	      head.setPreferredSize(new Dimension(head.getWidth(), 35));// ���ñ�ͷ��С
	      head.setFont(font);// ���ñ������
	     
	  	TableColumn column = null;
	  	int colunms = table.getColumnCount();
	  	for(int i = 0; i < colunms; i++){
	  		column = table.getColumnModel().getColumn(i);
	  		/*��ÿһ�е�Ĭ�Ͽ������Ϊ100*/
	  		column.setPreferredWidth(300);	
	  	}
	  	/*
	  	 * ����JTable�Զ������б��״̬���˴�����Ϊ�ر�
	  	 */
//	  	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	  	table.setBounds(400, 365, 600, 800);
	  	table.setFont(font);	
	  	/*��JScrollPaneװ��JTable������������Χ���оͿ���ͨ�����������鿴*/
	  	JScrollPane scroll = new JScrollPane(table);
	  	scroll.setLocation(186, 223);
	  	scroll.setSize(1058, 528);
	  	table.setSize(600, 800);	
	  	add(scroll);
	    
	    
	    
	    this.add(bt0);
	    bt0.setBounds(880,196-90,60,60);
	    bt0.setFont(font);
	    // ���ð�ť��Ĭ��ͼƬ
	    bt0.setIcon(new ImageIcon("img\\��ѯUI.png"));
	    bt0.setBorder(null);
	    
	    bt0.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(tf1.getText()!="") {
					ArrayList<BookInformation> Books = LS.queryBook(tf1.getText());
					Object[][] obj = new Object[Books.size()][7];
					for (int i = 0; i < Books.size(); i++){
						for (int j = 0; j < 7; j++){
							switch (j){
							case 0:
								obj[i][j] = new String(Books.get(i).getBookID());
								break;
							case 1:
								obj[i][j] = new String(Books.get(i).getBookName());
								break;
							case 2:
								obj[i][j] = new String(Books.get(i).getBookPress());
								break;
							case 3:
								obj[i][j] = new String(Books.get(i).getBookAddress());
								break;
							case 4:
								obj[i][j] = new String(Books.get(i).getBookWriter());
								break;
							case 5:
								obj[i][j] = new String(String.valueOf(Books.get(i).getTotalAmount()));
								break;
							case 6:
								obj[i][j] = new String(String.valueOf(Books.get(i).getBorrowedAmount()));
								break;	
							}
						}
					}
					JTable table = new JTable(obj, columnNames) {
						public boolean isCellEditable(int row, int column){
								return false;//��������༭
				    	}
					
					};
				    table.setRowHeight(30);// ���ñ���п�
				    
				    JTableHeader head = table.getTableHeader(); // �������������
				    head.setPreferredSize(new Dimension(head.getWidth(), 35));// ���ñ�ͷ��С
				    head.setFont(font);// ���ñ������
				   
					TableColumn column = null;
					int colunms = table.getColumnCount();
					for(int i = 0; i < colunms; i++){
						column = table.getColumnModel().getColumn(i);
						/*��ÿһ�е�Ĭ�Ͽ������Ϊ100*/
						column.setPreferredWidth(300);	
					}
					/*
					 * ����JTable�Զ������б��״̬���˴�����Ϊ�ر�
					 */
//					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					table.setBounds(400, 365, 600, 800);
					table.setFont(font);	
					/*��JScrollPaneװ��JTable������������Χ���оͿ���ͨ�����������鿴*/
					JScrollPane scroll = new JScrollPane(table);
					scroll.setLocation(186, 223);
					scroll.setSize(1058, 528);
					table.setSize(600, 800);	
					add(scroll);
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
			bt1.setIcon(new ImageIcon("img\\���ĵ��.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			bt1.setIcon(new ImageIcon("img\\����.png"));
				
			}
	    	
	    });
	    
	    
	    

		

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
	    bt1.setBounds(910-270, 910-80, 160, 80);
	    bt1.setFont(font);
	    // ���ð�ť��Ĭ��ͼƬ
	   
	    bt1.setContentAreaFilled(false);
	    bt1.setIcon(new ImageIcon("img\\����.png"));
	    bt1.setBorder(null);
	    bt1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			//	bt1.setIcon(new ImageIcon("img\\���ĵ��.png"));
			}
	    });
	    bt1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int index = table.getSelectedRow();
				//Object NewbookID=table.getValueAt(index,0);//return the id of the book
				BookBorrow BB = new BookBorrow();
				BB.setBookID(table.getValueAt(index,0).toString());
					
				String s=new String();
					 
						
				//String s6=table.getValueAt(index,6).toString();
				//int n6 = Integer.valueOf(s6).intValue();
					 
				//String s5=table.getValueAt(index,5).toString();
				//int n5 = Integer.valueOf(s5).intValue();
					 
				if(LS.borrowBook(BB)) {
					s=table.getValueAt(index,6).toString();
					int n = Integer.valueOf(s).intValue()+1;
					s=String.valueOf(n);
					table.setValueAt(s, index, 6);
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
			bt1.setIcon(new ImageIcon("img\\���ĵ��.png"));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			bt1.setIcon(new ImageIcon("img\\����.png"));
			// TODO Auto-generated method stub
			
		}
    	
    });

	}
	
}
