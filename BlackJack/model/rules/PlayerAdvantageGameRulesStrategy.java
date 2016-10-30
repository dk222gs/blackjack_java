package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

class PlayerAdvantageGameRulesStrategy implements IGameRulesStrategy {
  public boolean isDealerWinner(Dealer a_dealer, Player a_player) {
    if (a_player.CalcScore() > a_dealer.GetMaxScore()) {
      return true;
    } else if(a_dealer.CalcScore() > a_dealer.GetMaxScore()) {
      return false;
    } else if(a_player.CalcScore() < a_dealer.CalcScore() && a_dealer.CalcScore() <= a_dealer.GetMaxScore()) {
      return true;
    } else if (a_player.CalcScore() > a_dealer.CalcScore() && a_player.CalcScore() <= a_dealer.GetMaxScore()) {
      return false;
    }
    return false;
  }
}