import java.util.Scanner;

public class GameManager {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Starting game with two players and one turn");
        System.out.println("Number of turns");

        String userName = kb.nextLine();  // Read user input
        System.out.println("Turns are: " + userName);  // Output user input
    }

    private void startGame(Player playerA, Player playerB, int turns){

    }
}