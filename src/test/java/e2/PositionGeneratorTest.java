package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class PositionGeneratorTest {
    private PositionGenerator positionGenerator;
    private static final int SIZE = 5;

    @BeforeEach
    public void init() {
        this.positionGenerator = new PositionGeneratorImpl();
    }

    @Test
    public void testGenerateRandomPosition() {
        Pair<Integer, Integer> pos = positionGenerator.generateRandomPosition(SIZE, new Pair<>(0, 0));
        assertNotNull(pos);
        assertTrue(pos.getX() >= 0 && pos.getX() < SIZE && pos.getY() >= 0 && pos.getY() < SIZE);
        assertNotEquals(new Pair<>(0, 0), pos);
    }

    @Test
    void testGenerateRandomPositionWithAllExcluded() {
        assertThrows(IllegalStateException.class, () -> {
            positionGenerator.generateRandomPosition(1, new Pair<>(0, 0));
        });
    }
}
