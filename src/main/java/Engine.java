import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Engine extends JComponent implements KeyListener {

  private Board myArray = new Board();

  ArrayList<Tile> newTileList = new ArrayList<>();
  int dimension = 800;
  int counter = 1;

  Engine() {
    setPreferredSize(new Dimension(dimension, dimension));
    setVisible(true);

    myArray.fillLists();
  }

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);

    for (int i = 0; i < newTileList.size(); i++) {
      graphics.setColor(Color.black);
      graphics
          .fillRect(newTileList.get(i).posX * dimension / Board.array2d().length,
              newTileList.get(i).posY * dimension / Board.array2d().length,
              dimension / Board.array2d().length, dimension / Board.array2d().length);
    }
    ArrayList<Tile> tempList = new ArrayList<>();
    for (int i = 0; i < Board.array2d().length; i++) {
      for (int j = 0; j < Board.array2d().length; j++) {
        Tile newTile = new Tile(i, j, Board.isAlive(i, j));

        if (newTile.alive) {
          tempList.add(newTile);
        }
      }
    }
  newTileList = tempList;
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
  }

  @Override
  public void keyReleased(KeyEvent e) {
    try {
      Robot robot = new Robot();
      robot.keyPress(KeyEvent.VK_X);
      robot.keyRelease(KeyEvent.VK_X);

    } catch (AWTException ex) {
      ex.printStackTrace();
    }
    if (e.getKeyCode() == KeyEvent.VK_X) {
      Motion move = new Motion();
      move.motion();
    } else if (e.getKeyCode() == KeyEvent.VK_S) {
      System.out.println("stop");
      counter = 0;
    }
    repaint();
  }
}