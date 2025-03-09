package e2;

import java.util.Random;

public class PositionGeneratorImpl implements PositionGenerator {
    private final Random random = new Random();

    @Override
    public Pair<Integer, Integer> generateRandomPosition(int size, Pair<Integer, Integer> excludedPosition) {
        Pair<Integer, Integer> pos;
        if (size <= 1) {
            throw new IllegalStateException();
        }
        do {
            pos = new Pair<>(random.nextInt(size), random.nextInt(size));
        } while (pos.equals(excludedPosition));
        return pos;
    }
}