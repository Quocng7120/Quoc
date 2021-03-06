package fis.topic03.exercise02;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class WriteThread extends Thread{
	private PrintWriter writer;
    private Socket socket;
    private ChatClient client;
 
    public WriteThread(Socket socket, ChatClient client) {
        this.socket = socket;
        this.client = client;
 
        try {
            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);
        } catch (IOException ex) {
            System.out.println("Error getting output stream: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
 
    public void run() {
 
        Scanner sc=new Scanner(System.in);
 
        String text;
 
        do {
        	System.out.println("Nhap Cau Hoi : ");
            text = sc.nextLine();
            writer.println(text);
            try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("Nhap So Cau Hoi Ban Muon : ");
            text = sc.nextLine();
            writer.println(text);
            try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } while (!text.equals("bye"));
 
        try {
            socket.close();
        } catch (IOException ex) {
 
            System.out.println("Error writing to server: " + ex.getMessage());
        }
    }
}
