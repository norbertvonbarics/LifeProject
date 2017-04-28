import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Engine extends JComponent {

  private Board myArray = new Board();

  private ArrayList<Tile> newTileList = new ArrayList<>();
  private int dimension = 800;

  Engine() {
    setPreferredSize(new Dimension(dimension, dimension));
    setVisible(true);

    myArray.fillLists();
  }

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);

    for (Tile aNewTileList : newTileList) {
      graphics.setColor(Color.black);
      graphics
          .fillRect(aNewTileList.posX * dimension / Board.array2d().length,
              aNewTileList.posY * dimension / Board.array2d().length,
              dimension / Board.array2d().length, dimension / Board.array2d().length);
    }

    graphics.setFont(new Font("TimesRoman", Font.PLAIN, 20));
    graphics.drawString("Life cycle: " + Integer.toString(Motion.counter), 820, 20);
    graphics.drawString("There are " + Integer.toString(newTileList.size()) + " Bitizen alive!", 820, 60);
    ArrayList<Tile> tempList = new ArrayList<>();

    for (int i = 0; i < Board.array2d().length; i++) {
      for (int j = 0; j < Board.array2d().length; j++) {

        Tile newTile = new Tile(i, j, Board.isAlive(i, j));

        if (newTile.alive) {
          tempList.add(newTile);
        }
      }
      newTileList = tempList;
    }

    try {
      Thread.sleep(1000);
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
    Motion.motion();
    repaint();
  }
}
