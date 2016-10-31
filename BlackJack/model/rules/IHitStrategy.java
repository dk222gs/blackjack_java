package BlackJack.model.rules;

import BlackJack.model.Player;

public interface IHitStrategy {
  public enum Strategy {
    BASIC, SOFT
  }

  boolean DoHit(Player a_dealer);
}