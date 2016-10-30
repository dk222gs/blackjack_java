package BlackJack;

import BlackJack.model.Game;
import BlackJack.view.*;
import BlackJack.controller.*;

import java.util.Observer;

public class Program
{

  public static void main(String[] a_args)
  {
  
    Game g = new Game();
    IView v = new SimpleView(); //new SwedishView();
    g.addObserver((Observer)v);
    PlayGame ctrl = new PlayGame();
    
    while (ctrl.Play(g, v));
  }
}