package model.io;

import model.exceptions.io.TetrisIOException;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 17/11/2018
 *
 */
public class VisualizerFactory {

	public VisualizerFactory() {
		
	}
	
	public static IVisualizer createVisualizer(String s) throws TetrisIOException {
		
		IVisualizer v;
		
		//if (s.equals("window")) {
		if (s.equals("console")) {
			v = new VisualizerConsole();
			return v;
		}
		else {
			throw new TetrisIOException("The parameter of 'IVsualizer.createVisualizer' is wrong. Try to put 'console'.");
		}
	}
}
