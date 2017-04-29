import java.time.LocalDate;

public class Stats {

  int minBitizen;
  int maxBitizen;
  LocalDate time;

  Stats(int minBitizen, int maxBitizen, LocalDate time) {
    this.minBitizen = minBitizen;
    this.maxBitizen = maxBitizen;
    this.time = time;
  }

  int getMinBitizen(int numberAlive) {
    if (numberAlive < minBitizen) {
      minBitizen = numberAlive;
    }
    return numberAlive;
  }

  int getMaxBitizen(int numberAlive) {
    if(numberAlive > maxBitizen) {
      maxBitizen = numberAlive;
    }
    return maxBitizen;
  }
}
