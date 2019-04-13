//PURPOSE : Game instance holds player info, runs a turnManager, and displays final results.

public class Game {
    private Player playerA;
    private Player playerB;
    private int numTurns;


    public Game(Player playerA, Player playerB, int numTurns){
        this.playerA = playerA;
        this.playerB = playerB;
        this.numTurns = numTurns;

        System.out.print("Game created! | ");
        System.out.print("Player 1 : " + playerA.toString());
        System.out.print("  Player 2 : " + playerB.toString());
        System.out.println("  Turns in game : " + numTurns);
    }

    //Begins game (Loop through decisions for the number of turns)
    public void begin(){
        
        Turn t = null;
        
        //Begin iterated game loop
        for(int i = 0; i < numTurns; i++){
            t = new Turn(playerA, playerB);
            t.playTurn();
            System.out.println("Result : " + t.resultToString());
        }
        
        String winnerText = "\nGame over. Winner : " + getGameWinner();
        System.out.println(winnerText);
        
        try {
            GameManager.displayEndScreenPopup(winnerText, t.getScoresString());
        } catch (NullPointerException e){
            System.out.println("0 turns selected!");
        }
    }

    //TODO: Account for tie case
    public Player getGameWinner(){
        if(playerA.getScore() > playerB.getScore()){
            //playerA is winner
            return playerA;
        }else{
            //playerB is winner
            return playerB;
        }
    }
}
