/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserverudp;

import com.sun.security.ntlm.Client;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco
 */
public class Rilevatore {

	/**
	 * @param args the command line arguments
	 */
	static final int PORT = 5000;
	static final int TIMEOUT = 5;

	public static void main(String[] args) throws SocketException, UnknownHostException, IOException, InterruptedException {
		InetAddress addr = InetAddress.getByName("192.168.4.21");
		DatagramSocket client;
		Auto macchina = new Auto("Jiji");
		byte[] buffer = new byte[8];
		//test
		//byte[] lol=new byte[2];
		DatagramPacket pack;
		for (int i = 0; i < 100; i++) {
			try {
				refresh(macchina);
				buffer=macchina.toByte();
				pack= new DatagramPacket(buffer, buffer.length);
				//toByte(macchina, buffer);
				/*test
				*	lol[0]=0;
				*	lol[1]=1;
				*/
				client = new DatagramSocket();
				System.out.println("Socket aperto...");
				try {
					pack.setAddress(addr);
					System.out.println(addr);
					pack.setPort(PORT);
					client.send(pack);
					System.out.println("Sent frmae...");
					TimeUnit.SECONDS.sleep(TIMEOUT);
				} catch (IOException e) {
					System.out.println("Transmission error...");
				}
			} catch (SocketException ex) {
				Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	private static void refresh(Auto macchina) {
		macchina.latitudine = macchina.generaLatitudine();
		macchina.longitudine = macchina.generaLongitudine();
		macchina.data = macchina.generaData();
		macchina.ora = macchina.generaOra();
	}

	/*private static byte[] toByte(Auto macchina, byte[] buffer) {
		buffer[0] = (byte) macchina.latitudine;
		buffer[1] = (byte) macchina.longitudine;
		buffer[2] = (byte) macchina.data[0];
		buffer[3] = (byte) macchina.data[1];
		buffer[4] = (byte) macchina.data[2];
		buffer[5] = (byte) macchina.ora[0];
		buffer[6] = (byte) macchina.ora[1];
		buffer[7] = (byte) macchina.ora[2];
		return buffer;
	}*/
}
