package vCampus.server.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author SongZixing
 *
 * @version 0.0
 * 
 */
public class Server implements Runnable{
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
            ServerSocket serverSocket = new ServerSocket(18888);
            System.out.println("��������������ȴ��ͻ�������..");

            while (true) {
                Socket socket = serverSocket.accept();// ���������ܵ����׽��ֵ�����,����һ��Socket����
                ServerSocketThread socketThread = new ServerSocketThread(socket);
                socketThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
}
