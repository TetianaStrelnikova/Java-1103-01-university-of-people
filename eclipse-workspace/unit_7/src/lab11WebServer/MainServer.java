package lab11WebServer;
// please kindly provide your own data for root directory and file you would like to send
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) {
        int port = 8083; // Specify the port number for the server socket

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on 127.0.0.1:" + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New connection from " + clientSocket.getInetAddress());

                ConnectionThread thread = new ConnectionThread(clientSocket);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ConnectionThread extends Thread {
        Socket connection;

        ConnectionThread(Socket connection) {
            this.connection = connection;
        }

        public void run() {
            String root_directory = "C:\\Users\\strel\\Downloads";
            ConnectionHandler connectionHandler = new ConnectionHandler(root_directory);
            connectionHandler.handleConnection(connection);
        }
    }}