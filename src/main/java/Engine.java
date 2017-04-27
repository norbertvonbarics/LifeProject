import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Engine extends JComponent implements KeyListener {

  Board myArray = new Board();

  int dimension = 700;

  Engine() {

    setPreferredSize(new Dimension(dimension, dimension));
    setVisible(true);
  }

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);
    myArray.fillLists();

    for (int i = 0; i < myArray.size; i++) {
      for (int j = 0; j < myArray.size; j++) {
        if (myArray.isAlive(i, j)) {
          graphics.setColor(Color.black);
          graphics
              .fillRect(i * (dimension / myArray.size), j * (dimension / myArray.size),
                  dimension / myArray.size, dimension / myArray.size);
        }
      }
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
      for (int i = 0; i < myArray.size; i++) {
        for (int j = 0; j < myArray.size; j++) {
          if ((myArray.checkNeighbours(i, j) < 2) && myArray.isAlive(i, j)) {
            myArray.setDead(i, j);
          } else if ((myArray.checkNeighbours(i, j) == 2 || myArray.checkNeighbours(i, j) == 3)
              && myArray.isAlive(i, j)) {
            myArray.setAlive(i, j);
          } else if (myArray.checkNeighbours(i, j) > 3 && myArray.isAlive(i, j)) {
            myArray.setDead(i, j);
          } else if (myArray.checkNeighbours(i, j) == 3 && !myArray.isAlive(i, j)) {
            myArray.setAlive(i, j);
          }
        }
      }
    } else if (e.getKeyCode() == KeyEvent.VK_S) {
      System.out.println("stop");
      
    }
    repaint();
  }
}