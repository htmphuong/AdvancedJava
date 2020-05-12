package Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			while(true) {
				Socket skClient = new Socket("192.168.4.152", 9000);
				//gui du lieu
				System.out.print("Client:");
				DataOutputStream outChuoi = new DataOutputStream(skClient.getOutputStream());
				Scanner key = new Scanner(System.in);
				String chuoiGui = key.nextLine();				
				outChuoi.writeUTF(chuoiGui+"\n");
				// nhan du lieu
				DataInputStream inputChuoi = new DataInputStream(skClient.getInputStream());
				System.out.print("Server:"+inputChuoi.readUTF());
				outChuoi.close();
				inputChuoi.close();
				skClient.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
