import java.util.ArrayList;

public class Player {

  Player nextPlayer;
  Player prevPlayer;
  ArrayList<Card> hand;
  String _name;
  boolean isOut;

  public Player(String name){
    _name = name;
    hand = new ArrayList<Card>();
  }

  public void setName(String name){
    _name = name;
  }

  public String getName(){
    return _name;
  }

  public Player getNext() {
    return nextPlayer;
  }

  public Player getPrev() {
    return prevPlayer;
  }

  public void setNext(Player a) {
    nextPlayer = a;
  }

  public void setPrev(Player a) {
    prevPlayer = a;
  }

  public Player nextInLine(int direction) {
    if (direction == 0) {
      return getNext();
    }
    else {
      return getPrev();
    }
  }

  public boolean validateChoice(int chosen, Card top) {
    Card boopyboop = hand.get(chosen);
    if (boopyboop.getColor().equals(top.getColor())
    || boopyboop.getNumberOrSpecialty().equals(top.getNumberOrSpecialty())
    || boopyboop.getColor().equals("Wild")) {
      return true;
    }
    else if (chosen == hand.size()) {
      return true;
    }
    return false;
  }

  public boolean wonOrNot(){
    if(hand.size() == 0){
      return true;
    }
    return false;
  }

  public Card removeCard(int removezies){
    return hand.remove(removezies);
  }

  public void draw(Card yes) {
    hand.add(yes);
  }

  public String toString() {
    String ret = _name + "\n";
    for (int i = 0; i < hand.size(); i++) {
      ret += "" + i + ". " + hand.get(i) + "\n";
    }
    ret += hand.size() + ". No cards to place. Draw 2 cards.";
    return ret;
  }

  public void setSecondary(Card wild) {
    wild.setSecondary(1);
  }

  public int go(Card top) {
    for (int i = 1; i < hand.size(); i++) {
      if (validateChoice(i, top)) {
        return i;
      }
    }
    return getHandSize();
  }

  public int getHandSize() {
    return hand.size();
  }

  public static void main(String[] args) {
    Player jefferyiseatingagranolabar = new Player("Jeffery");
    Card granolabar = new Card(1,2);
    System.out.println(granolabar);
    jefferyiseatingagranolabar.draw(granolabar);
    System.out.println(jefferyiseatingagranolabar);
  }
}
