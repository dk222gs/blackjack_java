package BlackJack.controller;

import BlackJack.view.IView;
import BlackJack.view.IView.Input;
import BlackJack.model.Game;

import java.util.Observable;

public class PlayGame extends Observable {

  private Game a_game;
  private IView a_view;

  public boolean Play(Game a_game, IView a_view) {
    this.a_game = a_game;
    this.a_view = a_view;

    DisplayCards();

    if (a_game.IsGameOver()) {
      a_view.DisplayGameOver(a_game.IsDealerWinner());
    }

    Input input = a_view.GetOption();
    switch(input) {
      case NEWGAME:
        a_game.NewGame();
        break;
      case STAND:
        a_game.Stand();
        break;
      case HIT:
        a_game.Hit();
        break;
    }
    return input != Input.QUIT;
  }

  private void DisplayCards() {
    a_view.DisplayWelcomeMessage();

    a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
    a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());

    setChanged();
    notifyObservers(a_game);
  }
}

