package vCampus.client.TSG;
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
import vCampus.client.biz.LibraryService;
import vCampus.client.biz.LibraryServiceImpl;
import vCampus.client.register.RegisterView;
import vCampus.vo.Admin;
import vCampus.vo.BookInformation;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class AdmBookChange extends JPanel{

	JLabel lb0 = new JLabel("���");
	JTextField tf0 = new JTextField(20);
	JLabel lb1 = new JLabel("����");
	JTextField tf1 = new JTextField(20);
	JLabel lb2 = new JLabel("������");
	JTextField tf2 = new JTextField(20);
	JLabel lb3 = new JLabel("���λ��");
	JTextField tf3 = new JTextField(20);
	JLabel lb4 = new JLabel("����");
	JTextField tf4 = new JTextField(20);
	JLabel lb5 = new JLabel("�������");
	JTextField tf5 = new JTextField(20);
	DefaultTableModel dtm = null;
	
	
	
	public AdmBookChange(AdminService admin) {
		
	super();

	JButton bt0=new JButton("");
	JButton bt1=new JButton("");
	JButton bt2=new JButton("");
	
	this.setLayout(null);
	this.setSize(1650,1000);         
    
    Font font=new Font("ƻ�� ����",Font.CENTER_BASELINE,28);//���������ʽ�ʹ�С
   
    LibraryService LS = new LibraryServiceImpl(3,admin.getCacheAdmin().getAdminID());

    
    //syh
    
    
  	/*
  	 * ����JTable������
  	 */
  	String[] columnNames =
  	{ "���", "����", "������","���λ��","����","�������","�ѳ���" };

  	/*
  	 * ��ʼ��JTable��������ֵ
  	 */
  	
  	ArrayList<BookInformation> allbooks = new ArrayList<BookInformation>();
	allbooks = LS.queryAllBook();
  	int book_num=5;
  	if(allbooks!=null) book_num = allbooks.size();
  	
  	Object[][] obj = new Object[book_num][7];
  	for (int i = 0; i < book_num; i++){
  		for (int j = 0; j < 7; j++){
  			switch (j){
  			case 0:
  				obj[i][j] = allbooks.get(i).getBookID();
  				break;
  			case 1:
  				obj[i][j] = allbooks.get(i).getBookName();
  				break;
  			case 2:
  				obj[i][j] = allbooks.get(i).getBookPress();
  				break;
  			case 3:
  				obj[i][j] = allbooks.get(i).getBookAddress();
  				break;
  			case 4:
  				obj[i][j] = allbooks.get(i).getBookWriter();
  				break;
  			case 5:
  				obj[i][j] = String.valueOf(allbooks.get(i).getTotalAmount());
  				break;
  			case 6:
  				obj[i][j] = String.valueOf(allbooks.get(i).getBorrowedAmount());
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
  	scroll.setLocation(181, 215);
  	scroll.setSize(1058, 290);
  	table.setSize(600, 800);	
  	add(scroll);
    
    
    
    
    
    
    
    
    
    
    this.add(bt0);
    bt0.setBounds(880,196-90,60,60);
    bt0.setFont(font);
    // ���ð�ť��Ĭ��ͼƬ
    bt0.setIcon(new ImageIcon("img\\��ѯUI.png"));
    bt0.setBorder(null);
    bt0.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// to search for info of one book
			BookInformation book = LS.queryBookInformation(tf0.getText());
			if(book != null) {
				tf1.setText(book.getBookName());
				tf2.setText(book.getBookPress());
				tf3.setText(book.getBookAddress());
				tf4.setText(book.getBookWriter());
				tf5.setText(String.valueOf(book.getTotalAmount()));
			}
		}
    	
    });
    
    this.add(bt1);
    bt1.setBounds(910-270, 910-80, 160, 80);
    bt1.setFont(font);
    // ���ð�ť��Ĭ��ͼƬ
    bt1.setIcon(new ImageIcon("img\\ȷ��.png"));
    bt1.setBorder(null);
  
    bt1.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		// to confirm changes to info of one book
    		BookInformation BooktoUpdate = new BookInformation();
			BooktoUpdate.setBookID(tf0.getText());
			BooktoUpdate.setBookName(tf1.getText());
			BooktoUpdate.setBookPress(tf2.getText());
			BooktoUpdate.setBookAddress(tf3.getText());
			BooktoUpdate.setBookWriter(tf4.getText());
			BooktoUpdate.setTotalAmount(Integer.parseInt(tf5.getText()));
			BooktoUpdate.setBorrowedAmount(LS.queryBookInformation(tf0.getText()).getBorrowedAmount());
			if(LS.updateBookByAdmin(BooktoUpdate)==true) {
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
			}
			else {
				if(!LS.getExceptionCode().equals("")) {
					JOptionPane.showMessageDialog(null, LS.getExceptionCode());
				}
			}
			
			ArrayList<BookInformation> allbooks = new ArrayList<BookInformation>();
			allbooks = LS.queryAllBook();
			int books_num = 0;
			if(allbooks!=null) books_num = allbooks.size();
			
		  	Object[][] obj = new Object[books_num][7];
		  	for (int i = 0; i < books_num; i++){
		  		for (int j = 0; j < 7; j++){
		  			switch (j){
		  			case 0:
		  				obj[i][j] = allbooks.get(i).getBookID();
		  				break;
		  			case 1:
		  				obj[i][j] = allbooks.get(i).getBookName();
		  				break;
		  			case 2:
		  				obj[i][j] = allbooks.get(i).getBookPress();
		  				break;
		  			case 3:
		  				obj[i][j] = allbooks.get(i).getBookAddress();
		  				break;
		  			case 4:
		  				obj[i][j] = allbooks.get(i).getBookWriter();
		  				break;
		  			case 5:
		  				obj[i][j] = String.valueOf(allbooks.get(i).getTotalAmount());
		  				break;
		  			case 6:
		  				obj[i][j] = String.valueOf(allbooks.get(i).getBorrowedAmount());
		  				break;	
		  			}
		  		}
		  	}
		  	
			
			
			dtm.setDataVector(obj,columnNames);//����������
			dtm.fireTableStructureChanged();//������ʾ


    	}
    });

    bt1.setAutoscrolls(false);
    bt1.addMouseListener(new MouseListener() {
		@Override
		public void mouseEntered(MouseEvent e) {
			bt1.setIcon(new ImageIcon("img\\ȷ�ϵ��.png"));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			bt1.setIcon(new ImageIcon("img\\ȷ��.png"));
		}

		public void mouseClicked(MouseEvent e) {
		
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
	

    this.add(bt2);
    bt2.setBounds(1001, 910-80, 160, 80);
    bt2.setFont(font);
    // ���ð�ť��Ĭ��ͼƬ
    bt2.setIcon(new ImageIcon("img\\ɾ��.png"));
    bt2.setBorder(null);
    bt2.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		// to delete info of one book
			if(LS.deleteBookByAdmin(tf0.getText())==true) {
				JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
			}
			else {
				if(!LS.getExceptionCode().equals("")) {
					JOptionPane.showMessageDialog(null, LS.getExceptionCode());
				}
			}
			
			
			
			dtm.setDataVector(obj,columnNames);//����������
			dtm.fireTableStructureChanged();//������ʾ		
    	}
    });
    

    bt2.setAutoscrolls(false);
    bt2.addMouseListener(new MouseListener() {
		@Override
		public void mouseEntered(MouseEvent e) {
			bt2.setIcon(new ImageIcon("img\\ɾ�����.png"));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			bt2.setIcon(new ImageIcon("img\\ɾ��.png"));
		}

		public void mouseClicked(MouseEvent e) {
		
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
    
    bt1.setContentAreaFilled(false);
    bt2.setContentAreaFilled(false);
    
    this.add(lb0);
    lb0.setBounds(456-270, 196-80, 101, 47);
    lb0.setFont(font);
    this.add(tf0);
    tf0.setBackground(Color.WHITE);
    tf0.setBounds(660-270, 196-80, 402, 47);
    tf0.setFont(font);
  //  tf0.setEditable(false);
    tf0.setBorder(null);
    
    this.add(lb1);
    lb1.setBounds(185, 549, 101, 47);
    lb1.setFont(font);
    this.add(tf1);
    tf1.setBackground(Color.WHITE);
    tf1.setBounds(389, 549, 402, 47);
    tf1.setFont(font);
//    tf1.setEditable(false);
    tf1.setBorder(null);

    this.add(lb2);
    lb2.setBounds(885, 549, 101, 47);
    lb2.setFont(font);
    this.add(tf2);
    tf2.setBackground(Color.WHITE);
    tf2.setBounds(1089, 549, 402, 47);
    tf2.setFont(font);
 //   tf2.setEditable(false);
    tf2.setBorder(null);
    
    this.add(lb3);
    lb3.setBounds(185, 660, 201, 47);
    lb3.setFont(font);
    this.add(tf3);
    tf3.setBackground(Color.WHITE);
    tf3.setBounds(389, 660, 402, 47);
    tf3.setFont(font);
//    tf3.setEditable(false);
    tf3.setBorder(null);
    
    this.add(lb4);
    lb4.setBounds(885, 660, 250, 47);
    lb4.setFont(font);
    this.add(tf4);
    tf4.setBackground(Color.WHITE);
    tf4.setBounds(1089, 660, 402, 47);
    tf4.setFont(font);
//    tf4.setEditable(false);
    tf4.setBorder(null);
    
    this.add(lb5);
    lb5.setBounds(185, 771, 201, 47);
    lb5.setFont(font);
    this.add(tf5);
    tf5.setBackground(Color.WHITE);
    tf5.setBounds(389, 771, 402, 47);
    tf5.setFont(font);
//    tf5.setEditable(false);
    tf5.setBorder(null);
    
	}
}
