import java.util.ArrayList;
import java.util.List;

class Board {

  static int size = 10;
  static List<List<Integer>> multi = new ArrayList<>();
  static List<List<Integer>> array2d() {
    return multi;
  }

  static boolean isAlive(int posX, int posY) {
    return (multi.get(posX).get(posY) == 1);
  }

  static void setDead(int posX, int posY) {
    multi.get(posX).set(posY, 0);
  }

  static void setAlive(int posX, int posY) {
    multi.get(posX).set(posY, 1);
  }

  void fillLists() {
    for (int i = 0; i < size; i++) {
      List<Integer> innerList = new ArrayList<>();
      for (int j = 0; j < size; j++) {
        int random = (int) (Math.random() * 2);
        innerList.add(random);
      }
      multi.add(innerList);
    }
  }

  static int checkNeighbours(int posX, int posY) {
    int counter = 0;

    if (posX > 0 && isAlive(posX - 1, posY)) {
      counter++;
    }
    if (posX > 0 && posY < size - 1 && isAlive(posX - 1, posY + 1)) {
      counter++;
    }

    if (posY > 0 && isAlive(posX, posY - 1)) {
      counter++;
    }
    if (posY > 0 && posX < size - 1 && isAlive(posX + 1, posY - 1)) {
      counter++;
    }
    if (posX > 0 && posY > 0 && isAlive(posX - 1, posY - 1)) {
      counter++;
    }
    if (posX < size - 1 && isAlive(posX + 1, posY)) {
      counter++;
    }
    if (posY < size - 1 && isAlive(posX, posY + 1)) {
      counter++;
    }
    if (posX < size - 1 && posY < size - 1 && isAlive(posX + 1, posY + 1)) {
      counter++;
    }
    return counter;
  }
}