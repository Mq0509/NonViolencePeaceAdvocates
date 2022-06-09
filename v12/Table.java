import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;

public class Table {
  private Stack<Card> placed = new Stack<Card>();
  private Deck aDeck = new Deck();
  private int direction = 0;
  private Player current;
  private Player winner;
  private Card top;
  private boolean isStacking = false;
  private int stack_size = 0;

  private static final String RESET = "\033[0m";
  private static final String RED = "\u001B[31m";
  private static final String GREEN = "\u001B[32m";
  private static final String YELLOW = "\033[0;33m";
  private static final String BLUE = "\u001B[34m";

  public static final String PURPLE = "\u001b[35;1m";
  public static final String CYAN = "\u001B[36m";

  public int ctr = 0;


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
    System.out.println("Topmost Card : " + top + "\n");
    if (current.isHuman()) {
      System.out.println(current);    //cards player has
    }

    // if (ctr == 10) {             //for testing purposes porque idkidkdikdikdifdididididodsh
    //   return;
    // }
    // ctr++;

    System.out.println(current.getName() + " has " + current.getHandSize() + " card(s)");

    if (isStacking == true) { // first check if we're in stacking... 'mode'
      int placingCard = current.respondToAdding(top);
      if (placingCard != -1) { //if a valid card was chosen
        placeCard(placingCard);
        System.out.println(current.getName() + " adds another card onto the stack");

        if (top.getNumberOrSpecialty().equals("+2")) {
          stack_size += 2;
        }
        else {
          stack_size += 4;
        }
        System.out.println("Current stack size : " + stack_size);
        current.uno();
        current = current.nextInLine(direction);

        go();
      }
      else {
        isStacking = false;

        System.out.println(CYAN + "The stack ended! " + current.getName() + " must draw " + stack_size + " cards!" + RESET);
        aDeck.replenish(placed);
        drawCurrent(stack_size);
        stack_size = 0;
        //current = current.nextInLine(direction);
        go();
      }
    }

    else {
      int placingCard = current.go(top); //player chooses a card

      if (placingCard == current.getHandSize()) { //no cards available to choose
        aDeck.replenish(placed);
        current.draw(aDeck.removeFromDeck());
        current.draw(aDeck.removeFromDeck());
        System.out.println(current.getName() + " decided to draw two cards\n----------------------------------------------\n");
        current = current.nextInLine(direction);
        go();
      }
      else if(current.validateChoice(placingCard, top) == true){
        placeCard(placingCard);
        processCard();
        if (current.wonOrNot()) {
          return;
        }
        go();
      }
      else{
        System.out.println("Pick a valid card or else you will be punched by the extremely non violent peace advocates");
        go();

      }
    }
  }

  public Card placeFirst() {
    placed.push(aDeck.removeFromDeck());
    top = placed.peek();
    if (top.isWild()) {
      int random = (int)(Math.random() * 4 + 1);
      top.setSecondary(random);
    }
    return top;
  }

  public Stack<Card> getPlaced() {
    return placed;
  }

  public void placeCard(int chosen) {
    placed.push(current.removeCard(chosen));
    top = placed.peek();
  }

  public void processCard(){
    System.out.println(current.getName() + " placed a " + top + "\n----------------------------------------------");
    current.uno(aDeck);
    if (current.wonOrNot()) {
      winner = current;
      return;
    }
    else if (top.getNumberOrSpecialty().equals("Reverse")){
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
      aDeck.replenish(placed);
      isStacking = true;
      stack_size = 2;
      current = current.nextInLine(direction);

    }
    else if (top.getNumberOrSpecialty().equals("+4")) {
      aDeck.replenish(placed);
      current.setSecondary(top);
      isStacking = true;
      stack_size = 4;
      current = current.nextInLine(direction);
    }
    else if (top.isWild()) {
      current.setSecondary(top);
      current = current.nextInLine(direction);
    }
    else {
      current = current.nextInLine(direction);
    }
  }

  public String getWinner() {
    return winner.getName();
  }

  public void drawCurrent(int num){
    for(int i = 0; i < num; i++){
      current.draw(aDeck.removeFromDeck());
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

  public Card getTop() {
    return top;
  }

}
