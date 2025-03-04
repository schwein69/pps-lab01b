package e2;

import java.util.*;

public abstract class LogicsImpl implements Logics {

    private final Pair<Integer, Integer> pawn;
    private Pair<Integer, Integer> knight;
    private final int size;
    private final PositionGenerator positionGenerator;

    public LogicsImpl(int size, PositionGenerator positionGenerator) {
        this.size = size;
        this.positionGenerator = positionGenerator;
        HashSet<Pair<Integer, Integer>> hashSet = new HashSet<>();
        this.pawn = this.positionGenerator.generateRandomPosition(size, hashSet);
        hashSet.add(this.pawn);
        this.knight = this.positionGenerator.generateRandomPosition(size, hashSet);
    }

    public LogicsImpl(int size, Pair<Integer, Integer> knightPair, Pair<Integer, Integer> pawnPair, PositionGenerator positionGenerator) {
        this.size = size;
        this.knight = knightPair;
        this.pawn = pawnPair;
        this.positionGenerator = positionGenerator;
    }

    private void validatePosition(int row, int col) {
        if (row < 0 || col < 0 || row >= this.size || col >= this.size) {
            throw new IndexOutOfBoundsException();
        }
    }

    protected abstract boolean isValidMove(int row, int col);

    @Override
    public boolean hit(int row, int col) {
        validatePosition(row, col);
        if (isValidMove(row, col)) {
            this.knight = new Pair<>(row, col);
            return this.pawn.equals(this.knight);
        }
        return false;
    }

    @Override
    public boolean hasKnight(int row, int col) {
        return this.knight.equals(new Pair<>(row, col));
    }

    @Override
    public boolean hasPawn(int row, int col) {
        return this.pawn.equals(new Pair<>(row, col));
    }

    @Override
    public Pair<Integer, Integer> getKnightPosition() {
        return this.knight;
    }

    @Override
    public Pair<Integer, Integer> getPawnPosition() {
        return this.pawn;
    }


}
