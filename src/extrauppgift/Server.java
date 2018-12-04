/*
 * 
 */

package extrauppgift;

import java.net.ServerSocket;
    
public class Server {
    Server(){
        
    }

    public static void main(String[] args) throws Exception {
        ServerSocket listener = new ServerSocket(8901);
        System.out.println("Server is Running...");
        try {

            while (true) {
                
                Player player1 
                        = new Player(listener.accept(), "Player 1", 0);
                System.out.println("Player 1 connected...");
                Player player2 
                        = new Player(listener.accept(), "Player 2", 0);
                System.out.println("Player 2 connected...");
                player1.start();
                player2.start();
                
                
                
            }
        } finally {
            listener.close();
        }
    }
}

