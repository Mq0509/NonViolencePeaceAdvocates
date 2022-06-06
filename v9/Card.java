public class Card{
  private static final String RESET = "\033[0m";
  private static final String RED = "\u001B[31m";
  private static final String GREEN = "\u001B[32m";
  private static final String YELLOW = "\033[0;33m";
  private static final String BLUE = "\u001B[34m";


  private int _color;
  private int _numberOrSpecialty;
  private int _secondary; // FOR WILD CARDS
  public Card(int color, int numberOrSpecialty){
    _color = color;
    _numberOrSpecialty = numberOrSpecialty;
    _secondary = 325392;
  }

  public String getColor() {
    String color = "";
    if (_color == 1) {
      color = RED + "Red" + RESET;
    }
    else if (_color == 2) {
      color = GREEN + "Green" + RESET;
    }
    else if (_color == 3) {
      color = YELLOW + "Yellow" + RESET;
    }
    else if (_color == 4) {
      color = BLUE + "Blue" + RESET;
    }
    else {
      _color = 5;
      color = RED + "W" + BLUE + "I" + YELLOW + "L" + GREEN + "D" + RESET;
    }
    return color;
  }

  public boolean isWild() {
    if (_color == 5) {
      return true;
    }
    return false;
  }

  public String getNumberOrSpecialty() {
    String numberOrSpecialty = "";
    if (_numberOrSpecialty >= 0 && _numberOrSpecialty <= 9) {
      numberOrSpecialty = "" + _numberOrSpecialty;
    }
    else if (_numberOrSpecialty == 10) {
      numberOrSpecialty = "+2";
    }
    else if (_numberOrSpecialty == 11) {
      numberOrSpecialty = "Reverse";
    }
    else if (_numberOrSpecialty == 12) {
      numberOrSpecialty = "Skip";
    }
    else if (_numberOrSpecialty == 13 ) {
      numberOrSpecialty = "Regular";
    }
    else {
      numberOrSpecialty = "+4"; //_numberOrSpecialty = 14
    }
    return numberOrSpecialty;
  }

  public void setSecondary(int chosen) { // FOR WHEN PLAYERS CHOOSE A WILD CARD
    _secondary = chosen;
  }

  public String getSecondary() {
    String color = "";
    if (_secondary == 1) {
      color = RED + "Red" + RESET;
    }
    else if (_secondary == 2) {
      color = GREEN + "Green" + RESET;
    }
    else if (_secondary == 3) {
      color = YELLOW + "Yellow" + RESET;
    }
    else if (_secondary == 4) {
      color = BLUE + "Blue" + RESET;
    }
    return color;
  }

  public String toString() {
    String ret = getColor() + " " + getNumberOrSpecialty();
    if (isWild()) {
      ret += " " + getSecondary();
    }
    return ret;
  }

  public static void main(String[] args) {

    Card scared = new Card(5,13);
    System.out.println(scared);

  }
}
