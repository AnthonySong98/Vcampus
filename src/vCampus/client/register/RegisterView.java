package vCampus.client.register;
/**
 * @author CC
 * 
 * @date 8.24
 *
 */

import javax.swing.*;

import vCampus.client.socket.Client;
import vCampus.client.socket.ClientRequest;
import vCampus.client.biz.StudentService;

import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener; 

public class RegisterView extends JFrame{
	/**
	 *v0.0 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame = new JFrame("�û�ע��");
	public JLabel nameLab = new JLabel("�û���");
	public JLabel passLab1 = new JLabel("����");
	public JLabel passLab2 = new JLabel("ȷ������");
	public JTextField nameText = new JTextField(15);;
	public JPasswordField pwdText1 = new JPasswordField(15);
	public JPasswordField pwdText2 = new JPasswordField(15);
	public JButton registerButton = new JButton("ȷ��ע��");
	public JPanel buttonPan = new JPanel();
	String uID = null;
	String uPassword = null;
	
	public RegisterView() {
		
		//���ü���
		registerButton.addActionListener(new registerActionPerformed());
		//����JFrame��
		this.add(nameLab);
		this.add(nameText);
		this.add(passLab1);
		this.add(pwdText1);
		this.add(passLab2);
		this.add(pwdText2);
		buttonPan.add(registerButton);
		this.add(buttonPan);
		//���ֹ���
		this.setTitle("ע��");          
        this.setSize(400,300);         
        this.setLocation(600, 300);
        nameLab.setBounds(40, 20, 60, 30);
        nameText.setBounds(120, 20, 180, 30);
        passLab1.setBounds(40, 80, 60, 30);
        pwdText1.setBounds(120, 80, 180, 30);
        passLab2.setBounds(40,140,60,30);
        pwdText2.setBounds(120, 140, 180, 30);
        buttonPan.setBounds(150, 200, 100, 50);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //���õ��رմ���ʱ����֤JVMҲ�˳� 
        this.setVisible(true);  
        this.setResizable(true);
	}
	
	public class registerActionPerformed implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(pwdText1.getText().trim().equals(pwdText2.getText().trim())) {
				uID = nameText.getText();
				uPassword = pwdText1.getText();
				/*StudentService SS = null;
				SS.login(uID,uPassword);*/
				if(true) {
					ImageIcon icon = new ImageIcon("img/frisk.jpg");
					JOptionPane.showMessageDialog(null, "ע��ɹ�","��ʾ�Ի���",1,icon);
				}
			}else {
				ImageIcon icon = new ImageIcon("img/frisk.jpg");
				JOptionPane.showMessageDialog(null, "���벻һ��","��ʾ�Ի���",1,icon);
			}
		}
	}
	
	public static void main(String[] args) {  
        RegisterView RV=new RegisterView();  
    }
}