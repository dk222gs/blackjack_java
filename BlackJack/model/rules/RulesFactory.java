package BlackJack.model.rules;

public class RulesFactory {

  private IHitStrategy hitStrategy;
  private IGameRulesStrategy gameStrategy;
  private INewGameStrategy newGameStrategy;

  public RulesFactory(IHitStrategy.Strategy hitStrategy, IGameRulesStrategy.GameStrategy gameStrategy,
                      INewGameStrategy.NewGameStrategy newGameStrategy) throws Exception {
    SetHitRule(hitStrategy);
    SetGameRule(gameStrategy);
    SetNewGameRule(newGameStrategy);
  }


  private void SetHitRule(IHitStrategy.Strategy strategy) throws Exception {
    switch(strategy) {
      case BASIC:
        this.hitStrategy = new BasicHitStrategy();
        break;
      case SOFT:
        this.hitStrategy = new SoftHitStrategy();
        break;
      default:
        throw new Exception("Problem when instantiating hit strategy rules");
    }
  }

  private void SetGameRule(IGameRulesStrategy.GameStrategy strategy) throws Exception {
    switch(strategy) {
      case DEALERADVANTAGE:
        this.gameStrategy = new DealerAdvantageGameRulesStrategy();
        break;
      case PLAYERADVANTAGE:
        this.gameStrategy = new PlayerAdvantageGameRulesStrategy();
        break;
      default:
        throw new Exception("Problem when instantiating game rules");
    }
  }

  private void SetNewGameRule(INewGameStrategy.NewGameStrategy strategy) throws Exception {
    switch(strategy) {
      case INTERNATIONAL:
        this.newGameStrategy = new InternationalNewGameStrategy();
        break;
      case AMERICAN:
        this.newGameStrategy = new AmericanNewGameStrategy();
        break;
      default:
        throw new Exception("Problem when instantiating new game rules");
    }
  }

  public IHitStrategy GetHitRule() {
    return this.hitStrategy;
  }

  public IGameRulesStrategy GetGameRules() {
    return this.gameStrategy;
  }

  public INewGameStrategy GetNewGameRule() {
    return this.newGameStrategy;
  }

}