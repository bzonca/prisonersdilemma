public class AlwaysSame extends Player{

    //Decision this strategy will ALWAYS make
    private boolean staticDecision;

    public AlwaysSame(boolean staticDecision){
        this.staticDecision = staticDecision;
    }

    public boolean makeDecision(){
        return staticDecision;
    }

    public String toString(){
        return "Always" + (staticDecision ? "Cooperate" : "Defect");
    }
}
