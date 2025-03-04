package e2;

import java.util.Random;
import java.util.Set;

public class PositionGeneratorImpl implements PositionGenerator {
    private final Random random = new Random();

    @Override
    public Pair<Integer, Integer> generateRandomPosition(int size, Set<Pair<Integer, Integer>> excludedPositions) {
        Pair<Integer, Integer> pos;
        if (size == 1 || excludedPositions.size() == size * size) {
            throw new IllegalStateException();
        }
        do {
            pos = new Pair<>(random.nextInt(size), random.nextInt(size));
        } while (excludedPositions.contains(pos));
        return pos;
    }
}