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

	public void setGame(Game g) throws WrongSizeException;
	
	public void show();
}
