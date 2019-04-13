//Purpose : Each turn is an single instance of prisoners dilemma.
//Turns contain players, decisions, and rewards

public class Turn {

    private Player playerA;
    private Player playerB;
    private int playerAReward;
    private int playerBReward;
    private boolean playerADecision;
    private boolean playerBDecision;

    //Use for readability + testing
    private String resultString;

    public Turn(Player playerA, Player playerB){
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public void playTurn(){
        //Tell players to make decisions independently
        playerADecision = playerA.makeDecision();
        playerBDecision = playerB.makeDecision();

        if(playerADecision && playerBDecision){
            //If both cooperate, give both players 3 points
            playerAReward = 3;
            playerBReward = 3;
            resultString = "Mutual cooperation";
        }else if (!playerADecision && !playerBDecision){
            //If both defect, give both players 2 points
            playerAReward = 2;
            playerBReward = 2;
            resultString = "Mutual defection";
        }else if(!playerADecision && playerBDecision){
            //playerA defects while playerB cooperates
            playerAReward = 4;
            playerBReward = 1;
            resultString = "Player1 " + playerA.toString() + " wins";
        }else{
            //playerB defects while playerA cooperates
            playerAReward = 1;
            playerBReward = 4;
            resultString = "Player2 " + playerB.toString() + " wins";
        }

        playerA.addScore(playerAReward);
        playerB.addScore(playerBReward);
    }

    public String resultToString() {
        String out = resultString + "\nPayout : Player1 " + playerA.toString() + ": +" + playerAReward
                + "    Player2 " + playerB.toString() + ": +" + playerBReward +
                "\nScores : Player1 " + playerA.toString() + ": " + playerA.getScore()
                + "    Player2 " + playerB.toString() + ": " + playerB.getScore();
        return out;
    }

    public String getScoresString() { 
        return "Scores...\nPlayer1 (" + playerA.toString() + "): " + playerA.getScore()
                + "\nPlayer2 (" + playerB.toString() + "): " + playerB.getScore();
    }
}
