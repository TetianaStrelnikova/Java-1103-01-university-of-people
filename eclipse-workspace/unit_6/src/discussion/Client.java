package discussion;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		try {
			Socket client = new Socket("127.0.0.1", 8080);
			PrintWriter clientSays = new PrintWriter(client.getOutputStream());
			clientSays.println("Hello! I am Tati, new client!");
			clientSays.close();
			client.close();
		} catch (IOException e) {
			System.out.println("IOE Exeption" + e.getMessage());
		}

	}

}
