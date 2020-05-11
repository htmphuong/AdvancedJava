package GT;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class ChatServer extends Thread {
	private ServerSocket serverSK;
	public ChatServer(int port) throws IOException{
		serverSK = new ServerSocket(port);
	}
	public void run() {
		 while(true) {
	         try {
	            //System.out.println("Waiting for client on port " + 
	             //  serverSocket.getLocalPort() + "...");
	            Socket skServer = serverSK.accept();
	            
	            System.out.println("Just connected to " + skServer.getRemoteSocketAddress());
	            //nhan du lieu
	            DataInputStream inputData = new DataInputStream(skServer.getInputStream());
	            System.out.println("Client:"+inputData.readUTF());
	            
	            //gui dieu di
	            System.out.println("Server:");
		        Scanner key = new Scanner(System.in);
		        String serverChuoi = key.nextLine();
		        DataOutputStream outputData = new DataOutputStream(skServer.getOutputStream());
		        outputData.writeUTF(serverChuoi);
		        inputData.close();
		        outputData.close();
	            skServer.close();
	            
	             
	         } catch (SocketTimeoutException s) {
	            System.out.println("Socket timed out!");
	            break;
	         } catch (IOException e) {
	            e.printStackTrace();
	            break;
	         }
	      }
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
	         Thread t = new ChatServer(6070);
	         t.start();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
		   
	}
}
