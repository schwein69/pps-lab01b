package e2;

public abstract class LogicsImpl implements Logics {
    protected final ChessBoard chessBoard;
    private final PositionGenerator positionGenerator;
    private final int size;

    public LogicsImpl(int size, PositionGenerator positionGenerator) {
        this.size = size;
        this.positionGenerator = positionGenerator;
        this.chessBoard = new ChessBoardImpl(this.size, this.positionGenerator);
    }

    public LogicsImpl(int size, Pair<Integer, Integer> knightPair, Pair<Integer, Integer> pawnPair, PositionGenerator positionGenerator) {
        this.size = size;
        this.positionGenerator = positionGenerator;
        this.chessBoard = new ChessBoardImpl(knightPair, pawnPair);
    }


    private void validatePosition(int row, int col) {
        if (row < 0 || col < 0 || row >= this.size || col >= this.size) {
            throw new IndexOutOfBoundsException();
        }
    }

    protected abstract boolean isValidMove(int row, int col);

    protected abstract boolean uniqueHit(int row, int col);

    @Override
    public boolean hit(int row, int col) {
        validatePosition(row, col);
        return uniqueHit(row, col);
    }

    @Override
    public boolean hasKnight(int row, int col) {
        return this.chessBoard.getKnightPosition().equals(new Pair<>(row, col));
    }

    @Override
    public boolean hasPawn(int row, int col) {
        return this.chessBoard.getPawnPosition().equals(new Pair<>(row, col));
    }

    @Override
    public Pair<Integer, Integer> getKnightPosition() {
        return this.chessBoard.getKnightPosition();
    }

    @Override
    public Pair<Integer, Integer> getPawnPosition() {
        return this.chessBoard.getPawnPosition();
    }


}
