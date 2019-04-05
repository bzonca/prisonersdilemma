import java.util.Scanner;

public class GameManager {

    private boolean isProgramActive;

    public static void main(String[] args){
        GameManager gm = new GameManager();
        gm.runProgramLoop();
    }

    private void runProgramLoop(){
        isProgramActive = true;
        Scanner kb = new Scanner(System.in);  // Create a Scanner object
        while (isProgramActive){

            System.out.print("Number of turns : ");
            int numTurns = kb.nextInt();  // Read user input

            //Create player1 as a user. Let it use the scanner used previously.
            //Player player1 = new User(kb);
            Player player1 = new RandomPlayer();
            //Create player2 Always false
            //Player player2 = new AlwaysSame(false);
            Player player2 = new AlwaysSame(false);

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