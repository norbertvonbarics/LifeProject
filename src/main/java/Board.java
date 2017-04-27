class Board {

  private static int size = 200;
  private static int[][] multi = new int[size][size];

  static boolean isAlive(int posX, int posY) {
    return (multi[posX][posY] == 1);
  }

  static void setDead(int posX, int posY) {
    multi[posX][posY] = 0;
  }

  static void setAlive(int posX, int posY) {
    multi[posX][posY] = 1;
  }

  void fillLists() {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        int random = (int) (Math.random() * 2);
        multi[i][j] = random;
      }
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

  static int[][] array2d() {
    return multi;
  }

  static String arrayToString() {
    String map = "";
    for (int[] aMulti : multi) {
      for (int j = 0; j < multi.length; j++) {
        map += aMulti[j] + " ";
      }
      map += "\n";
    }
    return map;
  }
}