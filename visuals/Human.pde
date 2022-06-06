//import java.util.Scanner;

//public class Human extends Player {

//  public Human(String name) {
//    super(name);
//  }

//  @Override
//  public void setSecondary(Card wild) {
//    Scanner sc = new Scanner(System.in);
//    System.out.println("What color do you want to change it to?\n" +
//                        "1. Red\n" +
//                        "2. Green\n" +
//                        "3. Yellow\n" +
//                        "4. Blue\n");

//    int chosen = sc.nextInt();

//    if (chosen >= 1 && chosen <= 4) {
//      wild.setSecondary(chosen);
//    }
//    else {
//      System.out.println("Invalid color... Automatically set to red.");
//      wild.setSecondary(1);
//    }
//  }

//  @Override
//  public int go(Card top) {
//    Scanner whatCard = new Scanner(System.in);
//    print("Type the index of the card you wish to place.");
//    int placingCard = whatCard.nextInt();
//    while (validateChoice(placingCard, top) == false) {
//      print("Invalid index. Type the index of the card you wish to place.");
//      placingCard = whatCard.nextInt();
//    }
//    return placingCard;
//  }

//  public void uno(){

//    Scanner sc = new Scanner(System.in);
//    if(getHandSize() == 1){
//      long time = System.currentTimeMillis();
//      print("You have one card");
//      String input = sc.next();
//      long secondTime = System.currentTimeMillis();
//      time = secondTime - time;
//      if(time <= 3000 && (input.equals("UNO") || input.equals("uno"))){
//        print(":)");
//      }
//      else{
//        print("You did not type UNO fast enough. You take another card.");
//        draw(aDeck.removeFromDeck());
//      }
//    }
//    else if (getHandSize() == 0) {
//      long time = System.currentTimeMillis();
//      print("You don't have any cards left");
//      String input = sc.next();
//      long secondTime = System.currentTimeMillis();
//      time = secondTime - time;
//      if(time <= 5000 && (input.equals("UNO-OUT") || input.equals("uno-out"))){
//        print("YOU WON! AHHHHHHHHHHHHHHHHH");
//        won = true;
//      }
//      else{
//        print("... You were so close, but you didn't type UNO-OUT. You take another card.");
//        draw(aDeck.removeFromDeck());
//      }
//    }
//  }

//}
