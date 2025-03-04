package e2;

public class KnightLogicsImpl extends LogicsImpl{
    public KnightLogicsImpl(int size, PositionGenerator positionGenerator) {
        super(size, positionGenerator);
    }

    public KnightLogicsImpl(int size, Pair<Integer, Integer> knightPair, Pair<Integer, Integer> pawnPair) {
        super(size, knightPair, pawnPair);
    }

    @Override
    protected boolean isValidMove(int row, int col) {
        int x = row - this.knight.getX();
        int y = col - this.knight.getY();
        if (x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3) {
            this.knight = new Pair<>(row, col);
            return this.pawn.equals(this.knight);
        }
        return false;
    }
}
