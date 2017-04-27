
class Motion {



  static void motion() {
    for (int i = 0; i < Board.array2d().size(); i++) {
      for (int j = 0; j < Board.array2d().size(); j++) {
        if ((Board.checkNeighbours(i, j) < 2) && Board.isAlive(i, j)) {
          Board.setDead(i, j);
        } else if (((Board.checkNeighbours(i, j) == 2) || (Board.checkNeighbours(i, j) == 3)) && Board.isAlive(i, j)) {
          Board.setAlive(i, j);
        } else if ((Board.checkNeighbours(i, j) > 3) && Board.isAlive(i, j)) {
          Board.setDead(i, j);
        } else if ((Board.checkNeighbours(i, j) == 3) && !Board.isAlive(i, j)) {
          Board.setAlive(i, j);
        }
      }
    }
  }
}