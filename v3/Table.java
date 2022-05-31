import java.util.ArrayList;
import java.util.Stack;

public class Table {
  private Stack<Card> placed = new Stack<Card>();
  private Deck aDeck = new Deck();
  private int direction = 0;
  private Player current;
  private Player winner;

  public Table (Player p1, Player p2, Player p3, Player p4) {

  }
  public void addCard(Card used) {
    placed.push(used);
  }
  public Card placeFirst() {
    placed.push(aDeck.draw());
    return placed.peek();
  }

  public Stack<Card> getPlaced() {
    return placed;
  }
}
