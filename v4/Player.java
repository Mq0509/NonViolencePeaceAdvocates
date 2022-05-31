import java.util.ArrayList;

public class Player {

  Player nextPlayer;
  Player prevPlayer;
  ArrayList<Card> hand;
  String name;
  boolean isOut;

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
  public boolean validateChoice(Card chosen, Card top) {
    if (chosen.getColor().equals(top.getColor())
    || chosen.getNumberOrSpecialty().equals(top.getNumberOrSpecialty())
    || chosen.getColor().equals("Wild")) {
      return true;
    }
    return false;
  }
  // public Card placeCard(int chosen, ) {
  //   hand.remove(chosen);
  //
  // }
}
