import java.util.Scanner;

public class GameManager {

    private boolean isProgramActive;

    public static void main(String[] args){
        GameManager gm = new GameManager();
        gm.runProgramLoop();
    }

    private void runProgramLoop(){
        isProgramActive = true;
        while (isProgramActive){
            Scanner kb = new Scanner(System.in);  // Create a Scanner object

            System.out.println("Number of turns : ");
            int numTurns = kb.nextInt();  // Read user input

            //Create player1 Always true
            Player player1 = new AlwaysSame(true);

            //Create player2 Always false
        //    Player player2 = new AlwaysSame(false);
            Player player2 = new User(kb);

            //Create game with parameters
            startGame(player1, player2, numTurns);

            isProgramActive = false;
        }
    }

    private void startGame(Player playerA, Player playerB, int turns){
        //Create game and start it
        Game game = new Game(playerA, playerB, turns);
        game.begin();
    }
}