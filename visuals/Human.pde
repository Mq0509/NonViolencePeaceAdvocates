import java.util.Scanner;

public class Human extends Player {

  public Human(String name) {
    super(name);
  }

  public boolean isHuman() {
    return true;
  }

  @Override
  public void setSecondary(Card wild) {
    Scanner sc = new Scanner(System.in);
    System.out.println("What color do you want to change it to?\n" +
                        "1. Red\n" +
                        "2. Green\n" +
                        "3. Yellow\n" +
                        "4. Blue\n");

    int chosen = sc.nextInt();

    if (chosen >= 1 && chosen <= 4) {
      wild.setSecondary(chosen);
    }
    else {
      System.out.println("Invalid color... Automatically set to red.");
      wild.setSecondary(1);
    }
  }

  @Override
  public int go(Card top) {
    Scanner whatCard = new Scanner(System.in);
    System.out.println("Type the index of the card you wish to place.");
    int placingCard = whatCard.nextInt();
    while (validateChoice(placingCard, top) == false) {
      System.out.println("Invalid index. Type the index of the card you wish to place.");
      placingCard = whatCard.nextInt();
    }
    return placingCard;
  }

  public int respondToAdding(Card top) {
    Scanner whatCard = new Scanner(System.in);
    System.out.println("\u001B[35m" + "Choose a card to stack on, or draw cards" + "\u001B[0m"); //purple + msg + reset
    int index = whatCard.nextInt();
    if (validateTwo(index, top)) {
      return index;
    }
    return -1;
  }

  public void uno(Deck aDeck){

    Scanner sc = new Scanner(System.in);
    if(getHandSize() == 1){
      long time = System.currentTimeMillis();
      System.out.println("You have one card");
      String input = sc.next();
      long secondTime = System.currentTimeMillis();
      time = secondTime - time;
      if(time <= 3000 && (input.equals("UNO") || input.equals("uno"))){
        System.out.println(":)");
      }
      else{
        System.out.println("You did not type UNO fast enough. You take another card.");
        draw(aDeck.removeFromDeck());
      }
    }
    else if (getHandSize() == 0) {
      long time = System.currentTimeMillis();
      System.out.println("You don't have any cards left");
      String input = sc.nextLine();
      long secondTime = System.currentTimeMillis();
      time = secondTime - time;
      if(time <= 5000 && (input.equals("UNO-OUT") || input.equals("uno-out"))){
        System.out.println("YOU WON! AHHHHHHHHHHHHHHHHH");
        won = true;
      }
      else{
        System.out.println("... You were so close, but you didn't type UNO-OUT. You take another card.");
        draw(aDeck.removeFromDeck());
      }
    }
  }

}
