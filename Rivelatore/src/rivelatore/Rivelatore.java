/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivelatore;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author stoyan.botusharov
 */
public class Rivelatore {
	public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
		InetAddress addr = InetAddress.getByName("192.168.4.20");
		final int PORT = 5000;

		DatagramSocket socket = new DatagramSocket(3000);
		socket.setSoTimeout(30000);

		Auto macchina = new Auto("Jiji");
		macchina.updateCoordinates();
		int intervallo = 1000;
		while (true) {
			try {
				DatagramPacket pack = new DatagramPacket(macchina.toByte(), macchina.toByte().length, addr, PORT);
				socket.send(pack);
				Thread.sleep(intervallo);
				macchina.updateCoordinates();
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
	}
}
