package vCampus.client.JWC;
/**
* @author Yanhao Shen
* @version ����ʱ�䣺2018��9��8�� ����5:16:17
* ��˵��
*/
/*
 * 
 * ��������ʾ��ˮ��ʾ
 * 
 * 
 * ���ܣ�ʹ��JTextArea �� JTextField �����������
 * ���ڣ�JTextArea ��
 * JTextArea ����һ������ʾ���ı��Ķ�������
 * ���췽����   JTextArea();
 * �ڲ���Ա������   void  append(String str); // �������ı�׷�ӵõ��ĵ��Ľ�β��
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;

 

public class JT_area extends JFrame 
{
JScrollPane jsp=null;
JTextArea   jta=null;
JTextField  jtf=null;



JButton jb=null;
JPanel   jp=null;
JViewport vp=null;

JButton jb2=new JButton("��ť");
public JProgressBar progressbar; 
public JProgressBar progressbar2;

public JT_area()
{
// ���尴ť

jp=new JPanel();
 
 // �����������
jta=new JTextArea();

jtf=new JTextField(20);



progressbar = new JProgressBar();
// ��ʾ��ǰ����ֵ��Ϣ
progressbar.setStringPainted(true);
// ���ý������߿���ʾ
//progressbar.setBorderPainted(false);
// ���ý�������ǰ��ɫ
//progressbar.setForeground(new Color(0, 210, 40));
progressbar.setForeground(new Color(0, 0, 0));
// ���ý������ı���ɫ
progressbar.setBackground(new Color(188, 190, 194));
progressbar.setBounds(0,  100, 200, 15);
// ������


progressbar2 = new JProgressBar();
// ��ʾ��ǰ����ֵ��Ϣ
progressbar2.setStringPainted(true);
// ���ý������߿���ʾ
//progressbar.setBorderPainted(false);
// ���ý�������ǰ��ɫ
progressbar2.setForeground(new Color(0, 210, 40));
// ���ý������ı���ɫ
progressbar2.setBackground(new Color(188, 190, 194));
progressbar2.setBounds(0,  200, 200, 15);
// ������

jta.add(progressbar);
jta.add(progressbar2);


jta.add(jb2);
jb2.setBounds(20, 20, 40, 40);

jta.setPreferredSize(new Dimension(400,400)); // ʹ������һ��󣬾Ϳ�����ʾ�������ˡ�
/*
* ֮���Բ���ʾ����������ԭ��
* ��Ҫ�������룬����panel����ѡ��С��ͬʱ��֤��ߴ���JScrollPane�Ŀ�ߣ����������JScrollPane�Ż���ֹ�����
*����ֻ�е����ڣ�JScrollPane ֮�е����������ʾ�Ŀ�͸ߴ���JScrollPane �Ŀ�͸�ʱ���Ż���ʾ�������� 
* 
* 
* */

jsp=new JScrollPane(jta);

jsp.validate();
 
jp.add(jtf);
 


this.add(jsp,"Center");
this.add(jp,"South");


Thread t1 = new Thread(){
	

	int r = 255;
	int g = 0;
	int b = 0;

	
 	public void run() {
    	int goal=80;

		for (int i = 0; i <=goal; i++) {
			try {
				Thread.sleep(1200/goal);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (g != 255) {
				g += 5;
			} else {
				r -= 5;
			}
			
			Color color = new Color(r, g, b);
			progressbar.setBackground(color);
		//	jtar.progressbar.setDigitalColor(color);
			
			
			progressbar.setValue(i);
		}
    }
};

Thread t2 = new Thread(){
 	public void run() {
    	int goal=60;
		
		for (int i = 0; i <=goal; i++) {
			try {
				Thread.sleep(1200/goal);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			progressbar2.setValue(i);
		}
    }
};

t1.start();
t2.start();

// ���ÿ��

this.setLocation(300, 300);
this.setSize(800,800);

this.setTitle("����Ի���");
this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
this.setVisible(true);


}

	public static void main(String[] args)
	{
		JT_area jtar=new JT_area();
	 
	}

}