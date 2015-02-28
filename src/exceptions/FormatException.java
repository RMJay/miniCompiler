package exceptions;

import logoCompiler.parser.Parser;

public class FormatException extends Exception {

	private static final long serialVersionUID = 1L;
	private String chunk;
	
	public FormatException(String chunk) {
		this.chunk = chunk;
		Parser.error = true;
	}
	
	public String toString(){
		return "Format Exception: " + chunk;
	}
	
}
