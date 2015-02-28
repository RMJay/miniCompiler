package logoCompiler.lexer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import exceptions.FormatException;
import logoCompiler.LogoPSCompiler;

public final class Lexer {
	
	//static block to set up the List iterator called "feed" which is the output from the Chunker
	static{
		String path = LogoPSCompiler.inputFile;
		Chunker input;
		try {
			input = new Chunker(path);
			Lexer.feed = input.allChunks().listIterator();
		} catch (FileNotFoundException e) {
			System.err.println(e.toString());
		} catch (IOException e) {
			System.err.println(e.toString());
		}	
	}
	
	static ListIterator<String> feed; 
	
	public static Token lex() throws FormatException {
	
	String chunk = feed.next();
  
    //identify new character and return correct token
    switch (chunk) {

    	case "END_OF_FILE": {
			return new EOIToken();
		}
		case "(": {
			return new LParenToken();
		}
		case ")": {
			return new RParenToken();
		}
		case "*": {
			return new MultToken();
		}
		case "+": {
			return new AddToken();
		}
		case "-": {
			return new SubToken();
		}
		case "/": {
			return new DivToken();
		}
		case "<": {
			return new LeToken();
		}
		case ">": {
			return new GrToken();
		}
		case "!=": {
			return new NotEqToken();
		}
		case "<=": {
			return new LeEqToken();
		}
		case "==": {
			return new EqToken();
		}
		case ">=": {
			return new GrEqToken();
		}
		case "PROC": {
			return new PROCToken();
		}
		case "IF": {
			return new IfToken();
		}
		case "THEN": {
			return new ThenToken();
		}
		case "ELSE": {
			return new ElseToken();
		}
		case "ENDIF": {
			return new EndIfToken();
		}
		case "FORWARD": {
			return new ForwardToken();
		}
		case "LEFT": {
			return new LeftToken();
		}
		case "RIGHT": {
			return new RightToken();
		}
		default: {
			try {
				int value = Integer.parseInt(chunk);
				return new NumToken(value);
			} catch  (NumberFormatException e) {
				String ident = parseIdent(chunk);
				return new IdentToken(ident); 	
				}
			}
		}	
    }

public static String parseIdent(String chunk) throws FormatException {
	  // checks that chunk is of the form ident ::= letter { letter | digit }
	  int asciiVal;
	  boolean valid = true;
	  
	  //check all characters
	  for (int i = 0 ; i < chunk.length() ; i++) {
		  asciiVal = chunk.charAt(i);

		  if (!(((asciiVal >= 65) && (asciiVal <= 90)) // 'A'...'Z'
				|| ((asciiVal >= 97) && (asciiVal <= 122)) // 'a'...'z'
			  	|| ((asciiVal >= 48) && (asciiVal <= 57)))) { // '0'...'9'
			  
			  valid = false; 
		  }
	  }
		    
	  // check the first character
	  asciiVal = chunk.charAt(0); 
	  if (!(((asciiVal >= 65) && (asciiVal <= 90)) // 'A'...'Z'
			  || ((asciiVal >= 97) && (asciiVal <= 122)))) { // 'a'...'z'
		  
		  valid = false;
	  } 
	  
	  if (valid) {
		  return chunk;
	  } else {
		  throw new FormatException(chunk);
	  }
			  		  	 
  }
	  
}
