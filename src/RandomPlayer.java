import java.util.Random;

public class RandomPlayer extends Player{
    public boolean makeDecision() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
