package e2;

public class KnightLogicsImpl extends LogicsImpl {
    public KnightLogicsImpl(int size, PositionGenerator positionGenerator) {
        super(size, positionGenerator);
    }

    public KnightLogicsImpl(int size, Pair<Integer, Integer> knightPair, Pair<Integer, Integer> pawnPair, PositionGenerator positionGenerator) {
        super(size, knightPair, pawnPair, positionGenerator);
    }

    @Override
    protected boolean isValidMove(int row, int col) {
        int x = row - getKnightPosition().getX();
        int y = col - getKnightPosition().getY();
        return x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3;
    }
}
