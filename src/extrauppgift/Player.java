/*
 * 
 */

package extrauppgift;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Player extends Thread {
    String mark;
    Player opponent;
    Socket socket;
    BufferedReader input;
    PrintWriter output;
    int points;
    boolean me = false;
    
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
        public void SetOpponent(Player player){
            opponent = player;
        }
        public void run() {
            try {
            // The thread is only started after everyone connects.
            
                output.println("MESSAGE All players connected");
                String check;
                check = input.readLine();
                if(check.equalsIgnoreCase("Bulgakov")){
                    points+=1;
                    output.println("Correct");
                    me = true;
                    System.out.println(points);
                } else {
                    points=0;
                    output.println("Incorrect");
                    me = true;
                    System.out.println(points);
                    
                }
                
                while(!opponent.me){
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                String p;
                if (GetPoints() == opponent.GetPoints()) {
                    p = "LIKA";
                } else if(GetPoints() > opponent.GetPoints()){
                    p = "DU VANN";
                }else{
                    p = "DU FORLORADE'";
                }
                
                output.println(mark + " " + p);
                System.out.println("test");
                
                
                
                 // read association aggregation and composition. fokusera pa skillnader , fastna inte for mycket i UML.
                
                
//                s = Integer.parseInt(check);
                
                
            } catch (IOException e) {
                System.out.println("Player died: " + e);
            } finally {
                try {socket.close();} catch (IOException e) {}
            }
}
}
