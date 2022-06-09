import java.util.ArrayList;
import java.util.Stack;

class Deck {
  private ArrayList<Card> collection;
  private Card top;
  private Stack<Card> shuffled;
  public Deck() {
    collection = new ArrayList<Card>();
    for (int i = 1; i <= 4; i++) { //adding color cards + special cards numbered from 1 thru 9
      for (int j = 1; j <= 12; j++) {
        collection.add(new Card(i, j));
        collection.add(new Card(i, j));
      }
    }
    for (int i = 0; i < 4; i++) { //adding color cards numbered 0
      collection.add(new Card(i, 0));
    }
    for (int j = 13; j < 15; j++) { //adding wild cards
      collection.add(new Card(5, j));
      collection.add(new Card(5, j));
      collection.add(new Card(5, j));
      collection.add(new Card(5, j));
    }
    shuffle(); //shuffling the deck
    shuffled = new Stack<Card>();
    for (int i = 0; i < collection.size(); i++) { //putting the Cards in a Stack
      shuffled.push(collection.get(i));
    }
  }

  public void replenish(Stack<Card> asdf) { //making a new deck from used Cards
    Card top = asdf.pop();
    while (!asdf.empty()) {
      Card toberemoved = asdf.pop();
      toberemoved.setSecondary(0);
      //System.out.println("REPLENISHED: " + toberemoved);
      collection.add(toberemoved);
    }
    shuffle();
    shuffled = new Stack<Card>();
    for (int i = 0; i < collection.size(); i++) {
      shuffled.push(collection.get(i));
    }
    asdf.push(top);
  }

  public void putCardsDown() {
    shuffled = new Stack<Card>();
    for (int i = 0; i < collection.size(); i++) { //putting the Cards in a Stack
      shuffled.push(collection.get(i));
    }
  }

  public void swap(int card1, int card2) {
    Card temp = collection.get(card2);
    collection.set(card2, collection.get(card1));
    collection.set(card1, temp);
  }

  public void shuffle() {
    for (int c = 0; c < collection.size(); c++) {
      swap(c, (int)(Math.random()* collection.size()));
    }
  }

  public Card removeFromDeck() {
    return shuffled.pop();
  }

  public String toString() {
    return shuffled.toString();
  }

  //public static void main(String[] args) {
  //  Card wild = new Card(5, 14);
  //  wild.setSecondary(3);
  //  System.out.println(wild);
  //  wild.setSecondary(0);
  //  System.out.println(wild);

  //}
}
