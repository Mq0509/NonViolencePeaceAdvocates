//import java.util.Scanner;
//public class Woo{
//  public static void startMenu(){
//    String reset = "\u001B[37m";
//    String red = "\u001B[31m";
//    Scanner hehe = new Scanner(System.in);
//      print("Please Choose an Option:");
//      print("1. Start Game        2. How to Play        3. Quit        ");
//      String input = hehe.nextLine();
//      input = input.toLowerCase();
//      print("\033[H\033[2J");
//      if(input.equals("1") || input.equals("start game")){
//        // System.out.print("PLAY");
//        // System.out.print("\033[H\033[2J");
//        play();
//      }
//      else if(input.equals("2") || input.equals("how to play")){
//        print("The " + red + "OBJECTIVE" + reset + " is to clear all of your cards.");
//        print("Players can put down a card of the same color or number");
//        print("If player does not have any card, they must take one card from the deck");
//        print("Special cards include: reverse, add 2, add 4, wild, and skip. ");
//        print("If player does not have any card, they must take one card from the deck");
//        print("Add 2 may be placed on a add 4 if the color of the plus 4 is the same color of the plus 2");
//        print("Once player has one card left, player must type uno or UNO into the terminal within 3 seconds");
//        print("Player must type UNO-OUT or uno-out within 5 seconds inside the terminal once player has no cards");
//        print("If player does not type into the terminal in the designated time, player will recieve 1 card");
//        print("Type ready to continue");
//        String x = hehe.next();
//        if(x.equals("ready")){
//          try {
//              Thread.sleep(2000);
//            }
//            catch (InterruptedException e) {
//            }
//        }
//        print("\033[H\033[2J");
//        play();
//      }
//      else{
//        print("\033[H\033[2J");
//      }
//  }

//  public static void play(){
//    Scanner sc = new Scanner(System.in);
//    print("¿Cual es tu nombre?");
//    String name = sc.nextLine();
//    Player p1 = new Human(name);
//    Player p2 = new Bot("Kenny");
//    Player p3 = new Bot("Rachel");
//    Player p4 = new Bot("Bob The Builder");
//    Table newGame = new Table(p1,p2,p3,p4);
//    newGame.placeFirst();
//    newGame.distribute();

//    // print(p1);            Making sure distribute works <3
//    // print("--\n");
//    //
//    // print(p2);
//    // print("--\n");
//    //
//    // print(p3);
//    // print("--\n");
//    //
//    // print(p4);
//    // println("--\n");
//    //
//    // println("Topmost card: " + newGame.getTop());

//    newGame.go();
//  }

//  public static void main(String[] args) {
//    startMenu();
//  }
//}
