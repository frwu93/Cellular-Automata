package cellsociety.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConwayReaderTest {

  @Test
  void readFile() {
    ConwayReader reader = new ConwayReader();
    String[][] test = reader.readFile("conwayTest1.txt");
    assertEquals(2,test.length);
    assertEquals(3,test[0].length);
    assertEquals("1",test[0][0]);
    assertEquals("0",test[1][0]);
  }
}