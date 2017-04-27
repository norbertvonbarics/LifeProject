import java.util.ArrayList;
import java.util.List;

class Board {

  int size = 100;
  List<List<Integer>> multi = new ArrayList<>();

  List<List<Integer>> array2d() {
    return multi;
  }

  boolean isAlive(int posX, int posY) {
    return (array2d().get(posX).get(posY) == 1);
  }

  public void setDead(int posX, int posY) {
    multi.get(posX).set(posY, 0);
  }

  public void setAlive(int posX, int posY) {
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

  int checkNeighbours(int posX, int posY) {
    List<Boolean> checkList = new ArrayList<>();

    int counter = 0;

    boolean pos1 = isAlive(posX - 1, posY);
    boolean pos2 = isAlive(posX, posY - 1);
    boolean pos3 = isAlive(posX + 1, posY);
    boolean pos4 = isAlive(posX, posY + 1);
    boolean pos5 = isAlive(posX - 1, posY - 1);
    boolean pos6 = isAlive(posX + 1, posY + 1);
    boolean pos7 = isAlive(posX + 1, posY - 1);
    boolean pos8 = isAlive(posX - 1, posY + 1);

    checkList.add(pos1);
    checkList.add(pos2);
    checkList.add(pos3);
    checkList.add(pos4);
    checkList.add(pos5);
    checkList.add(pos6);
    checkList.add(pos7);
    checkList.add(pos8);

    for (boolean item : checkList) {
      if (item) {
        counter++;
      }
    }
    return counter;
  }
}