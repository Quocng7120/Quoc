package fis.topic03.exercise02;

public class ClientControl {
	public static void main(String[] args) {
      String hostname = "localhost";
      int port = 7770;
      ChatClient client = new ChatClient(hostname, port);
      client.execute();
	}
}
