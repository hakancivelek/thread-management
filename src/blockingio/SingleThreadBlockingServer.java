package blockingio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadBlockingServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(8080)) {
            while (true) {
                Socket socket = server.accept();
                handle(socket); // blocking I/O, single thread execution
            }
        }
    }

    private static void handle(Socket socket) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

            String data = reader.readLine(); // blocks if no data is available from the client

            writer.println("Echo: " + data);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}