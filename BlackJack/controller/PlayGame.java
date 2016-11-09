package BlackJack.controller;

import BlackJack.model.Player;
import BlackJack.view.IView;
import BlackJack.view.IView.Input;
import BlackJack.model.Game;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

public class PlayGame implements Observer {

  private Game a_game;
  private IView a_view;

  public boolean Play(Game a_game, IView a_view) {
    this.a_game = a_game;
    this.a_view = a_view;

    if (a_game.IsGameOver()) {
      a_view.DisplayGameOver(a_game.IsDealerWinner());
    }

    Input input = a_view.GetOption();
    switch (input) {
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

  @Override
  public void update(Observable o, Object arg) {
    a_view.DisplayWelcomeMessage();
    a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());
    a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
    try {
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException e) {
      System.out.println("Error when sleeping: " + e.getMessage());
    }
  }
}

