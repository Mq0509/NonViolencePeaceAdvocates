import java.util.Scanner;
public class Woo{
  public static void main(String[] args) {
    String reset = "\u001B[37m";
    String red = "\u001B[31m";
    Scanner hehe = new Scanner(System.in);
      System.out.println("Please Choose an Option:");
      System.out.println("1. Start Game        2. How to Play        3. Quit        ");
      String input = hehe.nextLine();
      input = input.toLowerCase();
      System.out.println("\033[H\033[2J");
      if(input.equals("1") || input.equals("start game")){
        //PLAY;
        System.out.println("PLAY");
        System.out.println("\033[H\033[2J");
      }
      else if(input.equals("2") || input.equals("how to play")){
        System.out.println("The " + red + "OBJECTIVE" + reset + " is to clear all of your cards.");
        System.out.println("Players can put down a card of the same color or number");
        System.out.println("If player does not have any card, they must take one card from the deck");
        System.out.println("Special cards include: reverse, add 2, add 4, wild, and skip. ");
        System.out.println("If player does not have any card, they must take one card from the deck");
        System.out.println("Add 2 may be placed on a add 4 if the color of the plus 4 is the same color of the plus 2");
        System.out.println("Once player has one card left, player must type uno into the terminal within 2 seconds");
        System.out.println("Player must type UNO OUT within 4 seconds inside the terminal once player has no cards");
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
        //PLAY
      }
      else{
        System.out.print("\033[H\033[2J");
      }
  }
}
