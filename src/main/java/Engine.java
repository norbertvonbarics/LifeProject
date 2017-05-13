import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Engine extends JComponent {

  private Board myArray = new Board();
  private ArrayList<Tile> newTileList = new ArrayList<>();

  private Stats stat = new Stats();
  private int dimension = 800;

  Engine() {
    setPreferredSize(new Dimension(dimension, dimension));
    setVisible(true);

    myArray.fillLists();
    //myArray.spacecraft();
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

    ArrayList<Tile> tempList = new ArrayList<>();

    for (int i = 0; i < Board.array2d().length; i++) {
      for (int j = 0; j < Board.array2d().length; j++) {

        Tile newTile = new Tile(i, j, Alive.isAlive(i, j));

        if (newTile.alive) {
          tempList.add(newTile);
        }
      }
      newTileList = tempList;
    }

    graphics.setFont(new Font("TimesRoman", Font.PLAIN, 20));
    graphics.drawString("Life cycle: " + Motion.counter, 820, 40);
    graphics.drawString("There are " + newTileList.size() + " Bitizen alive!", 820, 80);
    graphics.drawString("Min: " + stat.getMinBitizen(newTileList.size()), 820, 120);
    graphics.drawString("Max: " + stat.getMaxBitizen(newTileList.size()), 820, 140);

    try {
      Thread.sleep(50);
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
    }

    Motion.makeThemLive();
    Motion.makeThemDead();
    Motion.motion();
    repaint();
  }
}
