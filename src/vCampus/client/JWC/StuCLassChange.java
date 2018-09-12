package vCampus.client.JWC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.CellEditorListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import vCampus.client.biz.AcademicAffairsService;
import vCampus.client.biz.AcademicAffairsServiceImpl;
import vCampus.vo.CourseInformation;


public class StuCLassChange extends JPanel{
	//�������
	Object[][] data= {{"","","","","","","",""}};
	
	//������
	JTable tableDemo;
	TableColumn column;
	
	//�������ڵĶ���
	JFrame mesFrame;
	JTextArea ta;
	
	Font font1=new Font("ƻ�� ����",Font.CENTER_BASELINE,25);//���������ʽ�ʹ�С
	Font font2=new Font("ƻ�� ����",Font.CENTER_BASELINE,15);//���������ʽ�ʹ�С
	Font font3=new Font("ƻ�� ����",Font.CENTER_BASELINE,10);//���������ʽ�ʹ�С
	
	String userName;
	Object[][] Courses = {{"","","","","",""},
			{"","","","","",""},
			{"","","","","",""},
			{"","","","","",""},
			{"","","","","",""},
			{"","","","","",""},
			{"","","","","",""}
			};
	//************************************************
	//����Ҫ��ʾ����
	private void setData(String username) {
		Object[][] a= {{"","","","","",""},
				{"","","","","",""},
				{"","","","","",""},
				{"","","","","",""},
				{"","","","","",""},
				{"","","","","",""},
				{"","","","","",""}
				};
		data=a;
		AcademicAffairsService AAS = new AcademicAffairsServiceImpl(1,username);
		ArrayList<CourseInformation> allcourses = new ArrayList<CourseInformation>();
		/*allcourses.add(AAS.findCourseInformation("1"));
		allcourses.add(AAS.findCourseInformation("2"));
		allcourses.add(AAS.findCourseInformation("3"));
		allcourses.add(AAS.findCourseInformation("4"));
		for(int row=0;row<allcourses.size();row++) {
			a[row][0]=allcourses.get(row).getCourseName();
			a[row][1]=allcourses.get(row).getTeacherName();
			a[row][2]=allcourses.get(row).getCourseID();
			a[row][3]=allcourses.get(row).getCoursePlace();
			a[row][4]=allcourses.get(row).getCredit();
			}*/
		allcourses = AAS.studentGetAllAvailableCourses();
		int num = (allcourses!=null)?allcourses.size():0;
		for(int row=0;row<num;row++) {
			a[row][0]=allcourses.get(row).getCourseName();
			a[row][1]=allcourses.get(row).getTeacherName();
			a[row][2]=allcourses.get(row).getCourseID();
			a[row][3]=allcourses.get(row).getCoursePlace();
			a[row][4]=allcourses.get(row).getCredit();
			}
		Courses = a;
		}
	
	
	private void swtich(int col) {
		// TODO Auto-generated method stub
		
	}

	StuCLassChange(String username){
		super();
		userName = username;
		//this.setBounds(0, 0, 200, 150);
		this.setLayout(new BorderLayout());
		setData(username);

	//	this.setLayout(null);
		this.setSize(1650,1000);         
	    	
		tableDemo=new JTable(new MyTableModel(data));
		
		tableDemo.setPreferredScrollableViewportSize(new Dimension(1000,1650));
		tableDemo.setFillsViewportHeight(true);
		
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
		for (int i = 0; i <5 ; i++) {
		    column = tableDemo.getColumnModel().getColumn(i);
		   if(i==0||i==2) {
			   column.setPreferredWidth(250);
		   }
		   else
		        column.setPreferredWidth(150);
		    
		}
		
		//�����и�
		for(int i=0;i<7;i++) {
			
				tableDemo.setRowHeight(i, 80);
		
				
			
		}
		
		//�����Ⱦ��
		
	    tableDemo.getColumnModel().getColumn(0).setCellRenderer(new TipsRenderer());
		tableDemo.getColumnModel().getColumn(5).setCellRenderer(new CourseChooseRenderer());
		tableDemo.getColumnModel().getColumn(1).setCellRenderer(new TipsRenderer());
		tableDemo.getColumnModel().getColumn(2).setCellRenderer(new TipsRenderer());
		tableDemo.getColumnModel().getColumn(3).setCellRenderer(new TipsRenderer());
		tableDemo.getColumnModel().getColumn(4).setCellRenderer(new TipsRenderer());
		 tableDemo.getColumnModel().getColumn(5).setCellEditor(new CourseChooseEditor());
		//TableColumn tc=tableDemo.getColumn("ʱ��");
		
		 
		tableDemo.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				 java.awt.Point p = e.getPoint();
				int rowIndex = tableDemo.rowAtPoint(p);
		        int colIndex = tableDemo.columnAtPoint(p);
		        if(colIndex<3) {
		        	mesFrame=new JFrame();
		        	mesFrame.addWindowListener(new WindowAdapter() {
		        		public void windowClosing(WindowEvent e) {
		        			mesFrame.dispose();
		        		}
		        	});
		        	ta=new JTextArea();
		        	ta.setLineWrap(true);
		        	mesFrame.setLayout(new BorderLayout());
		        	mesFrame.add(ta, BorderLayout.CENTER);
		        	mesFrame.setBounds(300, 300, 200, 150);
		        	mesFrame.setVisible(true);
		        }
				
				
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
		
		this.add(scrollTable,BorderLayout.CENTER);
		
		
		
		this.setOpaque(true);
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(this);
		//myTable.pack();
		frame.setVisible(true);
		frame.setSize(1650, 1000);
		
	}
	
