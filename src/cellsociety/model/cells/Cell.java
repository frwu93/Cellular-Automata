package cellsociety.model.cells;

public abstract class Cell {

  private String state;

  public Cell(String state) {
    this.state = state;
  }

  public String getState() {
    return this.state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String toString() {
    return this.getState();
  }

}