public class Game {
    protected Player playerA;
    protected Player playerB;
    protected int numTurns;

    public Game(Player playerA, Player playerB, int numTurns){
        this.playerA = playerA;
        this.playerB = playerB;
        this.numTurns = numTurns;
        //Create turn manager
        TurnManager turnManager = new TurnManager();
    }
}
