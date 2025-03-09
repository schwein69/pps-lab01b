package e2;

public class ChessBoardImpl implements ChessBoard {
    private final Pair<Integer, Integer> pawn;
    private Pair<Integer, Integer> knight;

    public ChessBoardImpl(int size, PositionGenerator positionGenerator) {
        this.pawn = positionGenerator.generateRandomPosition(size, null);
        this.knight = positionGenerator.generateRandomPosition(size, this.pawn);
    }

    public ChessBoardImpl(Pair<Integer, Integer> knightPair, Pair<Integer, Integer> pawnPair) {
        this.pawn = pawnPair;
        this.knight = knightPair;
    }

    @Override
    public Pair<Integer, Integer> getKnightPosition() {
        return this.knight;
    }

    @Override
    public Pair<Integer, Integer> getPawnPosition() {
        return this.pawn;
    }

    @Override
    public void setKnightPosition(Pair<Integer, Integer> newPosition) {
        this.knight = newPosition;
    }

}
