package hdfs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.io.BufferedWriter; // Import the BufferedWriter class
import java.io.OutputStreamWriter; // Import the OutputStreamWriter class

public class WriteTask implements Runnable {
    private Socket socket;
    private String filePath;
    private long startLine;
    private long nbLines;


    public WriteTask(Socket socket, String filePath, long startLine, long nbLines) {
        this.socket = socket;
        this.filePath = filePath;
        this.startLine = startLine;
        this.nbLines = nbLines;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Skip lines until the start line is reached
            for (int i = 0; i < startLine; i++) {
                if (reader.readLine() == null) {
                    throw new IOException("File does not have enough lines");
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
                for (int i = 0; i < nbLines; i++) {
                    String line = reader.readLine();
                    if (line == null) {
                        throw new IOException("Unexpected end of file");
                    }
                    writer.write(line);
                    writer.newLine();
                }
                writer.flush();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}