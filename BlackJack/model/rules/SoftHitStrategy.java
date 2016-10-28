package BlackJack.model.rules;

import BlackJack.model.Card;
import BlackJack.model.Player;

class SoftHitStrategy implements IHitStrategy {
    private final int g_hitLimit = 17;

    public boolean DoHit(Player a_dealer) {
      int currentScore = a_dealer.CalcScore();
      if(currentScore < g_hitLimit) {
        return true;
      } else if( currentScore == g_hitLimit) {
        Iterable<Card> cards = a_dealer.GetHand();
        for (Card card : cards) {
          if (card.GetValue().equals(Card.Value.Ace)) {
            return true;
          }
        }
      }

      return false;
    }
}