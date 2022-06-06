import java.util.ArrayList;

public class Player {

  protected Player nextPlayer;
  protected Player prevPlayer;
  protected ArrayList<Card> hand;
  protected String _name;
  protected boolean won;
  protected boolean immakingthiscomplicatedandmayiswatchingme;

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
    if (chosen == hand.size()) {    //No cards to place
      return true;
    }

    Card boopyboop = hand.get(chosen);
    if (boopyboop.getColor().equals(top.getColor())
    || boopyboop.getNumberOrSpecialty().equals(top.getNumberOrSpecialty())
    || boopyboop.getColor().equals(top.getSecondary())
    || boopyboop.isWild()) {
      return true;
    }
    return false;
  }

  public boolean validateTwo(int chosen, Card top) {
    if(chosen.getNumberOrSpecialty().equals("+4"){ //if chosen is +4 it can always be played
      return true;
    }
    if(chosen.getNumberOrSpecialty().equals("+2")){
      if(top.getNumberOrSpecialty().equals("+2")){
        return true;
      }
      else if(top.isWild() && top.getColor().equals(chosen.getColor())){
        return true;
      }
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

  }

  public int go(Card top) {
    return -392;
  }

  public int getHandSize() {
    return hand.size();
  }

  public void uno(Deck aDeck) {

  }

  public void unoOut(Deck aDeck) {

  }

  public int respondToAdding(Card top) {
    return -1;
  }

  public static void main(String[] args) {
    Player jefferyiseatingagranolabar = new Player("Jeffery");
    Card granolabar = new Card(1,2);
    System.out.println(granolabar);
    jefferyiseatingagranolabar.draw(granolabar);
    System.out.println(jefferyiseatingagranolabar);
  }
}
