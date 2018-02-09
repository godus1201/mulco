package udp_client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPClient {

	
	public static void main(String[] args) throws Exception {
		
	    //InetAddress IPAddress = InetAddress.getByName("localhost");
	    //int server_port = 1234;
	    int client_port = 1235;
	    
	    DatagramSocket clientSocket = new DatagramSocket(client_port);
	    
		//byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
      
		while(true) {
			
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			clientSocket.receive(receivePacket);
			String data = new String(receivePacket.getData());
			
			System.out.println(data);
            
		}
		
		//clientSocket.close();
	}
}
