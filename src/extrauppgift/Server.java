/*
 * 
 */

package extrauppgift;

import java.net.ServerSocket;
    
public class Server {
    

        public static void main(String[] args) throws Exception {
        ServerSocket listener = new ServerSocket(8901);
        System.out.println("Server is running...");
        try {
            String p1;
            String p2;
            while (true) {
                
                Player player1 
                        = new Player(listener.accept(), "Player 1", 0);
                System.out.println("Player 1 connected...");
                Player player2 
                        = new Player(listener.accept(), "Player 2", 0);
                System.out.println("Player 2 connected...");
                player1.SetOpponent(player2);
                player2.SetOpponent(player1);
                player1.start();
                player2.start();
                
                
            }
        } finally {
            listener.close();
        }
    }
        public String ReturnScorep1(String p28){
            
            return p28;
        }
        public String ReturnScorep2(String p1){
            
            return p1;
        }
}

