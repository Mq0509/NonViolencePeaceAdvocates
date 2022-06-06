public class Bot extends Player{
  public Bot(String name) {
    super(name);
  }

  public void setSecondary(Card wild) {
      wild.setSecondary(1);
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

}
