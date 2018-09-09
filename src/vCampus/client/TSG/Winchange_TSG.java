package vCampus.client.TSG;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import vCampus.client.biz.AdminService;
import vCampus.client.biz.StudentService;
import vCampus.client.biz.TeacherService;


/**
 * @author Yanhao Shen
 *
 */
public class Winchange_TSG extends JPanel {
	
	JButton jb1=new JButton("��ѯͼ��");
	JButton jb2=new JButton("�黹ͼ��");
	JButton jb3=new JButton("���ͼ��");
	JButton jb4=new JButton("��ѯ�޸�");
	
	public Winchange_TSG(int identify,StudentService ss){
		super();
//		int identify=3;
	    CardLayout card=new CardLayout();
		JPanel cardpanel=new JPanel();
		StuBookChange w1=new StuBookChange(ss);
		StuBookCheck w2=new StuBookCheck(ss);
		
		
		Font font=new Font("ƻ�� ����",Font.CENTER_BASELINE,28);
		this.setLayout(null);

		
		//identify:1 ѧ�� ��ѯͼ��(��)/��
		//identify:2 ��ʦ 
		//identify:3 ����Ա ���/ɾ���޸�
		
		
		//this.add(jb1);
	    jb1.setBounds(0, 0, 270, 80);
	    jb1.setFont(font);
	    jb1.setIcon(new ImageIcon("img\\��ѯͼ����.png"));
	    jb1.addMouseListener(new ButtonClicked());
	       	
	    //this.add(jb2);
	    jb2.setBounds(0, 80, 270, 80);
	    jb2.setFont(font);
	    jb2.setIcon(new ImageIcon("img\\�黹ͼ��.png"));
	    jb2.addMouseListener(new ButtonClicked());
	    
	
	    
	    jb1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w1");
	        }
	    });
	    
	    jb2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w2");
	        }
	    });
	  
	  
	    
		//Winchange2 w2=new Winchange2();
		cardpanel.setLayout(card);
		cardpanel.setBounds(270, 0, 1920-270, 1000);

		if(identify==1||identify==2)
		{
			cardpanel.add("w1",w1);
			cardpanel.add("w2",w2);
			this.add(jb1);
			this.add(jb2);
			
		}
		
	
		
		
		this.add(cardpanel);
		
	}

	
	public Winchange_TSG(int identify, AdminService admin) {
		super();
//		int identify=3;
	    CardLayout card=new CardLayout();
		JPanel cardpanel=new JPanel();
		AdmBookAdd w3=new AdmBookAdd();
		AdmBookChange w4=new AdmBookChange();
		
		
		Font font=new Font("ƻ�� ����",Font.CENTER_BASELINE,28);
		this.setLayout(null);
		
		JButton jb3=new JButton();
		JButton jb4=new JButton();
		
		//identify:1 ѧ�� ��ѯͼ��(��)/��
		//identify:2 ��ʦ 
		//identify:3 ����Ա ���/ɾ���޸�
		
		

	    //this.add(jb3);
	    jb3.setBounds(0, 0, 270, 80);
	    jb3.setFont(font);
	    jb3.setIcon(new ImageIcon("img\\���ͼ����.png"));
	    jb3.addMouseListener(new ButtonClicked());

	    jb4.setBounds(0, 80, 270, 80);
	    jb4.setFont(font);
	    jb4.setIcon(new ImageIcon("img\\��ѯ�޸�.png"));
	    jb4.addMouseListener(new ButtonClicked());

	  
	    jb3.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w3");
	        }
	    });
	  
	    
	    jb4.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w4");
	        }
	    });
	  
	    
		//Winchange2 w2=new Winchange2();
		cardpanel.setLayout(card);
		cardpanel.setBounds(270, 0, 1920-270, 1000);

		
		if(identify==3)
		{
		
			cardpanel.add("w3",w3);
			cardpanel.add("w4",w4);
			this.add(jb3);
			this.add(jb4);
		}
	
		
		
		this.add(cardpanel);
	
	}

	
	
	public Winchange_TSG(int identify, TeacherService tc) {
		super();
//		int identify=3;
	    CardLayout card=new CardLayout();
		JPanel cardpanel=new JPanel();
		StuBookChange w1=new StuBookChange(tc);
		StuBookCheck w2=new StuBookCheck(tc);
		
		
		Font font=new Font("ƻ�� ����",Font.CENTER_BASELINE,28);
		this.setLayout(null);

		
		//identify:1 ѧ�� ��ѯͼ��(��)/��
		//identify:2 ��ʦ 
		//identify:3 ����Ա ���/ɾ���޸�
		
		
		//this.add(jb1);
	    jb1.setBounds(0, 0, 270, 80);
	    jb1.setFont(font);
	    jb1.setIcon(new ImageIcon("img\\��ѯͼ����.png"));
	    jb1.addMouseListener(new ButtonClicked());
	       	
	    //this.add(jb2);
	    jb2.setBounds(0, 80, 270, 80);
	    jb2.setFont(font);
	    jb2.setIcon(new ImageIcon("img\\�黹ͼ��.png"));
	    jb2.addMouseListener(new ButtonClicked());
	    
	
	    
	    jb1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w1");
	        }
	    });
	    
	    jb2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w2");
	        }
	    });
	  
	  
	    
		//Winchange2 w2=new Winchange2();
		cardpanel.setLayout(card);
		cardpanel.setBounds(270, 0, 1920-270, 1000);

		if(identify==1||identify==2)
		{
			cardpanel.add("w1",w1);
			cardpanel.add("w2",w2);
			this.add(jb1);
			this.add(jb2);
			
		}
		
	
		
		
		this.add(cardpanel);
		
	}
	
	
	public void refresh() {
		jb1.setIcon(new ImageIcon("img\\��ѯͼ��.png"));
		jb2.setIcon(new ImageIcon("img\\�黹ͼ��.png"));
		jb3.setIcon(new ImageIcon("img\\���ͼ��.png"));
		jb4.setIcon(new ImageIcon("img\\��ѯ�޸�.png"));
	}
	
	public class ButtonClicked implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==jb1) {
				refresh();
				jb1.setIcon(new ImageIcon("img\\��ѯͼ����.png"));
			}
			if(e.getSource()==jb2) {
				refresh();
				jb2.setIcon(new ImageIcon("img\\�黹ͼ����.png"));
			}
			if(e.getSource()==jb3) {
				refresh();
				jb3.setIcon(new ImageIcon("img\\���ͼ����.png"));
			}
			if(e.getSource()==jb4) {
				refresh();
				jb4.setIcon(new ImageIcon("img\\��ѯ�޸ĵ��.png"));
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
		
	}
	
}
