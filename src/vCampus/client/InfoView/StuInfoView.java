package vCampus.client.InfoView;
/**
 * @author CC
 * 
 * @date 8.27
 *
 */
import javax.swing.*;

import vCampus.client.register.RegisterView;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;

public class StuInfoView extends JFrame{
	JFrame frame = new JFrame("��ʦ��Ϣ");
	BackgroundPanel bgp;
	JLabel lb1 = new JLabel("һ��ͨ");
	JTextField tf1 = new JTextField(20);
	JLabel lb2 = new JLabel("����");
	JTextField tf2 = new JTextField(20);
	JLabel lb3 = new JLabel("�Ա�");
	JTextField tf3 = new JTextField(20);
	JLabel lb4 = new JLabel("���֤��");
	JTextField tf4 = new JTextField(20);
	JLabel lb5 = new JLabel("Ժϵ");
	JTextField tf5 = new JTextField(20);
	JLabel lb6 = new JLabel("רҵ");
	JTextField tf6 = new JTextField(20);
	JLabel lb7 = new JLabel("�༶");
	JTextField tf7 = new JTextField(20);
	JLabel lb8 = new JLabel("�����");
	JTextField tf8 = new JTextField(20);
	JLabel lb9 = new JLabel("�ֻ�");
	JTextField tf9 = new JTextField(20);
	JLabel lb10 = new JLabel("����");
	JTextField tf10 = new JTextField(20);
	JButton jb1 = new JButton();
	JButton jb2 = new JButton();
	JButton jb3 = new JButton();
	JButton jb4 = new JButton();
	JButton jb5 = new JButton();
	JButton jb6 = new JButton();
	JButton jb7 = new JButton();
	JButton jb8 = new JButton();
	
	public StuInfoView() {
	this.setLayout(null);
	this.setSize(1920,1080);         
    this.setLocation(0, 0);
    Font font=new Font("ƻ�� ����",Font.CENTER_BASELINE,28);//���������ʽ�ʹ�С
    this.add(lb1);
    lb1.setBounds(456, 196, 101, 47);
    lb1.setFont(font);
    this.add(tf1);
    tf1.setBounds(660, 196, 352, 47);
    tf1.setFont(font);
    tf1.setEditable(false);
    tf1.setBorder(null);

    this.add(lb2);
    lb2.setBounds(1156, 196, 101, 47);
    lb2.setFont(font);
    this.add(tf2);
    tf2.setBounds(1360, 196, 352, 47);
    tf2.setFont(font);
    tf2.setEditable(false);
    tf2.setBorder(null);
    
    this.add(lb3);
    lb3.setBounds(456, 307, 101, 47);
    lb3.setFont(font);
    this.add(tf3);
    tf3.setBounds(660, 307, 352, 47);
    tf3.setFont(font);
    tf3.setEditable(false);
    tf3.setBorder(null);
    
    this.add(lb4);
    lb4.setBounds(1156, 307, 150, 47);
    lb4.setFont(font);
    this.add(tf4);
    tf4.setBounds(1360, 307, 352, 47);
    tf4.setFont(font);
    tf4.setEditable(false);
    tf4.setBorder(null);
    
    this.add(lb5);
    lb5.setBounds(456, 418, 101, 47);
    lb5.setFont(font);
    this.add(tf5);
    tf5.setBounds(660, 418, 352, 47);
    tf5.setFont(font);
    tf5.setEditable(false);
    tf5.setBorder(null);
    
    this.add(lb6);
    lb6.setBounds(1156, 418, 101, 47);
    lb6.setFont(font);
    this.add(tf6);
    tf6.setBounds(1360, 418, 352, 47);
    tf6.setFont(font);
    tf6.setEditable(false);
    tf6.setBorder(null);
    
    this.add(lb7);
    lb7.setBounds(456, 529, 101, 47);
    lb7.setFont(font);
    this.add(tf7);
    tf7.setBounds(660, 529, 352, 47);
    tf7.setFont(font);
    tf7.setEditable(false);
    tf7.setBorder(null);
    
    this.add(lb8);
    lb8.setBounds(1156, 529, 101, 47);
    lb8.setFont(font);
    this.add(tf8);
    tf8.setBounds(1360, 529, 352, 47);
    tf8.setFont(font);
    tf8.setEditable(false);
    tf8.setBorder(null);
    
    this.add(lb9);
    lb9.setBounds(456, 640, 101, 47);
    lb9.setFont(font);
    this.add(tf9);
    tf9.setBounds(660, 640, 352, 47);
    tf9.setFont(font);
    tf9.setEditable(false);
    tf9.setBorder(null);
    
    this.add(lb10);
    lb10.setBounds(1156, 640, 101, 47);
    lb10.setFont(font);
    this.add(tf10);
    tf10.setBounds(1360, 640, 352, 47);
    tf10.setFont(font);
    tf10.setEditable(false);
    tf10.setBorder(null);
    
    this.add(jb1);
    jb1.setBounds(0, 80, 270, 80);
    jb1.setFont(font);
    jb1.setIcon(new ImageIcon("img\\��ѯ��Ϣ.png"));
    this.add(jb2);
    jb2.setBounds(0, 160, 270, 80);
    jb2.setFont(font);
    jb2.setIcon(new ImageIcon("img\\�޸���Ϣ.png"));
    
    this.add(jb3);
    jb3.setBounds(270, 0, 250, 78);
    jb3.setFont(font);
    // ���ð�ť��Ĭ��ͼƬ
    jb3.setIcon(new ImageIcon("img\\���˳���.png"));
    // ���ð�ť�����ʱ��ͼƬ
    //jb3.setPressedIcon(new ImageIcon("img\\���˵��.png"));
    jb3.setBorder(null);
    // ��Ӱ�ť����¼�������
    jb3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	refresh();
        	jb3.setIcon(new ImageIcon("img\\���˵��.png"));
        }
    });
    
    this.add(jb4);
    jb4.setBounds(520, 0, 250, 78);
    jb4.setFont(font);
    // ���ð�ť��Ĭ��ͼƬ
    jb4.setIcon(new ImageIcon("img\\���г���.png"));
    jb4.setBorder(null);
    // ��Ӱ�ť����¼�������
    jb4.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	refresh();
        	jb4.setIcon(new ImageIcon("img\\���е��.png"));
        }
    });
    
	bgp=new BackgroundPanel((new ImageIcon("img\\bgp.png")).getImage());
	bgp.setBounds(0,0,1920,1080);
	this.add(bgp);
	
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    this.setVisible(true);  
    this.setResizable(true);
	}
	
	public void refresh() {
		jb3.setIcon(new ImageIcon("img\\���˳���.png"));
		jb4.setIcon(new ImageIcon("img\\���г���.png"));
		jb5.setIcon(new ImageIcon("img\\ͼ�鳣��.png"));
		jb6.setIcon(new ImageIcon("img\\�̵곣��.png"));
		jb7.setIcon(new ImageIcon("img\\���񳣹�.png"));
		jb8.setIcon(new ImageIcon("img\\ҽԺ����.png"));
	}
	
	public static void main(String[] args) {  
		StuInfoView SIV=new StuInfoView();  
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