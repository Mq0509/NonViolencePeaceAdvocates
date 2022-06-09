public class Bot extends Player{
  public Bot(String name) {
    super(name);
  }

  public void setSecondary(Card wild) {
      int[] colors = new int[4];
      for (int i = 0; i < getHandSize(); i++) {
        if (hand.get(i).getColor().equals("Red")) {
          colors[0] += 1;
        }
        else if (hand.get(i).getColor().equals("Green")){
          colors[1] += 1;
        }
        else if (hand.get(i).getColor().equals("Yellow")){
          colors[2] += 1;
        }
        else {
          colors[3] += 1;
        }
      }
      int max = 0;
      int color = 0;
      for (int i = 0; i < colors.length; i++) {
        if (colors[i] > max) {
          max = colors[i];
          color = i;
        }
      }

      wild.setSecondary(color);
  }

  public int go(Card top) {
    for (int i = 1; i < hand.size(); i++) {
      if (validateChoice(i, top)) {
        if (hand.get(i).isWild() == true) {
          setSecondary(hand.get(i));
        }
        return i;
      }
    }
    return getHandSize();
  }

  public void uno(Deck aDeck) {
    if (getHandSize() == 1) {
      int succeed = (int)(Math.random() * 2);
      if (succeed == 0) {
        System.out.println(getName() + " succeeded in calling out UNO on time!");
      }
      else {
        System.out.println(getName() + " failed in calling out UNO on time. They draw another card.");
      }
    }
    else if (getHandSize() == 0) {
      int succeed = (int)(Math.random() * 10);
      if (succeed == 0) {
        System.out.println(getName() + " remembered to call out UNO-OUT! They win the game!");
        won = true;
      }
      else {
        System.out.println(getName() + " failed to call UNO-OUT! They draw another card.");
      }
    }
  }

  public int respondToAdding(Card top) {
    System.out.println(getName() + " decided to not continue the stack");
    return -1;
  }

  public static void main(String[] args) {
    Bot jesse = new Bot("jesse");
    jesse.hand.add(new Card(1, 4));
    jesse.hand.add(new Card(2, 7));
    jesse.hand.add(new Card(2, 9));
    jesse.hand.add(new Card(3, 2));
    jesse.hand.add(new Card(3, 3));
    jesse.hand.add(new Card(3, 0));

    Card wild = new Card(5, 14);

    System.out.println(wild);
    jesse.setSecondary(wild);
    System.out.println(wild);

  }

}
