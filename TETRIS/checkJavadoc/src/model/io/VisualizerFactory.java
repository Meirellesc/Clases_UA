package model.io;

import java.util.Objects;

import model.exceptions.io.TetrisIOException;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 17/11/2018
 *
 */
public class VisualizerFactory {

	/** [ENG] Constructor by default.
	 *  [SPA] Constructor por defecto.
	 * 
	 */
	public VisualizerFactory() {
	}
	
	/** [ENG] Method that creates and return a object of the "VisualizerConsole" class.
	 *  [SPA] Método que crea y devuelve un objeto de la clase "VisualizerConsole". 
	 *
	 * @param s = input "console" or "window" / introduce "console" or "window".
	 * @return = an object of the "VisualizerConsole" class / un objeto de la clase "VisualizerConsole".
	 * @throws TetrisIOException = if have some Error with the visualizer instructions.
	 */
	public static IVisualizer createVisualizer(String s) throws TetrisIOException {
		
		s = Objects.requireNonNull(s, "El parametro 'createVisualizer(s)' no puede ser null!");
		
		IVisualizer v;
		
		//Condition that check if the parameter is "console" or window"
		if (s.equals("console") || s.equals("window")) {
			v = new VisualizerConsole();
			return v;
		}
		else {
			throw new TetrisIOException("The parameter of 'IVsualizer.createVisualizer' is wrong. Try to put 'console'.");
		}
	}
}
