package e2;

public interface ChessBoard {
    Pair<Integer, Integer> getKnightPosition();

    Pair<Integer, Integer> getPawnPosition();

    void setKnightPosition(Pair<Integer, Integer> newPair);

}
