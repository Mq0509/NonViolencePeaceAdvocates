import java.util.ArrayList;
public class Deck {
  private ArrayList<Card> collection;
  private Card top;
  public Deck(){
    collection = new ArrayList<Card>();
    for(int i = 0; i < 4; i++){ //adding color cards + special cards numbered from 1 thru 9
      for(int j = 1; j < 13; j++){
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
  }
  public Deck(ArrayList asdf) {
    collection = asdf;
  }

  public void swap(int card1, int card2) {
    Card temp = collection.get(card2);
    collection.swap(card2, collection.get(card1));
    collection.swap(card1, temp);
  }

  public void shuffle() {
    for(int c = 0; c < collection.size() ; c++) {
      swap(c, (int) (Math.random*collection.size));
    }
  }

  public Card draw() {
    collection.remove();
  }

  public int getSize() {
    return collection.size();
  }

  public void refill
}
