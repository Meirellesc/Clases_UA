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

	private Game game;
	
	VisualizerConsole() {
		game = null;
	}
	
	@Override
	public void setGame(Game g) throws WrongSizeException {
		g = Objects.requireNonNull(g, "El parametro 'game (g)' no puede ser null.");
		
		if(g.getGameboard().getHeight() < 20 || g.getGameboard().getWidth() <10) {
			throw new WrongSizeException(new Coordinate(g.getGameboard().getHeight(),g.getGameboard().getWidth()));
		}
		
		game = g;
	}

	@Override
	public void show() {
		game.toString(); //I don't know if its necessary.
		System.out.println(game.toString());
	}

}
