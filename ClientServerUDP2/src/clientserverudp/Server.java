/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserverudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Marco
 */
public class Server {

	/**
	 * @param args the command line arguments
	 */
	static final int PORT = 5000;
	static final int TIMEOUT = 5000;

	public static void main(String[] args) throws IOException, InterruptedException {
		InetAddress addrClient1 = InetAddress.getByName("192.168.4.19");
		InetAddress addrClient2 = InetAddress.getByName("192.168.4.22");
		boolean received = false;
		byte[] buffer = new byte[2];
		DatagramSocket server;
		DatagramPacket pack = new DatagramPacket(buffer, buffer.length);
		Auto autoBella = new Auto();
		try {
			server = new DatagramSocket(PORT);
			System.out.println("Socket opened...");
			server.setSoTimeout(TIMEOUT);
			do {
				do {
					try {
						server.receive(pack);
						received = true;
					} catch (java.net.SocketTimeoutException e) {
						System.out.println(e.getMessage());
					}
				} while (!received);                             //InetAddress
				System.out.println("Received something from: " + addrClient1);
				System.out.println("Data: " + Arrays.toString(pack.getData()));
				received = false;
				
				//invio pacchetto al secondo client
				pack.setAddress(addrClient2);
				System.out.println(addrClient2);
				pack.setPort(PORT);
				server.send(pack);
				System.out.println("Sent frmae to second client..." + addrClient2);
				TimeUnit.SECONDS.sleep(TIMEOUT);
				
			} while (true);
		} catch (SocketException e) {
			System.out.println(e.getMessage());
		}
	}
}
