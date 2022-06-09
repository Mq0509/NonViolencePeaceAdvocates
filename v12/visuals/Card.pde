class Card {

  private int _color;
  private int _numberOrSpecialty;
  private int _secondary; // FOR WILD CARDS
  PImage visual;
  public Card(int colore, int numberOrSpecialty) {
    _color = colore;
    _numberOrSpecialty = numberOrSpecialty;
    _secondary = 0;
  }

  public String getColor() {
    String colore = "";
    if (_color == 1) {
      colore = "Red_";
    } else if (_color == 2) {
      colore = "Green_";
    } else if (_color == 3) {
      colore = "Yellow_";
    } else if (_color == 4) {
      colore = "Blue_";
    } else {
      _color = 5;
      colore = "Wild_";
    }
    return colore;
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
    } else if (_numberOrSpecialty == 10) {
      numberOrSpecialty = "Draw";
    } else if (_numberOrSpecialty == 11) {
      numberOrSpecialty = "Reverse";
    } else if (_numberOrSpecialty == 12) {
      numberOrSpecialty = "Skip";
    } else if (_numberOrSpecialty == 13 ) {
      numberOrSpecialty = "Regular";
    } else {
      numberOrSpecialty = "+4"; //_numberOrSpecialty = 14
    }
    return numberOrSpecialty;
  }

  public void setSecondary(int chosen) { // FOR WHEN PLAYERS CHOOSE A WILD CARD
    _secondary = chosen;
  }

  public String getSecondary() {
    String colore = "";
    if (_secondary == 1) {
      colore = "Red";
    } else if (_secondary == 2) {
      colore = "Green";
    } else if (_secondary == 3) {
      colore = "Yellow";
    } else if (_secondary == 4) {
      colore = "Blue";
    }
    return colore;
  }

  public String toString() {
    String ret = getColor() + getNumberOrSpecialty();
    if (isWild()) {
      ret += getSecondary();
    }
    return ret;
  }
  
  void setVisual(String value){
    this.visual = loadImage(this.toString()+".png");
  }

  //public static void main(String[] args) {

  //  Card scared = new Card(5,13);
  //  System.out.println(scared);

  //}
}