	//TableModel���࣬�̳���AbstractTableModel
	class MyTableModel extends AbstractTableModel{
		//���Ҫ��ʾ������
		//��ͷ
		private String[] columnHead= {"�γ�����","��ʦ","�γ̺�","�ص�","ѧ��",""};
		
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
				if(column==5)
				{
					return true;
				}
				else {
					return false;
				}
			
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
			
				this.setText(String.valueOf(table.getValueAt(row, col)));
				this.setOpaque(true);
				this.setToolTipText(String.valueOf(table.getValueAt(row, col)));
				this.setFont(font3);
				
			
			this.setHorizontalAlignment(CENTER);
			this.setVerticalAlignment(CENTER);
			
			return this;
		}
		
	}
	
	//����ѡ�ΰ�ť��Ⱦ��
	class CourseChooseRenderer extends JPanel implements TableCellRenderer{
		JButton choose,exit;
		JPanel pane;
		boolean chosen=false;
		@Override
		public Component getTableCellRendererComponent(JTable arg0, Object arg1, boolean arg2, boolean arg3, int row,
				int col) {
			// TODO Auto-generated method stub
			pane=new JPanel();
			choose=new JButton("ѡ��");
			exit=new JButton("�˿�");
			choose.setSize(35, 10);
			exit.setSize(35, 10);
			pane.setSize(100, 30);
			//pane.setLayout(new BorderLayout());
			pane.add(choose);
			pane.add(exit);
			chosen=false;
			if(chosen==true) {
				choose.setVisible(false);
				
			}
			else
			{
				exit.setVisible(false);
			}
			return pane;
		}
		
	}
	
	//���ñ༭��
	class CourseChooseEditor extends AbstractTableModel implements TableCellEditor{
		JButton choose,exit;
		JPanel pane;
		boolean chosen=false;

		public CourseChooseEditor() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public void addCellEditorListener(CellEditorListener arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void cancelCellEditing() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Object getCellEditorValue() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isCellEditable(EventObject arg0) {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public void removeCellEditorListener(CellEditorListener arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean shouldSelectCell(EventObject arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean stopCellEditing() {
			// TODO Auto-generated method stub
			fireEditingStopped();
			return true;
		}
		
		 private void fireEditingStopped(){
			 
		 }

		@Override
		public Component getTableCellEditorComponent(JTable table, Object arg1, boolean arg2, int row, int col) {
			// TODO Auto-generated method stub
			JButton choose,exit;
			JPanel pane;
			boolean chosen=true;
			pane=new JPanel();
			choose=new JButton("ѡ��");
			exit=new JButton("�˿�");
			choose.setSize(35, 10);
			exit.setSize(35, 10);
			pane.setSize(100, 30);
			//pane.setLayout(new BorderLayout());
			pane.add(choose);
			pane.add(exit);
			exit.setVisible(false);
			//fireTableCellUpdated();
			
			exit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//************************�ڴ˴���������ݿ����Ӵ���
					AcademicAffairsService AAS = new AcademicAffairsServiceImpl(1,userName);
					String courseID = (String)Courses[row][2];
					if(AAS.studentDeleteCourse(courseID)) {
						JOptionPane.showMessageDialog(null, "�˿γɹ�");
					}
					else JOptionPane.showMessageDialog(null, AAS.getExceptionCode());
			
					//***********************************************
					choose.setVisible(true);
					exit.setVisible(false);
					
					fireTableCellUpdated(row,col);
					fireEditingStopped();
					
				}
				
			});
			
			choose.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//************************�ڴ˴���������ݿ����Ӵ���
					AcademicAffairsService AAS = new AcademicAffairsServiceImpl(1,userName);
					//JOptionPane.showMessageDialog(null, userName);
					String courseID = (String)Courses[row][2];
					//JOptionPane.showMessageDialog(null, (String)Courses[row][2]);
					if(AAS.studentAddCourse(courseID)) {
						JOptionPane.showMessageDialog(null, "ѡ�γɹ�");
					}
					else JOptionPane.showMessageDialog(null, AAS.getExceptionCode());
					//***********************************************
					choose.setVisible(false);
					exit.setVisible(true);
					fireTableCellUpdated(row,col);
					fireEditingStopped();
					
				}
				
			});
			
			return pane;
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Object getValueAt(int arg0, int arg1) {
			// TODO Auto-generated method stub
			return null;
		}
		
		
	}
	

}
