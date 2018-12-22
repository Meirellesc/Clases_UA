package model.score;

import java.util.Objects;
import model.io.GamePlay;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 14/12/2018
 *
 */
public abstract class Score implements Comparable<Score> {

	/**
	 * @variable gamePlay.
	 */
	protected GamePlay gamePlay;
	
	/**
	 * @variable player's name.
	 */
	private String name;
	
	/**
	 * @variable score.
	 */
	private int score;
	
	/** [ENG] Constructor that stores its two parameters in the attributes 'name(s)’ y ‘gamePlay(g)’ and initialize 'score' with the result of getScoring().
	 *  [SPA] Constructor que almacena sus dos parámetros en los atributos ‘name(s)’ y ‘gamePlay(g)’ e inicializa 'score' con el resultado de getScoring().
	 * 
	 * @param s = input the player's name. / introduce el nombre del jugador.
	 * @param g = input a gamePlay / introduce un gamePlay. 
	 */
	Score(String s, GamePlay g){
		
		s = Objects.requireNonNull(s, "El parametro 'String(s)' no puede ser null!");
		g = Objects.requireNonNull(g, "El parametro 'GamePlay(g)' no puede ser null!");
		
		name = s; //Player's name
		gamePlay = g;
		
		score = getScoring(); //The class which implements getScoring() will define the value.
	}
	
	/** [ENG] Method that return the concatenation of "name + score".
	 *  [SPA] Método que devuelve la concatenación del "name + score". 
	 * 
	 * @return = "name + score".
	 */
	public String toString() {
		return (name + ":" + score);
	}
	
	/** [ENG] Method that return the player's name.
	 *  [SPA] Método que devuelve el nombre del jugador.
	 * 
	 * @return = name.
	 */
	public String getName() {
		return (name);
	}
	
	/** [ENG] Method abstract that returns the "score" of RowsClearedScore or TimeScore.
	 *  [SPA] Método abstracto que devuelve el "score" de RowsClearedScore o TimeScore.  
	 * 
	 * @return = RowsClearedScore's score or TimeScore's score.
	 */
	public abstract int getScoring();
	
	/** [ENG] Method that compares the actual "score" with the parameters one.
	 *  [SPA] Método que compara el "score" actual con el parámetro.
	 * 
	 * @param sc = score that will compare with the actual one.
	 * @return = (-1) if score > sc // (+1) if score < sc // (Name compare) if score == sc.
	 */
	public int compareTo(Score sc) {
		if (score > sc.getScoring()) {
			return (-1);
		}
		else if(score < sc.getScoring()){
			return (1);
		}
		else {
			return name.compareTo(sc.getName());
		}
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
