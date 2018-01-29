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

/**
 *
 * @author Marco
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    static final int PORTCLIENT = 5000;
    static final int PORTSERVER = 5000;
    static final int TIMEOUT = 5000;

    public static void main(String[] args) throws IOException {
        //InetAddress addrClient = InetAddress.getByName("192.168.4.19");
        //InetAddress addrServer = InetAddress.getByName("192.168.4.20");
        boolean received = false;
        byte[] buffer = new byte[8];
        DatagramSocket server;
        DatagramPacket pack = new DatagramPacket(buffer, 8);
        try {
            server = new DatagramSocket(PORTCLIENT); //da cambiare in PORTSERVER
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
                System.out.println("Received something from: " + pack.getAddress().getHostAddress());
                System.out.println("Data: " + Arrays.toString(pack.getData()));
                received = false;
            } while (true);
        } catch (SocketException e) {
            System.out.println(e.getMessage());
        }
    }
}
