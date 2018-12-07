package model.io;

import model.Game;
import model.exceptions.WrongSizeException;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 17/11/2018
 *
 */
public interface IVisualizer {

	/** [ENG] Method that receive a object initialized from the "Game" class and keep it in 'game' atribute.
	 * 	[SPA] Método que recibe un objeto ya inicializado de la clase Game y lo almacena en el atributo 'game'.
	 * 
	 * @param g = input a game / introduce un juego.
	 * @throws WrongSizeException = if the size of the game board is not respecting the rules(10W X 20H).
	 */
	public void setGame(Game g) throws WrongSizeException;
	
	/** [ENG] Method that calls the "game.toString" to get a representation as the current board string.
	 * 	[SPA] Método que llama a "game.toString" para obtener una representación como cadena del tablero actual.
	 * 
	 */	
	public void show();
}
