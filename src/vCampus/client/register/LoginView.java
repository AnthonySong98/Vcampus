package vCampus.client.register;
/**
 * @author CC
 * 
 * @date 8.31
 *
 */

import javax.swing.*;

import vCampus.client.biz.StudentService;
import vCampus.client.biz.StudentServiceImpl;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class LoginView extends JFrame{
	JFrame frame = new JFrame("��¼����");
	BackgroundPanel bgp;
	public JTextField usernameText = new JTextField(15);
	public JTextField pwdhintText = new JTextField(15);
	public JPasswordField pwdText = new JPasswordField(15);
	public JButton jb1 = new JButton();
	public JButton jb2 = new JButton();
	public JLabel stuLab = new JLabel("ѧ��");
	public JLabel teaLab = new JLabel("��ʦ");
	public JLabel manLab = new JLabel("����Ա");
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
	    this.add(usernameText);
	    this.add(pwdText);
	    this.setFocusable(true);
	    this.add(jb1);
	    this.add(jb2);
	    this.add(stuLab);
	    this.add(teaLab);
	    this.add(manLab);
	    this.add(jrb1);
	    this.add(jrb2);
	    this.add(jrb3);
	    bg.add(jrb1);
	    bg.add(jrb2);
	    bg.add(jrb3);
	    
	    usernameText.setBounds(750, 560, 425, 48);
	    usernameText.setFont(font);
	    usernameText.setBorder(null);
	    usernameText.addFocusListener(new JTextFieldHintListener(usernameText, "�û�ID"));
 
	    pwdText.setBounds(750, 655, 425, 48);
	    pwdText.setFont(font);
	    pwdText.setBorder(null);
	    pwdText.addFocusListener(new JTextFieldHintListener(pwdText, "******"));
	    
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
	    jb2.setIcon(new ImageIcon("img\\��½1.png"));
	    jb2.setContentAreaFilled(false);
	    jb2.setBorder(null);
	    jb2.setPressedIcon(new ImageIcon("img\\\\��½1���.png"));
	    jb2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	uID = usernameText.getText();
	        	uPassword = pwdhintText.getText();
	        	switch(identity) {
	        	case 0:
	        		StudentService SS = new StudentServiceImpl();
	        		if(SS.login(uID,uPassword))
	        			JOptionPane.showMessageDialog(null,"��¼�ɹ���");
	        		else if(!SS.login(uID,uPassword)) JOptionPane.showMessageDialog(null, "�˺Ż�������� ", "��¼ʧ�� ", JOptionPane.ERROR_MESSAGE);
	        		break;
	        	case 1:
	        		break;
	        	case 2:
	        		break;
	        	}
	        }
	    });
	    
	    stuLab.setBounds(753, 718, 80, 30);
	    jrb1.setBounds(800, 718, 30, 30);
	    jrb1.setSelected(true);
	    jrb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				identity = 0;
			}
	    	
	    });
	    teaLab.setBounds(850, 718, 80, 30);
	    jrb2.setBounds(900, 718, 30, 30);
	    jrb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				identity = 1;
			}
	    	
	    });
	    manLab.setBounds(950,718,80,30);
	    jrb3.setBounds(1000, 718, 30, 30);
	    jrb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				identity = 2;
			}
	    	
	    });
        
	    bgp=new BackgroundPanel((new ImageIcon("img\\��¼����.png")).getImage());
		bgp.setBounds(0,0,1920,1080);
		this.add(bgp);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    this.setVisible(true);  
	    this.setResizable(true);
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