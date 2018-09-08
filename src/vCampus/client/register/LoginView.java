package vCampus.client.register;
/**
 * @author CC
 * 
 * @date 8/27
 *
 * @v1.2 data 9/8
 *
 */

import javax.swing.*;

import vCampus.client.MainTable.InfoView_main;
import vCampus.client.InfoView.*;
import vCampus.client.JWC.*;
import vCampus.client.TSG.*;
import vCampus.client.Shop.*;
import vCampus.client.Dorm.*;
import vCampus.client.Bank.*;

import vCampus.client.biz.StudentService;
import vCampus.client.biz.StudentServiceImpl;
import vCampus.client.biz.TeacherService;
import vCampus.client.biz.TeacherServiceImpl;
import vCampus.client.biz.AdminService;
import vCampus.client.biz.AdminServiceImpl;

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


public class LoginView extends JFrame{
	JFrame frame = new JFrame("��¼����");
	BackgroundPanel bgp;
	public JTextField usernameText = new JTextField(15);
	public JTextField pwdhintText = new JTextField(15);
	public JPasswordField pwdText = new JPasswordField(15);
	boolean pwdisFocused = false;
	public JButton jb1 = new JButton();
	public JButton jb2 = new JButton();
	public JButton jb_close = new JButton();
	public JLabel stuLab = new JLabel("ѧ��");
	public JLabel teaLab = new JLabel("��ʦ");
	public JLabel admLab = new JLabel("����Ա");
	public JRadioButton jrb1 = new JRadioButton();
	public JRadioButton jrb2 = new JRadioButton();
	public JRadioButton jrb3 = new JRadioButton();
	public ButtonGroup bg=new ButtonGroup();
	private String uID = null;
	private String uPassword = null;
	private int identity = 0;
	
	public LoginView() {
		this.setLayout(null);
		this.setSize(1920,1080);         
	    this.setLocation(0, 0);
	    Font font=new Font("ƻ�� ����",Font.CENTER_BASELINE,28);
	    Font font1=new Font("ƻ�� ����",Font.LAYOUT_LEFT_TO_RIGHT,20);
	    this.add(usernameText);
	    this.add(pwdhintText);
	    this.add(pwdText);
	    this.setFocusable(true);
	    this.add(jb1);
	    this.add(jb2);
	    this.add(jb_close);
	    this.add(stuLab);
	    this.add(teaLab);
	    this.add(admLab);
	    this.add(jrb1);
	    this.add(jrb2);
	    this.add(jrb3);
	    bg.add(jrb1);
	    bg.add(jrb2);
	    bg.add(jrb3);
	    
	    usernameText.setBounds(750, 560, 425, 43);
	    usernameText.setFont(font);
	    usernameText.setBorder(null);
	    usernameText.addFocusListener(new JTextFieldHintListener(usernameText, "�û�ID"));
	    
	    pwdhintText.setBounds(750, 655, 425, 43);
	    pwdhintText.setFont(font);
	    pwdhintText.setBorder(null);
	    pwdhintText.setForeground(Color.GRAY);
	    pwdhintText.setText("����");
	    pwdhintText.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				//�����ʱ�������ı���,��ʾ�����������ȡ����		
				String temp = pwdhintText.getText();
				String hintText = "����";
				if(temp.equals(hintText)) {
					pwdhintText.setVisible(false);
					pwdText.setVisible(true);
					pwdText.requestFocus();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
	    	
	    });
	    
