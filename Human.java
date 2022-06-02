import java.util.Scanner;

public class Human extends Player {

  public Human(String name) {
    super(name);
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

}
