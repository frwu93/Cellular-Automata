package cellsociety.view;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.Group;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ConwaySimulationBoard extends SimulationBoard {

  public static final double CELL_GRID_WIDTH = 600;
  public static final double CELL_GRID_HEIGHT = 350;

  private GridPane myGrid = new GridPane();
  private Map<String, Color> stateColorMap = new HashMap<>();

  public ConwaySimulationBoard(Group root) {
    myGrid.setLayoutX(75);
    myGrid.setLayoutY(50);
    myGrid.setGridLinesVisible(true);
    setStateColorMap();
    root.getChildren().add(myGrid);
  }

  @Override
  protected void setStateColorMap() {
    stateColorMap.put("1", Color.RED);
    stateColorMap.put("0", Color.BLUE);
  }

  //works for non square 2D arrays
  // TODO: 2020-10-04 ask about X position?  
  private void initializeMyGrid(String[][] states) {
    double width = CELL_GRID_WIDTH/maxRowLength(states);
    for (int i = 0; i < states.length; i++) {
      for (int j = 0; j < states[i].length; j++) {
        //System.out.println(states[i].length);
        Rectangle cell = new Rectangle(width, CELL_GRID_HEIGHT/states.length);
        cell.setStroke(Color.BLACK);
        cell.setFill(stateColorMap.get(states[i][j]));
        cell.setId(String.format("cell%d,%d", i, j));
        myGrid.setConstraints(cell,j,i);
        myGrid.getChildren().add(cell);
      }
    }
  }
  private int maxRowLength(String[][] array){
    int maxRowLength = 0;
    for(String[] row : array){
      if(row.length > maxRowLength){
        maxRowLength = row.length;
      }
    }
    return maxRowLength;
  }
  public void updateMyGrid(String[][] states) {
    initializeMyGrid(states);
  }
}