	    pwdText.setBounds(750, 655, 425, 43);
	    pwdText.setFont(font);
	    pwdText.setBorder(null);
	    pwdText.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				pwdisFocused = true;
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				pwdisFocused = false;
				//ʧȥ����ʱ�������û�����������ҽ��㲻��������ϣ���ʾ�ı���
				String temp = pwdText.getText().trim();
				if(temp.equals("") && pwdisFocused == false) {
					pwdhintText.setVisible(true);
					pwdhintText.setText("����");
					pwdText.setVisible(false);
				}
			}
	    });
	    
	    
	    jrb1.setBounds(753, 718, 30, 30);
	    jrb1.setSelected(true);
	    jrb1.setContentAreaFilled(false);
	    jrb1.setIcon(new ImageIcon("img\\jrbѡ��.png"));//jrb1Ĭ��ѡ��
	    jrb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				identity = 0;
				refresh();
				jrb1.setIcon(new ImageIcon("img\\jrbѡ��.png"));
			}
	    	
	    });
	    stuLab.setBounds(790, 718, 80, 30);
	    stuLab.setFont(font1);
	    
	    jrb2.setBounds(920, 718, 30, 30);
	    jrb2.setContentAreaFilled(false);
	    jrb2.setIcon(new ImageIcon("img\\jrbδѡ��.png"));
	    jrb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				identity = 1;
				refresh();
				jrb2.setIcon(new ImageIcon("img\\jrbѡ��.png"));
			}
	    	
	    });
	    teaLab.setBounds(950, 718, 80, 30);
	    teaLab.setFont(font1);
	    

	    jrb3.setBounds(1080, 718, 30, 30);
	    jrb3.setContentAreaFilled(false);
	    jrb3.setIcon(new ImageIcon("img\\jrbδѡ��.png"));
	    jrb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				identity = 2;
				refresh();
				jrb3.setIcon(new ImageIcon("img\\jrbѡ��.png"));
			}
	    	
	    });
	    admLab.setBounds(1110,718,80,30);
	    admLab.setFont(font1);
	    
	    jb_close.setBounds(1920-80, 20, 50, 50);
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
				System.exit(0);
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
	    
	    jb1.setBounds(747, 781, 150, 56);
	    jb1.setIcon(new ImageIcon("img\\ע��.png"));
	    jb1.setContentAreaFilled(false);
	    jb1.setBorder(null);
	    jb1.setPressedIcon(new ImageIcon("img\\\\ע����.png"));
	    jb1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	RegisterView RV=new RegisterView();
	        }
	    });
	    
	    jb2.setBounds(1029, 781, 150, 56);
	    jb2.setIcon(new ImageIcon("img\\��¼.png"));
	    jb2.setContentAreaFilled(false);
	    jb2.setBorder(null);
	    jb2.setPressedIcon(new ImageIcon("img\\��¼���.png"));
	    jb2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	uID = usernameText.getText();
	        	uPassword = pwdText.getText();
	        	switch(identity) {
	        	case 0://ѧ����¼
	        		StudentService SS = new StudentServiceImpl();
	        		if(SS.login("213160821","szx123")/*SS.login(uID,uPassword)*/) {
	        			LToff();
	        			InfoView_main SIV=new InfoView_main(1,SS.getCacheStudent());
	        			JOptionPane.showMessageDialog(null,"��¼�ɹ���");
	        		}
	        		else if(!SS.login(uID,uPassword)) {
	        			JOptionPane.showMessageDialog(null, "��¼ʧ�� ", "ERROR ", JOptionPane.ERROR_MESSAGE);
	        		}
	        		break;
	        	case 1://��ʦ��¼
	        		TeacherService TS = new TeacherServiceImpl();
	        		TS.register("0", "12345", "12345");
	        		if(TS.login("0","12345")/*TS.login(uID,uPassword)*/) {
	        			LToff();
	        			InfoView_main TIV=new InfoView_main(2,TS.getCacheTeacher());
	        			JOptionPane.showMessageDialog(null,"��¼�ɹ���");
	        		}
	        		else if(!TS.login(uID,uPassword)) JOptionPane.showMessageDialog(null, "��¼ʧ�� ", "ERROR ", JOptionPane.ERROR_MESSAGE);
	        		break;
	        	case 2://����Ա��½
	        		AdminService AS = new AdminServiceImpl();
	        		AS.register("1", "1234", "1234");
	        		if(AS.login("1","1234")/*AS.login(uID,uPassword)*/) {
	        			LToff();
	        			InfoView_main AIV=new InfoView_main(3,AS.getCacheAdmin());
	        			JOptionPane.showMessageDialog(null,"��¼�ɹ���");
	        		}
	        		else if(!AS.login(uID,uPassword)) JOptionPane.showMessageDialog(null, "��¼ʧ�� ", "ERROR ", JOptionPane.ERROR_MESSAGE);
	        		break;
	        	}
	        }
	    });
        
	    bgp=new BackgroundPanel((new ImageIcon("img\\��¼����.png")).getImage());
		bgp.setBounds(0,0,1920,1080);
		this.add(bgp);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		  //Dimension dimension = kit.getScreenSize();
		  //  frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		  //  frame.setBounds(0, 0, dimension.width, dimension.height);
		   
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	    this.setVisible(true);  
	    this.setResizable(true);
	}
	

	
	public void refresh() {
		jrb1.setIcon(new ImageIcon("img\\jrbδѡ��.png"));
		jrb2.setIcon(new ImageIcon("img\\jrbδѡ��.png"));
		jrb3.setIcon(new ImageIcon("img\\jrbδѡ��.png"));
	}
	
	public void LToff() {
		this.dispose();
		this.setVisible(false);
	}
	
	public static void main(String[] args) {  
		LoginView demo=new LoginView();  
    }
}

class BackgroundPanel extends JPanel{
	Image im;
	public BackgroundPanel(Image im)
	{
		this.im=im;
		this.setOpaque(true);
	}
	//Draw the back ground.
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
	}
}