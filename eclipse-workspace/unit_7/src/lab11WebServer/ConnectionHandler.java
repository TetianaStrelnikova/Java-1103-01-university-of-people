package lab11WebServer;

import java.io.*;
import java.net.Socket;

public class ConnectionHandler {

	private String rootDirectory;

	public ConnectionHandler(String rootDirectory) {
		this.rootDirectory = rootDirectory;
	}

	public void handleConnection(Socket socket) {
		InputStream inputStream = null;
		OutputStream outputStream = null;

		try {
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();

			// Read request from the input stream
			String request = readRequest(inputStream);

			// Parse the request to extract the file path
			String filePath = extractFilePath(request);

			// Validate the file path
			if (filePath == null) {
				sendErrorResponse(outputStream, "Invalid request");
				return;
			}

			// Create a file object representing the requested file
			File file = new File(rootDirectory + filePath);

			// Check if the file exists and is readable
			if (!file.exists() || !file.canRead()) {
				sendErrorResponse(outputStream, "File not found");
				return;
			}

			// Send the file in the response
			sendFileResponse(outputStream, file);
		} catch (IOException e) {
			// Handle any IO exception
			e.printStackTrace();
		} finally {
			// Close the input stream, output stream, and the socket
			try {
				if (inputStream != null)
					inputStream.close();
				if (outputStream != null)
					outputStream.close();
				socket.close();
			} catch (IOException e) {
				// Handle any exception that occurs while closing resources
				e.printStackTrace();
			}
		}
	}

	private String readRequest(InputStream inputStream) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		return reader.readLine();
	}

	private String extractFilePath(String request) {
		String[] tokens = request.split(" ");
		if (tokens.length >= 3 && tokens[0].equals("GET")) {
			return tokens[1];
		}
		return null;
	}

	private void sendFileResponse(OutputStream outputStream, File file) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] buffer = new byte[1024];
		int bytesRead;

		try {
			// Send HTTP response headers
			String responseHeaders = "HTTP/1.1 200 OK\r\n" + "Content-Type: application/octet-stream\r\n"
					+ "Content-Length: " + file.length() + "\r\n\r\n";
			outputStream.write(responseHeaders.getBytes());

			// Send the file data
			while ((bytesRead = fileInputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
		} finally {
			fileInputStream.close();
		}
	}

	private void sendErrorResponse(OutputStream outputStream, String message) throws IOException {
		String response = "HTTP/1.1 400 Bad Request\r\n" + "Content-Type: text/plain\r\n" + "Content-Length: "
				+ message.length() + "\r\n\r\n" + message;
		outputStream.write(response.getBytes());
	}

	
}

// telnet localhost 8083
//GET /poem.txt HTTP/1.1