package e2;

import java.util.Set;

public interface PositionGenerator {
    /**
     * Generates a random position within the specified size, ensuring that the position
     * does not conflict with any of the positions in the excluded set.
     *
     * @param size The size of the grid within which the position should be generated.
     *             The generated position's coordinates will be in the range [0, size - 1].
     * @param excludedPositions A set of positions that should not be generated. The generated
     *                          position will not be present in this set.
     * @return A randomly generated position that is within the bounds of the grid and not
     *         present in the excluded set.
     * @throws IllegalStateException If the size is less than or equal to 0 or excludedPositions are full.
     */
    Pair<Integer, Integer> generateRandomPosition(int size, Set<Pair<Integer, Integer>> excludedPositions);
}