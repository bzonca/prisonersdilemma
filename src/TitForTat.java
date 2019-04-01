public class TitForTat extends Player{

    public boolean makeDecision() {
        return getOpponentsLastDecision();
    }

    private boolean getOpponentsLastDecision(){
        return false;
    }
}
