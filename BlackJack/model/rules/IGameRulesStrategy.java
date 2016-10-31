package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

public interface IGameRulesStrategy {
  public enum GameStrategy {
    DEALERADVANTAGE, PLAYERADVANTAGE
  }
  public boolean isDealerWinner(Dealer a_dealer, Player a_player);
}