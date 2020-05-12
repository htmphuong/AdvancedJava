package Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer extends Thread {
	ServerSocket serverSK;
	public ChatServer(int port) throws IOException{
		serverSK = new ServerSocket(9000);
	}
	public void run() {
		try {
			while(true) {
				Socket skServer= serverSK.accept();
				System.out.println("Connecting from:"+skServer.getRemoteSocketAddress());
				//nhan du lieu
				DataInputStream inputChuoi = new DataInputStream(skServer.getInputStream());
				System.out.print("Client:"+inputChuoi.readUTF());
				
				//gui du leiu di
				System.out.print("Server:");
				DataOutputStream outChuoi = new DataOutputStream(skServer.getOutputStream());
				Scanner key = new Scanner(System.in);
				String chuoiGui = key.nextLine();				
				outChuoi.writeUTF(chuoiGui+"\n");
				outChuoi.close();
				skServer.close();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Thread t = new ChatServer(9000);
			t.start();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
