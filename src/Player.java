public abstract class Player {
    private int score;

    public abstract boolean makeDecision();

    public int getScore() {
        return score;
    }
    public void setScore(int score) { this.score = score; }
    public void addScore(int points) { this.score += points; }
}
