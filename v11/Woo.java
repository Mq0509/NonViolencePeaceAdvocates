import java.util.Scanner;
public class Woo{
  public static void startMenu(){
    String reset = "\u001B[37m";
    String red = "\u001B[31m";
    Scanner hehe = new Scanner(System.in);
      System.out.println("Please Choose an Option:");
      System.out.println("1. Start: Reguar Mode      2. Start: Betting Mode        3. How to Play        4. Quit        ");
      String input = hehe.nextLine();
      input = input.toLowerCase();
      System.out.println("\033[H\033[2J");
      if(input.equals("1") || input.toLowerCase().equals("start: regular mode")){
        // System.out.println("PLAY");
        // System.out.println("\033[H\033[2J");
        play();
      }
      else if(input.equals("2") || input.toLowerCase().equals("start : betting mode")) {
        bet();
      }
      else if(input.equals("3") || input.toLowerCase().equals("how to play")){
        System.out.println("The " + red + "OBJECTIVE" + reset + " is to clear all of your cards.");
        System.out.println("Players can put down a card of the same color or number");
        System.out.println("If player does not have any card, they must take one card from the deck");
        System.out.println("Special cards include: reverse, add 2, add 4, wild, and skip. ");
        System.out.println("If player does not have any card, they must take one card from the deck");
        System.out.println("Add 2 may be placed on a add 4 if the color of the plus 4 is the same color of the plus 2");
        System.out.println("Once player has one card left, player must type uno or UNO into the terminal within 3 seconds");
        System.out.println("Player must type UNO-OUT or uno-out within 5 seconds inside the terminal once player has no cards");
        System.out.println("If player does not type into the terminal in the designated time, player will recieve 1 card");
        System.out.println("Type ready to continue");
        String x = hehe.next();
        if(x.equals("ready")){
          try {
              Thread.sleep(2000);
            }
            catch (InterruptedException e) {
            }
        }
        System.out.println("\033[H\033[2J");
        play();
      }
      else{
        System.out.print("\033[H\033[2J");
      }
  }

  public static void play(){
    Scanner sc = new Scanner(System.in);
    System.out.println("¿Cual es tu nombre?");
    String name = sc.nextLine();
    Player p1 = new Human(name);
    Player p2 = new Bot("Kenny");
    Player p3 = new Bot("Rachel");
    Player p4 = new Bot("Bob The Builder");
    Table newGame = new Table(p1,p2,p3,p4);
    newGame.placeFirst();
    newGame.distribute();

    // System.out.println(p1);            Making sure distribute works <3
    // System.out.println("--\n");
    //
    // System.out.println(p2);
    // System.out.println("--\n");
    //
    // System.out.println(p3);
    // System.out.println("--\n");
    //
    // System.out.println(p4);
    // System.out.println("--\n");
    //
    // System.out.println("Topmost card: " + newGame.getTop());

    newGame.go();
  }

  public static void bet() {
    System.out.println("The line-up of bots playing today are:   Mykolyk, Konstantinovich, DW, and Brooks");
    System.out.println("Who do you want to bet on?");
    System.out.println("1. Mykolyk\n" +
                       "2. Konstantinovich\n" +
                       "3. DW\n" +
                       "4. Brooks\n");
    Scanner sc = new Scanner(System.in);
    int aiibet = sc.nextInt();
    String bet;
    if (aiibet == 1) {
      bet = "Mykolyk";
    }
    else if (aiibet == 2) {
      bet = "Konstantinovich";
    }
    else if (aiibet == 3) {
      bet = "DW";
    }
    else {
      bet = "Brooks";
    }

    Player p1 = new Bot("Mykolyk");
    Player p2 = new Bot("Konstantinovich");
    Player p3 = new Bot("DW");
    Player p4 = new Bot("Brooks");
    Table newGame = new Table(p1, p2, p3, p4);
    newGame.placeFirst();
    newGame.distribute();
    newGame.go();
    if (newGame.getWinner().equals(bet)) {
      System.out.println("You were right! " + bet + " won! ... We don't have anything to offer you :)");
    }
    else {
      System.out.println("You were wrong! " + bet + " lost ... May will now have to slap you :(");
    }
  }

  public static void main(String[] args) {
    startMenu();
  }
}
