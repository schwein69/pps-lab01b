package e2;

import java.util.Set;

public interface PositionGenerator {
    /**
     * Generates a random position within the specified size, ensuring that the position
     * does not conflict with the occupied position.
     *
     * @param size The size of the grid within which the position should be generated.
     *             The generated position's coordinates will be in the range [0, size - 1].
     * @param excludedPosition A position that is already occupied.
     * @return A randomly generated position that is within the bounds of the grid and not
     *         equals to excludedPosition.
     * @throws IllegalStateException If the size is less than or equal to 0 or 1(the chessBoard can have only 1 position).
     */
    Pair<Integer, Integer> generateRandomPosition(int size, Pair<Integer, Integer> excludedPosition);
}