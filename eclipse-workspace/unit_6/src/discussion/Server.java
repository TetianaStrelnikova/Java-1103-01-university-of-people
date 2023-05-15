package discussion;

import java.io.IOException;
import java.util.Scanner;
import java.net.Socket;
import java.net.ServerSocket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket myServer = new ServerSocket(8080);
			Socket input = myServer.accept();
			Scanner clientSays = new Scanner(input.getInputStream());
			while (clientSays.hasNext()) {
				System.out.println(clientSays.nextLine());
			}
			input.close();
			clientSays.close();
			myServer.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
