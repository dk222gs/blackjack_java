package BlackJack.model;

import BlackJack.model.rules.IGameRulesStrategy;
import BlackJack.model.rules.IHitStrategy;
import BlackJack.model.rules.INewGameStrategy;

public class Game {

  private Dealer m_dealer;
  private Player m_player;

  public Game()
  {
    try {
      m_dealer = new Dealer(new BlackJack.model.rules.RulesFactory(IHitStrategy.Strategy.SOFT,
          IGameRulesStrategy.GameStrategy.DEALERADVANTAGE, INewGameStrategy.NewGameStrategy.AMERICAN));
      m_player = new Player();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
    
  public boolean IsGameOver()
  {
    return m_dealer.IsGameOver();
  }
  
  public boolean IsDealerWinner()
  {
    return m_dealer.IsDealerWinner(m_player);
  }
  
  public boolean NewGame()
  {
    return m_dealer.NewGame(m_player);
  }
  
  public boolean Hit()
  {
    boolean hit = m_dealer.Hit(m_player);
    return hit;
  }
  
  public boolean Stand() { return m_dealer.Stand(); }
  
  public Iterable<Card> GetDealerHand()
  {
    return m_dealer.GetHand();
  }
  
  public Iterable<Card> GetPlayerHand()
  {
    return m_player.GetHand();
  }
  
  public int GetDealerScore()
  {
    return m_dealer.CalcScore();
  }
  
  public int GetPlayerScore()
  {
    return m_player.CalcScore();
  }
    
  
}