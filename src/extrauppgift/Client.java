/*
 * 
 */

package extrauppgift;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

public class Client {
	private static int PORT = 8901;
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;
        
        public Client (String serverAddress) throws Exception{
            socket = new Socket(serverAddress, PORT);
            in = new BufferedReader(new InputStreamReader(
            socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        }
        public static void main(String[] args) throws Exception {
        while (true) {
//            String serverAddress = (args.length == 0) ? "localhost" : args[1];
            Client client = new Client("172.20.202.101");
            client.play();
            
            System.exit(0);
        }
    }
            public void play() throws Exception {
        String response;
        String answer;
        try {
        response = in.readLine();
            if (response.startsWith("MESSAGE")) {
                answer = JOptionPane.showInputDialog(null, "Who is the author of Master and Margarita?\nBulgakov         Bulkin\nDostoevski     Johanson");
                out.println(answer);
                answer = in.readLine();
                if (answer != null) {
                    JOptionPane.showMessageDialog(null, answer);
                }
                answer = in.readLine();
                JOptionPane.showMessageDialog(null, answer);
            }
        }
        finally {
            socket.close();
        }
            }
}

