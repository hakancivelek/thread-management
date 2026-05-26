package blockingio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(8080)) {
            while (true) {
                Socket socket = server.accept();

                // each request is handled in a separate thread
                new Thread(() -> handle(socket)).start();
            }
        }
    }

    private static void handle(Socket socket) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

            String data = reader.readLine();
            // blocks this thread if no data is available

            writer.println("Echo: " + data);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}