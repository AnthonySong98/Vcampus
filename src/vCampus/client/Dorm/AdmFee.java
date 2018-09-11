package vCampus.client.Dorm;
/**
 * @author SYH
 * 
 * @date 9.3
 *
 */
import javax.swing.*;

import vCampus.client.biz.DormitoryService;
import vCampus.client.biz.DormitoryServiceImpl;
import vCampus.client.register.RegisterView;
import vCampus.vo.Dormitory;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;

public class AdmFee extends JPanel{


	
	public AdmFee() {
		
	super();

	JLabel lb1 = new JLabel("�����");
	JTextField tf1 = new JTextField(20);
	JLabel lb2 = new JLabel("ˮ���");
	JTextField tf2 = new JTextField(20);
	JTextField tf3 = new JTextField(20);

	JButton bt1=new JButton("");
	
	this.setLayout(null);
	this.setSize(1650,1000);         
    
    Font font=new Font("ƻ�� ����",Font.CENTER_BASELINE,28);//���������ʽ�ʹ�С
   
    this.add(tf3);
    tf3.setBounds(810-170, 600-80, 352, 47);
    tf3.setFont(font);
    tf3.setEditable(false);
    tf3.setBorder(null);
    
    
    this.add(bt1);
    bt1.setBounds(910-270, 910-80, 160, 80);
    bt1.setFont(font);
    // ���ð�ť��Ĭ��ͼƬ
    bt1.setIcon(new ImageIcon("img\\ȷ��.png"));
    bt1.setBorder(null);
    bt1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
    			double moneychange = Double.parseDouble(tf2.getText());
    			if(moneychange<=0) throw new ArithmeticException();
    			DormitoryService DS = new DormitoryServiceImpl();
    			Dormitory newdorm = new Dormitory();
    			newdorm.setDormBill(moneychange);
    			if(DS.addDormitoryInfo(newdorm)) {
    				tf3.setText("�շѳɹ���");
    				tf1.setText("");
    				tf2.setText("");
    			}
    			else tf3.setText(DS.getExceptionCode());
    		}catch(NumberFormatException e1) {
    			tf3.setText("���벻�ܺ����ַ�");
    			tf1.setText("");
    			tf2.setText("");
    		}
    		catch(ArithmeticException e2) {
    			tf3.setText("������0-100������");
    			tf1.setText("");
    			tf2.setText("");
    		}
		}
    	
    });
    
    
    this.add(lb1);
    lb1.setBounds(456-270, 196-80, 101, 47);
    lb1.setFont(font);
    this.add(tf1);
    tf1.setBackground(Color.WHITE);
    tf1.setBounds(660-270, 196-80, 352, 47);
    tf1.setFont(font);
//    tf1.setEditable(false);
    tf1.setBorder(null);

    this.add(lb2);
    lb2.setBounds(1156-270, 196-80, 101, 47);
    lb2.setFont(font);
    this.add(tf2);
    tf2.setBackground(Color.WHITE);
  //  tf2.setText("11022");
    tf2.setBounds(1360-270, 196-80, 352, 47);
    tf2.setFont(font);
 //   tf2.setEditable(false);
    tf2.setBorder(null);
    
  
   
	}
}
