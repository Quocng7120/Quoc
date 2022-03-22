package fis.topic03.exercise02;

public class ServerControl {
	public static void main(String[] args) { 
        int port = 7770;
        ChatServer server = new ChatServer(port);
        server.execute();
    }
}
