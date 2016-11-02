package BlackJack.view;

public interface IView
{
  enum Input {
    NEWGAME, STAND, HIT, QUIT
  }

  Input GetOption();
  void DisplayWelcomeMessage();
  void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
  void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
  void DisplayGameOver(boolean a_dealerIsWinner);
}