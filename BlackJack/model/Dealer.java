package BlackJack.model;

import BlackJack.model.rules.*;

public class Dealer extends Player {

  private Deck m_deck;
  private INewGameStrategy m_newGameRule;
  private IHitStrategy m_hitRule;
  private IGameRulesStrategy m_gameRule;

  public Dealer(RulesFactory a_rulesFactory) {
  
    m_newGameRule = a_rulesFactory.GetNewGameRule();
    m_hitRule = a_rulesFactory.GetHitRule();
    m_gameRule = a_rulesFactory.GetGameRules();

  }

  
  public boolean NewGame(Player a_player) {
    if (m_deck == null || IsGameOver()) {
      m_deck = new Deck();
      ClearHand();
      a_player.ClearHand();
      return m_newGameRule.NewGame(m_deck, this, a_player);   
    }
    return false;
  }

  public boolean Hit(Player a_player) {
    if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
      DealCardFromDeck(a_player, true);
      return true;
    }
    return false;
  }

  public boolean IsDealerWinner(Player a_player) {
    return m_gameRule.isDealerWinner(this, a_player);
  }

  public boolean IsGameOver() {
    if (m_deck != null && m_hitRule.DoHit(this) != true) {
        return true;
    }
    return false;
  }

  public boolean Stand() {
      if (m_deck != null) {
          ShowHand();
          while (m_hitRule.DoHit(this)) {
              DealCardFromDeck(this, true);
          }
          return true;
      }
    return false;
  }

  public void DealCardFromDeck(Player a_player, boolean show) {
    Card c = m_deck.GetCard();
    c.Show(show);
    a_player.DealCard(c);
  }
  
}