class Board {

  static final int size = 200;
  private static int[][] multi = new int[size][size];

  static void setDead(int posX, int posY) {
    multi[posX][posY] = 0;
  }

  static void setAlive(int posX, int posY) {
    multi[posX][posY] = 1;
  }

  void fillLists() {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (j < 150 && j > 50 && i < 150 && i > 50) {
          int random = (int) (Math.random() * 2);
          multi[i][j] = random;
        } else {
          multi[i][j] = 0;
        }
      }
    }
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

  void spacecraft (){
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
          multi[i][j] = 0;
      }
    }
    setAlive(99,99);
    setAlive(98,98);
    setAlive(97, 97);
    setAlive(98,99);
    setAlive(98,100);
    setAlive(97,101);
    setAlive(96, 99);
    setAlive(95, 102);
    setAlive(94,102);
    setAlive(93,101);
    setAlive(92,100);
    setAlive(92,99);
    setAlive(92, 98);
    setAlive(93,97);
    setAlive(94,96);
    setAlive(95,96);
    setAlive(102,100);
    setAlive(103,100);
    setAlive(102,101);
    setAlive(103,101);
    setAlive(102,102);
    setAlive(103,102);
    setAlive(104,99);
    setAlive(104,103);
    setAlive(106,98);
    setAlive(106,99);
    setAlive(106,103);
    setAlive(106,104);
    setAlive(116,101);
    setAlive(117,101);
    setAlive(116,102);
    setAlive(117,102);
    setAlive(82,99);
    setAlive(83,99);
    setAlive(82,100);
    setAlive(83,100);
  }
}