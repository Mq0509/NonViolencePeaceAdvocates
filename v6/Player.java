import java.util.ArrayList;

public class Player {

  Player nextPlayer;
  Player prevPlayer;
  ArrayList<Card> hand;
  String _name = "bob";
  boolean isOut;

  public Player(String name){
    setName(name);
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
}
