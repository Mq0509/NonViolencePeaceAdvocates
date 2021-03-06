import java.util.ArrayList;
import java.util.Stack;

public class Deck {
  private ArrayList<Card> collection;
  private Card top;
  private Stack<Card> shuffled;
  public Deck(){
    collection = new ArrayList<Card>();
    for(int i = 1; i <= 4; i++){ //adding color cards + special cards numbered from 1 thru 9
      for(int j = 1; j <= 12; j++){
        collection.add(new Card(i,j));
        collection.add(new Card(i,j));
      }
    }
    for(int i = 0; i < 4; i++){ //adding color cards numbered 0
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

  public Deck(Stack<Card> asdf) { //making a new deck from used Cards
    while (!asdf.empty()) {
      collection.add(asdf.pop());
    }
    shuffle();
    shuffled = new Stack<Card>();
    for (int i = 0 ; i < collection.size() ; i++) {
      shuffled.push(collection.get(i));
    }
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
    return shuffled.pop();
  }

  public String toString() {
    return shuffled.toString();
  }

  public static void main(String[] args) {
    Deck softwaredevelopment = new Deck();
    System.out.println(softwaredevelopment);

    System.out.println("\nShuffling Again");
    softwaredevelopment.shuffle();
    softwaredevelopment.putCardsDown();
    System.out.println(softwaredevelopment);

    System.out.println("\nSwapping the first and second card");
    softwaredevelopment.swap(0, 1);
    softwaredevelopment.putCardsDown();
    System.out.println(softwaredevelopment);

  }
}
