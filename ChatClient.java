package GT;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String serverName = "192.168.48.194"; 
	      int port = 6070; // Integer.parseInt(args[1]);
	      while(true) {
	      try {
	        // System.out.println("Connecting to " + serverName + " on port " + port);
	         Socket skClient = new Socket(serverName, port);//localhost
	         //gui du lieu di
	         DataOutputStream outData = new DataOutputStream(skClient.getOutputStream());
	         System.out.println("Client:");
	         Scanner key = new Scanner(System.in);
	         String clientChuoi = key.nextLine();
	         outData.writeUTF(clientChuoi);
	         
	         //nhan du lieu ve
	         DataInputStream inputData = new DataInputStream(skClient.getInputStream());
	         System.out.println("Server:"+inputData.readUTF());
	         outData.close();
	         inputData.close();
	         skClient.close();
	        
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      }
	}

	}
