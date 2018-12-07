package model.score;

import model.io.GamePlay;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date --/--/2018
 *
 */
public class TimeScore extends Score{

	TimeScore(String s, GamePlay g) {
		super(s, g);
	}
	
	public int getScoring() {
		return 0;
	}

}
