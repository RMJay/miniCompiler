package logoCompiler.parser;
import java.io.PrintWriter;

import exceptions.FormatException;
import exceptions.UnexpectedTokenException;
import  logoCompiler.lexer.*;
/*
 * primary-expr:
 *   num
 *   ident
 */
public abstract class PrimaryExpr extends Expr {
  
	public static Expr parse() throws UnexpectedTokenException, FormatException{
	
		Expr expr;
		
	    if (Parser.t instanceof NumToken) {
	      expr = NumExpr.parse();
	      
	    } else if (Parser.t instanceof IdentToken) {
	      expr = IdentExpr.parse();
	    } else {
			throw new UnexpectedTokenException(Parser.t);
			//TODO
		}
	    
	    return expr;
    } 

	public abstract void codegen(PrintWriter p);
  
}
