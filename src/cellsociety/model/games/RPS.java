package cellsociety.model.games;

import cellsociety.model.GameBoard;
import java.util.List;

public class RPS extends Simulation {

  public static final int THRESHOLD = 3;

  public RPS(String csvConfig, String cellType, String neighborPolicy) {
    super(csvConfig, cellType, neighborPolicy);
  }


  @Override
  public void updateCell(GameBoard gameBoard, int row, int col) {
    if (isDefeated(row, col)) {
      gameBoard.setPiece(row, col, getOpponent(row, col));
    } else {
      gameBoard.setPiece(row, col, getGameBoard().getState(row, col));
    }
  }

  private boolean isDefeated(int currentRow, int currentColumn) {
    return countNeighboringOpponents(currentRow, currentColumn) > THRESHOLD;
  }

  public String getOpponent(int row, int col) {
    int state = Integer.parseInt(getGameBoard().getCell(row, col).getState());
    return Integer.toString((state + 1) % 3);
  }

  public int countNeighboringOpponents(int row, int col) {
    int opponentCount = 0;
    List<List<Integer>> neighbors = getGameBoard().getCell(row, col).getNeighborhood().getNeighbors();
    for (List<Integer> neighbor : neighbors){
      if (isOpponent(row, col, neighbor.get(0), neighbor.get(1))){
        opponentCount++;
      }
    }
    return opponentCount;
  }

  public boolean isOpponent(int x, int y, int currentRow, int currentColumn) {
    String currentState = getGameBoard().getCell(x, y).getState();
    String opponentState = getOpponent(currentRow, currentColumn);
    return currentState.equals(opponentState);
  }


}
