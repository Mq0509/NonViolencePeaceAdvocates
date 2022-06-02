import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;

public class Table {
  private Stack<Card> placed = new Stack<Card>();
  private Deck aDeck = new Deck();
  private int direction = 0;
  private Player current;
  private Card top;

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
    System.out.println("\nTopmost Card : " + top + "\n");

    System.out.println(current);
    int placingCard = current.go(top);

    if (placingCard == current.getHandSize()) {
      current.draw(aDeck.removeFromDeck());
      current.draw(aDeck.removeFromDeck());
      System.out.println(current + " drew two cards\n--\n");
      go();
    }
    else if(current.validateChoice(placingCard, top) == true){
      placeCard(placingCard);
      processCard();
      go();
    }
    else{
      System.out.println("Pick a valid card or else you will be punched by the extremely non violent peace advocates");
      go();
    }
  }

  public Card placeFirst() {
    placed.push(aDeck.removeFromDeck());
    top = placed.peek();
    return top;
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
    top = placed.peek();
  }

  public void processCard(){
    System.out.println(current.getName() + " placed a " + top + "\n--");
    if (top.getNumberOrSpecialty().equals("Reverse")){
      if(direction == 1){
        direction = 0;
      }
      else{
        direction = 1;
      }
      current = current.nextInLine(direction);
    }
    else if (top.getNumberOrSpecialty().equals("Skip")){
      current = current.nextInLine(direction).nextInLine(direction);
    }
    else if (top.getNumberOrSpecialty().equals("+2")) {
      current.nextInLine(direction).draw(aDeck.removeFromDeck());
      current.nextInLine(direction).draw(aDeck.removeFromDeck());
      current = current.nextInLine(direction);
    }
    else if (top.getNumberOrSpecialty().equals("+4")) {
      current.nextInLine(direction).draw(aDeck.removeFromDeck());
      current.nextInLine(direction).draw(aDeck.removeFromDeck());
      current.nextInLine(direction).draw(aDeck.removeFromDeck());
      current.nextInLine(direction).draw(aDeck.removeFromDeck());

      current.setSecondary(top);
      current = current.nextInLine(direction);
    }
    else if (top.getColor().equals("Wild")) {
      current.setSecondary(top);
      current = current.nextInLine(direction);
    }
    else {
      current = current.nextInLine(direction);
    }

  }

  public void distribute() {
    for(int x = 0 ; x < 4 ; x++) {
      for (int l = 0 ; l < 7 ; l++) {
        current.draw(aDeck.removeFromDeck());
      }
      current = current.nextInLine(direction);
    }
  }

public void Uno(){

  Scanner uNoOuT = new Scanner(System.in);
  if(current.getHandSize() == 1){
    long time = System.currentTimeMillis();
    System.out.println("You have one card");
    String dhed = uNoOuT.next();
    long secondTime = System.currentTimeMillis();
    time = secondTime - time;
    if(time <= 3000){
      System.out.println("You now have 1 card");
    }
    else{
      current.draw(aDeck.removeFromDeck());
    }
  }
}
  public Card getTop() {
    return top;
  }
}
