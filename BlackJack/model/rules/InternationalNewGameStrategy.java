package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.Card;  

class InternationalNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
    a_dealer.DealCardFromDeck(a_player);
    a_dealer.DealCardFromDeck(a_player);
    a_dealer.DealCardFromDeck(a_player);
  
    return true;
  }
}