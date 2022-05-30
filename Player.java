public class Player {

  Player nextPlayer;
  Player prevPlayer;
  ArrayList<Card> hand;
  String name;
  boolean isOut;

  public Player getNext() {
    return null;
  }

  public Player getPrev() {
    return null;
  }

  public void setNext(Player a) {
    nextPlayer = a;
  }

  public void setPrev(Player a) {
    prevPlayer = a;
  }
}
