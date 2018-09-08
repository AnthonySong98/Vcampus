package vCampus.client.register;
/**
 * @author CC
 * 
 * @date 8.27
 * @v2.0 data 9/8
 */

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import vCampus.client.socket.Client;
import vCampus.client.biz.StudentService;
import vCampus.client.biz.StudentServiceImpl;

public class RegisterView extends JFrame{
	/**
	 *v2.0 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame = new JFrame("�û�ע��");
	BackgroundPanel bgp;
	Font font=new Font("ƻ�� ����",Font.CENTER_BASELINE,28);
	public JTextField nameText = new JTextField(15);
	public JPasswordField pwdText1 = new JPasswordField(15);
	boolean pwdisFocused1 = false;
	public JTextField pwdHintText1 = new JTextField(15);
	public JPasswordField pwdText2 = new JPasswordField(15);
	boolean pwdisFocused2 = false;
	public JTextField pwdHintText2 = new JTextField(15);
	public JButton registerButton = new JButton();
	public JButton jb_close = new JButton();
	public JPanel buttonPan = new JPanel();
	String uID = null;
	String uPassword = null;

	public RegisterView() {
		this.setFocusable(true);
		//����ע�ᰴť����
		registerButton.addActionListener(new registerActionPerformed());
		//����JFrame��
		this.add(nameText);
		this.add(pwdText1);
		this.add(pwdHintText1);
		this.add(pwdText2);
		this.add(pwdHintText2);
		this.add(registerButton);
		this.add(jb_close);
		//���ֹ���         
		this.setSize(800,600);         
		this.setLocation(600, 300);
		
		nameText.setBounds(285, 200, 250, 48);
		nameText.setBorder(null);
		nameText.setFont(font);
		nameText.setOpaque(false);
		nameText.addFocusListener(new JTextFieldHintListener(nameText, "�û�ID"));
		
		pwdText1.setBounds(285, 275, 250, 48);
		pwdText1.setBorder(null);
		pwdText1.setFont(font);
		pwdText1.setOpaque(false);
		pwdText1.setVisible(false);
		pwdText1.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				pwdisFocused1=true;
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				pwdisFocused1=false;
				//ʧȥ����ʱ�������û�����������ҽ��㲻��������ϣ���ʾ�ı���
				String temp = pwdText1.getText().trim();
				if(temp.equals("") && pwdisFocused1 == false) {
					pwdHintText1.setVisible(true);
					pwdHintText1.setText("����");
					pwdText1.setVisible(false);
				}
			}
		});	
		
		pwdHintText1.setBounds(285, 275, 250, 48);
		pwdHintText1.setBorder(null);
		pwdHintText1.setFont(font);
		pwdHintText1.setOpaque(false);
		pwdHintText1.setForeground(Color.GRAY);
		pwdHintText1.setText("����");
		pwdHintText1.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				//�����ʱ�������ı���,��ʾ�����������ȡ����		
				String temp = "����";
				if(temp.equals("����")) {
					pwdHintText1.setVisible(false);
					pwdText1.setVisible(true);
					pwdText1.requestFocus();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		pwdText2.setBounds(285, 355, 250, 48);
		pwdText2.setBorder(null);
		pwdText2.setFont(font);
		pwdText2.setOpaque(false);
		pwdText2.setVisible(false);
		pwdText2.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				pwdisFocused2=true;
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				pwdisFocused2=false;
				//ʧȥ����ʱ�������û�����������ҽ��㲻��������ϣ���ʾ�ı���
				String temp = pwdText2.getText().trim();
				if(temp.equals("") && pwdisFocused2 == false) {
					pwdHintText2.setVisible(true);
					pwdHintText2.setText("����");
					pwdText2.setVisible(false);
				}
			}
		});
		
		pwdHintText2.setBounds(285, 355, 250, 48);
		pwdHintText2.setBorder(null);
		pwdHintText2.setFont(font);
		pwdHintText2.setOpaque(false);
		pwdHintText2.setForeground(Color.GRAY);
		pwdHintText2.setText("ȷ������");
		pwdHintText2.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				//��ȡ����ʱ�������ı���,��ʾ�����������ȡ����		
				String temp = "ȷ������";
				if(temp.equals("ȷ������")) {
					pwdHintText2.setVisible(false);
					pwdText2.setVisible(true);
					pwdText2.requestFocus();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		jb_close.setBounds(800-50, 0, 50, 50);
	    jb_close.setIcon(new ImageIcon("img\\exit_idle.png"));
	    jb_close.setBorder(null);
	    jb_close.setContentAreaFilled(false);
	    jb_close.setPressedIcon(new ImageIcon("img\\exit_ready.png"));
	    jb_close.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jb_close.setIcon(new ImageIcon("img\\exit_ready.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jb_close.setIcon(new ImageIcon("img\\exit_idle.png"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				RVoff();
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
		
	    registerButton.setBounds(341,466,130,40);
	    registerButton.setBorder(null);
	    registerButton.setIcon(new ImageIcon("img\\ȷ��ע��.png"));
	    registerButton.setPressedIcon(new ImageIcon("img\\ȷ��ע����.png"));
	    
		bgp=new BackgroundPanel((new ImageIcon("img\\ע�ᱳ��.png")).getImage());
		bgp.setBounds(0,0,800,600);
		this.add(bgp);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		  //Dimension dimension = kit.getScreenSize();
		  //  frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		  //  frame.setBounds(0, 0, dimension.width, dimension.height);
		   
		this.setUndecorated(true); 
		this.setVisible(true);  
		this.setResizable(true);
	}
	
	public void RVoff() {
		this.dispose();
		this.setVisible(false);
	}
	
	public class registerActionPerformed implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(pwdText1.getText().trim().equals(pwdText2.getText().trim())) {
				uID = nameText.getText();
				uPassword = pwdText1.getText();
				StudentService SS = new StudentServiceImpl();
				if(SS.register(uID, uPassword, pwdText2.getText()) == true) {
					ImageIcon icon = new ImageIcon("img\\frisk.jpg");
					JOptionPane.showMessageDialog(null, "ע��ɹ�","ע��ɹ�",1,icon);
				}
			}else {
				ImageIcon icon = new ImageIcon("img\\frisk.jpg");
				JOptionPane.showMessageDialog(null, "���벻һ��","ע��ʧ��",1,icon);
			}
		}
	}
	
}

