import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.stream.Collector;

public class LoadBalancer {
    static String hosts[] = {"localhost", "localhost"};
    static int ports[] = {8081, 8082};
    
    static int nbHosts = hosts.length;
    static Random rand = new Random();

    public static void main(String[] args) throws IOException {
        // Servers
        ServerSocket s = new ServerSocket(8080);
        Socket serverSockets[] = new Socket[nbHosts];
        InputStreamReader servIn[] = new InputStreamReader[nbHosts];
        LineNumberReader servLnr[] = new LineNumberReader[nbHosts];
        OutputStreamWriter servOut[] = new OutputStreamWriter[nbHosts];
        for (int i = 0; i < nbHosts; i++) {
            serverSockets[i] = new Socket(hosts[i], ports[i]);
            servIn[i] = new InputStreamReader(serverSockets[i].getInputStream());
            servLnr[i] = new LineNumberReader(servIn[i]);
            servOut[i] = new OutputStreamWriter(serverSockets[i].getOutputStream());
        }

        // Client
        Socket clientSocket = s.accept();
        InputStreamReader in = new InputStreamReader(clientSocket.getInputStream());
        LineNumberReader lnr = new LineNumberReader(in);
        OutputStreamWriter out = new OutputStreamWriter(clientSocket.getOutputStream());
        
        while(true) {
            String rq = lnr.readLine() + "\n";
            String line;
            while ((line = lnr.readLine()) != null) {
                rq += line + "\n";
            }
            System.out.println("############ REQUEST ############");
            System.out.println(rq);
            
            int i = rand.nextInt(nbHosts);
            servOut[i].write(rq);
            servOut[i].flush();
            
            String answ = servLnr[i].readLine() + "\n";
            while ((line = servLnr[i].readLine()) != null) {
                answ += line + "\n";
            }
            System.out.println("############ ANSWER ############");
            System.out.println(answ);

            out.write(answ);
            out.flush();
        }
    }
}