package model.score;

import model.io.GamePlay;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 14/12/2018
 *
 */
public class RowsClearedScore extends Score {

	/** [ENG] Constructor that creates a object of "RowsClearedScore".
	 *  [SPA] Constructor que crea un objecto de "RowsClearedScore".
	 * 
	 * @param s = input the player's name. / introduce el nombre del jugador.
	 * @param g = input a gamePlay. / introduce un gamePlay
	 */
	public RowsClearedScore(String s, GamePlay g) {
		super(s, g);
	}
	
	/** [ENG] Method that return the number of rows eliminated in a game.
	 *  [SPA] Método que devuelve el número de filas eliminadas de una partida.
	 * 
	 * @return = the number of rows eliminated in a game.
	 */
	public int getScoring() {
		return gamePlay.getRowsCleared();
	}

}
