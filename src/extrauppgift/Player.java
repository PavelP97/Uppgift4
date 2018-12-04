/*
 * 
 */

package extrauppgift;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Player extends Thread {
    String mark;
    Player opponent;
    Socket socket;
    BufferedReader input;
    PrintWriter output;
    int points;
    
        public Player(Socket socket, String mark, int points) {
            this.socket = socket;
            this.mark = mark;
            this.points = points;
            
            
            try {
                input = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
                output = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                System.out.println("Player died: " + e);
            }
            
        }
        public int GetPoints(){ // 
            return points;
        }
        public void run() {
            try {
            // The thread is only started after everyone connects.
            Server o = new Server();
                output.println("MESSAGE All players connected");
                String check;
                check = input.readLine();
                if(check.equalsIgnoreCase("Bulgakov")){
                    points+=1;
                } else {
                    points=0;
                }
                
                
                
//                s = Integer.parseInt(check);
                
                
            } catch (IOException e) {
                System.out.println("Player died: " + e);
            } finally {
                try {socket.close();} catch (IOException e) {}
            }
}
}
