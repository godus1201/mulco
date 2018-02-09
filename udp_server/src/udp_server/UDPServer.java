package udp_server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class UDPServer {

	private static void showTime() {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HHmmss") ;
		
		long date = System.currentTimeMillis();
		int offset = TimeZone.getDefault().getOffset(date);
		long microseconds = System.nanoTime() / 1000 ;
		
		System.out.println(dateFormat.format(System.currentTimeMillis()) +" "+ microseconds%1000000);
	
	}
    	
	public static void main(String[] args) throws Exception{
		
		//showTime();
		
		InetAddress IPAddress = InetAddress.getByName("localhost");
		int server_port = 1234;
		//int client_port = 1235;

		DatagramSocket serverSocket = new DatagramSocket(server_port);
		
		//byte[] receiveData = new byte[1024];
	    byte[] sendData = new byte[1024];
	    
	    BufferedReader br = new BufferedReader(new FileReader(new File("2.IMDV2")));
	    
	    while((sendData = br.readLine().getBytes()) != null){
	    
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 1235);
			serverSocket.send(sendPacket);
			
			Thread.sleep(100);
			
	    }
	    
	    br.close();
	    serverSocket.close();
	}
}
