package model.score;

import model.io.GamePlay;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 14/12/2018
 *
 */
public class TimeScore extends Score{

	/** [ENG] Constructor that creates a object of "TimeScore".
	 *  [SPA] Constructor que crea un objecto de "TimeScore".
	 * 
	 * @param s = input the player's name. / introduce el nombre del jugador.
	 * @param g = input a gamePlay. / introduce un gamePlay
	 */
	public TimeScore(String s, GamePlay g) {
		super(s, g);
	}
	
	/** [ENG] Method that return the duration of a game.
	 *  [SPA] Método que devuelve la duración de una partida.
	 * 
	 * @return = the duration of a game.
	 */
	public int getScoring() {
		return -(gamePlay.getDuration());
	}

}
