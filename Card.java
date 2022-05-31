public class Card{
  private int _color;
  private int _numberOrSpecialty;
  public Card(int color, int numberOrSpecialty){
    _color = color;
    _numberOrSpecialty = numberOrSpecialty;
  }

  public String getColor() {
    String color = "";
    if (_color == 1) {
      color = "Red";
    }
    else if (_color == 2) {
      color = "Green";
    }
    else if (_color == 3) {
      color = "Yellow";
    }
    else if (_color == 4) {
      color = "Blue";
    }
    else {
      color = "Wild";
    }
    return color;
  }

  public String getNumberOrSpecialty() {
    String numberOrSpecialty = "";
    if (_numberOrSpecialty >= 0 && _numberOrSpecialty <= 9) {
      numberOrSpecialty += _numberOrSpecialty;
    }
    else if (_numberOrSpecialty == 10) {
      numberOrSpecialty = "+2";
    }
    else if (_numberOrSpecialty == 11) {
      numberOrSpecialty = "Reverse";
    }
    else if (_numberOrSpecialty == 12) {
      numberOrSpecialty = "Cancel";
    }
    else if (_numberOrSpecialty == 13) {
      numberOrSpecialty = "Regular";
    }
    else {
      numberOrSpecialty = "+4";
    }
    return numberOrSpecialty;
  }

  public String toString() {
    return getColor() + " " + getNumberOrSpecialty();
  }

  public static void main(String[] args) {
    Card i = new Card(1, 4);
    System.out.println(i);
    Card am = new Card(1, 12);
    System.out.println(am);
    Card hungry = new Card(5, 14);
    System.out.println(hungry);
  }
}
