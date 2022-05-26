import java.util.ArrayList;
public class Deck {
  ArrayList<Card> collection = new ArrayList<Card>();
  public Deck(){
    for(int i = 0; i < 4; i++){
      for(int j = 1; j < 13; j++){
        collection.add(new Card(i,j));
        collection.add(new Card(i,j));
      }
    }
    for(int i = 0; i < 4; i++){
      collection.add(new Card(i,0);
    }
      for(int j = 13; j < 15; j++){
        collection.add(new Card(5,j));
        collection.add(new Card(5,j));
        collection.add(new Card(5,j));
        collection.add(new Card(5,j));
    }
  }
}
