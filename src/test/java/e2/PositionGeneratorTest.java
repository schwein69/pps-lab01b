package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class PositionGeneratorTest {
    private PositionGenerator positionGenerator;
    private static final int SIZE = 5;

    @BeforeEach
    public void init(){
        this.positionGenerator = new PositionGeneratorImpl();
    }

    @Test
    public void testGenerateRandomPosition(){
        HashSet<Pair<Integer, Integer>> excludedPositions = new HashSet<>();
        excludedPositions.add(new Pair<>(0, 0));
        Pair<Integer, Integer> pos = positionGenerator.generateRandomPosition(SIZE, excludedPositions);
        assertNotNull(pos);
        assertTrue(pos.getX() >= 0 && pos.getX() < SIZE);
        assertTrue(pos.getY() >= 0 && pos.getY() < SIZE);
        assertFalse(excludedPositions.contains(pos));
    }

    @Test
    void testGenerateRandomPositionWithAllExcluded() {
        Set<Pair<Integer, Integer>> excludedPositions = new HashSet<>();
        excludedPositions.add(new Pair<>(0, 0)); // Exclude the only possible position
        assertThrows(IllegalStateException.class, () -> {
            positionGenerator.generateRandomPosition(1, excludedPositions);
        });
    }
}
