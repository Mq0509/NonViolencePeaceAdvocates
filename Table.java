public class Table() {
  private ArrayList<Card> placed = new ArrayList<Card>();
  private Deck aDeck = new Deck();

  public void addCard(Card used) {
    placed.add(used);
  }
  public Card placeFirst() {
    placed.add(aDeck.draw());
    return placed[0];
  }

  public ArrayList<Card> getPlaced() {
    return placed;
  }

  public Card refill() {
    if (aDeck.getSize() == 0) {
      for(int i = 0; i < placed.size(); i++){
        aDeck
      }
    }
  }
}
