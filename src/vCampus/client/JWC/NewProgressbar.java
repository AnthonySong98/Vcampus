package vCampus.client.JWC;

import java.awt.Color;

import javax.swing.JProgressBar;

public class NewProgressbar {
	
	public JProgressBar progressbar;

	public NewProgressbar(int index,int goal){
	
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
	progressbar.setBounds(100+100*index,  100, 200, 15);
	// ������
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

	
	}
	
}
