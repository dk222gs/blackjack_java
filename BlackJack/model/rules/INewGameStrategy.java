package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;

public interface INewGameStrategy {
  public enum NewGameStrategy {
    INTERNATIONAL, AMERICAN
  }
    boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player);
}