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

	public RowsClearedScore(String s, GamePlay g) {
		super(s, g);
	}
	
	public int getScoring() {
		return gamePlay.getRowsCleared();
	}

}
