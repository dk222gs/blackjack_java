package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

class DealerAdvantageGameRulesStrategy implements IGameRulesStrategy {
  public boolean isDealerWinner(Dealer a_dealer, Player a_player) {
    if (a_player.CalcScore() > a_dealer.GetMaxScore()) {
      return true;
    } else if (a_player.CalcScore() > a_dealer.GetMaxScore()) {
      return false;
    }
    return a_player.CalcScore() >= a_dealer.CalcScore();
  }
}