import java.util.ArrayList;
import java.util.Stack;

public class Deck {
  private ArrayList<Card> collection;
  private Card top;
  private Stack<Card> shuffled;

  private static final String RED = "\u001B[31m";
  private static final String RESET = "\033[0m";

  public Deck(){
    collection = new ArrayList<Card>();
    for(int i = 1; i <= 4; i++){ //adding color cards + special cards numbered from 1 thru 9
      for(int j = 1; j <= 12; j++){
        collection.add(new Card(i,j));
        collection.add(new Card(i,j));
      }
    }
    for(int i = 1; i <= 4; i++){ //adding color cards numbered 0
      collection.add(new Card(i,0));
    }
      for(int j = 13; j < 15; j++){ //adding wild cards
        collection.add(new Card(5,j));
        collection.add(new Card(5,j));
        collection.add(new Card(5,j));
        collection.add(new Card(5,j));
    }
    shuffle(); //shuffling the deck
    shuffled = new Stack<Card>();
    for (int i = 0 ; i < collection.size() ; i++) { //putting the Cards in a Stack
      shuffled.push(collection.get(i));
    }
  }

  public void replenish(Stack<Card> asdf) { //making a new deck from used Cards
    Card top = asdf.pop();
    while (!asdf.empty()) {
      Card toberemoved = asdf.pop();
      toberemoved.setSecondary(0);
      // if (toberemoved.isWild()) {
      //   System.out.println(RED + "REPLENISHED: " + toberemoved + RESET);
      // }
      collection.add(toberemoved);
    }
    shuffle();
    shuffled = new Stack<Card>();
    for (int i = 0 ; i < collection.size() ; i++) {
      shuffled.push(collection.get(i));
    }
    asdf.push(top);
    System.out.println("what");
  }

  public void putCardsDown() {
    shuffled = new Stack<Card>();
    for (int i = 0 ; i < collection.size() ; i++) { //putting the Cards in a Stack
      shuffled.push(collection.get(i));
    }
  }

  public void swap(int card1, int card2) {
    Card temp = collection.get(card2);
    collection.set(card2, collection.get(card1));
    collection.set(card1, temp);
  }

  public void shuffle() {
    for(int c = 0; c < collection.size() ; c++) {
      swap(c, (int)(Math.random()* collection.size()));
    }
  }

  public Card removeFromDeck() {
    collection.remove(collection.size() - 1);
    return shuffled.pop();
  }

  public String toString() {
    return shuffled.toString();
  }

  public int getSize() {
    return shuffled.size();
  }
}
