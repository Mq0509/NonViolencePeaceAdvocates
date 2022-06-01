import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;

public class Table {
  private Stack<Card> placed = new Stack<Card>();
  private Deck aDeck = new Deck();
  private int direction = 0;
  private Player current;

  public Table (Player p1, Player p2, Player p3, Player p4) {
    p1.setNext(p2);
    p2.setNext(p3);
    p3.setNext(p4);
    p4.setNext(p1);
    p1.setPrev(p4);
    p2.setPrev(p1);
    p3.setPrev(p2);
    p4.setPrev(p3);
    current = p1;
  }

  public void go(){
    Scanner whatCard = new Scanner(System.in);
    System.out.println("Type the index of the card you wish to place");
    int placingCard = whatCard.nextInt();
    if(current.validateChoice(placingCard, placed.peek()) == true){
      placeCard(placingCard);
      goNext();
      go();
    }
    else{
      System.out.println("pick a correct card or else you will be punched by the extremely non violent peace advocates");
      go();
    }
  }

  public Card placeFirst() {
    placed.push(aDeck.removeFromDeck());
    return placed.peek();
  }

  public Stack<Card> getPlaced() {
    return placed;
  }
  // public void endGame(){
  //   if (current.wonOrNot() == true){
  //     System.out.println(current.getName() + "has won the game");
  //     System.out.println("\033[H\033[2J");
  //   }
  // }
  public void placeCard(int chosen) {
    placed.push(current.removeCard(chosen));
  }

  public void goNext(){
    if((placed.peek()).getNumberOrSpecialty().equals("Reverse")){
      if(direction == 1){
        direction = 0;
      }
      else{
        direction = 1;
      }
      current = current.nextInLine(direction);
    }
    if((placed.peek()).getNumberOrSpecialty().equals("Skip")){
      current = current.nextInLine(direction).nextInLine(direction);
    }
    if((placed.peek()).getNumberOrSpecialty().equals("+2")) {
      current.nextInLine(direction).draw(aDeck.removeFromDeck());
      current.nextInLine(direction).draw(aDeck.removeFromDeck());
    }
  }
  public void distribute() {
    for(int x = 0 ; x < 4 ; x++) {
      for (int l = 0 ; l < 7 ; l++) {
        current.draw(aDeck.removeFromDeck());
      }
      current = current.getNext();
    }
  }
}
