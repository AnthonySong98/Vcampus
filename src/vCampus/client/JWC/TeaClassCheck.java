package vCampus.client.JWC;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import vCampus.client.biz.AcademicAffairsService;
import vCampus.client.biz.AcademicAffairsServiceImpl;
import vCampus.vo.CourseChoose;
import vCampus.vo.CourseInformation;


public class TeaClassCheck extends JPanel{
	//�������
	Object[][] data= {{"","","","","","","",""}};
	
	//������
	JTable tableDemo;
	TableColumn column;
	
	//�������ڵĶ���
	JFrame mesFrame;
	JTextArea ta;
	
	Font font1=new Font("ƻ�� ����",Font.BOLD,25);//���������ʽ�ʹ�С
	Font font2=new Font("ƻ�� ����",Font.CENTER_BASELINE,20);//���������ʽ�ʹ�С
	Font font3=new Font("ƻ�� ����",Font.CENTER_BASELINE,18);//���������ʽ�ʹ�С
	
	private void setData(String username) {
		
		AcademicAffairsService AAS = new AcademicAffairsServiceImpl(2,username);
		ArrayList<CourseChoose>courseTable = AAS.teacherGetAllCourses();
		int num = 0;
		if(courseTable!=null) {
			num = courseTable.size();
		}
		
		Object[][] a= {{"��һ��","","","","","","",""},
				{"�ڶ���","","","","","","",""},
				{"����","","","","","","",""},
				{"������","","","","","","",""},
				{"���Ľ�","","","","","","",""},
				{"����","","","","","","",""},
				{"�����","","","","","","",""}
				};
		data=a;
		
		for(int i=0;i<num;i++) {
			int row= AAS.findCourseInformation(courseTable.get(i).getCourseID()).getWeekIndex()/5;
			int col= AAS.findCourseInformation(courseTable.get(i).getCourseID()).getWeekIndex()%5+1;
			String courseName = courseTable.get(i).getCourseName();
			String coursePlace = AAS.findCourseInformation(courseTable.get(i).getCourseID()).getCoursePlace();
			a[row][col]="<html><body>"+courseName+"<br>"+coursePlace+"<body><html>";
		}
	}
	
	TeaClassCheck(String username){
		super();
		//this.setBounds(0, 0, 200, 150);
		this.setLayout(new BorderLayout());
		setData(username);
		//this.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
		//this.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		tableDemo=new JTable(new MyTableModel(data));
		
		tableDemo.setPreferredScrollableViewportSize(new Dimension(1000,1650));
		tableDemo.setFillsViewportHeight(true);
		//���ñ�ͷ
		JTableHeader head=tableDemo.getTableHeader();
		head.setFont(font1);
		//��ֹ�ı��п�
		tableDemo.getTableHeader().setResizingAllowed(false);
		//��ֹ�ı���˳��
		tableDemo.getTableHeader().setReorderingAllowed(false);
		//��ֹ�Զ��ı��С
		tableDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		//ȷ���п�
		column = null;
		for (int i = 1; i < 8; i++) {
		    column = tableDemo.getColumnModel().getColumn(i);
		   
		   
		        column.setPreferredWidth(200);
		    
		}
		
		//�����и�
		for(int i=0;i<7;i++) {
			if(i==2||i==5) {
				tableDemo.setRowHeight(i, 15);
			}
			else {
				tableDemo.setRowHeight(i, 150);
			}
		}
		
		//�����Ⱦ��
		
	    tableDemo.getColumnModel().getColumn(0).setCellRenderer(new TipsRenderer());
		tableDemo.getColumnModel().getColumn(3).setCellRenderer(new TipsRenderer());
		tableDemo.getColumnModel().getColumn(1).setCellRenderer(new TipsRenderer());
		tableDemo.getColumnModel().getColumn(2).setCellRenderer(new TipsRenderer());
		 tableDemo.getColumnModel().getColumn(4).setCellRenderer(new TipsRenderer());
		 tableDemo.getColumnModel().getColumn(5).setCellRenderer(new TipsRenderer());
		 tableDemo.getColumnModel().getColumn(6).setCellRenderer(new TipsRenderer());
		 tableDemo.getColumnModel().getColumn(7).setCellRenderer(new TipsRenderer());
		//TableColumn tc=tableDemo.getColumn("ʱ��");
		
		 
		tableDemo.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				 java.awt.Point p = e.getPoint();
				int rowIndex = tableDemo.rowAtPoint(p);
		        int colIndex = tableDemo.columnAtPoint(p);
//		        if(colIndex>0) {
//		        	mesFrame=new JFrame();
//		        	mesFrame.addWindowListener(new WindowAdapter() {
//		        		public void windowClosing(WindowEvent e) {
//		        			mesFrame.dispose();
//		        		}
//		        	});
//		        	ta=new JTextArea();
//		        	ta.setLineWrap(true);
//		        	mesFrame.setLayout(new BorderLayout());
//		        	mesFrame.add(ta, BorderLayout.CENTER);
//		        	mesFrame.setBounds(300, 300, 200, 150);
//		        	mesFrame.setVisible(true);
//		        }
				
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		
		//scrollTable.add(tableDemo);
		JScrollPane scrollTable=new JScrollPane();
		scrollTable.setViewportView(tableDemo);
		//System.err.println();
		this.add(scrollTable,BorderLayout.CENTER);
		
		
	}
	
	//TableModel���࣬�̳���AbstractTableModel
	class MyTableModel extends AbstractTableModel{
		//���Ҫ��ʾ������
		//��ͷ
		private String[] columnHead= {"ʱ��","��һ","�ܶ�","����","����","����","����","����"};
		
		//����
		private Object[][] data=null;
		
		MyTableModel(Object[][] a){
			data=a;
		}
		
		


		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return columnHead.length;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return data.length;
		}

		@Override
		public Object getValueAt(int col, int row) {
			// TODO Auto-generated method stub
			return data[col][row];
		}
		
		public String getColumnName(int col,int row) {
			return columnHead[col];
		}
		
		public boolean isCellEditable(int row,int column) {
				return false;
			
		}
		
		public String getColumnName(int row)
		{
			return columnHead[row];
		}
		
		
		
		
		
	}
	
	//������Ⱦ����ʹ������ʾtips
	class TipsRenderer extends JLabel implements TableCellRenderer{

		@Override
		public Component getTableCellRendererComponent(JTable table, Object arg1, boolean isSelected, boolean hasFoucesed, int row,
				int col) {
			// TODO Auto-generated method stub
			
			if(col<1) {
				this.setBackground(Color.GRAY);
				this.setText(String.valueOf(table.getValueAt(row, col)));
				this.setOpaque(true);
				this.setFont(font2);
			}
			else {
				this.setText(String.valueOf(table.getValueAt(row, col)));
				this.setOpaque(true);
				this.setToolTipText(String.valueOf(table.getValueAt(row, col)));
				this.setFont(font3);
				if(isSelected) {

				}
			}
			this.setHorizontalAlignment(CENTER);
			this.setVerticalAlignment(CENTER);
			
			return this;
		}
	
		
	}
/*	
	public static void main(String args[]) {
		StuClassCheck table=new StuClassCheck();
		//table.setOpaque(true);
		
	}
*/
}
