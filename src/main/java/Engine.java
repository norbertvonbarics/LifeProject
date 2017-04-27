import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Engine extends JComponent implements KeyListener {

  private Board myArray = new Board();

  private ArrayList<Tile> newTileList = new ArrayList<>();

  private int dimension = 800;
  int counter = 1;

  Engine() {
    setPreferredSize(new Dimension(dimension, dimension));
    setVisible(true);

    myArray.fillLists();
    for (int i = 0; i < Board.array2d().size(); i++) {
      for (int j = 0; j < Board.array2d().size(); j++) {
        Tile newTile = new Tile(i * dimension / Board.array2d().size(),
            j * dimension / Board.array2d().size(),
            Board.isAlive(i, j));
        if (newTile.alive) {
          newTileList.add(newTile);
        }
      }
    }
  }

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);
    for (int i = 0; i < newTileList.size(); i++) {
      graphics.setColor(Color.black);
      graphics
          .fillRect(newTileList.get(i).posX, newTileList.get(i).posY,
              dimension / Board.array2d().size(), dimension / Board.array2d().size());
    }
    if (counter > 0) {
      Motion.motion();
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
  }

  @Override
  public void keyReleased(KeyEvent e) {

    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
      System.out.println("start");
      Motion move = new Motion();
      move.motion();
    } else if (e.getKeyCode() == KeyEvent.VK_S) {
      System.out.println("stop");
    counter = 0;
    }
    repaint();
  }
}