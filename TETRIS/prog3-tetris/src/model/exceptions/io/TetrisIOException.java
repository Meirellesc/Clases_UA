package model.exceptions.io;

import model.exceptions.*;

/**
 * 
 * @author Lucas Meirelles
 * @version Oxygen 4.7
 * @date 17/11/2018
 *
 */
@SuppressWarnings("serial")  
public class TetrisIOException extends TetrisException{

	private String message;
	
	public TetrisIOException(String s) {
		message = s;
	}
	
	public String getMessage() {
		return message;
	}
}
