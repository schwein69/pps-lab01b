package e2;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {
    private Logics logics;
    private static final int SIZE = 5;

    private boolean isWithinBounds(Pair<Integer, Integer> position) {
        return position.getX() >= 0 && position.getX() < SIZE &&
                position.getY() >= 0 && position.getY() < SIZE;
    }

    @BeforeEach
    public void init() {
        this.logics = new KnightLogicsImpl(SIZE, new PositionGeneratorImpl());
    }

    @Test
    public void testInitialState() {
        assertNotEquals(this.logics.getKnightPosition(), this.logics.getPawnPosition());
    }

    @Test
    public void testKnightStartsOnBoard() {
        Pair<Integer, Integer> knight = this.logics.getKnightPosition();
        assertNotNull(knight);
        assertTrue(isWithinBounds(knight));
    }

    @Test
    public void testPawnStartsOnBoard() {
        Pair<Integer, Integer> pawn = this.logics.getPawnPosition();
        assertNotNull(pawn);
        assertTrue(isWithinBounds(pawn));
    }

    @Test
    void testKnightCapturesPawn() {
        Logics customLogics = new KnightLogicsImpl(SIZE, new Pair<>(2, 2), new Pair<>(4, 3), new PositionGeneratorImpl());
        assertTrue(customLogics.hit(4, 3));
        assertFalse(customLogics.hit(3, 4));
    }

    @Test
    public void testMoveKnightInsideBoard() {
        Pair<Integer, Integer> actualPosition = this.logics.getKnightPosition();
        int[][] possibleMoves = {
                {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
                {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
        };
        boolean validMove = Arrays.stream(possibleMoves)
                .anyMatch(move -> {
                    int newX = actualPosition.getX() + move[0];
                    int newY = actualPosition.getY() + move[1];
                    return isWithinBounds(new Pair<>(newX, newY));
                });
        assertTrue(validMove);
    }

    @Test
    public void testInvalidMoveOutsideBoard() {
        Pair<Integer, Integer> knightPosition = this.logics.getKnightPosition();
        int invalidRow = knightPosition.getX() + 10;
        int invalidCol = knightPosition.getY() + 10;
        assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(invalidRow, invalidCol));
    }

    @Test
    public void testInvalidMoveNotLShaped() {
        Pair<Integer, Integer> knightPosition = this.logics.getKnightPosition();
        int invalidRow = knightPosition.getX() + 1 < SIZE ? knightPosition.getX() + 1 : knightPosition.getX() - 1;
        int invalidCol = knightPosition.getY() + 1 < SIZE ? knightPosition.getY() + 1 : knightPosition.getY() - 1;
        assertFalse(this.logics.hit(invalidRow, invalidCol));
    }

}
