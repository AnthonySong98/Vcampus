package vCampus.client.Dorm;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * @author Yanhao Shen
 *
 */
public class Winchange_dorm extends JPanel {
	
	public Winchange_dorm(){
		super();
		int identify=3;
	    CardLayout card=new CardLayout();
		JPanel cardpanel=new JPanel();
		
		StuCheck w1=new StuCheck();
		AdmFee w2=new AdmFee();
		AdmScore w3=new AdmScore();
		
		
		Font font=new Font("ƻ�� ����",Font.CENTER_BASELINE,28);
		this.setLayout(null);
		
		JButton jb1=new JButton();
		JButton jb2=new JButton();
		JButton jb3=new JButton();
		JButton jb4=new JButton();
		JButton jb5=new JButton();
		JButton jb6=new JButton();
		JButton jb7=new JButton();
		JButton jb8=new JButton();
		
		//identify:1 ѧ�� ��ѯ
		//identify:2 ��ʦ 
		//identify:3 ����Ա ���ÿ۳�/�ǼǷ���
		
		
		//this.add(jb1);
	    jb1.setBounds(0, 0, 270, 80);
	    jb1.setFont(font);
	    jb1.setIcon(new ImageIcon("img\\��ѯ��Ϣ.png"));
	       	
	    //this.add(jb2);
	    jb2.setBounds(0, 0, 270, 80);
	    jb2.setFont(font);
	    jb2.setIcon(new ImageIcon("img\\�۳�����.png"));

	    //this.add(jb3);
	    jb3.setBounds(0, 80, 270, 80);
	    jb3.setFont(font);
	    jb3.setIcon(new ImageIcon("img\\�ǼǷ���.png"));

	    	    
	
	    
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
	  
	    jb3.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w3");
	        }
	    });
	  
		//Winchange2 w2=new Winchange2();
		cardpanel.setLayout(card);
		cardpanel.setBounds(270, 0, 1920-270, 1000);

		if(identify==1||identify==2)
		{
			cardpanel.add("w1",w1);
		
			this.add(jb1);
		
			
		}
		
		if(identify==3)
		{
			cardpanel.add("w2",w2);
			cardpanel.add("w3",w3);
			this.add(jb2);
			this.add(jb3);
		}
	
		
		
		this.add(cardpanel);
		
	}
	
	
}