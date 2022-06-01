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
  }

  public void go(){
    Scanner whatCard = new Scanner(System.in);
    System.out.println("Type the index of the card you wish to place");
    int placingCard = whatCard.nextInt();
    if(current.validateChoice(card, placed.peek()) == true){
      placeCard(placingCard);
      endGame();
      goNext();
      go();
    }
    else{
      System.out.println("pick a correct card or else you will be punched");
      go();
    }
  }

  public Card placeFirst() {
    placed.push(aDeck.draw());
    return placed.peek();
  }

  public Stack<Card> getPlaced() {
    return placed;
  }
  public void endGame(){
    if (current.wonOrNot() == true){
      System.out.println(current.getName() + "has won the game");
      System.out.println("\033[H\033[2J");
    }
  }
  public void placeCard(int chosen) {
    placed.push(current.removeCard(chosen));
  }

  public void goNext(){
    if((placed.peek()).getNumberOrSpecialty() == 10){
    if(direction == 1){
      direction = 0;
      current = current.getNext();
    }
    else{
      direction = 1;
      current = current.getPrev();
    }
  }
  if((placed.peek()).getNumberOrSpecialty() == 11){
    if(direction == 1){
      current = current.getNext().getNext();
    }
    else{
      current = current.getPrev().getPrev();
    }
  }
  }
}
