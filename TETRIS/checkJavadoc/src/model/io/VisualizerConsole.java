package model.io;

import java.util.Objects;

import model.Coordinate;
import model.Game;
import model.exceptions.WrongSizeException;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 17/11/2018
 *
 */
public class VisualizerConsole implements IVisualizer{
	
	/**
	 * @variable juego.
	 */
	private Game game;
	
	/** [ENG] Constructor that just put the atribute "game" as null.
	 *  [SPA] Constructor que simplemente pone el atributo "game" a null.
	 * 
	 */ 
	VisualizerConsole() {
		game = null;
	}
	
	@Override
	public void setGame(Game g) throws WrongSizeException {
		g = Objects.requireNonNull(g, "El parametro 'game (g)' no puede ser null.");
		
		//Condition that check if the Game Board created doesn't respect the minimum size (10W X 20H)
		if(g.getGameboard().getHeight() < 20 || g.getGameboard().getWidth() <10) {
			throw new WrongSizeException(new Coordinate(g.getGameboard().getHeight(),g.getGameboard().getWidth()));
		}
		
		game = g;
	}

	@Override
	public void show() {
		game.toString();
		System.out.println(game.toString());
	}

}
