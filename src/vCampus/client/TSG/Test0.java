package vCampus.client.TSG;


import javax.swing.*;  
import java.awt.*;  

public class Test0 extends JFrame{  
  JList jlist;    //�б��  
  JComboBox jcb;  //������  
  JPanel jp1, jp2;    //���  
  JLabel jlb1, jlb2;  
  JScrollPane jsp;    //�����ؼ�  
    
  //���캯��  
  public Test0(){  
        
        
        
      jlb1 = new JLabel("���ˮƽ��");  
      String str1[] = {"�޿�", "����", "һ��", "����"};  
      jcb = new JComboBox(str1);  
        
      jlb2 = new JLabel("ѡ��Ӣ�ۣ�");  
      String str2[] = {"����", "��ϣ", "��Ī", "����", "����", "����"};  
      jlist = new JList(str2);  
      jlist.setBounds(200, 200, 100, 100);
      jlist.setVisibleRowCount(2);//Ĭ����ʾ����  
      jsp = new JScrollPane(jlist);  
        
      //this.add(jlb1);  
      //this.add(jcb);  
        
      this.add(jlb2);  
      this.add(jsp);  
        
          //���񲼾�2��һ��  
      this.setLayout(new GridLayout(2, 1));  
        
      this.add(jp1);  
        
        
      this.setSize(1000,1000);  
      this.setTitle("�����ʾ");  
      this.setVisible(true);  
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  }  
    
  public static void main(String[] args) {  
      Test0 test0 = new Test0();  

  }  

}  