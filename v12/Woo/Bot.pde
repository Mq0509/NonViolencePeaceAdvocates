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
      int colore = 0;
      for (int i = 0; i < colors.length; i++) {
        if (colors[i] > max) {
          max = colors[i];
          colore = i;
        }
      }

      wild.setSecondary(colore);
  }

  public int go(Card top) {
    for (int i = 0; i < hand.size(); i++) {
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
      System.out.println(getName() + " succeeded in calling out UNO on time!");
    }
    else if (getHandSize() == 0) {
      int succeed = (int)(Math.random() * 2);
      if (succeed == 0) {
        System.out.println(getName() + " remembered to call out UNO-OUT! They win the game!");
        won = true;
      }
      else {
        System.out.println(getName() + " failed to call UNO-OUT! They draw another card.");
        draw(aDeck.removeFromDeck());
      }
    }
  }

  public int respondToAdding(Card top) {
    for (int i = 1; i < hand.size(); i++) {
      if (validateTwo(i, top)) {
        setSecondary(top);
        return i;
      }
    }
    System.out.println(getName() + " decided to not continue the stack");
    return -1;
  }

}
