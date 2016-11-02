package BlackJack.view;

import BlackJack.model.Card;
import BlackJack.model.Game;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

public class SimpleView implements IView, Observer
{

  public SimpleView() {
    DisplayWelcomeMessage();
  }

  public void DisplayWelcomeMessage()
  {
    for(int i = 0; i < 50; i++) {
      System.out.print("\n");
    };
    System.out.println("Hello Black Jack World");
    System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
  }

  public Input GetOption() {
    switch (GetInput()) {
      case 'p':
        return Input.NEWGAME;
      case 'h':
        return Input.HIT;
      case 's':
        return Input.STAND;
      case 'q':
        return Input.QUIT;
      default:
        return null;
    }
  }

  public int GetInput()
  {
    try {
      int c = System.in.read();
      while (c == '\r' || c =='\n') {
        c = System.in.read();
      }
      return c;
    } catch (java.io.IOException e) {
      System.out.println("" + e);
      return 0;
    }
  }

  public void DisplayCard(BlackJack.model.Card a_card)
  {
      System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
  }

  public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
  {
      DisplayHand("Player", a_hand, a_score);
  }

  public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
  {
      DisplayHand("Dealer", a_hand, a_score);
  }

  private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score)
  {
      System.out.println(a_name + " Has: ");
      for(BlackJack.model.Card c : a_hand)
      {
          DisplayCard(c);
      }
      System.out.println("Score: " + a_score);
      System.out.println("");
  }

  public void DisplayGameOver(boolean a_dealerIsWinner)
  {
      System.out.println("GameOver: ");
      if (a_dealerIsWinner)
      {
          System.out.println("Dealer Won!");
      }
      else
      {
          System.out.println("You Won!");
      }

  }

  @Override
  public void update(Observable o, Object arg) {
    try {
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException e) {
      System.out.println("Error when sleeping: " + e.getMessage());
    }
    final String player = "Player";
    final String dealer = "Dealer";
    Game game = (Game)arg;
    printHand(game.GetPlayerHand(), player);
    printHand(game.GetDealerHand(), dealer);
  }

  private void printHand(Iterable<Card> cards, String user) {
    StringBuilder builder = new StringBuilder();
    builder.append(user + " hand ||");
    for(Card c : cards) {
      builder.append(" " + c.GetValue() + "of" + c.GetColor());
    }
    builder.append(" ||");
    System.out.println(builder.toString());
  }
}
