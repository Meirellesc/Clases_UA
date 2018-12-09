package model.score;

import java.util.Objects;

import model.io.GamePlay;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date --/--/2018
 *
 */
public abstract class Score {

	protected GamePlay gamePlay;
	
	private String name;
	
	private int score;
	
	
	Score(String s, GamePlay g){
		
		s = Objects.requireNonNull(s, "El parametro 'String(s)' no puede ser null!");
		g = Objects.requireNonNull(g, "El parametro 'String(s)' no puede ser null!");
		
		name = s; //Player's name
		gamePlay = g;
		
		score = getScoring();
	}
	
	public String toString() {
		return (name + ":" + score);
	}
	
	public String getName() {
		return (name);
	}
	
	public abstract int getScoring();
	
	public int compareTo(Score sc) {
		//HAVE TO USE "COMPARABLE" ??
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + score;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (score != other.score)
			return false;
		return true;
	}
	
	
	
}
