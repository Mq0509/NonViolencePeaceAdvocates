//public class Card{
//  private static final String RESET = "\033[0m";
//  private static final String RED = "\u001B[31m";
//  private static final String GREEN = "\u001B[32m";
//  private static final String YELLOW = "\033[0;33m";
//  private static final String BLUE = "\u001B[34m";


//  private int _color;
//  private int _numberOrSpecialty;
//  private int _secondary; // FOR WILD CARDS
//  public Card(int colore, int numberOrSpecialty){
//    _color = colore;
//    _numberOrSpecialty = numberOrSpecialty;
//    _secondary = 325392;
//  }

//  public String getColor() {
//    String colore = "";
//    if (_color == 1) {
//      colore = RED + "Red" + RESET;
//    }
//    else if (_color == 2) {
//      colore = GREEN + "Green" + RESET;
//    }
//    else if (_color == 3) {
//      colore = YELLOW + "Yellow" + RESET;
//    }
//    else if (_color == 4) {
//      colore = BLUE + "Blue" + RESET;
//    }
//    else {
//      colore = RED + "W" + BLUE + "I" + YELLOW + "L" + GREEN + "D" + RESET;
//    }
//    return colore;
//  }

//  public boolean isWild() {
//    if (_color == 5) {
//      return true;
//    }
//    return false;
//  }

//  public String getNumberOrSpecialty() {
//    String numberOrSpecialty = "";
//    if (_numberOrSpecialty >= 0 && _numberOrSpecialty <= 9) {
//      numberOrSpecialty = "" + _numberOrSpecialty;
//    }
//    else if (_numberOrSpecialty == 10) {
//      numberOrSpecialty = "+2";
//    }
//    else if (_numberOrSpecialty == 11) {
//      numberOrSpecialty = "Reverse";
//    }
//    else if (_numberOrSpecialty == 12) {
//      numberOrSpecialty = "Skip";
//    }
//    else if (_numberOrSpecialty == 13 ) {
//      numberOrSpecialty = "Regular";
//    }
//    else {
//      numberOrSpecialty = "+4"; //_numberOrSpecialty = 14
//    }
//    return numberOrSpecialty;
//  }

//  public void setSecondary(int chosen) { // FOR WHEN PLAYERS CHOOSE A WILD CARD
//    _secondary = chosen;
//  }

//  public String getSecondary() {
//    String colore = "";
//    if (_secondary == 1) {
//      colore = RED + "Red" + RESET;
//    }
//    else if (_secondary == 2) {
//      colore = GREEN + "Green" + RESET;
//    }
//    else if (_secondary == 3) {
//      colore = YELLOW + "Yellow" + RESET;
//    }
//    else if (_secondary == 4) {
//      colore = BLUE + "Blue" + RESET;
//    }
//    return colore;
//  }

//  public String toString() {
//    String ret = getColor() + " " + getNumberOrSpecialty();
//    if (isWild()) {
//      ret += " " + getSecondary();
//    }
//    return ret;
//  }

//  public void main(String[] args) {
//    Card i = new Card(1, 4);
//    print(i);
//    Card am = new Card(1, 12);
//    print(am);
//    Card hungry = new Card(5, 14);
//    print(hungry);

//    Card scared = new Card(5,13);
//    print(scared);

//  }
//}
