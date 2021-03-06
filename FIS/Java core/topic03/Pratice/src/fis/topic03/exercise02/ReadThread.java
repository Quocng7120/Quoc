package fis.topic03.exercise02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadThread extends Thread{
	 private BufferedReader reader;
	    private Socket socket;
	    private ChatClient client;
	 
	    public ReadThread(Socket socket, ChatClient client) {
	        this.socket = socket;
	        this.client = client;
	 
	        try {
	            InputStream input = socket.getInputStream();
	            reader = new BufferedReader(new InputStreamReader(input));
	        } catch (IOException ex) {
	            System.out.println("Error getting input stream: " + ex.getMessage());
	            ex.printStackTrace();
	        }
	    }
	 
	    public void run() {
	        while (true) {
	            try {
	                String response = reader.readLine();
	                String[] s=response.split("/");
	                for (int i = 0; i < s.length; i++) {
	                	System.out.println(s[i]);
					}
	                if (client.getUserName() != null) {
	                    System.out.print("[" + client.getUserName() + "]: ");
	                }
	            } catch (IOException ex) {
	                System.out.println("Error reading from server: " + ex.getMessage());
	                ex.printStackTrace();
	                break;
	            }
	        }
	    }
}
