package TicTacToe;

import java.util.Random;

public class RandomWrapper {
    Random random = new Random();

    public int nextInt(int bound) {
        return random.nextInt(bound);
    }
}
