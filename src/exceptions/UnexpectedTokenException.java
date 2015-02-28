package exceptions;

import logoCompiler.lexer.Token;
import logoCompiler.parser.Parser;

public class UnexpectedTokenException extends Exception {

	private static final long serialVersionUID = 1L;
	public Token token;
	
	public UnexpectedTokenException(Token token) {
		this.token = token;
		Parser.error = true;
	}
	
	public String toString(){
		String string = "Unexpected Token: " + token.toString();
		return string;
	}

}
