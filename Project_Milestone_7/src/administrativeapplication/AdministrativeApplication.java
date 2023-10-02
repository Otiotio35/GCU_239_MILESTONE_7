package administrativeapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;  // Import the Files class
import java.nio.file.Paths;  // Import the Paths class

// ... (rest of your code)

public class AdministrativeApplication {

    // Constants for server connection and retry configuration
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8899;
    private static final int MAX_RETRIES = 3;
    private static final int RETRY_INTERVAL_MS = 2000; // 2 seconds

    public static void main(String[] args) {
        for (int i = 0; i < MAX_RETRIES; i++) {
            try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                // Command to Update with the pipe separator
                String commandUpdate = "U|";
                String fileContent = new String(Files.readAllBytes(Paths.get("InFile.txt")));
                out.println(commandUpdate + fileContent);
                out.println("END_OF_FILE");

                String response = in.readLine();
                System.out.println("Response: " + response);

                // Requesting inventory with the pipe separator
                String commandRequestInventory = "R|";
                out.println(commandRequestInventory);

                StringBuilder inventoryResponseBuilder = new StringBuilder();
                String inventoryLine;
                while (!(inventoryLine = in.readLine()).equals("END_OF_FILE")) {
                    inventoryResponseBuilder.append(inventoryLine).append("\n");
                }

                System.out.println("Received Inventory:\n" + inventoryResponseBuilder.toString());

                // Requesting stock levels with the pipe separator
                String commandRequestStockLevels = "S|";
                out.println(commandRequestStockLevels);

                StringBuilder stockLevelsResponseBuilder = new StringBuilder();
                String stockLevelsLine;
                while (!(stockLevelsLine = in.readLine()).equals("END_OF_FILE")) {
                    stockLevelsResponseBuilder.append(stockLevelsLine).append("\n");
                }

                System.out.println("Received Stock Levels:\n" + stockLevelsResponseBuilder.toString());

                return; // Successfully connected and processed, exit the loop and the main method.

            } catch (IOException e) {
                System.err.println("Connection error (Attempt " + (i + 1) + "): " + e.getMessage());

                if (i < MAX_RETRIES - 1) {
                    System.err.println("Retrying in " + RETRY_INTERVAL_MS + " milliseconds...");
                    try {
                        Thread.sleep(RETRY_INTERVAL_MS);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        System.err.println("Interrupted while waiting for retry: " + ie.getMessage());
                        break;
                    }
                }
            }
        }

        System.err.println("Failed to connect after " + MAX_RETRIES + " attempts.");
    }
}
